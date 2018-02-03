package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.engine.ui.list.DefaultListDialog;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.player.Player;
import pl.bbl.osbir.screens.login.director.LoginDirector;
import pl.bbl.osbir.screens.login.network.receivers.authentication.AuthenticationPacketReceiver;
import pl.bbl.osbir.screens.login.network.receivers.information.UserInformationReceiver;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private UserInterfaceManager userInterfaceManager;
    private LoginDirector loginDirector;

    public LoginScreen(Game game) {
        super(game);
        this.networkDirector = new NetworkDirector();
        this.userInterfaceManager = new UserInterfaceManager(assetManager);
        this.loginDirector = new LoginDirector(actors, userInterfaceManager, networkDirector);
        initializePacketReceivers();
    }

    private void initializePacketReceivers(){
        PacketDistributor packetDistributor = new PacketDistributor();
        packetDistributor.registerPacketReceiver(new AuthenticationPacketReceiver(loginDirector));
        packetDistributor.registerPacketReceiver(new UserInformationReceiver(loginDirector));
        networkDirector.setAuthenticationPacketDistributor(packetDistributor);
    }

    @Override
    protected void draw() {
        loginDirector.render(spriteBatch);
    }

    @Override
    protected void update() {
        loginDirector.update();
    }

    @Override
    public void dispose() {
        super.dispose();
        loginDirector.dispose();
    }
}
