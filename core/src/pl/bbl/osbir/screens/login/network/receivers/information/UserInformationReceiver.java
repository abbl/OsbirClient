package pl.bbl.osbir.screens.login.network.receivers.information;

import pl.bbl.network.client.ClientConnection;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.osbir.screens.login.director.LoginDirector;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInformationReceiver extends PacketReceiver{
    private static LoginDirector loginDirector;

    public UserInformationReceiver(LoginDirector loginDirector) {
        super("UserInformationReceiver");
        UserInformationReceiver.loginDirector = loginDirector;
    }

    @Override
    public void receivePacket(Packet packet, ClientConnection clientConnection) {
        switch (packet.getPacketType()){
            case "GAMESERVER_LIST":
                passGameServerList(packet);
        }
    }

    private void passGameServerList(Packet packet) {
        loginDirector.receiveGameServerList((ArrayList<HashMap<String, String>>) packet.getData("list"));
    }
}
