package pl.bbl.osbir.network.authentication;

import pl.bbl.network.client.Client;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.network.tools.LogType;
import pl.bbl.network.tools.NetworkLogger;
import pl.bbl.osbir.properties.OsbirProperties;

public class AuthenticationConnection {
    private Client connection;
    private Thread connectionThread;
    private PacketDistributor packetDistributor;

    public void connect(){
        if(packetDistributor != null){
            this.connection = new Client(
                    OsbirProperties.getAuthenticationServerHost(),
                    OsbirProperties.getAuthenticationServerPort(),
                    packetDistributor);
            this.connectionThread = new Thread(connection);
            this.connectionThread.start();
        }else{
            NetworkLogger.log(LogType.INFO, "[NetworkDirector] Please provide a packet distributor before you start a connection.");
        }
    }

    public void close(){
        if(connection != null)
            connectionThread.interrupt();
        else
            NetworkLogger.log(LogType.INFO, "[AuthenticationConnection.class] Can't close connecton which doesn't exist. ");
    }

    public void sendPacket(Packet packet){
        if(connection != null)
            connection.write(packet);
    }

    public void setPacketDistributor(PacketDistributor packetDistributor){
        this.packetDistributor = packetDistributor;
    }

    public boolean isConnected(){
        if(connection != null)
            return connection.isConnected();
        return false;
    }
}
