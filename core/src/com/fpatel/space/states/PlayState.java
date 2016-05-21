package com.fpatel.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fpatel.space.MyGdxGame;
import com.fpatel.space.sprites.Bullet;
import com.fpatel.space.sprites.Enemy;
import com.fpatel.space.sprites.Spaceship;

import java.util.ArrayList;

/**
 * Created by fpatel on 18/05/16.
 */
public class PlayState extends State {
    private Spaceship spaceship;
    private Texture background;
    private ArrayList<Bullet> bullets =new ArrayList<Bullet>();
    private ArrayList<Enemy> enemies =new ArrayList<Enemy>();
    private float elapsedtime = 0;
    public PlayState(GameStateManager gsm,SpriteBatch sb) {
        super(gsm,sb);
        spaceship= new Spaceship((MyGdxGame.WIDTH/4)-25,5);
        background = new Texture("background.jpg");
        cam.setToOrtho(false,MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            spaceship.move(-15,0);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            spaceship.move(15,0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            bullets.add(new Bullet((spaceship.getPosition().x+20-7.5f),spaceship.getPosition().y+10));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (spaceship.getPosition().x > cam.viewportWidth)
            spaceship.getPosition().x = cam.viewportWidth;

        if (spaceship.getPosition().x < 0)
            spaceship.getPosition().x = 0;
        spaceship.update(dt);

        for(Bullet bullet: bullets){
            bullet.update(dt);
        }
        //add enemes every 5 seconds
        elapsedtime = Gdx.graphics.getDeltaTime() + elapsedtime;
        if(elapsedtime > 5) {
            enemies.add(new Enemy());
            elapsedtime = 0;
        }
        for(Enemy enemy: enemies){
            if( enemy.getPosition().y < 0 ){
                enemy.dispose();
            }else{
                enemy.update(dt);
            }

        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,cam.position.x - (cam.viewportWidth / 2),0);
        sb.draw(spaceship.getTexture(),spaceship.getPosition().x,spaceship.getPosition().y,40,40);

        for(Bullet bullet: bullets){
            bullet.draw(sb);
        }
        for(Enemy enemy: enemies){
            enemy.draw(sb);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        for(Bullet bullet: bullets){
            bullet.getTexture().dispose();
        }
        for(Enemy enemy: enemies){
            enemy.getTexture().dispose();
        }
        spaceship.getTexture().dispose();
    }
}
