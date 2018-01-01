package pl.bbl.osbir.network;

import pl.bbl.osbir.network.authentication.AuthenticationConnectionWrapper;
import pl.bbl.osbir.properties.OsbirProperties;

public class NetworkDirector {
    private AuthenticationConnectionWrapper authenticationConnectionWrapper;

    public NetworkDirector(){
        authenticationConnectionWrapper = new AuthenticationConnectionWrapper(new OsbirProperties());
    }

    public AuthenticationConnectionWrapper establishAuthenticationServerConnection(){
        return authenticationConnectionWrapper.establishConnection();
    }
}
