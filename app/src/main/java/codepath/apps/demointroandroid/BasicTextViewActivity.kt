package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu

class BasicTextViewActivity : Activity() {

    // Log the lifecycle so students can see when the screen is created and shown.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_text_view)
        Log.d("DEBUG", "onCreate was just called!")
    }

    // Keep track of when the activity comes back into the foreground.
    override fun onResume() {
        super.onResume()
        Log.d("DEBUG", "onResume was just called!")
    }

    // Keep track of when the activity is about to lose focus.
    override fun onPause() {
        super.onPause()
        Log.d("DEBUG", "onPause was just called!")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_basic_text_view, menu)
        return true
    }
}
