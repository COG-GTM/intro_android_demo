package codepath.apps.demointroandroid

import android.app.Activity
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class PersistSettingsActivity : Activity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var edits: Editor
    private lateinit var txtPersist: TextView
    private lateinit var chkPersist: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persist_settings)

        // Bind the editable views and the shared-preferences storage used by the demo.
        txtPersist = findViewById(R.id.txtPersistText)
        chkPersist = findViewById(R.id.chkPersistState)
        prefs = getSharedPreferences("view", 0)
        edits = prefs.edit()
        populateValues()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_persist_settings, menu)
        return true
    }

    fun populateValues() {
        // Restore the last saved text and checkbox state into the UI.
        val persistedText = prefs.getString("txtVal", "None Stored Yet")
        val isChecked = prefs.getBoolean("chkState", false)
        txtPersist.text = persistedText
        chkPersist.isChecked = isChecked
    }

    fun persistValues(v: View) {
        // Save the current form state and confirm persistence to the user.
        edits.putString("txtVal", txtPersist.text.toString())
        edits.putBoolean("chkState", chkPersist.isChecked)
        edits.commit()
        Toast.makeText(this, "Persisted!", Toast.LENGTH_SHORT).show()
    }
}
