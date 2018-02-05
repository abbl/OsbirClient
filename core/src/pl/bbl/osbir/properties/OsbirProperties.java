package pl.bbl.osbir.properties;

import java.io.Serializable;

public class OsbirProperties implements Serializable{
    private static String authenticationServerHost = "localhost";
    private static int authenticationServerPort = 9987;
    private static float viewportWidth = 1024;
    private static float viewportHeight = 720;

    public static String getAuthenticationServerHost() {
        return authenticationServerHost;
    }

    public static int getAuthenticationServerPort() {
        return authenticationServerPort;
    }

    public static float getViewportWidth() {
        return viewportWidth;
    }

    public static float getViewportHeight() {
        return viewportHeight;
    }
}
