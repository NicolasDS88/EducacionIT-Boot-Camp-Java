package ar.com.educacionit.daos;


import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;


public interface ArticuloDao extends GenericDao<Articulo>{
	//usa las del Generic DAO (CRUD) mas las propias de cada una
	//no forma parte del crud
	public Articulo getByCode(String codigo) throws GenericException;
	
	
 }
