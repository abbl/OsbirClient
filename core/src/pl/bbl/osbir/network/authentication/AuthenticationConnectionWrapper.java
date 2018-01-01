package pl.bbl.osbir.network.authentication;

import pl.bbl.osbir.network.authentication.communication.authentication.receiver.AuthenticationReceiver;
import pl.bbl.osbir.network.authentication.communication.information.receiver.InformationReceiver;
import pl.bbl.osbir.network.authentication.connection.AuthenticationConnection;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;
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

    public AuthenticationConnectionWrapper establishConnection(){
        thread.start();
        return this;
    }

    public AuthenticationReceiver getAuthenticationReceiver(){
        return (AuthenticationReceiver) authenticationConnection.getPacketReceiver(AuthenticationReceivers.AUTHENTICATION_RECEIVER);
    }

    public InformationReceiver getInformationReceiver(){
        return (InformationReceiver) authenticationConnection.getPacketReceiver(AuthenticationReceivers.INFORMATION_RECEIVER);
    }
}
