package MainGamePanel;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Overlay {
	private Bitmap bitmapIn;
	private Bitmap bitmapOut;
	public  int x;
	public  int y;
	public boolean MagneticIn = true;
	public void flipField(){
		MagneticIn = !MagneticIn;
	}

	public Overlay(Bitmap bitmapIn, Bitmap bitmapOut, int x, int y) {
		this.bitmapIn = bitmapIn;
		this.bitmapOut = bitmapOut;
		this.x = x;
		this.y = y;
	}
	public void draw(Canvas canvas) {
		if(MagneticIn){
			canvas.drawBitmap(bitmapIn, (int)x , (int)y , null);
			
		} else{
			canvas.drawBitmap(bitmapOut, (int)x , (int)y , null);
		}
		
	}
}
