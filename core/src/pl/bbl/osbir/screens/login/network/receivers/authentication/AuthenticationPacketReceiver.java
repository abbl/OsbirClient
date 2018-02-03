package pl.bbl.osbir.screens.login.network.receivers.authentication;

import pl.bbl.network.client.ClientConnection;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class AuthenticationPacketReceiver extends PacketReceiver{
    private LoginDirector loginDirector;

    public AuthenticationPacketReceiver(LoginDirector loginDirector) {
        super("AuthenticationPacketReceiver");
        this.loginDirector = loginDirector;
    }

    @Override
    public void receivePacket(Packet packet, ClientConnection clientConnection) {
        switch (packet.getPacketType()){
            case "USER_AUTHENTICATION_RESULT":
                loginDirector.receiveAuthenticationResult((boolean) packet.getData("result"));
        }
    }
}
