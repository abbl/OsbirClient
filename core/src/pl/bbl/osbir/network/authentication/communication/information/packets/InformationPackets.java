package pl.bbl.osbir.network.authentication.communication.information.packets;

import pl.bbl.network.packet.Packet;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;

public abstract class InformationPackets {
    public static Packet requestGameServerList(){
        return new Packet(AuthenticationReceivers.AUTHENTICATION_RECEIVER, "REQUEST_GAMESERVER_LIST");
    }
}
