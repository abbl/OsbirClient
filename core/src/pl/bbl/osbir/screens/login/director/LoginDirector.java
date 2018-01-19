package pl.bbl.osbir.screens.login.director;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.screens.login.director.ui.LoginScreenLayout;

public class LoginDirector {
    private UserInterfaceManager userInterfaceManager;
    private LoginScreenLayout loginScreenLayout;

    public LoginDirector(Stack mainStack, AssetManager assetManager){
        this.userInterfaceManager = new UserInterfaceManager(assetManager);
        this.loginScreenLayout = new LoginScreenLayout(mainStack, userInterfaceManager.getSkin(), assetManager, this);
    }

    public void startLoginProcess(String login, String password) {
    }

    public void render(SpriteBatch spriteBatch){
        loginScreenLayout.render(spriteBatch);
    }

    public void dispose() {

    }
}
