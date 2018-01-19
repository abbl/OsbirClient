package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;

    public LoginScreen(Game game) {
        super(game);
        this.networkDirector = new NetworkDirector();
        this.loginDirector = new LoginDirector(actors, assetManager);
    }

    @Override
    protected void draw() {
        loginDirector.render(spriteBatch);
    }

    @Override
    protected void update() {

    }

    @Override
    public void dispose() {
        super.dispose();
        loginDirector.dispose();
    }
}
