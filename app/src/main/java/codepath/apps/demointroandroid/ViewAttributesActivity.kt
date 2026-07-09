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

        // Read the TextView text that was defined in XML so we can echo it back.
        val tvMain = findViewById<TextView>(R.id.tvMain)
        val message = tvMain.text.toString()
        Log.d("DEBUG", message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_view_attributes, menu)
        return true
    }
}
