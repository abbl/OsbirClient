package pl.bbl.osbir.engine.loader.zip;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import pl.bbl.osbir.engine.tools.Strings;

import java.io.IOException;
import java.util.zip.ZipFile;

public class ZipLoader extends AsynchronousAssetLoader<ZipArchive, ZipLoader.ZipParameters>{
    private ZipFile zipFile;

    public ZipLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, ZipParameters parameter) {
        return null;
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, ZipParameters parameter) {
        try {
            zipFile = new ZipFile(Strings.swapSlashesToMatchZipConvetion(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public ZipArchive loadSync(AssetManager manager, String fileName, FileHandle file, ZipParameters parameter) {
        ZipFile zipFile = this.zipFile;
        this.zipFile = null;
        return new ZipArchive(zipFile);
    }


    static class ZipParameters extends AssetLoaderParameters<ZipArchive>{}
}
