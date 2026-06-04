package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class LayoutGravityActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_gravity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_layout_gravity, menu)
        return true
    }
}
