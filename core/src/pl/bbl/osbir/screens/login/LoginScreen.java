package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import pl.bbl.osbir.engine.loader.zip.ZipArchive;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

import java.util.zip.ZipEntry;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;
    private UserInterfaceManager userInterfaceManager;

    public LoginScreen(Game game) {
        super(game);
        networkDirector = new NetworkDirector();
        loginDirector = new LoginDirector();
        userInterfaceManager = new UserInterfaceManager(zipAssetManager, assetManager);
    }

    @Override
    protected void draw() {

    }

    @Override
    protected void update() {
        //userInterfaceManager.update();
    }


    @Override
    public void dispose() {
        super.dispose();
        userInterfaceManager.dispose();
    }
}
