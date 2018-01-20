package pl.bbl.osbir.screens.login.director;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.tools.ConditionalTrigger;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.network.authentication.communication.authentication.receiver.AuthenticationReceiver;
import pl.bbl.osbir.screens.login.director.ui.LoginScreenLayout;

public class LoginDirector {
    private LoginScreenLayout loginScreenLayout;
    private NetworkDirector networkDirector;

    public LoginDirector(Stack mainStack, AssetManager assetManager, UserInterfaceManager userInterfaceManager, NetworkDirector networkDirector){
        this.loginScreenLayout = new LoginScreenLayout(mainStack, userInterfaceManager.getSkin(), assetManager, this);
        this.networkDirector = networkDirector;
    }

    public void startLoginProcess(String login, String password) {
        networkDirector.establishAuthenticationServerConnection();
        loginScreenLayout.displayConnectingWindow();
        requestAuthenticationAfterConnectionIsEstablished(login, password).start();
    }

    private ConditionalTrigger requestAuthenticationAfterConnectionIsEstablished(final String login, final String password){
        return new ConditionalTrigger(){
            @Override
            protected boolean isConditionTrue() {
                return networkDirector.isAuthenticationConnectionEstablished();
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
        networkDirector.getAuthenticationConnectionWrapper().getAuthenticationReceiver().requestLoginProcess(login, password);
    }

    private void listenForLoginResult(){
        if(networkDirector.isAuthenticationConnectionEstablished()){
            AuthenticationReceiver authenticationReceiver = networkDirector.getAuthenticationConnectionWrapper().getAuthenticationReceiver();
            if(authenticationReceiver.isAuthenticationResultReceived()){
                loginScreenLayout.hideLoggingInWindow();
                if(authenticationReceiver.getAuthenticationResult()){
                    loginScreenLayout.displayRequestingServerListWindow();
                }else{
                    loginScreenLayout.displayLoginFailureDialog();
                }
            }
        }
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
