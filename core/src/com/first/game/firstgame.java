package com.first.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.first.game.mylib.ImageLoader;
import com.first.game.mylib.stateManager;
import com.first.game.states.SplashState;


public class firstgame extends ApplicationAdapter {

	static public int WIDTH=480;
	static public int HEIGHT=360;
	static public int GamePlay=0;

	float elapsedTime;

	SpriteBatch batch;
	public static stateManager sm;
	OrthographicCamera cam;
	Viewport view;

	@Override
	public void create () {
		elapsedTime=0;

		batch = new SpriteBatch();
		cam=new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.position.set(WIDTH/2,HEIGHT/2,0);

		view=new StretchViewport(WIDTH, HEIGHT);
		view.setCamera(cam);
		view.apply();

		ImageLoader.load();

		sm=new stateManager();
		sm.pushState(new SplashState(sm,cam));

	}

	@Override
	public void render () {
			elapsedTime+=Gdx.graphics.getDeltaTime();
			sm.update(elapsedTime);
			sm.render(batch);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		view.update(width,height);
		cam.position.set(WIDTH/2,HEIGHT/2,0);
		cam.update();

	}

	@Override
	public void dispose () {
		sm.dispose();
		batch.dispose();
		ImageLoader.dispose();
	}
}
