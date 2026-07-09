package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class SpinnerWithToastActivity : Activity() {

    private lateinit var spinner: Spinner
    private lateinit var btnSpinnerVal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_with_toast)
        spinner = findViewById(R.id.spnOptions)
        btnSpinnerVal = findViewById(R.id.btnSpinnerValue)
        loadSpinner()
    }

    private fun loadSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.spinner_options, android.R.layout.simple_spinner_item
        )
        // Set layout style during dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Load data from adapter
        spinner.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_spinner_with_toast, menu)
        return true
    }

    fun displayVal(v: View) {
        Toast.makeText(this, spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }
}
