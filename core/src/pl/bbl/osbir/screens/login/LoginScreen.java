package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreen extends AbstractScreen {
    private UserInterfaceManager userInterfaceManager;
    private LoginDirector loginDirector;

    public LoginScreen(Game game) {
        super(game);
        this.userInterfaceManager = new UserInterfaceManager(assetManager);
        this.loginDirector = new LoginDirector(actors, assetManager, userInterfaceManager);
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
