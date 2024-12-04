import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;

public class InventarioTest {
    
    private RepositorioProductos repositorioMock;
    private Inventario inventario;
    
    @BeforeEach
    public void setUp() {
        repositorioMock = mock(RepositorioProductos.class);
        inventario = new Inventario(repositorioMock);
    }

    @AfterEach
    public void tearDown() {
    }
 
    @Test
    public void testConsultarStock() {
        when(repositorioMock.getStock("P001")).thenReturn(10);
        
        int stock = inventario.consultarStock("P001");
        
        assertEquals(10, stock);
    }

    @Test
    public void testAgregarProducto(){
        Producto producto = new Producto("P002", "Producto 2", 20, 10);
        inventario.agregarProducto(producto);

        verify(repositorioMock).agregarProducto(producto);
    }
    
    @Test
    public void testActualizarStock(){
        Producto producto = new Producto("P001", "Producto 1", 10, 10);

        inventario.actualizarStock(producto, 5);

        verify(repositorioMock).actualizarStock(producto, 5);

        assertEquals(15, producto.getCantidad());

        inventario.actualizarStock(producto, -3);

        verify(repositorioMock).actualizarStock(producto, -3);

        assertEquals(12, producto.getCantidad());
    }
    
    @Test
    public void testEliminarProducto(){
        Producto producto = new Producto("P003", "Producto 3", 0, 0);

        inventario.eliminarProducto(producto);

        verify(repositorioMock).eliminarProducto(producto);
    }
    
    @Test
    public void testEliminarProductoDisponible(){
        Producto producto = new Producto("P004", "Producto 4", 3, 0);
        
        assertThrows(IllegalArgumentException.class, () -> inventario.eliminarProducto(producto));        
    }
    
    @Test
    public void testAplicarDescuento(){
        Producto producto = new Producto("P001", "Producto 1", 2, 100);

        // Aplicamos un descuento del 20%
        inventario.aplicarDescuento(producto, 20);

        assertEquals(80, producto.getPrecio(), "El precio con descuento debe ser 80");
    }
    
    @Test
    public void testConsultarPrecio(){
        when(repositorioMock.getPrecio("P005")).thenReturn(120.0);
        
        double precio = inventario.consultarPrecio("P005");
        
        assertEquals(120.0, precio);
    }
    

    
}
