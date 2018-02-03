package pl.bbl.osbir.screens.login.director.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import pl.bbl.osbir.engine.ui.dialog.TextDialog;
import pl.bbl.osbir.engine.ui.textinputs.DefaultTextField;
import pl.bbl.osbir.engine.ui.window.TextWindow;
import pl.bbl.osbir.screens.login.director.LoginDirector;

public class LoginScreenLayout {
    private Stack mainStack;
    private AssetManager assetManager;
    private LoginDirector loginDirector;

    private Table loginComponentsTable;
    private DefaultTextField login;
    private DefaultTextField password;
    private Button confirm;

    private Table windowTable;
    private TextWindow connectingMessageWindow;
    private TextWindow requestingServersMessageWindow;
    private TextWindow loggingInWindow;
    private TextDialog loginFailureDialog;

    private TextureAtlas loginScreenAtlas;
    private TextureRegion background;

    public LoginScreenLayout(Stack mainStack, Skin skin, AssetManager assetManager, LoginDirector loginDirector){
        this.mainStack = mainStack;
        this.assetManager = assetManager;
        this.loginDirector = loginDirector;
        initializeComponents(skin);
        addChangeListenerToConfirmButton();
        assignComponentsToTable();
        loadBackground();
    }

    private void initializeComponents(Skin skin){
        loginComponentsTable = new Table();
        login = new DefaultTextField("", skin);
        password = new DefaultTextField("", skin);
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        confirm = new Button(skin, "confirm");

        windowTable = new Table();
        connectingMessageWindow = new TextWindow("", skin, "Connecting...");
        loggingInWindow = new TextWindow("", skin, "Logging in...");
        requestingServersMessageWindow = new TextWindow("", skin, "Requesting server list...");
        loginFailureDialog = new TextDialog("", skin, "Your authentication credentials are probably wrong.", 500, 150);
    }

    private void addChangeListenerToConfirmButton(){
        confirm.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                loginDirector.startLoginProcess(login.getText(), password.getText());
            }
        });
    }

    private void assignComponentsToTable() {
        loginComponentsTable.add(login).width(300).height(150);
        loginComponentsTable.row().pad(10);
        loginComponentsTable.add(password).width(300).height(150);
        loginComponentsTable.row().pad(10);
        loginComponentsTable.add(confirm).width(100).height(75);
        mainStack.add(loginComponentsTable);
        mainStack.add(windowTable);
    }

    private void loadBackground(){
        String atlasLocation = "textures/loginscreen/loginscreen.atlas";

        assetManager.load(atlasLocation, TextureAtlas.class);
        assetManager.finishLoading();
        loginScreenAtlas = assetManager.get(atlasLocation, TextureAtlas.class);
        background = loginScreenAtlas.findRegion("background");
    }

    public void displayConnectingWindow(){
        windowTable.add(connectingMessageWindow).width(500).height(150);
    }

    public void hideConnectingWindow(){
        windowTable.clearChildren();
        windowTable.removeActor(connectingMessageWindow);
    }

    public void displayLoggingInWindow(){
        windowTable.add(loggingInWindow).width(500).height(150);
    }

    public void hideLoggingInWindow(){
        windowTable.clearChildren();
        windowTable.removeActor(loggingInWindow);
    }

    public void displayLoginFailureDialog(){
        windowTable.add(loginFailureDialog).width(500).height(150);
    }

    public void displayRequestingServerListWindow(){
        windowTable.add(requestingServersMessageWindow).width(500).height(150);
    }

    public void hideRequestingServerListWindow(){
        windowTable.clearChildren();
        windowTable.removeActor(requestingServersMessageWindow);
    }

    public void render(SpriteBatch spriteBatch){
        spriteBatch.draw(background, 0, 0);
    }

    public void dispose(){
        loginScreenAtlas.dispose();
    }
}
