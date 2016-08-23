package Tests;

import Tests.Mocks.MockCache;
import Tests.Mocks.MockDB;
import datos.Repositorio;
import datos.cache_proxy.CacheProxy;
import datos.db_proxy.DBProxy;
import dominio.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepositorioTest {

    private Repositorio repositorio;
    private final int idPedido = 1;
    private final String nombrePedido = "pizza";
    private final float montoPedido = 90;
    private final float descuentoPedido = 5;

    @Before
    public void setUp() throws Exception {
        DBProxy db = new MockDB();
        CacheProxy cache = new MockCache();
        repositorio = new Repositorio(db, cache);
        Pedido pedido = new Pedido(idPedido, nombrePedido, montoPedido, descuentoPedido);
        repositorio.crear(pedido);
    }

    @Test
    public void testCrear() throws Exception {
        Pedido pedido = new Pedido(2, "torta", 20, 10);
        repositorio.crear(pedido);
        Pedido pedidoBuscado = repositorio.buscar(pedido.getId());
        assertEquals(pedido.getId(), pedidoBuscado.getId());
    }

    @Test
    public void testModificar() throws Exception {
        String nuevoProducto = "empanadas";
        Pedido pedido = new Pedido(idPedido, nuevoProducto, 80, 10);
        repositorio.modificar(idPedido, pedido);
        Pedido buscado = repositorio.buscar(pedido.getId());
        assertEquals(nuevoProducto, pedido.getNombre());
    }

    @Test
    public void testBuscar() throws Exception {
        Pedido pedido = repositorio.buscar(idPedido);
        assertTrue(idPedido == pedido.getId());
        assertEquals(nombrePedido, pedido.getNombre());
    }

    @Test
    public void testEliminar() throws Exception {
        repositorio.eliminar(idPedido);
        Pedido pedido = repositorio.buscar(idPedido);
        assertNull(pedido);
    }
}