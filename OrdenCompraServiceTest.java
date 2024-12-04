import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;

public class OrdenCompraServiceTest {
    
    private RepositorioOrdenes repositorioMock;
    private OrdenCompraService ordenCompraService;
    private OrdenCompra orden;
    
    @BeforeEach
    public void setUp(){
        repositorioMock = mock(RepositorioOrdenes.class);
        ordenCompraService = new OrdenCompraService(repositorioMock);
        
        Producto producto1 = new Producto("P001", "Producto 1", 1, 100);
        Producto producto2 = new Producto("P002", "Producto 2", 1, 150);
        List<Producto> productos = List.of(producto1, producto2);
        
        orden = new OrdenCompra("Cliente1", productos);
    }
    
    @AfterEach
    public void tearDown(){
    }
    
    @Test
    public void testRegistrarOrdenCompra() {
        ordenCompraService.registrarOrdenCompra(orden);
        verify(repositorioMock).registrarOrden(orden);
    }
    
    @Test
    public void testConsultarOrdenesPorCliente() {
        when(repositorioMock.consultarOrdenesPorCliente("Cliente1")).thenReturn(List.of(orden));

        List<OrdenCompra> ordenes = ordenCompraService.consultarOrdenesPorCliente("Cliente1");

        assertNotNull(ordenes);
        assertEquals(1, ordenes.size());
        assertEquals("Cliente1", ordenes.get(0).getCliente());
    }
    
}

