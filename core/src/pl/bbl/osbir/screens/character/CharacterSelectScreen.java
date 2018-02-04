package pl.bbl.osbir.screens.character;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.player.Player;

public class CharacterSelectScreen extends AbstractScreen{
    private final NetworkDirector networkDirector;
    private final Player player;
    private final UserInterfaceManager userInterfaceManager;

    public CharacterSelectScreen(Game game, AssetManager assetManager, NetworkDirector networkDirector, Player player, UserInterfaceManager userInterfaceManager) {
        super(game);
        this.assetManager = assetManager;
        this.networkDirector = networkDirector;
        this.userInterfaceManager = userInterfaceManager;
        this.player = player;
    }

    @Override
    protected void draw() {

    }

    @Override
    protected void update() {

    }
}
