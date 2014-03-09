package com.helique.spinupandroid.obstacles;

import android.graphics.Canvas;

import com.helique.spinupandroid.math.force;

public abstract class Obstacle {
	int height;
	int width;
	public double x;
	public double y;
	public abstract void move(double distanceY);
	public abstract force calculateForce(double electronX, double electronY);
	public abstract void draw(Canvas canvas);
	
}
