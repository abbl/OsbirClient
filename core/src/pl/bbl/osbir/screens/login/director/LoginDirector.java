package pl.bbl.osbir.screens.login.director;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.tools.ConditionalTrigger;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.gameserver.GameServer;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.ui.LoginScreenLayout;
import pl.bbl.osbir.screens.login.network.packets.AuthenticationPackets;
import pl.bbl.osbir.screens.login.network.packets.InformationPackets;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginDirector {
    private LoginScreenLayout layout;
    private NetworkDirector networkDirector;

    public LoginDirector(Stack mainStack, UserInterfaceManager userInterfaceManager, NetworkDirector networkDirector){
        this.layout = new LoginScreenLayout(mainStack, userInterfaceManager.getSkin(), userInterfaceManager.getAssetManager(), this);
        this.networkDirector = networkDirector;
    }

    public void startLoginProcess(String login, String password) {
        layout.displayConnectingWindow();
        networkDirector.establishAuthenticationServerConnection();
        requestAuthenticationAfterConnectionIsEstablished(login, password).start();
    }

    private ConditionalTrigger requestAuthenticationAfterConnectionIsEstablished(final String login, final String password){
        return new ConditionalTrigger(){
            @Override
            protected boolean isConditionTrue() {
                return networkDirector.getAuthenticationConnection().isConnected();
            }

            @Override
            protected void doSomething() {
                layout.hideConnectingWindow();
                requestLogin(login, password);
            }
        };
    }

    private void requestLogin(String login, String password){
        layout.displayLoggingInWindow();
        networkDirector.getAuthenticationConnection().sendPacket(AuthenticationPackets.createAuthenticationRequestPacket(login, password));
    }

    public void receiveAuthenticationResult(boolean result) {
        layout.hideLoggingInWindow();
        if(result){
            layout.displayRequestingServerListWindow();
            networkDirector.getAuthenticationConnection().sendPacket(InformationPackets.requestGameServerList());
        }else{
            layout.displayLoginFailureDialog();
            networkDirector.closeAuthenticationConnection();
        }
    }

    public void receiveGameServerList(ArrayList<HashMap<String, String>> gameserverList) {
        layout.hideRequestingServerListWindow();
        ArrayList<GameServer> gameServers = new ArrayList<>();

        for(HashMap<String , String> server : gameserverList){
            gameServers.add(new GameServer(server.get("name"), server.get("host"), Integer.parseInt(server.get("port"))));
        }
        layout.displayGameServerSelection(gameServers.toArray(new GameServer[gameServers.size()]));
    }

    public void receiveSelectedServer(Object object) {

    }

    public void render(SpriteBatch spriteBatch){
        layout.render(spriteBatch);
    }

    public void update(){

    }

    public void dispose() {

    }
}
