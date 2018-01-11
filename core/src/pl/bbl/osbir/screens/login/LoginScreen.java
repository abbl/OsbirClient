package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;
import pl.bbl.osbir.screens.login.ui.LoginUserInterfaceDirector;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;
    private UserInterfaceManager userInterfaceManager;
    private LoginUserInterfaceDirector loginUserInterfaceDirector;

    public LoginScreen(Game game) {
        super(game);
        networkDirector = new NetworkDirector();
        loginDirector = new LoginDirector();
        userInterfaceManager = new UserInterfaceManager(assetManager);
    }

    @Override
    protected void draw() {
        if(loginUserInterfaceDirector != null)
            loginUserInterfaceDirector.render(spriteBatch);
    }

    @Override
    protected void update() {
        userInterfaceManager.update();


        if(userInterfaceManager.isDependenciesLoadingDone() && loginUserInterfaceDirector == null)
            loginUserInterfaceDirector = new LoginUserInterfaceDirector(stage, userInterfaceManager.getSkin(), assetManager);
        if(userInterfaceManager.isDependenciesLoadingDone() && loginUserInterfaceDirector != null)
            loginUserInterfaceDirector.update();
    }


    @Override
    public void dispose() {
        super.dispose();
        userInterfaceManager.dispose();
    }
}
