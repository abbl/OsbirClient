package pl.bbl.osbir.screens.login.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class LoginLayout {
    private Table textFieldsTable;

    private TextField[] textFields; //0 login 1 password

    public LoginLayout(){

    }

    private void initializeTextFields(){
        textFieldsTable = new Table();
        textFields = new TextField[2];
    }
}
