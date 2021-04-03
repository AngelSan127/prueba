package sv.com.bean;

import java.util.List;

import sv.com.dao.facturaDetalleDao;
import sv.com.imp.FacturaDetalleImp;
import sv.com.model.TestFactura;
import sv.com.model.TestFacturaDetalle;
import sv.com.model.TestProducto;

public class facturaDetalleBean {

	private TestProducto testProducto;
	private TestFactura testFactura;
	private TestFacturaDetalle testFacturaDetalle;
	private List<TestFacturaDetalle> ListtestFacturaDetalle;
	
	
	public TestFacturaDetalle getTestFacturaDetalle() {
	 
		if(testFacturaDetalle==null)
		{
			testFacturaDetalle = new TestFacturaDetalle();
		}
		return testFacturaDetalle;
	}


	public void setTestFacturaDetalle(TestFacturaDetalle testFacturaDetalle) {
		
		this.testFacturaDetalle = testFacturaDetalle;
	}


	public List<TestFacturaDetalle> getListtestFacturaDetalle() {
		
		facturaDetalleDao FacturaDetalleDao = new FacturaDetalleImp();
		ListtestFacturaDetalle = FacturaDetalleDao.listDetalleFactura();
		return ListtestFacturaDetalle;
	}
	
	public void nuevoDetalle()
	{
		facturaDetalleDao FacturaDetalleDao = new FacturaDetalleImp();
		FacturaDetalleDao.nuevoDetalleFactura(testFacturaDetalle);
		this.testFacturaDetalle = new TestFacturaDetalle();
	}
	
	public void editarDetalle()
	{
		facturaDetalleDao FacturaDetalleDao = new FacturaDetalleImp();
		FacturaDetalleDao.modificarDetalleFactura(testFacturaDetalle);
		this.testFacturaDetalle = new TestFacturaDetalle();
	}
	
	public void eliminarDetalle()
	{
		facturaDetalleDao FacturaDetalleDao = new FacturaDetalleImp();
		FacturaDetalleDao.eliminarDetalleFactura(testFacturaDetalle);
		this.testFacturaDetalle = new TestFacturaDetalle();
	}

	public facturaDetalleBean() {
		
		this.testFacturaDetalle= new TestFacturaDetalle();
		this.testFactura =new TestFactura();
		this.testProducto = new TestProducto();
		
		this.testFacturaDetalle.setTestProducto(testProducto);
		this.testFacturaDetalle.setTestFactura(testFactura);
		
	}
}
