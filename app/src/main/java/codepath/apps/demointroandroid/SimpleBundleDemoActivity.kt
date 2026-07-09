package codepath.apps.demointroandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class SimpleBundleDemoActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_bundle_demo)

        // Show the incoming text extra, then enable the action-bar home affordance.
        val initialText = intent.getStringExtra("text")
        val tvDisplayText = findViewById<TextView>(R.id.tvDisplayText)
        if (initialText != null) {
            tvDisplayText.text = initialText
        }
        actionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_simple_bundle_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Route the home button back to the action-bar demo screen.
                startActivity(Intent(this, ActionBarMenuActivity::class.java))
            }
        }
        return true
    }
}
