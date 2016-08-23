package datos.db_proxy;

import negocio.dominio.Pedido;

/**
 * Clase que "adapta" la interfaz de PedidosDAO para que implemente la interfaz DBProxy.
 * Wrapper de la clase PedidosDAO.
 */
public class PedidosDAOAdapter implements DBProxy {

    /**
     * Inserta un nuevo pedido en la base de datos o modifica un pedido
     * existente (en caso de crear uno nuevo el pedido pasado como parámetro se
     * completa con el nuevo id).
     * @param pedido : la instancia de Pedido a ser ingresada a la base de datos.
     */
    @Override
    public void insertOrUpdate(Pedido pedido) {
        PedidosDAO.insertOrUpdate(pedido);
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina el pedido que corresponde al id recibido.
     * @param pedido : La instancia de pedido recibida, trae dentro el id del
     *               pedido que se desea eliminar.
     */
    @Override
    public void delete(Pedido pedido) {
        PedidosDAO.delete(pedido);
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Busca un pedido por id.
     * @param idPedido
     * @return el pedido correspondiente al id pasado por parametro.
     */
    @Override
    public Pedido select(Integer idPedido) {
        return PedidosDAO.select(idPedido);
    }
}
