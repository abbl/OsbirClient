package pl.bbl.osbir.screens.login.director;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.tools.ConditionalTrigger;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.screens.login.director.ui.LoginScreenLayout;

public class LoginDirector {
    private LoginScreenLayout loginScreenLayout;

    public LoginDirector(Stack mainStack, AssetManager assetManager, UserInterfaceManager userInterfaceManager){
        this.loginScreenLayout = new LoginScreenLayout(mainStack, userInterfaceManager.getSkin(), assetManager, this);
    }

    public void startLoginProcess(String login, String password) {
        loginScreenLayout.displayConnectingWindow();
        requestAuthenticationAfterConnectionIsEstablished(login, password).start();
    }

    private ConditionalTrigger requestAuthenticationAfterConnectionIsEstablished(final String login, final String password){
        return new ConditionalTrigger(){
            @Override
            protected boolean isConditionTrue() {
                return false;
            }

            @Override
            protected void doSomething() {
                loginScreenLayout.hideConnectingWindow();
                requestLogin(login, password);
            }
        };
    }

    private void requestLogin(String login, String password){
        loginScreenLayout.displayLoggingInWindow();
    }

    private void listenForLoginResult(){

    }

    public void render(SpriteBatch spriteBatch){
        loginScreenLayout.render(spriteBatch);
    }

    public void update(){
        listenForLoginResult();
    }

    public void dispose() {

    }
}
