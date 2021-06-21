package com.context;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private static Context instance;
    private static Map<String, Object> context = new HashMap<>();

    public Context() {
    }

    public static Context get(String email) {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public static void clear() {
        context.clear();
    }

    public static <T> void put(String key, T object) {
        context.put(key, object);
    }

    public static <T> T get(String key, Class<T> userClass) {
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format("Object with key %s doesn't exist!", key));
        }
        return userClass.cast(object);
    }
}
