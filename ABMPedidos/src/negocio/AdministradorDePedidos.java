package negocio;

import negocio.dominio.Pedido;
import presentacion.Constantes;


/**
 * La clase que se encarga de decidir que operacion se debe llevar a cabo en
 * cada momento.
 */
public class AdministradorDePedidos {

    private RepositorioInterface repositorio;

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Constructor de la clase AdministradorDePedidos
     * @param repo el repositorio que manejara los datos de los pedidos.
     */
    public AdministradorDePedidos(RepositorioInterface repo) {
        repositorio = repo;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Realiza la operacion indicada por el parametro operacion con el pedido
     * recibido tambien por parametro.
     * @param operacion la operacion a realizar. Los valores validos son:
     *                  crear, modificar, buscar, eliminar.
     * @param pedido el pedido sobre el cual se va a realizar la operacion.
     */
    public void realizarOperacion(String operacion, Pedido pedido) {
        if (operacion.equals(Constantes.CREAR)) {
            repositorio.crear(pedido);
        } else if (operacion.equals(Constantes.BUSCAR)) {
            repositorio.buscar(pedido.getId());
        } else if (operacion.equals(Constantes.MODIFICAR)) {
            repositorio.modificar(pedido.getId(), pedido);
        } else if (operacion.equals(Constantes.ELIMINAR)) {
            repositorio.eliminar(pedido.getId());
        }
    }
}
