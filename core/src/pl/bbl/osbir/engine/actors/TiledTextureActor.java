package pl.bbl.osbir.engine.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;

public class TiledTextureActor extends Actor {
    private TiledDrawable texture;

    public TiledTextureActor(TextureAtlas.AtlasRegion atlasTexture)
    {
        texture = new TiledDrawable(atlasTexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        texture.draw(batch, getX(), getY(), getWidth(), getHeight());
    }
}