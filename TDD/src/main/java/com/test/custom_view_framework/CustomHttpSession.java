package com.test.custom_view_framework;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CustomHttpSession {
    private final Map<String, Object> impl = new ConcurrentHashMap<>();
    final static Long lifetime = 20_000L;

    public void putAttribute(String key, Object value){
        impl.put(key, value);
    }

    public Object getAttribute(String key){
        return impl.get(key);
    }

    public Iterator<String> getAttributeNames(){
       return impl.keySet().iterator();
    }

}

