package com.first.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.first.game.mylib.Object;
import com.first.game.mylib.SpriteAnimation;

public class mainPlayer extends Object{

    private SpriteAnimation sprite;
    public int beginRun,endRun,beginJump,endJump,beginWait,endWait;
    public boolean move=true,jmp;
    private float floor;

    private Sound soundJump,soundRun,gameoverSound;

    public mainPlayer(Vector2 position,SpriteAnimation sprite) {
        super(position);
        this.sprite=sprite;
        this.floor=position.y;
        jmp=true;

        gameoverSound = Gdx.audio.newSound(Gdx.files.internal("sound/gameover.mp3"));
        soundJump = Gdx.audio.newSound(Gdx.files.internal("sound/jump.mp3"));
        soundRun = Gdx.audio.newSound(Gdx.files.internal("sound/run.mp3"));
    }
    public void setCam(OrthographicCamera cam){
        this.cam=cam;
    }

    public SpriteAnimation getSprite(){
        return sprite;
    }

    public void setSpriteChange(int begin,int end){
        this.sprite.setBetweenFrame(begin,end);
    }

    public void setSpriteJump(){
        sprite.setSpeed(1 / 10f);
        setSpriteChange(this.beginJump,this.endJump);
        soundRun.stop();
        soundJump.play(0.5f);
    }
    public void setSpriteRun(){
        sprite.setSpeed(1 / 10f);
        setSpriteChange(this.beginRun,this.endRun);
        soundJump.stop();
        soundRun.loop(0.5f);
    }

    public void setSpriteWait(){
        soundJump.stop();
        soundRun.stop();
        setSpriteChange(this.beginWait,this.endWait);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.draw(sprite.getAnimationSprite(delta),position.x,position.y);

    }

    public void update(float delta){
        this.delta=delta;
        position.set(cam.position.x-180,position.y);
        junp();
    }


    public void junp(){
        if(move==false) {
            if (jmp==true) position.y += 2;
            else position.y-=2;

            if(position.y==floor+50) jmp =false;
            if(position.y==floor){
                jmp =true;
                move=true;
                setSpriteRun();
            }

        }
    }

    public boolean getMoveBool(){
        boolean tut=false;
        if(floor==position.y) tut=true;
            return tut;
    }

    public Vector2 getPosition(){
        return this.position;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(position.x+2,position.y+2,sprite.getCurrentSprite().getWidth()-4,sprite.getCurrentSprite().getHeight()-2);
    }

    public Sound getGameoverSound(){
        return gameoverSound;
    }

    public void dispose(){
        soundJump.dispose();
        soundRun.dispose();
        gameoverSound.dispose();
    }

}
