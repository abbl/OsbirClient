package pl.bbl.osbir.screens.character.director.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.screens.character.director.CharacterSelectionDirector;

public class CharacterSelectionLayout {
    private Stack mainStack;
    private AssetManager assetManager;
    private CharacterSelectionDirector characterSelectionDirector;
    private Skin skin;

    private TextureAtlas backgroundAtlas;
    private TextureAtlas characterSelectionAtlas;
    private TextureRegion background;

    public CharacterSelectionLayout(Stack actors,  UserInterfaceManager userInterfaceManager, CharacterSelectionDirector characterSelectionDirector){
        this.mainStack = actors;
        this.assetManager = userInterfaceManager.getAssetManager();
        this.characterSelectionDirector = characterSelectionDirector;
        this.skin = userInterfaceManager.getSkin();
        loadDependencies();
    }

    private void loadDependencies(){
        backgroundAtlas = assetManager.get("textures/loginscreen/loginscreen.atlas");
        background = backgroundAtlas.findRegion("background");

        assetManager.load("textures/characterscreen/characterscreen.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        characterSelectionAtlas = assetManager.get("textures/characterscreen/characterscreen.atlas");
    }

    public void render(SpriteBatch spriteBatch){
        renderBackground(spriteBatch);
    }

    private void renderBackground(SpriteBatch spriteBatch){
        spriteBatch.draw(background, 0, 0);
    }
}
