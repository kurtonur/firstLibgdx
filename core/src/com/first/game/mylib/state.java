package com.first.game.mylib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ONUR on 2018-07-22.
 */

public abstract class state {

    protected OrthographicCamera cam;
    protected stateManager sm;
    protected float delta;

    public state(stateManager sm,OrthographicCamera cm){
        this.sm=sm;
        this.cam=cm;
    }
    public abstract void render(SpriteBatch sb);
    public abstract void update(float delta);
    public abstract void dispose();


}
