package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;
    private UserInterfaceManager userInterfaceManager;

    public LoginScreen(Game game) {
        super(game);
        networkDirector = new NetworkDirector();
        userInterfaceManager = new UserInterfaceManager(assetManager);
        loginDirector = new LoginDirector(stage, userInterfaceManager.getSkin(), assetManager);
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
        userInterfaceManager.dispose();
    }
}
