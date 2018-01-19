package pl.bbl.osbir.network;

import pl.bbl.osbir.network.authentication.AuthenticationConnectionWrapper;
import pl.bbl.osbir.properties.OsbirProperties;

public class NetworkDirector {
    private AuthenticationConnectionWrapper authenticationConnectionWrapper;

    public NetworkDirector() {
        authenticationConnectionWrapper = new AuthenticationConnectionWrapper(new OsbirProperties());
    }

    public void establishAuthenticationServerConnection() {
        authenticationConnectionWrapper.establishConnection();
    }

    public boolean isAuthenticationConnectionEstablished() {
        return authenticationConnectionWrapper != null && authenticationConnectionWrapper.isConnected();
    }

    public AuthenticationConnectionWrapper getAuthenticationConnectionWrapper() {
        return authenticationConnectionWrapper;
    }
}
