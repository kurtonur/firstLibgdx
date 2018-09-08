package com.first.game.mylib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteAnimation {

    private Sprite[] kareler;
    private float speed=1/30f;
    private int currentFrame=0,firstFrame,lastFrame;
    private Sprite temp;
    private float tempdelta=0;

    public SpriteAnimation (Texture tresimler, int width, int height){

        TextureRegion[][] resim=TextureRegion.split(tresimler,width,height);

        this.kareler=new Sprite[resim[0].length*resim.length];
        this.karele(resim,resim[0].length,resim.length);
        this.firstFrame=0;
        this.lastFrame=kareler.length-1;
        this.temp=kareler[firstFrame];

    }

    public SpriteAnimation (TextureRegion tresimler, int width, int height){


        TextureRegion[][] resim=tresimler.split(width,height);
        this.kareler=new Sprite[resim[0].length*resim.length];
        this.karele(resim,resim[0].length,resim.length);
        this.firstFrame=0;
        this.lastFrame=kareler.length-1;
        this.temp=kareler[firstFrame];

    }

    public SpriteAnimation (TextureRegion[] tresimler){


        kareler = new Sprite[tresimler.length];
        this.karele(tresimler);
        this.firstFrame=0;
        this.lastFrame=kareler.length-1;
        this.temp=kareler[firstFrame];

    }

    private void karele(TextureRegion[][] resim, int cX, int cY){
        int say=0;
        for(int i=0;i<cY;i++)
            for(int j=0;j<cX;j++){
                //resim[i][j].flip(false,true);
                kareler[say++]=new Sprite(resim[i][j]);
                new Sprite();
            }
    }
    private void karele(TextureRegion[] tresimler){
        int say=0;
        for(int i=0;i<tresimler.length;i++){
                kareler[say++]=new Sprite(tresimler[i]);
            }
    }

    public TextureRegion getTextureRegion(int id){ return this.kareler[id]; }
    public Sprite getSprite(int id){ return new Sprite(this.kareler[id]); }

    public TextureRegion getCurrentTextureRegion(){ return this.kareler[this.currentFrame]; }
    public Sprite getCurrentSprite(){ return new Sprite(this.kareler[this.currentFrame]); }


    public TextureRegion getAnimationTextureRegion(float delta){

            if(delta-tempdelta>=speed){
            tempdelta=delta;
            temp=kareler[currentFrame];
                currentFrame++;
            if(currentFrame==lastFrame) currentFrame=firstFrame;
            }
        return temp;
    }



    public Sprite getAnimationSprite(float delta){

        if(delta-tempdelta>=speed){
            tempdelta=delta;
            temp=kareler[currentFrame];
            currentFrame++;
            if(currentFrame==lastFrame) currentFrame=firstFrame;
        }
        return temp;
    }

    public void setSpeed(float speed){
        this.speed=speed;
    }
    public void setBetweenFrame(int first,int last){
        if(first<=last){
            firstFrame=first;
            lastFrame=last;
            currentFrame=first;
        }
    }

}
