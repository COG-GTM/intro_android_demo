package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class ToastFormInputsActivity : Activity() {

    private lateinit var etVal: EditText
    private lateinit var chkVal: CheckBox
    private lateinit var rdgVal: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_form_inputs)
        etVal = findViewById(R.id.etVal)
        chkVal = findViewById(R.id.chkVal)
        rdgVal = findViewById(R.id.rdgVal)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_toast_form_inputs, menu)
        return true
    }

    fun toastInputs(v: View) {
        val selected = rdgVal.checkedRadioButtonId
        val b = findViewById<RadioButton>(selected)

        val text = "${etVal.text} | ${chkVal.isChecked} | ${b.text}"
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
