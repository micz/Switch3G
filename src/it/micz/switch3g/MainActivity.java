package it.micz.switch3g;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
    
    @Override
	public void onStart() {
		super.onStart();
		Intent intent = new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		int currentapiVersion = android.os.Build.VERSION.SDK_INT;
		if(currentapiVersion>=android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH){
			//Android 4.0+
			intent.setAction(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
		}else{
			//Other Android
			intent.setAction(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
			ComponentName cName = new ComponentName("com.android.phone","com.android.phone.Settings");
			intent.setComponent(cName);
		}
		startActivity(intent);
		finish();
    }
    
	@Override
    public void onDestroy() {
        super.onDestroy();
        System.runFinalization();
        System.exit(0);
    }
}
