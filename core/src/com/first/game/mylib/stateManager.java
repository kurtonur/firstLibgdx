package com.first.game.mylib;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by ONUR on 2018-07-22.
 */

public class stateManager {

    private Stack<state> states;

    public stateManager(){
        states=new Stack<state>();
    }

    public void  render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public void update(float d){
        states.peek().update(d);
    }

    public void dispose(){
        states.peek().dispose();
    }

    public void pushState(state s){
        this.states.push(s);
    }

    public void popState(){
        this.states.pop();
    }


}
