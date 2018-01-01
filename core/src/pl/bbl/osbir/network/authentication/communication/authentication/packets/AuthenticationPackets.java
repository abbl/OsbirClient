package pl.bbl.osbir.network.authentication.communication.authentication.packets;

import pl.bbl.network.packet.Packet;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;

public abstract class AuthenticationPackets {
    public static Packet requestLogin(String login, String password){
        return new Packet(AuthenticationReceivers.AUTHENTICATION_RECEIVER, "AUTHENTICATION_START")
                .addData("login", login).addData("password", password);
    }

    public static Packet requestUserId(){
        return new Packet(AuthenticationReceivers.AUTHENTICATION_RECEIVER, "REQUEST_USER_ID");
    }
}
