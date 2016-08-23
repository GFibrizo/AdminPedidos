package datos.db_proxy;

import dominio.Pedido;

/**
 * Created by fabrizio on 19/08/16.
 */
public class PedidosDAO {


    private PedidosDAO() {
        // TODO: Asumo que esta implementado
    }

    /**************************************************************************/
    /**************************************************************************/
    /**
     * Inserta un nuevo pedido en la base de datos o modifica un pedido
     * existente (en caso de crear uno nuevo el pedido pasado como parámetro se
     * completa con el nuevo id).
     * @param pedido : la instancia de Pedido a ser ingresada a la base de datos.
     */
    public static void insertOrUpdate(Pedido pedido) {
        // TODO: Asumo que esta implementado
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina el pedido que corresponde al id recibido.
     * @param pedido : La instancia de pedido recibida, trae dentro el id del
     *               pedido que se desea eliminar.
     */
    public static void delete(Pedido pedido) {
        // TODO: Asumo que esta implementado
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Busca un pedido por id.
     * @param idPedido
     * @return el pedido correspondiente al id pasado por parametro.
     */
    public static Pedido select(Integer idPedido) {
        // TODO: Asumo que esta implementado
        return null;
    }

}

