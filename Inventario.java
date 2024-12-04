public class Inventario {
    private RepositorioProductos repositorio;

    public Inventario(RepositorioProductos repositorio) {
        this.repositorio = repositorio;
    }
    
    public int consultarStock(String codigoProducto) {
        return repositorio.getStock(codigoProducto);
    }
    
    public double consultarPrecio(String codigoProducto){
        return repositorio.getPrecio(codigoProducto);
    }
    
    public void agregarProducto(Producto producto){
        repositorio.agregarProducto(producto);
    }
    
    public void actualizarStock(Producto producto, int cantidad){
        producto.setCantidad(producto.getCantidad() + cantidad);
        repositorio.actualizarStock(producto, cantidad);
    }
    
    public void eliminarProducto(Producto producto){
        if(producto.getCantidad() == 0){
            repositorio.eliminarProducto(producto);
        } else {
            throw new IllegalArgumentException("No se puede eliminar un producto con stock mayor a 0.");
        }
    }
    
    public void aplicarDescuento(Producto producto, double porcentaje){
        double descuento = producto.getPrecio() * porcentaje / 100;
        producto.setPrecio(producto.getPrecio() - descuento);
    }
    

    
}

