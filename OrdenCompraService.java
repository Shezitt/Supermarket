import java.util.List;

public class OrdenCompraService {
    private RepositorioOrdenes repositorio;

    public OrdenCompraService(RepositorioOrdenes repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarOrdenCompra(OrdenCompra orden) {
        repositorio.registrarOrden(orden);
    }
    
    public List<OrdenCompra> consultarOrdenesPorCliente(String cliente){
        return repositorio.consultarOrdenesPorCliente(cliente);
    }
    
}
