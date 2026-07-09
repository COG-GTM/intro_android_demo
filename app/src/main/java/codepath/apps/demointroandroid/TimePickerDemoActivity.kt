package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TimePicker
import android.widget.Toast

// Activity that reads the current TimePicker value and shows it in a toast.
class TimePickerDemoActivity : Activity() {

    private lateinit var tpTime: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_demo)

        // Keep a reference to the picker used by the click handler.
        tpTime = findViewById(R.id.tpTime)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_time_picker_demo, menu)
        return true
    }

    @Suppress("UNUSED_PARAMETER")
    fun displayTime(v: View) {
        val time = "${tpTime.currentHour}:${tpTime.currentMinute}"
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
    }
}
