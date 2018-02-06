package pl.bbl.osbir.engine.ui.buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import pl.bbl.osbir.player.PlayerCharacter;

public class PlayerCharacterButton extends Button{
    private static PlayerCharacter selectedCharacter;
    private PlayerCharacter playerCharacter;
    private Label label;

    public PlayerCharacterButton(Skin skin, PlayerCharacter playerCharacter){
        super(skin, "characterSelect");
        this.playerCharacter = playerCharacter;
        this.label = new Label(playerCharacter.toString(), skin);
        addListener(addCharacterSelection());
    }

    private ChangeListener addCharacterSelection(){
        return new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                selectedCharacter = playerCharacter;
            }
        };
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        drawCharacterName(batch, parentAlpha);
    }

    private void drawCharacterName(Batch batch, float parentAlpha) {
        label.draw(batch, parentAlpha);
    }

    public PlayerCharacter getSelectedButton(){
        return selectedCharacter;
    }
}
