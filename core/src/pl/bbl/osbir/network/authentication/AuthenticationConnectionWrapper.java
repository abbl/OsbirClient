package pl.bbl.osbir.network.authentication;

import pl.bbl.osbir.network.authentication.communication.authentication.receiver.AuthenticationReceiver;
import pl.bbl.osbir.network.authentication.communication.information.receiver.InformationReceiver;
import pl.bbl.osbir.network.authentication.connection.AuthenticationConnection;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;
import pl.bbl.osbir.properties.OsbirProperties;

public class AuthenticationConnectionWrapper {
    private OsbirProperties osbirProperties;
    private AuthenticationConnection authenticationConnection;
    private Thread thread;

    public AuthenticationConnectionWrapper(OsbirProperties osbirProperties){
        this.osbirProperties = osbirProperties;
    }

    private void initializeConnection(){
        authenticationConnection = new AuthenticationConnection(osbirProperties.getAuthenticationServerHost(), osbirProperties.getAuthenticationServerPort());
        thread = new Thread(authenticationConnection);
    }

    public AuthenticationConnectionWrapper establishConnection(){
        initializeConnection();
        thread.start();
        return this;
    }

    public AuthenticationReceiver getAuthenticationReceiver(){
        return (AuthenticationReceiver) authenticationConnection.getPacketReceiver(AuthenticationReceivers.AUTHENTICATION_RECEIVER);
    }

    public InformationReceiver getInformationReceiver(){
        return (InformationReceiver) authenticationConnection.getPacketReceiver(AuthenticationReceivers.INFORMATION_RECEIVER);
    }

    public boolean isConnected(){
        return authenticationConnection != null && authenticationConnection.isConnected();
    }
}
