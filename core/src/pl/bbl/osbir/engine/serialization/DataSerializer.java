package pl.bbl.osbir.engine.serialization;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSerializer {
    public static void serialize(Object object, String savePath){
        try {
            FileOutputStream fileOut = new FileOutputStream(Gdx.files.local(savePath).file());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Serialized object to file: " + savePath);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Object deserialize(){
        return null;
    }
}
