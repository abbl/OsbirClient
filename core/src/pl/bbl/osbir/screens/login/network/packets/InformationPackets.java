package pl.bbl.osbir.screens.login.network.packets;

import pl.bbl.network.packet.Packet;

public class InformationPackets {
    public static Packet requestGameServerList(){
        return new Packet("REQUEST_GAMESERVER_LIST");
    }
}
