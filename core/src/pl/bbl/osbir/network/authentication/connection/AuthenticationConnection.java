package pl.bbl.osbir.network.authentication.connection;

import pl.bbl.network.client.AbstractClient;

public class AuthenticationConnection extends AbstractClient{
    public AuthenticationConnection(String host, int port) {
        super(host, port);
    }
}
