package ar.com.educacionit.daos.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Entity;

public abstract class JDBCBaseDao<T extends Entity> implements GenericDao<T>{

	protected String tabla; //cuando creo uno de los hijos le tengo que pasar el nombre de su tabla
	
	public JDBCBaseDao(String tabla) {
		if(tabla == null) {
			throw new IllegalArgumentException("Debe indicar la tabla del DAO");
		}
		this.tabla = tabla;
	}
	
	//cada impl debe especificar como es su sql insert
	public abstract String getSaveSQL();
	
	public abstract void saveData(T entity,PreparedStatement pst) throws SQLException;	
	public abstract String getUpdateSQL(T entity);
	public abstract void updateData(T entity, PreparedStatement st) throws SQLException;
	//cada hijo convierte el ResultSet a la entidad que le corresponde 
	public abstract T fromResultSetToEntity(ResultSet rs) throws SQLException;
	
	public String getSaveSQL2(T entity) {				
			StringBuilder sb = new StringBuilder();		
			try {  
		    	Field[] campos = entity.getClass().getDeclaredFields();
		        sb.append("( ");
		        for(int i = 1; i < campos.length; i++){ //comienza despues del 1� elemento ID		        	
		        	campos[i].setAccessible(true);
		            String fName = campos[i].getName();//tengo que agregar el "_" em la primera mayuscula		            
		            fName=fName.replaceAll("(.)(\\p{Lu})", "$1_$2");
		            //System.err.println(fName);
		            sb.append(fName.toUpperCase() + ",");
		        }
		        sb.deleteCharAt(sb.length()-1); //borra la ultima ","
		        sb.append(") VALUES (");
		        //agrego los "?" correspondiente a la cantidad de campos
		        for (int i = 1; i < campos.length; i++) { //comienza despues del 1� elemento ID
		        	sb.append("?,");
				}
		        sb.deleteCharAt(sb.length()-1); //borra la ultima ","
		        sb.append(")");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return sb.toString(); //devuelvo la consulta
		}
	
	
	public void update(T entity) throws GenericException {		
		String sql = "UPDATE " + this.tabla + " SET " +this.getUpdateSQL(entity) + " where id=?";		
		//contar cuantos ?
		int idx = getWhereIndex(sql);//en este ejemplo idx = 7
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {
				// puedo setear atributo=valor con el tipo correcto				
				this.updateData(entity, st); //llama al metodo del hijo
				st.setLong(idx, entity.getId()); //LE ASIGNO A LA ULTIMA POSICION de "?"-> where id=? <- ultimo "?"
				st.execute();// alt+shift+m 
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}

	/*
	 * Determina el indice del where ID en un update
	 */
	private int getWhereIndex(String sql) {
		int idx = 0;
		for(char c : sql.toString().toCharArray()) {
			if(c == '?') {
				idx ++;
			}
		}
		return idx;
	}
	
	public void save(T entity) throws DuplicatedException, GenericException {		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {			
			StringBuffer sql = new StringBuffer("INSERT INTO ").append(this.tabla).append(this.getSaveSQL());
			StringBuffer sql2 = new StringBuffer("INSERT INTO ").append(this.tabla).append(this.getSaveSQL2(entity));			
			try(PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {				
				this.saveData(entity, st);				
				st.execute();				
				try(ResultSet rs = st.getGeneratedKeys()){					
					if(rs.next()) {						
						Long id = rs.getLong(1);						
						entity.setId(id);
					}
				}
			}			
		}catch(SQLException se) {
			if(se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el articulo, integridad de datos violada",se);
			}
			throw new GenericException(se.getMessage(), se);
		}catch(GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}
	}
	
	/*private Object getSaveSQL2(T entity) {
		//armar la logica para el insert...
		return null;
	}*/

	@Override
	public T getByPK(Long id) throws GenericException {
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			try (Statement st = con2.createStatement()) {				
				String sql = "SELECT * FROM " + this.tabla + " WHERE ID = " + id; 
				
				try(ResultSet rs = st.executeQuery(sql)) { 
					T entity = null;
					if(rs.next()) {
						entity = this.fromResultSetToEntity(rs);
					}
					return entity;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el entity "+this.tabla+"id:"+id, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el entity "+ this.tabla+" id:"+id, e);
		}
	}
	
	@Override
	public List<T> findAll() throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla;
		try(
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql);
			) {
			while(rs.next()) {
				T entity = this.fromResultSetToEntity(rs); //convierte del result al entity invocado, ejemplo un articulo.
				registros.add(entity);
			}					
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: " +sql, e);
		}
		return registros;
	}
	
	@Override
	public List<T> findPageable(Integer currentPage, Integer size) throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla + " LIMIT "+ size + " offset "+ (currentPage-1);
		try(
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql);
			) {
			while(rs.next()) {
				T entity = this.fromResultSetToEntity(rs);
				registros.add(entity);
			}					
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: " +sql, e);
		}
		return registros;
	}
	
	//llama a la tabla del hijo.. ya sea articulo o categorias etc...
	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM " +this.tabla+ " WHERE ID = " + id;
		try (
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				//auto commit en false -> hasta que no hagoi con2.commit() no se cierra si falla hago rollback
				Statement st = con2.createStatement();
		) {
			st.executeUpdate(sql); //hay que tener cuidado con el metodo q se usa dependiendo lo q haga
		}catch(GenericException ge) {
			//con2.rollback();
			throw new GenericException(sql, ge);
		}catch(SQLException se) {
			//con2.rollback();
			throw new GenericException(sql, se);
		}
	}
	

		
}
