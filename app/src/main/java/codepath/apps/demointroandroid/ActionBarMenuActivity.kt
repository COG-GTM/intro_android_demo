package codepath.apps.demointroandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ActionBarMenuActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar_menu)
        actionBar?.title = "Click an Icon"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_toast -> Toast.makeText(this, "Toasted", Toast.LENGTH_SHORT).show()
            R.id.menu_launch -> startActivity(Intent(this, SimpleBundleDemoActivity::class.java))
        }
        return true
    }
}
