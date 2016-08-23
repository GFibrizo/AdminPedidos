package Tests.Mocks;

import datos.cache_proxy.CacheProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabrizio on 23/08/16.
 */
public class MockCache implements CacheProxy {

    private Map<Integer, Object> data;

    public MockCache() {
        data = new HashMap<Integer, Object>();
    }

    @Override
    public void set(Integer key, Object value) {
        data.put(key, value);
    }

    @Override
    public Object get(Integer key) {
        return data.get(key);
    }

    @Override
    public void delete(Integer key) {
        data.remove(key);
    }
}
