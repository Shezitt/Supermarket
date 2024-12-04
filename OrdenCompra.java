import java.util.List;

public class OrdenCompra {
    private String cliente;
    private List<Producto> productos;

    public OrdenCompra(String cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
