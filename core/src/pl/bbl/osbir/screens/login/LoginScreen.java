package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.network.server.handler.PacketDistributor;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.player.Player;
import pl.bbl.osbir.screens.character.CharacterSelectScreen;
import pl.bbl.osbir.screens.login.director.LoginDirector;
import pl.bbl.osbir.network.authentication.loginscreen.receivers.authentication.AuthenticationPacketReceiver;
import pl.bbl.osbir.network.authentication.loginscreen.receivers.information.UserInformationReceiver;

public class LoginScreen extends AbstractScreen {
    private final NetworkDirector networkDirector;
    private final UserInterfaceManager userInterfaceManager;
    private final LoginDirector loginDirector;
    private final Player player;

    public LoginScreen(Game game) {
        super(game);
        this.networkDirector = new NetworkDirector();
        this.userInterfaceManager = new UserInterfaceManager(assetManager);
        this.player = new Player();
        this.loginDirector = new LoginDirector(actors, userInterfaceManager, networkDirector, player);
        initializePacketReceivers();
    }

    private void initializePacketReceivers(){
        PacketDistributor packetDistributor = new PacketDistributor();
        packetDistributor.registerPacketReceiver(new AuthenticationPacketReceiver(loginDirector, player));
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
        changeScreenToGameServer();
    }

    private void changeScreenToGameServer(){
        if(player.isVerified()){
            game.setScreen(new CharacterSelectScreen(game, assetManager, networkDirector, player, userInterfaceManager));
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        loginDirector.dispose();
    }
}
