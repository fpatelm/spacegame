package com.fpatel.space;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fpatel.space.screens.PlayScreen;
import com.fpatel.space.states.GameStateManager;

public class MyGdxGame extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "SPACE";

	private GameStateManager gsm;
	public SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
//		gsm = new GameStateManager();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		gsm.push(new MenuState(gsm,batch));
	}

	@Override
	public void render () {
		super.render();
	}
}
