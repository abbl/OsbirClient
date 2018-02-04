package pl.bbl.osbir.network;

import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.network.tools.LogType;
import pl.bbl.network.tools.NetworkLogger;
import pl.bbl.osbir.gameserver.GameServer;
import pl.bbl.osbir.network.authentication.AuthenticationConnection;
import pl.bbl.osbir.network.game.GameServerConnection;

public class NetworkDirector {
    private AuthenticationConnection authenticationConnection;
    private GameServerConnection gameServerConnection;

    public NetworkDirector(){
        this.authenticationConnection = new AuthenticationConnection();
        this.gameServerConnection = new GameServerConnection();
    }

    /*
     * AuthenticationServer connection
     */

    public void establishAuthenticationServerConnection(){
        authenticationConnection.connect();
    }

    public void closeAuthenticationConnection(){
        authenticationConnection.close();
    }

    public boolean isAutheticationConnectionEstablished(){
        return authenticationConnection.isConnected();
    }

    public void setAuthenticationPacketDistributor(PacketDistributor authenticationPacketDistributor) {
        authenticationConnection.setPacketDistributor(authenticationPacketDistributor);
    }

    public AuthenticationConnection getAuthenticationConnection(){
        return authenticationConnection;
    }

    /*
     * GameServer connection
     */

    public void establishConnectionWithGameServer(){
        gameServerConnection.start();
    }

    public void sendGameServerPacket(Packet packet){
        gameServerConnection.sendPacket(packet);
    }

    public void setGameServer(GameServer gameServer){
        gameServerConnection.setGameServer(gameServer);
    }

    public void setGameServerPacketDistributor(PacketDistributor gameServerPacketDistributor){
        gameServerConnection.setPacketDistributor(gameServerPacketDistributor);
    }

    public boolean isGameServerConnectionEstablished(){
        return gameServerConnection.isConnected();
    }

    public GameServer getGameServer(){
        return gameServerConnection.getGameServer();
    }

    public void addPacketReceiverIntoGameServer(PacketReceiver packetReceiver){
        gameServerConnection.addPacketReceiver(packetReceiver);
    }
}
