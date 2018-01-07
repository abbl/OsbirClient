package pl.bbl.osbir.screens.login;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import pl.bbl.osbir.engine.loader.zip.ZipArchive;
import pl.bbl.osbir.engine.loader.zip.ZipLoader;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.screens.login.director.LoginDirector;

import java.util.zip.ZipEntry;

public class LoginScreen extends AbstractScreen {
    private NetworkDirector networkDirector;
    private LoginDirector loginDirector;
    private Texture texture;

    public LoginScreen(Game game) {
        super(game);
        networkDirector = new NetworkDirector();
        loginDirector = new LoginDirector();
    }

    @Override
    protected void draw() {
        testDraw();
    }

    @Override
    protected void update() {
        test();
    }

    private void test(){
        if(zipAssetManager.isLoaded("assets.zip")){
            ZipArchive zipArchive = zipAssetManager.get("assets.zip");
            ZipEntry zipEntry = zipArchive.getEntry("textures/grass.png");
            if(zipEntry != null){
                System.out.println("Yeah boi " + zipEntry.getName());
                texture = new Texture(zipEntry.getName());
                if(texture != null){
                    System.out.println("Yea");
                }
            }
        }
    }

    private void testDraw(){
        if(texture != null){
            spriteBatch.draw(texture, 0, 0);
        }
    }
}
