package com.first.game.mylib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageLoader {

    public static Texture gameTexture;

    public static TextureRegion bg1;
    public static TextureRegion bg2;
    public static TextureRegion bg3;
    public static TextureRegion openinglogo;
    public static TextureRegion EnemyBuzzSaw;
    public static TextureRegion EnemyBframe1,EnemyBframe2,EnemyBframe3;
    public static TextureRegion PlayerWait1,PlayerWait2,PlayerWait3,PlayerWait4,
    PlayerRun1,PlayerRun2,PlayerRun3,PlayerRun4,PlayerRun5,PlayerRun6,
    PlayerJump1,PlayerJump2,PlayerJump3,PlayerJump4,PlayerJump5,PlayerJump6,PlayerJump7,PlayerJump8;

    public static void load(){
        gameTexture=new Texture("Gameassets.png");

        bg1=new TextureRegion(gameTexture,481,0,480,360);
        bg2=new TextureRegion(gameTexture,0,361,480,360);
        bg3=new TextureRegion(gameTexture,0,0,480,360);

        openinglogo=new TextureRegion(gameTexture,481,361,400,330);

        EnemyBframe1=new TextureRegion(gameTexture,882,361,29,40);
        EnemyBframe2=new TextureRegion(gameTexture,882,402,36,30);
        EnemyBframe3=new TextureRegion(gameTexture,481,692,34,26);

        PlayerWait1=new TextureRegion(gameTexture,882,522,19,29);
        PlayerWait2=new TextureRegion(gameTexture,920,491,17,30);
        PlayerWait3=new TextureRegion(gameTexture,882,491,19,30);
        PlayerWait4=new TextureRegion(gameTexture,882,461,20,29);


        PlayerRun1=new TextureRegion(gameTexture,882,580,20,27);
        PlayerRun2=new TextureRegion(gameTexture,882,552,20,27);
        PlayerRun3=new TextureRegion(gameTexture,537,692,20,25);
        PlayerRun4=new TextureRegion(gameTexture,882,433,23,27);
        PlayerRun5=new TextureRegion(gameTexture,882,608,20,27);
        PlayerRun6=new TextureRegion(gameTexture,516,692,20,25);

        PlayerJump1=new TextureRegion(gameTexture,900,636,19,27);
        PlayerJump2=new TextureRegion(gameTexture,558,692,21,23);
        PlayerJump3=new TextureRegion(gameTexture,901,668,15,21);
        PlayerJump4=new TextureRegion(gameTexture,607,692,24,17);
        PlayerJump5=new TextureRegion(gameTexture,882,668,18,21);
        PlayerJump6=new TextureRegion(gameTexture,580,692,26,17);
        PlayerJump7=new TextureRegion(gameTexture,882,636,17,31);
        PlayerJump8=new TextureRegion(gameTexture,902,491,17,30);


        EnemyBuzzSaw=new TextureRegion(gameTexture,632,692,15,15);
    }

    public static void dispose(){
        gameTexture.dispose();
    }

}
