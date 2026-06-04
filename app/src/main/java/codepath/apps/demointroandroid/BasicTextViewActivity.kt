package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu

class BasicTextViewActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_text_view)
        Log.d("DEBUG", "onCreate was just called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("DEBUG", "onResume was just called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DEBUG", "onPause was just called!")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_basic_text_view, menu)
        return true
    }
}
