package pl.bbl.osbir.engine.animations;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationPart {
    private Animation<TextureRegion> animation;
    private AnimationData.AnimationPartDetails animationPartDetails;
    private AnimationData animationData;
    private AssetManager assetManager;
    private float stateTime;
    private String name;
    private float x;
    private float y;

    public AnimationPart(AnimationData.AnimationPartDetails animationPartDetails, AnimationData animationData, AssetManager assetManager){
        this.animationPartDetails = animationPartDetails;
        this.animationData = animationData;
        this.name = animationPartDetails.name;
        this.assetManager = assetManager;
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
        TextureRegion.split();
    }

    private TextureRegion[][] split (Texture texture, int x, int y, int width, int height, int tileWidth, int tileHeight) {
        int rows = height / tileHeight;
        int cols = width / tileWidth;

        int startX = x;
        TextureRegion[][] tiles = new TextureRegion[rows][cols];
        for (int row = 0; row < rows; row++, y += tileHeight) {
            x = startX;
            for (int col = 0; col < cols; col++, x += tileWidth) {
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
        if(assetManager.isLoaded(animationData.animationAtlasLocation) && animation == null)
            createAnimation();
    }

    public void resetStateTime()
    {
        stateTime = 0f;
    }

    public void render(SpriteBatch spriteBatch) {
        if(animation != null)
            spriteBatch.draw(animation.getKeyFrame(stateTime), 0, 0);
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }
}
