package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast

class IntentWithResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_result)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_intent_with_result, menu)
        return true
    }

    fun enterText(v: View) {
        startActivityForResult(
            Intent(this, SimpleReturnResultActivity::class.java), GET_RESULT_TEXT
        )
    }

    // Handle the result once the activity returns a result, display contact
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_RESULT_TEXT) {
            if (resultCode == RESULT_OK) {
                val tvResult = findViewById<TextView>(R.id.txtDisplayResult)
                val result = data?.getStringExtra("result")
                tvResult.text = result
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val GET_RESULT_TEXT = 0
    }
}
