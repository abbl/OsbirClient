package pl.bbl.osbir.properties;

import java.io.Serializable;

public class OsbirProperties implements Serializable{
    private String authenticationServerHost = "localhost";
    private int authenticationServerPort = 9987;
    private float viewportWidth = 1920;
    private float viewportHeight = 1080;

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

    public float getViewportWidth() {
        return viewportWidth;
    }

    public float getViewportHeight() {
        return viewportHeight;
    }
}
