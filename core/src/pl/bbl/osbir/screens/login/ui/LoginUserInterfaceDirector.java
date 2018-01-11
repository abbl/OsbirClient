package pl.bbl.osbir.screens.login.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LoginUserInterfaceDirector {
    private LoginLayout loginLayout;
    private Stage stage;
    private Skin skin;

    public LoginUserInterfaceDirector(Stage stage, Skin skin, AssetManager assetManager){
        this.stage = stage;
        this.skin = skin;
        this.loginLayout = new LoginLayout(skin, assetManager);
        stage.addActor(loginLayout.getStageTable());
    }

    public void render(SpriteBatch spriteBatch){
        loginLayout.render(spriteBatch);
    }

    public void update(){
        loginLayout.update();
    }
}
