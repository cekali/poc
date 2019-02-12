package com.geospiza.poc;

public class ThreadLocalStorage {

    private static ThreadLocal<String> tenant = new ThreadLocal<>();

    public static void setTenantName(String tenantName) {
        tenant.set(tenantName);
    }

    public static String getTenantName() {
        return null == tenant.get() ? "basic" : tenant.get();
    }

}
