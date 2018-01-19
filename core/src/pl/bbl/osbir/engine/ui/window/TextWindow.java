package pl.bbl.osbir.engine.ui.window;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class TextWindow extends Window{
    public TextWindow(String title, Skin skin, String text) {
        super(title, skin);
        addLabel(text);
    }

    private void addLabel(String text){
        add(new Label(text, getSkin()));
    }
}
