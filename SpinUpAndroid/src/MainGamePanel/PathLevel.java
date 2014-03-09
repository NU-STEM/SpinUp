package MainGamePanel;

import java.util.ArrayList;

import com.helique.spinupandroid.obstacles.ChargedPlate;
import com.helique.spinupandroid.obstacles.Inductor;
import com.helique.spinupandroid.obstacles.Obstacle;
import com.helique.spinupandroid.obstacles.PointCharge;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PathLevel {
	static final int ChargedPlateUP = 1;
	static final int ChargedPlateDOWN = 2;
	static final int ChargedPlateLEFT = 3;
	static final int ChargedPlateRIGHT = 4;
	
	static final int InductorIn = 5;
	static final int InductorOUT = 6;
	
	static final int PointChargePositive = 7;
	static final int PointChargeNegative = 8;
	static int[][] level1 = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	public Paint lineStyle;
	
	public int width;
	public int height;
	
	static public ArrayList<Obstacle> parseLevel(int levelNumber, int Width, int Height){
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		int blockSize = 50;
		int offset = 25;
		for(int j = 0; j < level1.length; j++){
			for (int i = 0; i < level1[j].length; i++){
			
				if(level1[j][i] == PathLevel.ChargedPlateUP){
					obstacles.add(new ChargedPlate(i*blockSize +offset,j*blockSize+offset,ChargedPlate.UP));
				}
				if(level1[j][i] == PathLevel.ChargedPlateDOWN){
					obstacles.add(new ChargedPlate(i*blockSize+offset ,j*blockSize+offset,ChargedPlate.DOWN));
				}
				if(level1[j][i] == PathLevel.ChargedPlateLEFT){
					obstacles.add(new ChargedPlate(i*blockSize +offset,j*blockSize +offset,ChargedPlate.LEFT));
				}
				if(level1[j][i] == PathLevel.ChargedPlateRIGHT){
					obstacles.add(new ChargedPlate(i*blockSize +offset,j*blockSize +offset,ChargedPlate.RIGHT));
				}
				if(level1[j][i] == PathLevel.InductorIn){
					obstacles.add(new Inductor(i*blockSize +offset ,j*blockSize +offset,Inductor.IN));
				}	
				if(level1[j][i] == PathLevel.InductorOUT){
					obstacles.add(new Inductor(i*blockSize +offset,j*blockSize +offset,Inductor.OUT));
				}
				if(level1[j][i] == PathLevel.PointChargePositive){
					obstacles.add(new PointCharge(i*blockSize +offset,j*blockSize +offset,PointCharge.PLUS));
				}	
				if(level1[j][i] == PathLevel.PointChargeNegative){
					obstacles.add(new PointCharge(i*blockSize +offset,j*blockSize +offset,PointCharge.MINUS));
				}	
			}
		}
		return obstacles;
		
		
	}
	public void draw(Canvas canvas) {
		
	}
}
