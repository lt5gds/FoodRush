package com.foodrush.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.foodrush.game.FoodRushGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "FoodRush";
		config.width = 800;
		config.height = 460;
		new LwjglApplication(new FoodRushGame(), config);
	}
}
