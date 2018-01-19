package pl.bbl.osbir.network.authentication.communication.authentication.receiver;

import pl.bbl.network.client.AbstractClient;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handlers.PacketReceiver;
import pl.bbl.osbir.network.authentication.communication.authentication.packets.AuthenticationPackets;

public class AuthenticationReceiver extends PacketReceiver{
    private boolean isAuthenticationResultReceived = false;
    private boolean authenticationResult = false;

    public AuthenticationReceiver(String receiverType, AbstractClient abstractClient) {
        super(receiverType, abstractClient);
    }

    @Override
    public boolean receive(Packet packet) {
        switch (packet.packetPurpose){
            case "AUTHENTICATION_RESULT":
                isAuthenticationResultReceived = true;
                authenticationResult = (Boolean) packet.getData("result");
        }
        return false;
    }

    public void requestLoginProcess(String login, String password){
        abstractClient.write(AuthenticationPackets.requestLogin(login, password));
    }

    public boolean isAuthenticationResultReceived() {
        return isAuthenticationResultReceived;
    }

    public boolean getAuthenticationResult() {
        return authenticationResult;
    }
}
