import java.util.List;

public class EntregaProductoService {
    private RepositorioProductos repositorio;
    
    public EntregaProductoService(RepositorioProductos repositorio) {
        this.repositorio = repositorio;
    }
    
    public void registrarEntrega(List<Producto> productos){
        repositorio.registrarEntrega(productos);
    }
    
}