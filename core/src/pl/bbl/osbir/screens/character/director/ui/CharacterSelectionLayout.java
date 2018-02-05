package pl.bbl.osbir.screens.character.director.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
    private TextureRegion characterDisplayBorder;
    private TextureRegion characterDisplayBackground;

    public CharacterSelectionLayout(Stack actors,  UserInterfaceManager userInterfaceManager, CharacterSelectionDirector characterSelectionDirector){
        this.mainStack = actors;
        this.assetManager = userInterfaceManager.getAssetManager();
        this.characterSelectionDirector = characterSelectionDirector;
        this.skin = userInterfaceManager.getSkin();
        loadDependencies();
        createLayout();
    }

    private void loadDependencies(){
        assetManager.load("textures/loginscreen/loginscreen.atlas", TextureAtlas.class); //TEMPORARY
        assetManager.finishLoading();
        backgroundAtlas = assetManager.get("textures/loginscreen/loginscreen.atlas");
        background = backgroundAtlas.findRegion("background");

        assetManager.load("textures/characterscreen/characterscreen.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        characterSelectionAtlas = assetManager.get("textures/characterscreen/characterscreen.atlas");
        characterDisplayBorder = characterSelectionAtlas.findRegion("frame");
        characterDisplayBackground = characterSelectionAtlas.findRegion("characterbackground");
    }

    private void createLayout(){
        Table mainTable = new Table();
        mainTable.add(createCharacterDisplay(400, 500));
        mainTable.add(createBorderImage(300, 500)).pad(15);
        mainStack.add(mainTable);
    }

    private Stack createCharacterDisplay(float width, float height){
        Stack characterDisplayStack = new Stack();
        Image characterBackground = new Image(characterDisplayBackground);
        Table characterBackgroundTable = new Table();
        characterBackgroundTable.add(characterBackground).width(width - 10).height(height - 12); //with those minuses Im making the image fit into the border/
        characterDisplayStack.add(characterBackgroundTable);
        characterDisplayStack.add(createBorderImage(width, height));
        return characterDisplayStack;
    }

    private Stack createCharacterList(){
        Stack characterListStack = new Stack();
    }

    private Table createBorderImage(float width, float height){
        Image borderImage = new Image(characterDisplayBorder);
        Table borderTable = new Table();
        borderTable.add(borderImage).width(width).height(height);
        return borderTable;
    }

    public void render(SpriteBatch spriteBatch){
        renderBackground(spriteBatch);
    }

    private void renderBackground(SpriteBatch spriteBatch){
        spriteBatch.draw(background, 0, 0);
    }
}
