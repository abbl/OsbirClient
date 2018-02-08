package pl.bbl.osbir.engine.animations;

import com.badlogic.gdx.assets.AssetManager;
import pl.bbl.osbir.engine.logger.EngineLogger;
import pl.bbl.osbir.engine.serialization.DataSerializer;

import java.util.ArrayList;

public class AnimationLoader {
    private static final String animationDir = "animations/data/";

    public static ArrayList<AnimationPart> loadAnimation(String name, AssetManager assetManager){
        AnimationData animationData = (AnimationData) DataSerializer.deserialize(animationDir + name + ".anim");
        if(animationData != null){
            ArrayList<AnimationPart> animationParts = new ArrayList<>();
            for(AnimationData.AnimationPartDetails partDetails : animationData.parts){
                animationParts.add(new AnimationPart(partDetails, animationData, assetManager));
            }
            return animationParts;
        }else{
            EngineLogger.log("Animation:" + name + "was not found.");
        }
        return null;
    }
}
