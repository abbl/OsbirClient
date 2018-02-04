package pl.bbl.osbir.network.authentication.loginscreen.packets;

import pl.bbl.network.packet.Packet;

public class InformationPackets {
    public static Packet requestGameServerList(){
        return new Packet("REQUEST_GAMESERVER_LIST");
    }
}
