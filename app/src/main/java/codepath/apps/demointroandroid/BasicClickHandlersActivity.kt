package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button

// Activity that demonstrates both XML-driven and code-driven click handlers.
class BasicClickHandlersActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_click_handlers)

        // Wire up the second button in code so students can compare the two approaches.
        val secondButton = findViewById<Button>(R.id.btnClick2)
        secondButton.setOnClickListener { view ->
            secondButtonClicked(view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_basic_click_handlers, menu)
        return true
    }

    // Called from XML using android:onClick.
    @Suppress("UNUSED_PARAMETER")
    fun firstButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler")
    }

    // Private helper for the programmatically attached click listener.
    @Suppress("UNUSED_PARAMETER")
    private fun secondButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "secondButton clicked via Java handler in onCreate")
    }
}
