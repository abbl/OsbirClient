package pl.bbl.osbir.network.authentication.loginscreen.receivers.authentication;

import pl.bbl.network.client.ClientConnection;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.osbir.player.Player;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class AuthenticationPacketReceiver extends PacketReceiver{
    private LoginDirector loginDirector;
    private Player player;

    public AuthenticationPacketReceiver(LoginDirector loginDirector, Player player) {
        super("AuthenticationPacketReceiver");
        this.loginDirector = loginDirector;
        this.player = player;
    }

    @Override
    public void receivePacket(Packet packet, ClientConnection clientConnection) {
        switch (packet.getPacketType()){
            case "USER_AUTHENTICATION_RESULT":
                loginDirector.receiveAuthenticationResult((boolean) packet.getData("result"));
                break;
            case "USER_ID":
                player.setUserKey((String) packet.getData("userId"));
        }
    }
}
