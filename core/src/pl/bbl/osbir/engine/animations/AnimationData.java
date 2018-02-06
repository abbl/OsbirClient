package pl.bbl.osbir.engine.animations;

import java.io.Serializable;
import java.util.ArrayList;

public class AnimationData implements Serializable{
    public ArrayList<AnimationPartDetails> parts = new ArrayList<>();
    public String name;
    public String animationAtlasLocation;
    public String animationRegionName;

    public static class AnimationPartDetails{
        public String name;
        public float leftUpperCornerPositionX;
        public float leftUpperCornerPositionY;
        public float rightLowerCornerPositionX;
        public float rightLowerCornerPositionY;
        public int frameWidth;
        public int frameHeight;
    }
}
