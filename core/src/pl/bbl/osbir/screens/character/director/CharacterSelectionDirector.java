package pl.bbl.osbir.screens.character.director;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import pl.bbl.osbir.engine.ui.UserInterfaceManager;
import pl.bbl.osbir.screens.character.director.ui.CharacterSelectionLayout;

public class CharacterSelectionDirector {
    private CharacterSelectionLayout characterSelectionLayout;

    public CharacterSelectionDirector(Stack actors, UserInterfaceManager userInterfaceManager){
        characterSelectionLayout = new CharacterSelectionLayout(actors, userInterfaceManager, this);
    }

    public void render(SpriteBatch spriteBatch){
        characterSelectionLayout.render(spriteBatch);
    }
}
