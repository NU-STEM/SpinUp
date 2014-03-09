package com.helique.spinupandroid.obstacles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.helique.spinupandroid.math.force;

public class Inductor extends Obstacle {
	public static final String OUT = "out";
	final public static String IN = "in";
	String direction;
	Bitmap image;
	public Inductor(int x, int y, String direction ){
		this.x =x;
		this.y = y;
		this.direction = direction;
		if(direction == OUT){
			image = MainGamePanel.MainGamePanel.InductorOut;
		}
		if(direction == IN){
			image = MainGamePanel.MainGamePanel.InductorIn;
		}
	}
	@Override
	public force calculateForce(double electronX, double electronY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, (int)x - (image.getWidth() / 2), (int)y - (image.getHeight() / 2), null);
	}

	
	

}
