package pl.bbl.osbir.engine.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UserInterfaceManager {
    private static final String UI_SKIN_PATH = "ui/skin.json";
    private static final String[] UI_COMPONENTS_PATH = {
            "ui/Buttons/Buttons.atlas",
            "ui/Fonts/Fonts.atlas",
            "ui/Lists/Lists.atlas",
            "ui/TextFields/TextFields.atlas",
            "ui/Windows/Windows.atlas"
    };
    private AssetManager assetManager;
    private Skin skin;
    private boolean isDependenciesLoadingDone = false;

    public UserInterfaceManager(AssetManager assetManager){
        this.assetManager = assetManager;
        skin = new Skin();
        loadDependencies();
    }

    private void loadDependencies(){
        loadUIComponents();
    }

    private void loadUIComponents(){
        for(String filePath : UI_COMPONENTS_PATH){
            assetManager.load(filePath, TextureAtlas.class);
        }
    }

    public void update(){
        if(!isDependenciesLoadingDone)
            assignDependencies();
    }

    private void assignDependencies(){
        for(String filePath : UI_COMPONENTS_PATH){
            if(!assetManager.isLoaded(filePath))
                return;
        }
        loadSkin();
    }

    private void loadSkin(){
        for(String filePath : UI_COMPONENTS_PATH){
            skin.addRegions(assetManager.get(filePath, TextureAtlas.class));
        }
        skin.load(Gdx.files.internal(UI_SKIN_PATH));
        isDependenciesLoadingDone = true;
    }

    public Skin getSkin() {
        return skin;
    }

    public boolean isDependenciesLoadingDone() {
        return isDependenciesLoadingDone;
    }

    public void dispose(){

    }
}
