package pl.bbl.osbir.screens.character.director.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import pl.bbl.osbir.engine.actors.TiledTextureActor;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.engine.ui.buttons.PlayerCharacterButton;
import pl.bbl.osbir.player.PlayerCharacter;
import pl.bbl.osbir.screens.character.director.CharacterSelectionDirector;

public class CharacterSelectionLayout {
    private Stack mainStack;
    private AssetManager assetManager;
    private CharacterSelectionDirector characterSelectionDirector;
    private Skin skin;

    private TextureAtlas backgroundAtlas;
    private TextureAtlas characterSelectionAtlas;
    private TextureRegion background;
    private TextureRegion windowBorder;
    private TextureRegion characterDisplayBackground;
    private TextureRegion smallerWindowBorder;
    private TextureRegion chain;

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
        windowBorder = characterSelectionAtlas.findRegion("frame");
        smallerWindowBorder = characterSelectionAtlas.findRegion("frame-smaller");
        characterDisplayBackground = characterSelectionAtlas.findRegion("characterbackground");
        chain = characterSelectionAtlas.findRegion("chain");
    }

    private void createLayout(){
        Table mainTable = new Table();
        mainTable.add(createCharacterDisplay(400, 500));
        mainTable.add(createCharacterList(300, 500)).pad(15);
        mainTable.row();
        mainTable.add(createOptionMenu(400, 150));
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

    private Stack createCharacterList(float width, float height){
        Stack characterListStack = new Stack();
        Table characterListTable = new Table();
        characterListTable.add(new TiledTextureActor(
                new TextureAtlas.AtlasRegion(characterSelectionAtlas.findRegion("plank"))))
                .width(width - 10).height(height - 12); //Fitting image inside border.
        characterListStack.add(characterListTable);
        characterListStack.add(addCharacterButtons());
        characterListStack.add(createBorderImage(width, height));
        return characterListStack;
    }

    private Table addCharacterButtons(){
        PlayerCharacter[] playerCharacters = {new PlayerCharacter("Jezus"), new PlayerCharacter("Chrystus"), new PlayerCharacter("Bejo"), new PlayerCharacter("Maciek")};
        Table characterButtonsTable = new Table();
        for(PlayerCharacter playerCharacter : playerCharacters){
            Table buttonTable = new Table();
            buttonTable.row();
            buttonTable.add(new PlayerCharacterButton(skin, playerCharacter));
            characterButtonsTable.add(buttonTable).pad(15);
            characterButtonsTable.row();
        }
        return characterButtonsTable;
    }

    private Stack createOptionMenu(float width, float height){
        Stack optionMenuStack = new Stack();
        Table optionMenuTable = new Table();
        optionMenuTable.add(new TiledTextureActor(
                new TextureAtlas.AtlasRegion(characterSelectionAtlas.findRegion("plank"))))
                .width(width - 10).height(height - 12); //Fitting image inside border.
        optionMenuStack.add(optionMenuTable);
        optionMenuStack.add(createSmallerBorderImage(width, height));
        return optionMenuStack;
    }

    private Table createBorderImage(float width, float height){
        Image borderImage = new Image(windowBorder);
        Table borderTable = new Table();
        borderTable.add(borderImage).width(width).height(height);
        return borderTable;
    }

    private Table createSmallerBorderImage(float width, float height){
        Image borderImage = new Image(smallerWindowBorder);
        Table borderTable = new Table();
        borderTable.add(borderImage).width(width).height(height);
        return borderTable;
    }

    private Image createChain(){
        return new Image(chain);
    }

    public void render(SpriteBatch spriteBatch){
        renderBackground(spriteBatch);
    }

    private void renderBackground(SpriteBatch spriteBatch){
        spriteBatch.draw(background, 0, 0);
    }
}
