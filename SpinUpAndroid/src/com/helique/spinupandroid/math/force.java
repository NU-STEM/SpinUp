package com.helique.spinupandroid.math;

public class force {
	public double xComponent=0;
	public double yComponent=0;
	public force(double setXComponent , double setYComponent ){
		xComponent = setXComponent;
		yComponent = setYComponent;
	}
	public static force FromMagRotation(double magnatude, double rotation){
		double x= magnatude*Math.cos(rotation);
		double y = magnatude*Math.sin(rotation);
		return new force(x,y);
	}
	public static force FromMagDelta(double magnatude, double deltaX, double deltaY){
		double rotation = Math.atan2(deltaY, deltaX);
		return FromMagRotation(magnatude, rotation);
	}
	public void add(force f){
		if(f != null){
			this.xComponent +=f.xComponent;
			this.yComponent +=f.yComponent;
		}
	}
	
}
