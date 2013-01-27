package com.hyperactivity.android_app;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Boolean isLocked;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Set up our lock button stuff
        isLocked = true;
        final TextView lockText = (TextView)findViewById(R.id.textView2);
        
        final Drawable lockedImg = getResources().getDrawable(R.drawable.locked);
        final Drawable unlockedImg = getResources().getDrawable(R.drawable.unlocked);
        final ImageButton lockButton = (ImageButton)findViewById(R.id.imageButton1);
		
        final String lockedText = "Locked";
        final String unlockedText = "Unlocked";
        
        lockText.setText(lockedText);
        
        lockButton.setBackgroundDrawable(lockedImg);
        lockButton.invalidate();
		
        lockButton.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				if (isLocked) {
					lockButton.setBackgroundDrawable(unlockedImg);
					lockText.setText(unlockedText);
				}
				else {
					lockButton.setBackgroundDrawable(lockedImg);
					lockText.setText(lockedText);
				}
				
				lockButton.invalidate();
				isLocked = !isLocked;
				
			}});
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
