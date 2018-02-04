package pl.bbl.osbir.engine.ui.textinputs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class DefaultTextField extends TextField{
    public DefaultTextField(String text, Skin skin) {
        super(text, skin);
        fitTextIntoBoxes();
    }

    private void fitTextIntoBoxes(){
        getStyle().background.setLeftWidth(getStyle().background.getLeftWidth() + 5);
        getStyle().background.setRightWidth(getStyle().background.getRightWidth() + 5);
    }
}
