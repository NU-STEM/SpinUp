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
	public force calculateForce(double electronX, double electronY , double Vx, double Vy) {
		if((electronX > this.x - 50/2) && (electronX < (this.x+ 50 /2)) && (electronY > this.y - 50/2) && (electronY < (this.y+ 50 /2))){
			if(direction == IN){
				return force.FromMagDelta(.2,Vy,-Vx);
				
			}else{
				return force.FromMagDelta(.2,-Vy,Vx);
			}
		}
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, (int)x - (image.getWidth() / 2), (int)y - (image.getHeight() / 2), null);
	}

	
	

}
