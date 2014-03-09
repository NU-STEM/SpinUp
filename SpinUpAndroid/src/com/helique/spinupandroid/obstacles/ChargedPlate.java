package com.helique.spinupandroid.obstacles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.helique.spinupandroid.math.force;

public class ChargedPlate extends Obstacle {
	private Paint lineStyle; 
	final public static String DOWN = "down";
	final public static String UP ="up";
	final public static String RIGHT = "right";
	final public static String LEFT = "left";
	Bitmap image;
	String direction;
	public ChargedPlate(int x, int y, String direction){
		lineStyle = new Paint();
		lineStyle.setAlpha(255);
		lineStyle.setColor(Color.rgb(255, 255, 255));
		lineStyle.setStrokeWidth(3f);
		this.direction = direction;
		this.x = x;
		this.y = y;
		
		if(direction == DOWN){
			image = MainGamePanel.MainGamePanel.ChargedPlateDown;
		}
		if(direction == UP)
		{
			image = MainGamePanel.MainGamePanel.ChargedPlateUp;
		}
		if(direction == LEFT){
			image = MainGamePanel.MainGamePanel.ChargedPlateLeft;
		}
		if(direction == RIGHT){
			image = MainGamePanel.MainGamePanel.ChargedPlateRight;
		}
	}
	@Override
	public force calculateForce(double electronX, double electronY) {
		if ((electronY > this.y) && (electronY < (this.y+this.height))){
			return force.FromMagDelta(1, this.x - electronX, 0);	
		} 
		return null;
		
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, (int)x - (image.getWidth() / 2), (int)y - (image.getHeight() / 2), null);
		
	}

}
