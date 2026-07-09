package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class LinearLayoutDemoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Show the layout that demonstrates how LinearLayout positions its children.
        setContentView(R.layout.activity_linear_layout_demo)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_linear_layout_demo, menu)
        return true
    }
}
