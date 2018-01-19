package pl.bbl.osbir.engine.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TextDialog extends Dialog{
    public TextDialog(String title, Skin skin, String text, float width, float height) {
        super(title, skin);
        addLabel(text, width, height);
        addButton();
    }

    private void addLabel(String text, float width, float height){
        Label dialogText = new Label(text, getSkin());
        dialogText.setWrap(true);
        getContentTable().add(dialogText).width(width).height(height * 95 / 100);
    }

    private void addButton(){
        getButtonTable().defaults().width(75).height(75);
        button(new Button(getSkin(), "confirm"));
    }
}
