package negocio.dominio;

import java.io.Serializable;

/**
 * Clase que modela un pedido.
 */
public class Pedido implements Serializable {

    private Integer idPedido;
    private String nombre;
    private float monto;
    private float descuento;

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Constructor de la clase pedido.
     * @param idPedido el id del pedido.
     * @param nombre el nombre del pedido.
     * @param monto el monto total a pagar por el pedido.
     * @param descuento el descuento a ser aplicado en el pedido.
     */
    public Pedido(Integer idPedido, String nombre, float monto, float descuento) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Devuelve el id del pedido.
     * @return un integer que representa el id del pedido.
     */
    public Integer getId() {
        return this.idPedido;
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Devuelve el nombre del pedido.
     * @return un string que representa el nombre del pedido.
     */
    public String getNombre() {
        return this.nombre;
    }
}
