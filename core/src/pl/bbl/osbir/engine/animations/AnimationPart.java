package pl.bbl.osbir.engine.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationPart {
    private final Animation<TextureRegion> animation;
    private float x;
    private float y;
    private float stateTime = 0f;

    public AnimationPart(Animation animation, String name)
    {
        this.animation = animation;
    }

    public void update(float delta)
    {
        stateTime += delta;
    }

    public void resetStateTime()
    {
        stateTime = 0f;
    }

    public void render(SpriteBatch spriteBatch) {
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
}
