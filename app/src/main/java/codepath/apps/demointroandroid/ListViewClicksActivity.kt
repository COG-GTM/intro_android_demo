package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

// Activity that shows how to react to ListView row taps.
class ListViewClicksActivity : Activity() {

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_clicks)

        // Build a simple adapter from a fixed set of sample values.
        val myCountries = arrayOf("United States", "Canada", "Mexico", "Japan")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myCountries)

        // Connect the adapter and react to row selections with a dialog and a toast.
        val listView = findViewById<ListView>(R.id.lvDemo)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val country = adapter.getItem(position)!!
            SimpleAlertDialog.displayWithOK(this@ListViewClicksActivity, country)
            Toast.makeText(this@ListViewClicksActivity, country, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_list_view_clicks, menu)
        return true
    }
}
