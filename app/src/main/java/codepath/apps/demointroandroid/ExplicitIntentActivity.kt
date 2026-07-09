package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button

class ExplicitIntentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        // Launch the demo activity with an explicit intent and a simple text extra.
        val btnLaunchSecond = findViewById<Button>(R.id.btnLaunchSecond)
        btnLaunchSecond.setOnClickListener {
            val intent = Intent(this, SimpleBundleDemoActivity::class.java)
            intent.putExtra("text", "Passed String Extra!")
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_explicit_intent, menu)
        return true
    }
}
