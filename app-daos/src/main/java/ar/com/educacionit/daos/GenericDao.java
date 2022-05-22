package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;

public interface GenericDao<T> {

	//definir los metodos CRUD
	public List<T> findAll() throws GenericException;
	public void save(T orden) throws GenericException, DuplicatedException; //CREATE
	public T getByPK(Long pk) throws GenericException; //READ
	public void update(T ordenToUpdate) throws GenericException; //UPDATE
	public void delete(Long pk) throws GenericException; //DELETE
	
	/*puede*/
	public List<T> findPageable(Integer currentPage, Integer size) throws GenericException;
}
