package pl.bbl.osbir.engine.ui.list;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DefaultListDialog extends Dialog{
    private List list;

    public DefaultListDialog(String title, Skin skin, Object[] listContent) {
        super(title, skin);
        createList(listContent);
        addButton();
    }

    private void createList(Object[] listContent){
        list = new List(getSkin());
        list.setItems(listContent);
        getContentTable().add(list);
    }

    private void addButton(){
        getButtonTable().defaults().width(75).height(75);
        button(new Button(getSkin(), "confirm"));
    }
}
