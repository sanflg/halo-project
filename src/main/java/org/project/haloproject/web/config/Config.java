package org.project.haloproject.web.config;

public final class Config {
    private Config() {
    }

    public static Browser browser() {
        return Browser.from(System.getProperty("browser", "chrome"));
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

    public static boolean maximize() {
        return Boolean.parseBoolean(System.getProperty("maximize", "true"));
    }

    public static int timeout() {
        return Integer.parseInt(System.getProperty("timeout", "5"));
    }

    public enum Browser {
        CHROME,
        FIREFOX;

        public static Browser from(String value) {
            return Browser.valueOf(value.toUpperCase());
        }
    }
}
