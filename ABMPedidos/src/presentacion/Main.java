package presentacion;

import negocio.dominio.Pedido;
import negocio.AdministradorDePedidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        AdministradorDePedidos administradorDePedidos = Inicializador.inicializarAdministrador();

        mostrarAyuda();
        BufferedReader br = null;
        String comando = "";
        br = new BufferedReader(new InputStreamReader(System.in));;

        try {
            comando = br.readLine();
            while (!comando.equals("salir")) {
                String operacion = ParserDeComando.obtenerOperacion(comando);
                Pedido pedido = ParserDeComando.obtenerPedido(comando);
                if ((operacion == null) || (pedido == null)) {
                    showError();
                } else {
                    administradorDePedidos.realizarOperacion(operacion, pedido);
                }
                comando = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**************************************************************************/
    /**************************************************************************/

    private static void mostrarAyuda() {
        System.out.println("Uso:");
        System.out.println("'operacion' idPedido,nombre,monto,descuento");
        System.out.println("\nValores de operacion:");
        System.out.println("\tcrear");
        System.out.println("\tmodificar");
        System.out.println("\tbuscar");
        System.out.println("\teliminar");

        System.out.println("\nPara terminar ingresar:");
        System.out.println("\tsalir");
    }

    /**************************************************************************/
    /**************************************************************************/

    private static void showError() {
        System.out.println("Error. El comando ingresado no cumple el formato establecido.");
    }
}
