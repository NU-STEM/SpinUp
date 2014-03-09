package com.helique.spinupandroid.obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.helique.spinupandroid.math.force;

public class ChargedPlate extends Obstacle {
	private Paint lineStyle;
	public ChargedPlate(int x, int y){
		lineStyle = new Paint();
		lineStyle.setAlpha(255);
		lineStyle.setColor(Color.rgb(255, 255, 255));
		lineStyle.setStrokeWidth(3f);
		height = 200;
		this.x = x;
		this.y = y;
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
		canvas.drawLine((float)x ,(float) y,(float) x , (float)y+height, lineStyle);
		canvas.drawLine((float)x ,(float) y,(float) x+500 , (float)y, lineStyle);
		canvas.drawLine((float)x ,(float) y+height,(float) x+500 , (float)y+height, lineStyle);

	}
	@Override
	public void move(double distanceY) {
		this.y +=distanceY;
		
	}

}
