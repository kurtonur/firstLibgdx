package com.first.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.first.game.Collision;
import com.first.game.firstgame;
import com.first.game.inputPlayState;
import com.first.game.mylib.Background;
import com.first.game.mylib.ImageLoader;
import com.first.game.mylib.Object;
import com.first.game.mylib.SpriteAnimation;
import com.first.game.mylib.state;
import com.first.game.mylib.stateManager;
import com.first.game.objects.bird;
import com.first.game.objects.mainPlayer;
import com.first.game.objects.saw;

import java.util.ArrayList;
import java.util.Random;

public class PlayState extends state {

    Background layer1bg,layer1bg2,layer1bg3;
    public float speed=1f;
    public mainPlayer player;
    private ArrayList<Object> allenemy;
    private BitmapFont write;

    private Sound bgsound;

    public PlayState(stateManager sm, OrthographicCamera cm) {
        super(sm, cm);
        Gdx.input.setInputProcessor(new inputPlayState(this));

        write =new BitmapFont(Gdx.files.internal("font/gamefont.fnt"), false);
        bgsound = Gdx.audio.newSound(Gdx.files.internal("sound/bg.mp3"));


        layer1bg=new Background(false,ImageLoader.bg1,ImageLoader.bg1,ImageLoader.bg1,cam,0f);
        layer1bg2=new Background(false,ImageLoader.bg2,ImageLoader.bg2,ImageLoader.bg2,cam,0f);
        layer1bg3=new Background(false,ImageLoader.bg3,ImageLoader.bg3,ImageLoader.bg3,cam,0f);


        player=new mainPlayer(new Vector2(cam.position.x-180,cam.position.y-110),new SpriteAnimation(
                new TextureRegion[]{ImageLoader.PlayerWait1,ImageLoader.PlayerWait2,ImageLoader.PlayerWait3,ImageLoader.PlayerWait4,ImageLoader.PlayerRun1,ImageLoader.PlayerRun2,ImageLoader.PlayerRun3,ImageLoader.PlayerRun4,ImageLoader.PlayerRun5,ImageLoader.PlayerRun6
                ,ImageLoader.PlayerJump1,ImageLoader.PlayerJump2,ImageLoader.PlayerJump3,ImageLoader.PlayerJump4,ImageLoader.PlayerJump5,ImageLoader.PlayerJump6,ImageLoader.PlayerJump7,ImageLoader.PlayerJump8}
        ));
        player.beginRun=4;
        player.endRun=9;
        player.beginJump=10;
        player.endJump=18;
        player.beginWait=0;
        player.endWait=4;
        player.setCam(cam);
        player.getSprite().setSpeed(1/5f);
        if(firstgame.GamePlay==0)
        player.setSpriteWait();
        else player.setSpriteRun();

        allenemy=new ArrayList<Object>();
        addobject(allenemy,cam);
        addobject(allenemy,cam);
        addobject(allenemy,cam);

        bgsound.loop(0.3f);

    }


    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(18/255f,39/255f,60/255f, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        layer1bg3.Scrolling(sb);
        layer1bg2.Scrolling(sb);
        layer1bg.Scrolling(sb);
        player.render(sb);

        for (Object enemy : allenemy)
            enemy.render(sb);

        if(firstgame.GamePlay==0) {
            write.draw(sb, "Touch and Start", 65, 50);
        }
        else if(firstgame.GamePlay==2) {
            write.draw(sb, "Restart", cam.position.x-45, 50);
        }
        sb.end();
        cam.update();
    }

    @Override
    public void update(float delta) {
        player.update(delta);
        if(firstgame.GamePlay==1){

            layer1bg.setPace(-0.8f);
            layer1bg2.setPace(-0.6f);
            cam.position.x+=speed;

            for (Object enemy : allenemy)
                enemy.update(delta);
            if(Collision.AllObject(player, allenemy,cam)){
                player.getGameoverSound().play(0.5f);
                firstgame.GamePlay=2;
            }
        }
        else if(firstgame.GamePlay==2){
            player.setSpriteWait();
            layer1bg.setPace(0f);
            layer1bg2.setPace(0f);
            bgsound.stop();
        }

    }

    @Override
    public void dispose() {
        player.dispose();
        bgsound.dispose();
    }

    public void addobject(ArrayList<Object> obs,OrthographicCamera cam){
        Random ran = new Random();
        if(ran.nextInt(2)==0)
            obs.add(new bird(new Vector2(cam.position.x+firstgame.WIDTH/2+ran.nextInt(150)+25,cam.position.y-70)));
        else
            obs.add(new saw(new Vector2(cam.position.x+firstgame.WIDTH/2+ran.nextInt(75)+25,cam.position.y-110)));
    }

    public stateManager getStateManager(){
        return this.sm;
    }
    public OrthographicCamera getCamera(){
        return this.cam;
    }
}
