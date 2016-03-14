package chapter2.staticFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 方便service的注册与访问
 * Created by Administrator on 2016/3/8.
 */
public class Services {
    /**
     * 私有构造函数
     */
    private Services(){}

    /**
     * map services names to services
     */
    private static final Map<String,Provider> providers =
            new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * provider register API
     */
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME,p);
    }


    public static void registerProvider(String name,Provider p){
        providers.put(name,p);
    }

    /**
     * service access API
     */
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if (p ==null){
            throw new IllegalArgumentException(
                    "No provider registered wiht name:"+name);
        }
        return p.newService();
    }





}
