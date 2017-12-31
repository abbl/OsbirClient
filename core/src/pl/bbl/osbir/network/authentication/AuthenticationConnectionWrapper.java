package pl.bbl.osbir.network.authentication;

import pl.bbl.osbir.network.authentication.connection.AuthenticationConnection;
import pl.bbl.osbir.properties.OsbirProperties;

public class AuthenticationConnectionWrapper {
    private AuthenticationConnection authenticationConnection;
    private Thread thread;

    public AuthenticationConnectionWrapper(OsbirProperties osbirProperties){
        initializeConnection(osbirProperties);
    }

    private void initializeConnection(OsbirProperties osbirProperties){
        authenticationConnection = new AuthenticationConnection(osbirProperties.getAuthenticationServerHost(), osbirProperties.getAuthenticationServerPort());
        thread = new Thread(authenticationConnection);
    }

    public void estaliblishConnection(){
        thread.start();
    }
}
