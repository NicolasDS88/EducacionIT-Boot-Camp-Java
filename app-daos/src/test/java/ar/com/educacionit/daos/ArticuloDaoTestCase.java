package ar.com.educacionit.daos;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoTestCase {
	                
	@Order(1)
	@Test
	public void test() {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		assertNotNull(art);	                 
		}
	
	@Order(2)
	@Test
	public void when_create_update_delete_then_notExist() throws GenericException, DuplicatedException {
		ArticuloDao art = new ArticuloDaoMysqlImpl();

		Articulo articulo = new Articulo("Un Titulo", "UnCodigo", new java.sql.Date(System.currentTimeMillis()) , 100D, 20L, 1L, 2L);
		art.save(articulo);		
		articulo.setPrecio(300D);		
		art.update(articulo);
		art.delete(articulo.getId());	
				
	}
	
	                                                         
	

	}


