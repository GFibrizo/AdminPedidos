package presentacion;

import datos.Repositorio;
import datos.cache_proxy.BumexMemcachedAdapter;
import datos.cache_proxy.CacheProxy;
import datos.db_proxy.DBProxy;
import datos.db_proxy.PedidosDAOAdapter;
import negocio.AdministradorDePedidos;

/**
 * Clase que concentra y aisla las dependencias. Trata de emular lo que hacen
 * algunos frameworks de inyeccion de dependencias.
 */
public class Inicializador {

    public static AdministradorDePedidos inicializarAdministrador() {
        DBProxy pedidosDB = new PedidosDAOAdapter();
        CacheProxy pedidosCache = new BumexMemcachedAdapter();
        Repositorio repositorio = new Repositorio(pedidosDB, pedidosCache);
        return new AdministradorDePedidos(repositorio);
    }
}
