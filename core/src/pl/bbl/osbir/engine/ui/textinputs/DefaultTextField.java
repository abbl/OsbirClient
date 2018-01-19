package pl.bbl.osbir.engine.ui.textinputs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DefaultTextField extends TextField{
    public DefaultTextField(String text, Skin skin) {
        super(text, skin);
        textOffset = 0.5f;
    }
}
