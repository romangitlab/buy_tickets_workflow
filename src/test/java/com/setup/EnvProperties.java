package com.setup;

public final class EnvProperties {
    public static final String BASE_URL = System.getProperty("baseUrl", "https://www.cp.pt");
    static final Integer DEFAULT_TIMEOUT = Integer.parseInt(System.getProperty("timeout", "5"));
}
