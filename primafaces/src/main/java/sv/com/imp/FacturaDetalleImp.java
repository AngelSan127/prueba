package sv.com.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sv.com.dao.facturaDetalleDao;
import sv.com.model.TestFacturaDetalle;
import sv.com.util.HibernateUtil;

public class FacturaDetalleImp implements facturaDetalleDao{

	public Session s = null;
	
	public FacturaDetalleImp()   {
	
		}

	@Override
	public void nuevoDetalleFactura(TestFacturaDetalle facturaDetalle) {

		System.out.println("-------------- facturaDetalle.getIdFacturaDetalle ----------- :"+facturaDetalle.getIdFacturaDetalle());
		System.out.println("-------------- facturaDetalle.getIdFactura ----------- :"+facturaDetalle.getTestFactura().getIdFactura());
		System.out.println("-------------- facturaDetalle.getIdProducto() ----------- :"+facturaDetalle.getTestProducto().getIdProducto());
		System.out.println("-------------- facturaDetalle.getCantidad() ----------- :"+facturaDetalle.getCantidad());
		System.out.println("-------------- facturaDetalle.getValorUnidad() ----------- :"+facturaDetalle.getValorUnidad());
		System.out.println("-------------- facturaDetalle.getValorTotal() ----------- :"+facturaDetalle.getValorTotal());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String fechaFinal = sdf.format(now);
		System.out.println(fechaFinal);
		
		
		facturaDetalle.getTestFactura().setFechaVenta(java.sql.Date.valueOf(fechaFinal));
		 
		
		try {
			
			s = HibernateUtil.sessionFactory.openSession();
			s.beginTransaction();
			
			s.save(facturaDetalle);
			s.getTransaction().commit();
			s.close();
			
		} catch (Exception e) {
			System.out.println("FALLO AL INSERTAR :"+e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally {
			
			s.getTransaction().rollback();
			s.close();
		}
	}

	@Override
	public void modificarDetalleFactura(TestFacturaDetalle facturaDetalle) {
	
		try {
			
			s = HibernateUtil.sessionFactory.openSession();
			s.beginTransaction();
			s.update(facturaDetalle);
			s.getTransaction().commit();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			
			s.getTransaction().rollback();
			s.close();
		}
		
	}

	@Override
	public void eliminarDetalleFactura(TestFacturaDetalle facturaDetalle) {
		
		try {
			
			s = HibernateUtil.sessionFactory.openSession();
			s.beginTransaction();
			s.delete(facturaDetalle);
			s.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			
			s.getTransaction().rollback();
			s.close();
		}
		
	}

	@SuppressWarnings("unchecked")	
	@Override
	public List<TestFacturaDetalle> listDetalleFactura() {
		
		List<TestFacturaDetalle> listDetalleFactura = null;
		s = HibernateUtil.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		
		try {
					
			List<TestFacturaDetalle> query =s.createQuery("from TestFacturaDetalle",TestFacturaDetalle.class).list();
			t.commit();
			s.close();
			
		}catch (Exception e) 
		{
			System.out.println(e.getMessage());	
			t.rollback();
		}
		
		return listDetalleFactura;
	}

}
