package pl.bbl.osbir.network.game;

import pl.bbl.network.client.Client;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.network.server.handler.PacketReceiver;
import pl.bbl.network.tools.LogType;
import pl.bbl.network.tools.NetworkLogger;
import pl.bbl.osbir.gameserver.GameServer;

public class GameServerConnection {
    private Client gameServerConnection;
    private Thread connectionThread;
    private GameServer gameServer;
    private PacketDistributor packetDistributor;

    public GameServerConnection(){
    }

    public void start(){
        if(packetDistributor != null && gameServer != null){
            this.gameServerConnection = new Client(gameServer.getHost(), gameServer.getPort(), packetDistributor);
            this.connectionThread = new Thread(gameServerConnection);
            connectionThread.start();
        }else{
            NetworkLogger.log(LogType.INFO, "Please provide PacketDistributor and GameServer object to establish connection to it.");
        }
    }

    public void sendPacket(Packet packet){
        if(gameServerConnection != null)
            gameServerConnection.write(packet);
    }

    public boolean isConnected(){
        if(gameServer != null)
            return gameServerConnection.isConnected();
        return false;
    }

    public void setGameServer(GameServer gameServer){
        this.gameServer = gameServer;
    }

    public void setPacketDistributor(PacketDistributor packetDistributor){
        this.packetDistributor = packetDistributor;
    }

    public void addPacketReceiver(PacketReceiver packetReceiver){
        if(packetDistributor != null)
            packetDistributor.registerPacketReceiver(packetReceiver);
    }
}
