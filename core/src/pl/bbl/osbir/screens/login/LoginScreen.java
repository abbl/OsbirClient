package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;

    public LoginScreen(Game game) {
        super(game);
        networkDirector = new NetworkDirector();
        loginDirector = new LoginDirector();
    }

    @Override
    protected void draw() {

    }

    @Override
    protected void update() {

    }
}
