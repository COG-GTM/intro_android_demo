package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView

class SimpleListViewActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        // Build a tiny in-memory data set for the ListView demo.
        val myStringArray = arrayOf("Bruce", "Wayne", "Bill")

        // Use the row layout from the lesson to render each string.
        val adapter = ArrayAdapter(this, R.layout.simple_list_view_item, myStringArray)

        // Connect the adapter to the ListView defined in the screen XML.
        val listView = findViewById<ListView>(R.id.lvDemo)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_simple_list_view, menu)
        return true
    }
}
