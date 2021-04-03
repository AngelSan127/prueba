package sv.com.dao;

import java.util.List;
import sv.com.model.TestFacturaDetalle;

public interface facturaDetalleDao {

	public void nuevoDetalleFactura(TestFacturaDetalle facturaDetalle );
	
	public void modificarDetalleFactura(TestFacturaDetalle facturaDetalle );

	public void eliminarDetalleFactura(TestFacturaDetalle facturaDetalle );
	
	public List<TestFacturaDetalle> listDetalleFactura();
	

}
