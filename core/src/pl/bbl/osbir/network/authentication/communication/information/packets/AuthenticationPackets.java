package pl.bbl.osbir.network.authentication.communication.information.packets;

import pl.bbl.network.packet.Packet;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;

public abstract class AuthenticationPackets {
    public static Packet requestLogin(String login, String password){
        return new Packet(AuthenticationReceivers.INFORMATION_RECEIVER, "AUTHENTICATION_START")
                .addData("login", login).addData("password", password);
    }
}
