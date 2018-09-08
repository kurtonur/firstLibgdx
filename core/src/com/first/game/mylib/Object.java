package com.first.game.mylib;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {

    protected Vector2 position;
    protected OrthographicCamera cam;
    protected float delta;

    public Object(Vector2 position){
        this.position=position;
    }

    public abstract void render(SpriteBatch sb);
    public abstract void update(float delta);
    public abstract Vector2 getPosition();
    public abstract Rectangle getRectangle();

}
