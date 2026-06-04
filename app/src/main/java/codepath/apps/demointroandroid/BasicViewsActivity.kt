package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class BasicViewsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_views)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_basic_views, menu)
        return true
    }
}
