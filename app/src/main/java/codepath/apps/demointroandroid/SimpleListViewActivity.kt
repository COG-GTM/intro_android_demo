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
        val myStringArray = arrayOf("Bruce", "Wayne", "Bill")
        val adapter = ArrayAdapter(this, R.layout.simple_list_view_item, myStringArray)

        val listView = findViewById<ListView>(R.id.lvDemo)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_simple_list_view, menu)
        return true
    }
}
