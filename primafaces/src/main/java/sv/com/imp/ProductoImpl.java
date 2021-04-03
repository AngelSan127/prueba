package sv.com.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sv.com.dao.productoDao;
import sv.com.model.TestFacturaDetalle;
import sv.com.model.TestProducto;
import sv.com.util.HibernateUtil;

public class ProductoImpl implements productoDao {

	public Session s = null;
	
	public ProductoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<TestProducto> listProducto() {
	
		List<TestProducto> listTestProducto = null;
		s = HibernateUtil.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
			
		
	try {
			
		listTestProducto =s.createQuery("select testproducto from TestProducto as testproducto",TestProducto.class).list();
		t.commit();
		s.close();

	}catch (Exception e) 
	{
		System.out.println(e.getMessage());	
		t.rollback();
	}
	
	return listTestProducto;
		
		
	}

}
