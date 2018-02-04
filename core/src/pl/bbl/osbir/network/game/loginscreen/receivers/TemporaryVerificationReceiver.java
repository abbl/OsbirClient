package pl.bbl.osbir.network.game.loginscreen.receivers;

import pl.bbl.network.client.ClientConnection;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.osbir.player.Player;

public class TemporaryVerificationReceiver extends PacketReceiver{
    private Player player;

    public TemporaryVerificationReceiver(Player player) {
        super("TemporaryVerificationReceiver");
        this.player = player;
    }

    @Override
    public void receivePacket(Packet packet, ClientConnection clientConnection) {
        switch (packet.getPacketType()){
            case "PLAYER_VERIFICATION_RESULT":
                setVerificationResult(packet);
        }
    }

    private void setVerificationResult(Packet packet) {
        player.setVerificationResult((boolean) packet.getData("result"));
    }
}
