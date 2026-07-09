package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast

class IntentWithResultActivity : Activity() {

    companion object {
        const val GET_RESULT_TEXT = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_result)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_intent_with_result, menu)
        return true
    }

    fun enterText(v: View) {
        // Start the child activity and wait for its returned result bundle.
        startActivityForResult(Intent(this, SimpleReturnResultActivity::class.java), GET_RESULT_TEXT)
    }

    // Handle the result once the activity returns a result, display contact
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GET_RESULT_TEXT) {
            if (resultCode == RESULT_OK) {
                val result = data?.getStringExtra("result").orEmpty()
                val tvResult = findViewById<TextView>(R.id.txtDisplayResult)
                tvResult.text = result
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
