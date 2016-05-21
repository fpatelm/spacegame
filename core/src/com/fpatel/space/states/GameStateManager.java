package com.fpatel.space.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by fpatel on 18/05/16.
 */
public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states =new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void reder(SpriteBatch sb){
        states.peek().render(sb);
    }
}
