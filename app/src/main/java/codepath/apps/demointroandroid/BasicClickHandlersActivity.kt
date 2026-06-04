package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button

class BasicClickHandlersActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_click_handlers)
        val secondButton = findViewById<Button>(R.id.btnClick2)
        secondButton.setOnClickListener { v -> secondButtonClicked(v) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_basic_click_handlers, menu)
        return true
    }

    fun firstButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler")
    }

    private fun secondButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "secondButton clicked via handler in onCreate")
    }
}
