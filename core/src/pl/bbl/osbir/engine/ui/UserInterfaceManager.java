package pl.bbl.osbir.engine.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import pl.bbl.osbir.engine.loader.zip.ZipArchive;

import java.util.zip.ZipEntry;

public class UserInterfaceManager {
    private static final String UI_ARCHIVE_PATH = "data/ui.zip";
    private static final String UI_SKIN_PATH = "ui/skin.json";
    private static final String[] UI_COMPONENTS_PATH = {
            "ui/Buttons/Buttons.atlas",
            "ui/Fonts/Fonts.atlas",
            "ui/Lists/Lists.atlas",
            "ui/TextFields/TextFields.atlas",
            "ui/Windows/Windows.atlas"
    };

    private ZipArchive userInterfaceZipArchive;
    private AssetManager zipAssetManager;
    private AssetManager assetManager;
    private Skin skin;

    public UserInterfaceManager(AssetManager zipAssetManager, AssetManager assetManager){
        this.zipAssetManager = zipAssetManager;
        this.assetManager = assetManager;
        loadDependencies();
    }

    private void loadDependencies(){
        zipAssetManager.load(UI_ARCHIVE_PATH, ZipArchive.class);
    }

    public void update(){
        assignDependencies();
    }

    private void assignDependencies(){
        if(zipAssetManager.isLoaded(UI_ARCHIVE_PATH)){
            userInterfaceZipArchive = zipAssetManager.get(UI_ARCHIVE_PATH);
            loadAtlases();
        }
    }

    private void loadAtlases(){
        for(String path : UI_COMPONENTS_PATH){
            ZipEntry zipEntry = userInterfaceZipArchive.getEntry(path);
            if(zipEntry != null){
                System.out.println(zipEntry.getName());
                assetManager.load(zipEntry.getName(), TextureAtlas.class);
            }
        }
    }

    public void dispose(){
        zipAssetManager.unload(UI_ARCHIVE_PATH);
    }
}
