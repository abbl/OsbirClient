package pl.bbl.osbir.engine.animations;

import java.io.Serializable;
import java.util.ArrayList;

public class AnimationData implements Serializable{
    public ArrayList<AnimationPartDetails> parts = new ArrayList<>();
    public String name;
    public String animationAtlasLocation;
    public String animationRegionName;
    public int frameWidth;
    public int frameHeight;

    public static class AnimationPartDetails implements Serializable{
        public String name;
        public float frameTime;
        public float leftUpperCornerPositionX;
        public float leftUpperCornerPositionY;
        public float width;
        public float height;
    }
}
