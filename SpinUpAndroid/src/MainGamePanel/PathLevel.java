package MainGamePanel;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PathLevel {
	public Paint lineStyle;
	
	public int width;
	public int xOffset;
	public PathLevel(int Width, int x){
		this.width = Width;
		this.xOffset =x;
		lineStyle = new Paint();
		lineStyle.setAlpha(255);
		lineStyle.setColor(Color.rgb(255, 255, 255));
		lineStyle.setStrokeWidth(3f);
	}
	public void draw(Canvas canvas) {
		canvas.drawLine(xOffset - width/2, 0, xOffset - width/2, canvas.getHeight(), lineStyle);
		canvas.drawLine(xOffset + width/2, 0, xOffset + width/2, canvas.getHeight(), lineStyle);
	}
}
