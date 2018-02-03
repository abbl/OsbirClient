package pl.bbl.osbir.screens.login.network.packets;

import pl.bbl.network.packet.Packet;

public class AuthenticationPackets {
    public static Packet createAuthenticationRequestPacket(String username, String password){
        return new Packet("REQUEST_USER_AUTHENTICATION").addData("username", username).addData("password", password);
    }
}
