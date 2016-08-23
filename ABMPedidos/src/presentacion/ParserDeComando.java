package presentacion;

import dominio.Pedido;

/**
 * Clase que contiene la logica de parseo de strings para obtener la operacion
 * y el pedido que se encuentren en dichos strings.
 */
public class ParserDeComando {

    /**
     * Obtiene la operacion a realizar a partir del comando recibido por
     * parametro.
     * @param comando el comando a parsear
     * @return un String que representa la operacion a realizar.
     */
    public static String obtenerOperacion(String comando) {
        try {
            String[] partes = comando.split(" ");
            String operacion = partes[0];
            return operacion;
        } catch (Exception e) {
            return null;
        }
    }

    /**************************************************************************/
    /**************************************************************************/

    /**
     * Obtiene el pedido a partir del comando recibido por parametro.
     * @param comando el comando a parsear.
     * @return una instancia de pedido
     */
    public static Pedido obtenerPedido(String comando) {

        int id = 0;
        String nombre = "";
        float monto = 0;
        float descuento = 0;

        try {
            String[] partes = comando.split(" ");
            String operacion = partes[0];
            String pedido = partes[1];

            if ((operacion.equals(Constantes.CREAR))
                    || (operacion.equals(Constantes.MODIFICAR))) {
                String[] pedidoPartes = pedido.split(",");
                id = Integer.valueOf(pedidoPartes[0]);
                nombre = pedidoPartes[1];
                monto = Integer.valueOf(pedidoPartes[2]);
                descuento = Integer.valueOf(pedidoPartes[3]);
            } else {
                id = Integer.valueOf(pedido);
            }
            return new Pedido(id, nombre, monto, descuento);
        } catch (Exception e) {
            return null;
        }
    }
}