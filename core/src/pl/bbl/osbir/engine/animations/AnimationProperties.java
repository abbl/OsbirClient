package pl.bbl.osbir.engine.animations;

import java.io.Serializable;
import java.util.ArrayList;

public class AnimationProperties implements Serializable{
    public String name;
    public String animationAtlasLocation;
    public String animationRegionName;
    public ArrayList<AnimationPart> parts;

    public static class AnimationPart{
        public float leftUpperCornerPosition;
        public float rightLowerCornerPosition;
        public int frameWidth;
        public int frameHeight;
    }
}
