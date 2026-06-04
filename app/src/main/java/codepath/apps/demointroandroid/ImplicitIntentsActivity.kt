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
        menuInflater.inflate(R.menu.activity_implicit_intents, menu)
        return true
    }

    fun visitUrlAddress(v: View) {
        val url = getUriToVisit()
        if (url != null) {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = url
            startActivity(i)
        }
    }

    fun getUriToVisit(): Uri? {
        var urlAddress = findViewById<TextView>(R.id.txtUrlAddress).text.toString()
        if (!urlAddress.startsWith("http://")) {
            urlAddress = "http://$urlAddress"
        }
        return Uri.parse(urlAddress)
    }
}
