package sv.com.bean;

import java.util.List;

import sv.com.dao.productoDao;
import sv.com.imp.ProductoImpl;
import sv.com.model.TestProducto;

public class productoBean {

	private TestProducto testProducto;
	private List<TestProducto> listtestProducto;
	
	
	public productoBean() {
		
		
	}
	
	public  List<TestProducto> getlisttestProducto()
	{
		productoDao ProductoDetalladoDao = new ProductoImpl();
		listtestProducto = ProductoDetalladoDao.listProducto();
		
		return listtestProducto;
		
	}
	
	
}
