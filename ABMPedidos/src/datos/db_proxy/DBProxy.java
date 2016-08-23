package datos.db_proxy;

import dominio.Pedido;

/**
 * Interfaz que define las operaciones que podran realizar las clases concretas
 * que se comuniquen con la BD.
 */
public interface DBProxy {

    /**
     * Inserta un nuevo pedido en la base de datos o modifica un pedido
     * existente (en caso de crear uno nuevo el pedido pasado como parámetro se
     * completa con el nuevo id).
     * @param pedido : la instancia de Pedido a ser ingresada a la base de datos.
     */
    public void insertOrUpdate(Pedido pedido);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina el pedido que corresponde al id recibido.
     * @param pedido : La instancia de pedido recibida, trae dentro el id del
     *               pedido que se desea eliminar.
     */
    public void delete(Pedido pedido);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Busca un pedido por id.
     * @param idPedido
     * @return el pedido correspondiente al id pasado por parametro.
     */
    public Pedido select(Integer idPedido);


}
