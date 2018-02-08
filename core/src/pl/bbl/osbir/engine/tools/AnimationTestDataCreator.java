package pl.bbl.osbir.engine.tools;

import com.badlogic.gdx.Gdx;
import pl.bbl.osbir.engine.animations.AnimationData;
import pl.bbl.osbir.engine.serialization.DataSerializer;

public class AnimationTestDataCreator {
    public static void createTestDataForPlayerAnimation(){
        AnimationData animationData = new AnimationData("playerTest", "animations/characters/characters.atlas", "player", 47, 48);
        animationData.parts.add(new AnimationData.AnimationPartDetails("down", 0.33f, 0, 0, 142, 48));
        animationData.parts.add(new AnimationData.AnimationPartDetails("left", 0.33f, 0, 50, 142, 48));
        animationData.parts.add(new AnimationData.AnimationPartDetails("right", 0.33f, 0, 100, 142, 48));
        animationData.parts.add(new AnimationData.AnimationPartDetails("up", 0.33f, 0, 150, 142, 48));
        System.out.println(Gdx.files.local("animations/data/player.anim"));
        DataSerializer.serialize(animationData, "animations/data/player.anim");
    }
}
