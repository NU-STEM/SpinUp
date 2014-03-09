package MainGamePanel;




import java.util.ArrayList;

import com.helique.spinupandroid.R;


import com.helique.spinupandroid.math.force;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.helique.spinupandroid.obstacles.*;

/**
 * @author impaler
 * This is the main surface that handles the ontouch events and draws
 * the image to the screen.
 */
public class MainGamePanel extends SurfaceView implements
		SurfaceHolder.Callback {

	private static final String TAG = MainGamePanel.class.getSimpleName();
	
	public static Bitmap ChargedPlateUp;
	public static Bitmap ChargedPlateDown;
	public static Bitmap ChargedPlateLeft;
	public static Bitmap ChargedPlateRight;
	
	public static Bitmap InductorIn;
	public static Bitmap InductorOut;
	
	public static Bitmap PointChargePlus;
	public static Bitmap PointChargeMinus;
	
	private MainThread thread;
	private electron playerElectron;
	private Overlay magneticOverlay;
	private PathLevel level;
	private int surfaceHeight;
	private int surfaceWidth;
	private ArrayList<Obstacle> obstacleList;

	private double MagneticField = 1.5;
	private boolean fieldIn = true;
	private boolean playing;

	
	public MainGamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		playing = true;
		// create droid and load bitmap

		
		InductorIn = BitmapFactory.decodeResource(getResources(), R.drawable.fieldin);
		InductorOut = BitmapFactory.decodeResource(getResources(), R.drawable.fieldout);
		ChargedPlateUp = BitmapFactory.decodeResource(getResources(), R.drawable.upplate);
		ChargedPlateDown = BitmapFactory.decodeResource(getResources(), R.drawable.downplate);
		ChargedPlateLeft = BitmapFactory.decodeResource(getResources(), R.drawable.leftplate);
		ChargedPlateRight = BitmapFactory.decodeResource(getResources(), R.drawable.rightplate);
		PointChargePlus = BitmapFactory.decodeResource(getResources(), R.drawable.pointchargeplus);
		PointChargeMinus = BitmapFactory.decodeResource(getResources(), R.drawable.pointchargeminus);
		playerElectron = new electron(BitmapFactory.decodeResource(getResources(), R.drawable.electronplus), surfaceWidth/2, surfaceHeight*3/4,1,0);
		obstacleList = PathLevel.parseLevel(0,0,0);
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		surfaceHeight = holder.getSurfaceFrame().height();
		surfaceWidth = holder.getSurfaceFrame().width();
		
		
		// at this point the surface is created and
		// we can safely start the game loop
		if(thread.getState() == Thread.State.NEW){
			thread.setRunning(true);
			thread.start();
		} else if(thread.getState() == Thread.State.TERMINATED){
			thread = new MainThread(getHolder(), this);
			thread.setRunning(true);
			thread.start();
		}
	}
	

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// delegating event handling to the droid
			//playerElectron.handleActionDown((int)event.getX(), (int)event.getY());
			
			// check if in the lower part of the screen we exit
			if (event.getY() > getHeight() - 50) {
				thread.setRunning(false);
				((Activity)getContext()).finish();
			} else {
				if(playing == true){
					this.fieldIn = !this.fieldIn;
					
					//playing = false;
				}else{
					
					
					
				}
			}
		} if (event.getAction() == MotionEvent.ACTION_MOVE) {
			// the gestures
//			if (playerElectron.isTouched()) {
//				// the droid was picked up and is being dragged
//				playerElectron.setX((int)event.getX());
//				playerElectron.setY((int)event.getY());
//			}
		} if (event.getAction() == MotionEvent.ACTION_UP) {
			// touch was released
//			if (playerElectron.isTouched()) {
//				playerElectron.setTouched(false);
//			}
		}
		return true;
	}

	public void render(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		playerElectron.draw(canvas);
		
		for(Obstacle o: obstacleList){
			o.draw(canvas);
		}
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
		// check collision with right wall if heading right
//		if (playerElectron.Vx == Speed.DIRECTION_RIGHT
//				&& playerElectron.getX() + playerElectron.getBitmap().getWidth() / 2 >= getWidth()) {
//			playerElectron.getSpeed().toggleXDirection();
//		}
//		// check collision with left wall if heading left
//		if (playerElectron.Vx == Speed.DIRECTION_LEFT
//				&& playerElectron.getX() - playerElectron.getBitmap().getWidth() / 2 <= 0) {
//			playerElectron.getSpeed().toggleXDirection();
//		}
//		// check collision with bottom wall if heading down
//		if (playerElectron.getSpeed().getyDirection() == Speed.DIRECTION_DOWN
//				&& playerElectron.getY() + playerElectron.getBitmap().getHeight() / 2 >= getHeight()) {
//			playerElectron.getSpeed().toggleYDirection();
//		}
//		// check collision with top wall if heading up
//		if (playerElectron.getSpeed().getyDirection() == Speed.DIRECTION_UP
//				&& playerElectron.getY() - playerElectron.getBitmap().getHeight() / 2 <= 0) {
//			playerElectron.getSpeed().toggleYDirection();
//		}
		if(playing){
			
			force magneticForce = new force(0,0);
			for(Obstacle o: obstacleList){
				magneticForce.add(o.calculateForce(playerElectron.getX(),playerElectron.getY()));
			}
			playerElectron.update(magneticForce);
			
			
			
			
		}
	}

}
