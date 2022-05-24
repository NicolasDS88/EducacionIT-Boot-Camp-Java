package ar.com.educacionit.daos.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	public ArticuloDaoMysqlImpl() {
		super("articulos"); //aca le indico el nombre de la tabla
	}


	@Override //mejorar usando reflection
	public void saveData(Articulo entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setString(2, entity.getCodigo());
		st.setDouble(3, entity.getPrecio());
		st.setLong(4, entity.getCategoriasId());
		st.setLong(5, entity.getMarcasId());
		st.setDate(6, new java.sql.Date(System.currentTimeMillis()));// java.sql.Date
		st.setLong(7, entity.getStock());
	}

	@Override //es de la interfaz ArticuloDao
	public Articulo getByCode(String codigo) throws GenericException {
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			String sql = "SELECT * FROM ARTICULOS WHERE codigo = ?";
			try (PreparedStatement st = con2.prepareStatement(sql)) {
				st.setString(1, codigo);
				try (ResultSet rs = st.executeQuery()) {
					Articulo articulo = null;
					if (rs.next()) {
						// uso el metodo para transformar de una entity al objeto, en este caso Articulo
						articulo = fromResultSetToEntity(rs);
					}
					return articulo;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el articulo id:" + codigo, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id:" + codigo, e);
		}
	}

	public Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idArticulo = rs.getLong("id");
		String titulo = rs.getString("titulo");
		String codigo = rs.getString("codigo");
		Date fechaCreacion = rs.getDate("fecha_creacion");
		Double precio = rs.getDouble("precio");
		Long stock = rs.getLong("stock");
		Long marcasId = rs.getLong("marcas_id");
		Long categoriasId = rs.getLong("categorias_id");
		return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
	}

	@Override
	public void updateData(Articulo entity, PreparedStatement st) throws SQLException {
		if (entity.getTitulo() != null) {
			st.setString(1, entity.getTitulo());
		}
		if (entity.getCodigo() != null) {
			st.setString(2, entity.getCodigo());
		}
		if (entity.getPrecio() != null) {
			st.setDouble(3, entity.getPrecio());
		}
		if (entity.getStock() != null) {
			st.setLong(4, entity.getStock());
		}
		if (entity.getMarcasId() != null) {
			st.setLong(5, entity.getMarcasId());
		}
		if (entity.getCategoriasId() != null) {
			st.setLong(6, entity.getCategoriasId());
		}

	}

	@Override //arma la consulta
	public String getUpdateSQL(Articulo entity) {
		StringBuffer sql = new StringBuffer();

		if (entity.getTitulo() != null) {
			sql.append("titulo=?").append(", ");
		}
		if (entity.getCodigo() != null) {
			sql.append("codigo=?").append(", ");
		}
		if (entity.getPrecio() != null) {
			sql.append("precio=?").append(", ");
		}
		if (entity.getStock() != null) {
			sql.append("stock=?").append(", ");
		}
		if (entity.getMarcasId() != null) {
			sql.append("marcas_id=?").append(", ");
		}
		if (entity.getCategoriasId() != null) {
			sql.append("categorias_id=?").append(",");
		}

		return sql.substring(0, sql.length() - 1).toString(); //saca la ultima coma y devuelve el sql
	}

	@Override
	public String getSaveSQL() { // save = create
		//TODO se puede hacer con JAVA REFLECTION
		return "(TITULO, CODIGO, PRECIO, CATEGORIAS_ID, MARCAS_ID, FECHA_CREACION, STOCK) VALUES (?,?,?,?,?,?,?)";
	}
	
	/*@Override
	public String getSaveSQL2(Articulo entity) {		
		StringBuilder sb = new StringBuilder();		
	    Class<Articulo> thisClass = null;
	    try {  
	    	Field[] campos = thisClass.getDeclaredFields();
	        sb.append("( ");
	        for(Field f : campos){
	        	f.setAccessible(true);
	            String fName = f.getName();//tengo que agregar el "_" em la primera mayuscula
	            fName.replaceAll("()([A-Z])", "$1_$2");
	            sb.append(fName.toUpperCase() + ", ");
	        }
	        sb.deleteCharAt(sb.length()-1); //borra la ultima ","
	        sb.append(") VALUES (");
	        //agrego los "?" correspondiente a la cantidad de campos
	        for (int i = 0; i < campos.length; i++) {
	        	sb.append("?,");
			}
	        sb.deleteCharAt(sb.length()-1); //borra la ultima ","
	        sb.append(")");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sb.toString(); //devuelvo la consulta
	}*/
}
