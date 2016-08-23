package datos.cache_proxy;

/**
 * Interfaz que define las operaciones que podran realizar las clases concretas
 * que se comuniquen con la Cache.
 */
public interface CacheProxy {

    /**
     * Inserta un pedido en la cache de pedidos. Si habia un pedido con la misma
     * key que tiene el pedido que se quiere insertar, se pisa el pedido viejo.
     * @param key el id del pedido que se desea insertar.
     * @param value el pedido que se desea insertar.
     */
    public void set(Integer key, Object value);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene un pedido de la cache de pedidos.
     * @param key el id del pedido buscado.
     * @return el pedido buscado. Habra que castearlo a Pedido para acceder a
     * sus datos.
     */
    public Object get(Integer key);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina un pedido de la cache de pedidos.
     * @param key el id del pedido que se desea eliminar.
     */
    public void delete(Integer key);

}
