package pl.bbl.osbir;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.bbl.osbir.network.authentication.AuthenticationConnectionWrapper;
import pl.bbl.osbir.properties.OsbirProperties;
import pl.bbl.osbir.screens.login.LoginScreen;

public class OsbirGame extends Game {
    @Override
    public void create() {
        setScreen(new LoginScreen(this));
    }
}
