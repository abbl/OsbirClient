package pl.bbl.osbir.network.authentication.connection;

import io.netty.channel.ChannelPipeline;
import pl.bbl.network.client.AbstractClient;
import pl.bbl.network.server.handlers.PacketHandler;
import pl.bbl.network.server.handlers.PacketReceiver;
import pl.bbl.osbir.network.authentication.receivers.AuthenticationReceivers;

public class AuthenticationConnection extends AbstractClient{
    PacketHandler packetHandler;

    public AuthenticationConnection(String host, int port) {
        super(host, port);
        packetHandler = new PacketHandler();
    }

    @Override
    protected void addHandlersToChannel(ChannelPipeline pipeline) {
        super.addHandlersToChannel(pipeline);

        pipeline.addLast("PACKET_HANDLER", packetHandler);
        AuthenticationReceivers.createReceivers(packetHandler, this);
    }

    public PacketReceiver getPacketReceiver(String receiverType){
        return packetHandler.getReceiver(receiverType);
    }

}
