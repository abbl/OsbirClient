package pl.bbl.osbir.properties;

import java.io.Serializable;

public class OsbirProperties implements Serializable{
    private String authenticationServerHost = "localhost";
    private int authenticationServerPort = 9987;
    private static float viewportWidth = 1920;
    private static float viewportHeight = 1080;

    public OsbirProperties(){

    }

    public void importProperties(){

    }

    public void exportProperties(){

    }

    public String getAuthenticationServerHost() {
        return authenticationServerHost;
    }

    public int getAuthenticationServerPort() {
        return authenticationServerPort;
    }

    public static float getViewportWidth() {
        return viewportWidth;
    }

    public static float getViewportHeight() {
        return viewportHeight;
    }
}
