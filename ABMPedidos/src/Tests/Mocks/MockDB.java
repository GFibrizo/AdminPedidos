package Tests.Mocks;

import datos.db_proxy.DBProxy;
import negocio.dominio.Pedido;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabrizio on 23/08/16.
 */
public class MockDB implements DBProxy {

    private Map<Integer, Pedido> data;

    public MockDB() {
        data = new HashMap<Integer, Pedido>();
    }

    @Override
    public void insertOrUpdate(Pedido pedido) {
        Integer id = pedido.getId();
        data.put(id, pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        data.remove(pedido.getId());
    }

    @Override
    public Pedido select(Integer idPedido) {
        return data.get(idPedido);
    }
}
