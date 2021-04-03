package sv.com.model;
// Generated 18/11/2020, 7:41:26 p.�m. by Hibernate Tools 4.3.5.Final


import java.math.BigDecimal;
import java.util.List;	
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * TestFacturaDetalle generated by hbm2java
 */

@javax.persistence.Entity
@javax.persistence.Table(name = "test_factura_detalle")
public class TestFacturaDetalle implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829735165086104870L;

	@Id
	@Column(name = "IdFacturaDetalle")
	private Integer idFacturaDetalle;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IdFactura")
	private TestFactura testFactura;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IdProducto")
	private TestProducto testProducto;
	
	@Column(name = "Cantidad")
	private int cantidad;
	
	@Column(name = "ValorUnidad")
	private BigDecimal valorUnidad;
	
	@Column(name = "ValorTotal")
	private BigDecimal valorTotal;

	public TestFacturaDetalle() {
	}

	public TestFacturaDetalle(TestFactura testFactura, TestProducto testProducto, int cantidad, BigDecimal valorUnidad,
			BigDecimal valorTotal) {
		this.testFactura = testFactura;
		this.testProducto = testProducto;
		this.cantidad = cantidad;
		this.valorUnidad = valorUnidad;
		this.valorTotal = valorTotal;
	}

	public Integer getIdFacturaDetalle() {
		return this.idFacturaDetalle;
	}

	public void setIdFacturaDetalle(Integer idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public TestFactura getTestFactura() {
		return this.testFactura;
	}

	public void setTestFactura(TestFactura testFactura) {
		this.testFactura = testFactura;
	}

	public TestProducto getTestProducto() {
		return this.testProducto;
	}

	public void setTestProducto(TestProducto testProducto) {
		this.testProducto = (TestProducto) testProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorUnidad() {
		return this.valorUnidad;
	}

	public void setValorUnidad(BigDecimal valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
