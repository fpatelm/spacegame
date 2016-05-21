package com.fpatel.space.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by fpatel on 19/05/16.
 */
public class Enemy {
    private static final int FLUCTUATION = 200;
    private static final int VELOCITY = -1;
    private Vector3 position;
    private Vector3 velocity;
    private Texture texture;
    Random rand;

    public Enemy(){
        rand = new Random();
        position = new Vector3(rand.nextInt(FLUCTUATION),600,0);
        velocity = new Vector3(0,0,0);
        texture = new Texture("enemy.png");
    }

    public void update(float dt){
        velocity.add(0,VELOCITY,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);
        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void draw(SpriteBatch sb){
        sb.draw(texture,position.x,position.y,15,15);
    }

    public void dispose(){
        texture.dispose();
    }
}
