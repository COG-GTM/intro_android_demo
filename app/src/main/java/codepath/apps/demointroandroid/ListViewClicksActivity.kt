package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewClicksActivity : Activity() {

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_clicks)
        val myCountries = arrayOf("United States", "Canada", "Mexico", "Japan")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myCountries)

        val listView = findViewById<ListView>(R.id.lvDemo)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val country = adapter.getItem(position)!!
            SimpleAlertDialog.displayWithOK(this, country)
            Toast.makeText(this, country, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_list_view_clicks, menu)
        return true
    }
}
