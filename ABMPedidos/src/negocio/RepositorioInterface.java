package negocio;

import negocio.dominio.Pedido;

/**
 * Created by fabrizio on 23/08/16.
 */
public interface RepositorioInterface {

    /**
     * Crea una nuevo pedido, lo almacena en la base de datos y la cache.
     * @param pedido el pedido a ser creado y almacenado.
     */
    public void crear(Pedido pedido);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Modifica un pedido antes guardado.
     * @param idPedido
     * @param pedido
     */
    public void modificar(int idPedido, Pedido pedido);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene un pedido previamente almacenado.
     * @param idPedido id del pedido buscado.
     * @return el pedido buscado.
     */
    public Pedido buscar(int idPedido);

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Elimina un pedido de los que se encuentren guardados.
     * @param idPedido id del pedido a eliminar.
     */
    public void eliminar(int idPedido);

}
