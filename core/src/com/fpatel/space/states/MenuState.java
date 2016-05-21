package com.fpatel.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fpatel.space.MyGdxGame;

/**
 * Created by fpatel on 18/05/16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gsm,SpriteBatch sb) {
        super(gsm,sb);
        background = new Texture("background.jpg");
        playBtn = new Texture("PlayButton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm,sb));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        sb.draw(playBtn,(MyGdxGame.WIDTH)/2-playBtn.getWidth()/2,(MyGdxGame.HEIGHT)/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
