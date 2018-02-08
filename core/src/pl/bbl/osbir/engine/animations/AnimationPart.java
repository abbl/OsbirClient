package pl.bbl.osbir.engine.animations;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import pl.bbl.osbir.engine.logger.EngineLogger;

import java.util.ArrayList;

public class AnimationPart {
    private Animation<TextureRegion> animation;
    private AnimationData.AnimationPartDetails animationPartDetails;
    private AnimationData animationData;
    private AssetManager assetManager;
    private float stateTime;
    private String name;
    private float x;
    private float y;
    private int rowsNumber;
    private int columnsNumber;

    public AnimationPart(AnimationData.AnimationPartDetails animationPartDetails, AnimationData animationData, AssetManager assetManager){
        this.animationPartDetails = animationPartDetails;
        this.animationData = animationData;
        this.name = animationPartDetails.name;
        this.assetManager = assetManager;
        this.x = 0;
        this.y = 0;
        loadDependencies();
    }

    private void loadDependencies(){
        if(assetManager.isLoaded(animationData.animationAtlasLocation)){
            createAnimation();
        }else{
            assetManager.load(animationData.animationAtlasLocation, TextureAtlas.class);
        }
    }

    private void createAnimation(){
        TextureAtlas textureAtlas = assetManager.get(animationData.animationAtlasLocation, TextureAtlas.class);
        TextureRegion spriteSheet = textureAtlas.findRegion(animationData.animationRegionName);
        if(spriteSheet != null){
            TextureRegion[][] splitedRegion = split(spriteSheet.getTexture(), animationPartDetails.leftUpperCornerPositionX,
                    animationPartDetails.leftUpperCornerPositionY, animationPartDetails.width, animationPartDetails.height,
                    animationData.frameWidth, animationData.frameHeight);
            ArrayList<TextureRegion> frames = new ArrayList<>();
            int index = 0;

            for(int row = 0; row < rowsNumber; row++)
                for(int column = 0; column < columnsNumber; column++)
                    if(index < splitedRegion.length)
                        frames.add(splitedRegion[row][column]);

            animation = new Animation<>(animationPartDetails.frameTime, frames.toArray(new TextureRegion[frames.size()]));
        }else{
            EngineLogger.log("Animation: [" + animationPartDetails.name + "] has no region called " + animationData.animationRegionName);
        }
    }

    private TextureRegion[][] split (Texture texture, int x, int y, int width, int height, int tileWidth, int tileHeight) {
        rowsNumber = height / tileHeight;
        columnsNumber = width / tileWidth;

        int startX = x;
        TextureRegion[][] tiles = new TextureRegion[rowsNumber][columnsNumber];
        for (int row = 0; row < rowsNumber; row++, y += tileHeight) {
            x = startX;
            for (int col = 0; col < columnsNumber; col++, x += tileWidth) {
                tiles[row][col] = new TextureRegion(texture, x, y, tileWidth, tileHeight);
            }
        }
        return tiles;
    }

    public void update(float delta)
    {
        isAnimationAtlasLoaded();
        if(animation != null)
            stateTime += delta;
    }

    private void isAnimationAtlasLoaded(){
        if(animation == null)
            if(assetManager.isLoaded(animationData.animationAtlasLocation))
            createAnimation();
    }

    public void resetStateTime()
    {
        stateTime = 0f;
    }

    public void render(SpriteBatch spriteBatch) {
        if(animation != null)
            spriteBatch.draw(animation.getKeyFrame(stateTime, true), x, y);
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }
}
