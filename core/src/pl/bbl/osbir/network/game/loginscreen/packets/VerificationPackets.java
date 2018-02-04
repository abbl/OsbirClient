package pl.bbl.osbir.network.game.loginscreen.packets;

import pl.bbl.network.packet.Packet;

public class VerificationPackets {
    public static Packet createPlayerVerificationPacket(String userKey, String username){
        return new Packet("START_PLAYER_AUTHENTICATION").addData("userKey", userKey).addData("username", username);
    }
}
