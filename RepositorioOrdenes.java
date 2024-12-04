import java.util.List;

public interface RepositorioOrdenes {
    public void registrarOrden(OrdenCompra orden);
    List<OrdenCompra> consultarOrdenesPorCliente(String cliente);
}
