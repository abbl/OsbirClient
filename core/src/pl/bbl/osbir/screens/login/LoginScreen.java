package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private UserInterfaceManager userInterfaceManager;
    private LoginDirector loginDirector;

    public LoginScreen(Game game) {
        super(game);
        this.networkDirector = new NetworkDirector();
        this.userInterfaceManager = new UserInterfaceManager(assetManager);
        this.loginDirector = new LoginDirector(actors, assetManager, userInterfaceManager, networkDirector);
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
