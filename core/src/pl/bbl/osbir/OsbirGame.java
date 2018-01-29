package pl.bbl.osbir;

import com.badlogic.gdx.Game;
import pl.bbl.osbir.screens.login.LoginScreen;

public class OsbirGame extends Game {
    @Override
    public void create() {
        setScreen(new LoginScreen(this));
    }
}
