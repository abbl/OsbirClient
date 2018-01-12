package pl.bbl.osbir.screens.login.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class LoginLayout {
    private AssetManager assetManager;
    private Table stageTable;
    private Table textFieldsTable;
    private Skin skin;

    private final String backgroundLocation = "textures/loginscreen/loginscreen.atlas";
    private TextField[] textFields; //0 login 1 password
    private TextureRegion background;

    public LoginLayout(Skin skin, AssetManager assetManager){
        stageTable = new Table();
        this.skin = skin;
        this.assetManager = assetManager;
        textFieldsTable = new Table();
        stageTable.setFillParent(true);
        //stageTable.setDebug(true);
        loadBackground();
        initializeTextFields();
        prepareLayout();
    }

    private void loadBackground(){
        assetManager.load(backgroundLocation, TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas textureAtlas = assetManager.get(backgroundLocation);
        background = textureAtlas.findRegion("background");
    }

    private void initializeTextFields(){
        textFields = new TextField[2];
        for(int i = 0; i < textFields.length; i++){
            textFields[i] = new TextField("", skin);
        }
    }

    private void prepareLayout(){
        textFieldsTable.add(textFields[0]).width(300).height(200).row();
        textFieldsTable.row();
        textFieldsTable.add(textFields[1]).width(300).height(200).row();
        stageTable.add(textFieldsTable);
    }

    public void render(SpriteBatch spriteBatch){
        if(background != null)
            spriteBatch.draw(background, 0, 0);
    }

    public Table getStageTable(){
        return stageTable;
    }
}
