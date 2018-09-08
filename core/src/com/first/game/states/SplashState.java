package com.first.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.first.game.mylib.ImageLoader;
import com.first.game.mylib.state;
import com.first.game.mylib.stateManager;

public class SplashState extends state {

    Sprite Logo;
    float setAlphafloat=0f;
    int changestatetimer=0;
    private Sound opingSound;
    public SplashState(stateManager sm, OrthographicCamera cm) {
        super(sm, cm);
        Logo=new Sprite(ImageLoader.openinglogo);
        Logo.setSize(140,120);
        Logo.setPosition(cam.position.x-Logo.getWidth()/2,cam.position.y-Logo.getHeight()/2);

        opingSound = Gdx.audio.newSound(Gdx.files.internal("sound/open.mp3"));
        opingSound.play(0.5f);

    }


    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        Logo.draw(sb);
        sb.end();
    }

    @Override
    public void update(float delta) {



        if(setAlphafloat<0.99){
            setAlphafloat+=.02f;
        }
        else {
            setAlphafloat = 1f;
            changestatetimer++;
        }

        Logo.setAlpha(setAlphafloat);
        if(changestatetimer == 15){
            sm.popState();
            sm.pushState(new PlayState(sm,cam));
        }
    }

    @Override
    public void dispose() {
        opingSound.dispose();
    }
}
