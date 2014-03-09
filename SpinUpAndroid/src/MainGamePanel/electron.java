package MainGamePanel;

import com.helique.spinupandroid.math.force;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class electron {
	private Bitmap bitmap;	// the actual bitmap
	private double x;			// the X coordinate
	private double y;			// the Y coordinate
	private boolean touched;	// if droid is touched/picked up
		// the speed with its directions
	double vMax = 10;
	double Vx;
	double Vy;
	public electron(Bitmap bitmap, int x, int y, double setVx, double setVy) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.Vx = setVx;
		this.Vy = setVy;
		
	}
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	

	

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, (int)x - (bitmap.getWidth() / 2), (int)y - (bitmap.getHeight() / 2), null);
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void update(force f) {
		Vx += f.xComponent;
		Vy += f.yComponent;
		
		double speed = Math.sqrt((Math.pow(Vx, 2) + Math.pow(Vy,2)));
		if(speed > vMax){
			Vy = (Vy/speed)*vMax;
			Vx = (Vx/speed)*vMax;
		}
		
		this.x += Vx;
		this.y += Vy;
		
		
	}
}
