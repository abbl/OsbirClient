package pl.bbl.osbir;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.bbl.osbir.network.authentication.AuthenticationConnectionWrapper;
import pl.bbl.osbir.properties.OsbirProperties;

public class OsbirGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private AuthenticationConnectionWrapper authenticationConnectionWrapper;

	@Override
	public void create () {
		batch = new SpriteBatch();
		startTestConnection();
	}

	private void startTestConnection(){
	    OsbirProperties osbirProperties = new OsbirProperties();
	    authenticationConnectionWrapper = new AuthenticationConnectionWrapper(osbirProperties);
	    authenticationConnectionWrapper.estaliblishConnection();
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
