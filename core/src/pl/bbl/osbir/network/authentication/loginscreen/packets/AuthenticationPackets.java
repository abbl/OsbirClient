package pl.bbl.osbir.network.authentication.loginscreen.packets;

import pl.bbl.network.packet.Packet;

public class AuthenticationPackets {
    public static Packet createAuthenticationRequestPacket(String username, String password){
        return new Packet("REQUEST_USER_AUTHENTICATION").addData("username", username).addData("password", password);
    }

    public static Packet createUserKeyRequestPacket(){
        return new Packet("REQUEST_USER_ID");
    }
}
