package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView

class ImplicitIntentsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_implicit_intents, menu)
        return true
    }

    fun visitUrlAddress(v: View) {
        // Build a browsable URI and hand it off to the platform.
        val url = getUriToVisit()
        if (url != null) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = url
            }
            startActivity(intent)
        }
    }

    fun getUriToVisit(): Uri? {
        // Normalize the text field into an http:// URL before creating the Uri.
        var urlAddress = findViewById<TextView>(R.id.txtUrlAddress).text.toString()
        if (!urlAddress.startsWith("http://")) {
            urlAddress = "http://$urlAddress"
        }
        return Uri.parse(urlAddress)
    }
}
