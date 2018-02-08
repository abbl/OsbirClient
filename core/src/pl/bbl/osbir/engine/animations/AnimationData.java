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

    public AnimationData(String name, String animationAtlasLocation, String animationRegionName, int frameWidth, int frameHeight){
        this.name = name;
        this.animationAtlasLocation = animationAtlasLocation;
        this.animationRegionName = animationRegionName;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public static class AnimationPartDetails implements Serializable{
        public String name;
        public float frameTime;
        public int leftUpperCornerPositionX;
        public int leftUpperCornerPositionY;
        public int width;
        public int height;

        public AnimationPartDetails(String name, float frameTime, int leftUpX, int leftUpY, int width, int height){
            this.name = name;
            this.frameTime = frameTime;
            this.leftUpperCornerPositionX = leftUpX;
            this.leftUpperCornerPositionY = leftUpY;
            this.width = width;
            this.height = height;
        }
    }
}
