package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class LinearLayoutDemoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_demo)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_linear_layout_demo, menu)
        return true
    }
}
