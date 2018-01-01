package pl.bbl.osbir.network.authentication.communication.information.receiver;

import pl.bbl.network.client.AbstractClient;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handlers.PacketReceiver;

public class InformationReceiver extends PacketReceiver{
    public InformationReceiver(String receiverType, AbstractClient abstractClient) {
        super(receiverType, abstractClient);
    }

    @Override
    public boolean receive(Packet packet) {
        return false;
    }

    public void requestUserId(){

    }

    public void passUserId(){

    }

    public void requestGameServerList(){

    }

    public void passGameServerList(){

    }
}
