package codepath.apps.demointroandroid;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDemoActivity extends Activity {
	
	TimePicker tpTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_picker_demo);
		tpTime = (TimePicker) findViewById(R.id.tpTime);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_time_picker_demo, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void displayTime(View v) {
		int hour;
		int minute;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			hour = tpTime.getHour();
			minute = tpTime.getMinute();
		} else {
			hour = tpTime.getCurrentHour();
			minute = tpTime.getCurrentMinute();
		}
		String time = hour + ":" + minute;
		Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
	}

}
