import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;

public class EntregaProductoServiceTest {
    @BeforeEach
    public void setUp(){
    }

    @AfterEach
    public void tearDown(){
    }
    
    @Test
    public void testRegistrarEntregaProducto() {
        RepositorioProductos repositorioMock = mock(RepositorioProductos.class);

        EntregaProductoService entregaProductoService = new EntregaProductoService(repositorioMock);

        Producto producto1 = new Producto("P001", "Producto 1", 1, 100);
        Producto producto2 = new Producto("P002", "Producto 2", 1, 150);

        List<Producto> productos = List.of(producto1, producto2);

        entregaProductoService.registrarEntrega(productos);
        
        verify(repositorioMock).registrarEntrega(productos);
    }
}

