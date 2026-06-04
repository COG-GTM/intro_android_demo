package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class ExplicitIntentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)
        val btnLaunchSecond = findViewById<Button>(R.id.btnLaunchSecond)
        btnLaunchSecond.setOnClickListener {
            val i = Intent(this, SimpleBundleDemoActivity::class.java)
            i.putExtra("text", "Passed String Extra!")
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_explicit_intent, menu)
        return true
    }
}
