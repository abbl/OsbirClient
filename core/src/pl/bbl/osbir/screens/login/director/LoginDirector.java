package pl.bbl.osbir.screens.login.director;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.ui.LoginLayout;

public class LoginDirector {
    private LoginLayout loginLayout;
    private NetworkDirector networkDirector;

    public LoginDirector(Stage stage, Skin skin, AssetManager assetManager){
        loginLayout = new LoginLayout(skin, assetManager);
        stage.addActor(loginLayout.getStageTable());
    }

    public void establishAuthServerConnection(){

    }

    public void establishGameServerConnection(){

    }

    public void render(SpriteBatch spriteBatch){
        loginLayout.render(spriteBatch);
    }

    public void update(){

    }

    public void loginButtonClicked(){

    }
}
