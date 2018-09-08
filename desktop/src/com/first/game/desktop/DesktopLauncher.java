package com.first.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.first.game.firstgame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled=true;
		config.width=firstgame.WIDTH;
		config.height=firstgame.HEIGHT;

		new LwjglApplication(new firstgame(), config);
	}
}
