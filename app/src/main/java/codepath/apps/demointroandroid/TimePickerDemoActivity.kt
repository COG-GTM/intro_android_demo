package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TimePicker
import android.widget.Toast

class TimePickerDemoActivity : Activity() {

    private lateinit var tpTime: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_demo)
        tpTime = findViewById(R.id.tpTime)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_time_picker_demo, menu)
        return true
    }

    @Suppress("DEPRECATION")
    fun displayTime(v: View) {
        val time = "${tpTime.currentHour}:${tpTime.currentMinute}"
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
    }
}
