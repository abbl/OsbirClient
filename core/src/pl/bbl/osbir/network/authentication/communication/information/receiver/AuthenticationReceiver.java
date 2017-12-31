package pl.bbl.osbir.network.authentication.communication.information.receiver;

import pl.bbl.network.client.AbstractClient;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handlers.PacketReceiver;
import pl.bbl.osbir.network.authentication.communication.information.packets.AuthenticationPackets;

public class AuthenticationReceiver extends PacketReceiver{
    public AuthenticationReceiver(String receiverType, AbstractClient abstractClient) {
        super(receiverType, abstractClient);
    }

    @Override
    public boolean receive(Packet packet) {
        switch (packet.packetPurpose){
            case "AUTHENTICATION_RESULT":
                passLoginResult((Boolean) packet.getData("result"));
        }
        return false;
    }

    public void requestLoginProcess(String login, String password){
        abstractClient.write(AuthenticationPackets.requestLogin(login, password));
    }

    public void passLoginResult(boolean result){

    }
}
