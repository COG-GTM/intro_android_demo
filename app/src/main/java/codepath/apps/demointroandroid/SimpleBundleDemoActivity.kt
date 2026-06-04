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
        val initialText = intent.getStringExtra("text")
        val tvDisplayText = findViewById<TextView>(R.id.tvDisplayText)
        if (initialText != null) {
            tvDisplayText.text = initialText
        }
        actionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_simple_bundle_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> startActivity(Intent(this, ActionBarMenuActivity::class.java))
        }
        return true
    }
}
