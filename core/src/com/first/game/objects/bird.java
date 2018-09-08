package com.first.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.first.game.mylib.ImageLoader;
import com.first.game.mylib.Object;
import com.first.game.mylib.SpriteAnimation;

public class bird extends Object {

    private SpriteAnimation sp;

    public bird(Vector2 position) {
        super(position);

        sp=new SpriteAnimation(new TextureRegion[]{ImageLoader.EnemyBframe1,ImageLoader.EnemyBframe2,ImageLoader.EnemyBframe3,ImageLoader.EnemyBframe2});
        sp.setSpeed(1/5f);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(sp.getAnimationSprite(delta),position.x,position.y);
    }

    @Override
    public void update(float delta) {
        this.delta=delta;
        position.x-=2.5;
    }

    public void setVector(float x,float y){
        position.set(x,y);
    }

    public Vector2 getPosition(){
        return this.position;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(position.x+2,position.y+2,sp.getCurrentSprite().getWidth()-4,sp.getCurrentSprite().getHeight()-4);
    }

}
