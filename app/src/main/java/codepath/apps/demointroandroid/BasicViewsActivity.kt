package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class BasicViewsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Show the layout that introduces the basic widget types used in the lesson.
        setContentView(R.layout.activity_basic_views)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_basic_views, menu)
        return true
    }
}
