package com.helique.spinupandroid;

import MainGamePanel.MainGamePanel;
import MainGamePanel.MainThread;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	
	private static final String TAG = MainActivity.class.getSimpleName();
	MainGamePanel mGP = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requesting to turn the title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // making it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // set our MainGamePanel as the View
        mGP = new MainGamePanel(this);
        setContentView(mGP);
        Log.d(TAG, "View added");
    }
    @Override
    protected void onPause() {
    Log.d(TAG, "Pausing…");
    MainThread.running=false;//this is the value for stop the loop in the run()
    super.onPause();
    }
	@Override
	protected void onDestroy() {
		Log.d(TAG, "Destroying...");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "Stopping...");
		super.onStop();
		
	}
	@Override
	protected void onResume(){
		Log.d(TAG, "Resume...");
		super.onResume();
		
		
		
	}
	
    
    
}
