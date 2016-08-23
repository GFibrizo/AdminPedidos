package datos.cache_proxy;

/**
 * Clase que "adapta" la interfaz de BumexMemcached para que implemente la interfaz CacheProxy.
 * Wrapper de la clase BumexMemcached.
 */
public class BumexMemcachedAdapter implements CacheProxy{

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Inserta un pedido en la cache de pedidos. Si habia un pedido con la misma
     * key que tiene el pedido que se quiere insertar, se pisa el pedido viejo.
     * @param key el id del pedido que se desea insertar.
     * @param value el pedido que se desea insertar.
     */
    @Override
    public void set(Integer key, Object value) {
        BumexMemcached.set(key, value);
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene un pedido de la cache de pedidos.
     * @param key el id del pedido buscado.
     * @return el pedido buscado. Habra que castearlo a Pedido para acceder a
     * sus datos.
     */
    @Override
    public Object get(Integer key) {
        return BumexMemcached.get(key);
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina un pedido de la cache de pedidos.
     * @param key el id del pedido que se desea eliminar.
     */
    @Override
    public  void delete(Integer key) {
        BumexMemcached.delete(key);
    }
}
