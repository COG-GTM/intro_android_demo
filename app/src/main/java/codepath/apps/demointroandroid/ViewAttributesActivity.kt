package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast

class ViewAttributesActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_attributes)
        val tvMain = findViewById<TextView>(R.id.tvMain)
        Log.d("DEBUG", tvMain.text.toString())
        Toast.makeText(this, tvMain.text.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_view_attributes, menu)
        return true
    }
}
