package com.first.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.first.game.mylib.ImageLoader;
import com.first.game.mylib.Object;

public class saw extends Object {

    Sprite sp;
    int rotate=0;
    public saw(Vector2 position) {
        super(position);
        sp=new Sprite(ImageLoader.EnemyBuzzSaw);
        sp.setSize(15,15);
        sp.setPosition(position.x,position.y);

    }

    @Override
    public void render(SpriteBatch sb) {

        sp.draw(sb);

    }

    @Override
    public void update(float delta) {

        if(rotate<-360) rotate=0;
        rotate+=10;
        sp.setRotation(rotate);
        sp.setPosition(position.x-=3,position.y);

    }

    public Vector2 getPosition(){
        return this.position;
    }

    @Override
    public Rectangle getRectangle() {
         return new Rectangle(position.x+2,position.y+2,sp.getWidth()-4,sp.getHeight()-4);
    }
}
