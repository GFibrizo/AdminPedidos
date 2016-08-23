package datos.cache_proxy;

/**
 * Singleton que coniene la logica para realizar operaciones en la cache de
 * pedidos.
 */
public class BumexMemcached {

    /**
     * Constructor privado para evitar instanciar esta clase, que se suponse
     * es un singleton.
     */
    private BumexMemcached() {
        // TODO: Asumo que esta implementado
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Inserta un pedido en la cache de pedidos. Si habia un pedido con la misma
     * key que tiene el pedido que se quiere insertar, se pisa el pedido viejo.
     * @param key el id del pedido que se desea insertar.
     * @param value el pedido que se desea insertar.
     */
    public static void set(Integer key, Object value) {
        // TODO: Asumo que esta implementado
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene un pedido de la cache de pedidos.
     * @param key el id del pedido buscado.
     * @return el pedido buscado. Habra que castearlo a Pedido para acceder a
     * sus datos.
     */
    public static Object get(Integer key) {
        // TODO: Asumo que esta implementado
        return null;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina un pedido de la cache de pedidos.
     * @param key el id del pedido que se desea eliminar.
     */
    public static void delete(Integer key) {
        // TODO: Asumo que esta implementado
    }

}

