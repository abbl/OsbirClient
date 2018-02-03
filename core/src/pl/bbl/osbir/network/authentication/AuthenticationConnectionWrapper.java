package pl.bbl.osbir.network.authentication;

import pl.bbl.network.client.Client;
import pl.bbl.network.packet.Packet;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.osbir.properties.OsbirProperties;

public class AuthenticationConnectionWrapper {
    private Client connection;
    private Thread connectionThread;

    public AuthenticationConnectionWrapper(PacketDistributor packetDistributor){
        this.connection = new Client(OsbirProperties.getAuthenticationServerHost(), OsbirProperties.getAuthenticationServerPort(), packetDistributor);
        this.connectionThread = new Thread(connection);
    }

    public void connect(){
        connectionThread.start();
    }

    public void close(){
        connectionThread.interrupt();
    }

    public void sendPacket(Packet packet){
        connection.write(packet);
    }

    public boolean isConnected(){
        return connection.isConnected();
    }
}
