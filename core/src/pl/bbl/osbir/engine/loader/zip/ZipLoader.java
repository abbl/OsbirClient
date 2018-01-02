package pl.bbl.osbir.engine.loader.zip;

import com.badlogic.gdx.Gdx;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoader {
    private ZipFile zipFile;

    public void load(String path){
        try {
            zipFile = new ZipFile(path);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while(entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                System.out.println("Zip:" + zipEntry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
