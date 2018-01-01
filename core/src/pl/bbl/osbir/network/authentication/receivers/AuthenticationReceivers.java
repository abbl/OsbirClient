package pl.bbl.osbir.network.authentication.receivers;

import pl.bbl.network.server.handlers.PacketHandler;
import pl.bbl.osbir.network.authentication.communication.information.receiver.AuthenticationReceiver;
import pl.bbl.osbir.network.authentication.connection.AuthenticationConnection;

public class AuthenticationReceivers {
    public static final String AUTHENTICATION_RECEIVER = "AUTHENTICATION_PACKETS";

    public static void createReceivers(PacketHandler packetHandler, AuthenticationConnection authenticationConnection){
        packetHandler.addReceiver(new AuthenticationReceiver(AUTHENTICATION_RECEIVER, authenticationConnection));
    }
}
