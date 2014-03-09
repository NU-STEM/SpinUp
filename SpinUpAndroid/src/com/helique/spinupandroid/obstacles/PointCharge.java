package com.helique.spinupandroid.obstacles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.helique.spinupandroid.R;
import com.helique.spinupandroid.math.force;

public class PointCharge extends Obstacle {
	
	public static final String PLUS = "plus";
	public static final String MINUS = "minus";
	String direction;
	Bitmap image;
	public PointCharge (int x, int y, String direction){
		this.x =x;
		this.y =y;
		this.direction = direction;
		if(direction == PLUS){
			image = MainGamePanel.MainGamePanel.PointChargePlus;
		}
		if(direction == MINUS){
			image = MainGamePanel.MainGamePanel.PointChargeMinus;
		}
	}
	public force calculateForce(double electronX, double electronY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, (int)x - (image.getWidth() / 2), (int)y - (image.getHeight() / 2), null);

	}

}
