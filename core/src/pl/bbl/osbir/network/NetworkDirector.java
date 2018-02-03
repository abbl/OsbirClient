package pl.bbl.osbir.network;

import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.network.tools.LogType;
import pl.bbl.network.tools.NetworkLogger;
import pl.bbl.osbir.network.authentication.AuthenticationConnectionWrapper;

public class NetworkDirector {
    private AuthenticationConnectionWrapper authenticationConnectionWrapper;
    private PacketDistributor authenticationPacketDistributor;

    public void establishAuthenticationServerConnection(){
        if(authenticationPacketDistributor != null){
            authenticationConnectionWrapper = new AuthenticationConnectionWrapper(authenticationPacketDistributor);
            authenticationConnectionWrapper.connect();
        }else{
            NetworkLogger.log(LogType.INFO, "[NetworkDirector] Please provide a packet distributor before you start a connection.");
        }
    }

    public void closeAuthenticationConnection(){
        if(authenticationConnectionWrapper != null)
            authenticationConnectionWrapper.close();
        else
            NetworkLogger.log(LogType.INFO, "Can't close connection which doesn't exist.");
    }

    public void setAuthenticationPacketDistributor(PacketDistributor authenticationPacketDistributor) {
        this.authenticationPacketDistributor = authenticationPacketDistributor;
    }

    public AuthenticationConnectionWrapper getAuthenticationConnectionWrapper(){
        return authenticationConnectionWrapper;
    }

    public boolean isConnected() {
        return authenticationConnectionWrapper.isConnected();
    }
}
