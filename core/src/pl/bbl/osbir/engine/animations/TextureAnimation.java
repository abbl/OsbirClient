package pl.bbl.osbir.engine.animations;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.bbl.osbir.engine.logger.EngineLogger;

import java.util.ArrayList;

public class TextureAnimation {
    private ArrayList<AnimationPart> animationParts;
    private String animationName;
    private int selectedAnimation;

    public TextureAnimation(String animationName, AssetManager assetManager){
        this.animationName = animationName;
        this.animationParts = AnimationLoader.loadAnimation(animationName, assetManager);
        this.selectedAnimation = 0;
    }

    public TextureAnimation(String animationName, String partName, AssetManager assetManager){
        this(animationName, assetManager);
        selectAnimation(partName);
    }

    public void selectAnimation(String partName){
        int selectedBefore = selectedAnimation;
        for(AnimationPart animationPart : animationParts){
            if(animationPart.getName().equals(partName))
                selectedAnimation = animationParts.indexOf(animationPart);
        }
        if(selectedBefore == selectedAnimation)
            EngineLogger.log("[Animation][" + animationName + "]selectAnimation was invoked but it didn't change anything," +
                    " so requesting part[" + partName + "] might not exist.");
    }

    public void render(SpriteBatch spriteBatch){
        animationParts.get(selectedAnimation).render(spriteBatch);
    }

    public void update(float deltaTime){
        animationParts.get(selectedAnimation).update(deltaTime);
    }
}
