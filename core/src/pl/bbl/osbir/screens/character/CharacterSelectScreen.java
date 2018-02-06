package pl.bbl.osbir.screens.character;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import pl.bbl.osbir.engine.animations.AnimationProperties;
import pl.bbl.osbir.engine.screen.AbstractScreen;
import pl.bbl.osbir.engine.serialization.DataSerializer;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.network.NetworkDirector;
import pl.bbl.osbir.player.Player;
import pl.bbl.osbir.screens.character.director.CharacterSelectionDirector;

public class CharacterSelectScreen extends AbstractScreen{
    private NetworkDirector networkDirector;
    private Player player;
    private UserInterfaceManager userInterfaceManager;
    private CharacterSelectionDirector characterSelectionDirector;

    public CharacterSelectScreen(Game game){
        super(game);
        userInterfaceManager = new UserInterfaceManager(assetManager);
        characterSelectionDirector = new CharacterSelectionDirector(actors, userInterfaceManager);
    }

    public CharacterSelectScreen(Game game, AssetManager assetManager, NetworkDirector networkDirector, Player player, UserInterfaceManager userInterfaceManager) {
        super(game);
        this.assetManager = assetManager;
        this.networkDirector = networkDirector;
        this.userInterfaceManager = userInterfaceManager;
        this.player = player;
        this.characterSelectionDirector = new CharacterSelectionDirector(actors, userInterfaceManager);
    }

    @Override
    protected void draw() {
        characterSelectionDirector.render(spriteBatch);
    }

    @Override
    protected void update() {

    }
}
