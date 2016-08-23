package datos;

import datos.cache_proxy.CacheProxy;
import datos.db_proxy.DBProxy;
import dominio.Pedido;

/**
 * Clase que realiza las operaciones de Alta, Baja, Modificacion y Busqueda de
 * pedidos en los medios de almacenamiento de datos.
 */
public class Repositorio {

    private CacheProxy cache;
    private DBProxy dataBase;

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Constructor de la clase Repositorio.
     * @param dbProxy el objeto que se comunicara con la base de datos.
     * @param cacheProxy el objeto que se comunicara con el cache
     */
    public Repositorio(DBProxy dbProxy, CacheProxy cacheProxy) {
        dataBase = dbProxy;
        cache = cacheProxy;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Crea una nuevo pedido, lo almacena en la base de datos y la cache.
     * @param pedido el pedido a ser creado y almacenado.
     */
    public void crear(Pedido pedido) {
        dataBase.insertOrUpdate(pedido);
        cache.set(pedido.getId(), pedido);
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Modifica un pedido antes guardado.
     * @param idPedido
     * @param pedido
     */
    public void modificar(int idPedido, Pedido pedido) {
        dataBase.insertOrUpdate(pedido);
        cache.delete(idPedido);         // Esto podria estar de mas si set
        cache.set(idPedido, pedido);    // pisara el pedido viejo con idPedido
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene un pedido previamente almacenado.
     * @param idPedido id del pedido buscado.
     * @return el pedido buscado.
     */
    public Pedido buscar(int idPedido) {
        Pedido pedido = (Pedido) cache.get(idPedido);
        if (pedido != null) return pedido;
        pedido = dataBase.select(idPedido);
        cache.set(idPedido, pedido);
        return pedido;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina un pedido de los que se encuentren guardados.
     * @param idPedido id del pedido a eliminar.
     */
    public void eliminar(int idPedido) {
        Pedido pedido = (Pedido) cache.get(idPedido);
        if (pedido != null) {
            cache.delete(idPedido);
        }
        pedido = dataBase.select(idPedido);
        dataBase.delete(pedido);
    }
}
