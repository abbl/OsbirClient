package pl.bbl.osbir.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.*;
import pl.bbl.osbir.OsbirGame;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DesktopLauncher {
    private static Settings settings;

    public static void main (String[] arg) {
		settings = new Settings();
        settings.maxWidth = 2048;
        settings.maxHeight = 2048;
        //startTexturePacker();
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new OsbirGame(), config);
	}

	private static void startTexturePacker(){
        packDirectoriesInDirectory("data-dontpacked/textures");
        packDirectoriesInDirectory("data-dontpacked/animations");
        packDirectoriesInDirectory("data-dontpacked/ui");
	}

	private static void packDirectoriesInDirectory(String directoryPath){
        for(String directory : getDirectories(directoryPath)){
            TexturePacker.process(settings,directoryPath + "/" + directory + "/", "data-topack/" + getDirectoryName(directoryPath) + "/" + directory, directory);
        }
    }

    private static String[] getDirectories(String directoryPath){
        File file = new File(directoryPath);
        return file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
    }

    private static String getDirectoryName(String directoryPath){
        String[] cuttedStrings = directoryPath.split("/");
        return cuttedStrings[1];
    }
}
