import java.util.List;

public interface RepositorioProductos {
    public int getStock(String codigoProducto);
    public double getPrecio(String codigoProducto);
    
    public void agregarProducto(Producto producto);
    public void actualizarStock(Producto producto, int cantidad);
    public void eliminarProducto(Producto producto);
    public void registrarEntrega(List<Producto> productos);
    
}


