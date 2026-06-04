package codepath.apps.demointroandroid

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.facebook.stetho.server.http.HttpStatus
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.ByteArrayOutputStream
import java.io.IOException

class ProgressBarActivity : Activity() {

    private lateinit var pb: ProgressBar
    private lateinit var tvResult: TextView
    private val lines = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        pb = findViewById(R.id.pgDownloading)
        tvResult = findViewById(R.id.txtUrlOutput)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_progress_bar, menu)
        return true
    }

    fun startFourUrlAsync(v: View) {
        DelayTask().execute()
    }

    inner class DelayTask : AsyncTask<Void?, Int?, String>() {

        override fun onPreExecute() {
            pb.visibility = ProgressBar.VISIBLE
        }

        override fun doInBackground(vararg params: Void?): String {
            var res = loadUrlBody("https://google.com")
            lines.add((res ?: "").split("\n")[0])
            publishProgress(25)
            res = loadUrlBody("https://yahoo.com")
            lines.add((res ?: "").split("\n")[0])
            publishProgress(50)
            res = loadUrlBody("https://twitter.com")
            lines.add((res ?: "").split("\n")[0])
            publishProgress(75)
            res = loadUrlBody("https://facebook.com")
            lines.add((res ?: "").split("\n")[0])
            publishProgress(100)
            return "complete"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            pb.progress = values[0] ?: 0
        }

        override fun onPostExecute(result: String) {
            Toast.makeText(this@ProgressBarActivity, "Completed!", Toast.LENGTH_SHORT).show()
            tvResult.text = lines.toString()
        }

        private fun loadUrlBody(address: String): String? {
            val httpclient = OkHttpClient()
            var responseString: String? = null
            try {
                val response = httpclient.newCall(Request.Builder().url(address).build()).execute()
                val statusCode = response.code
                if (statusCode == HttpStatus.HTTP_OK) {
                    val out = ByteArrayOutputStream()
                    out.write(response.body!!.bytes())
                    responseString = out.toString()
                    out.close()
                } else {
                    response.body!!.byteStream().close()
                    throw IOException(response.message)
                }
            } catch (e: IOException) {
                Log.e(
                    ProgressBarActivity::class.java.simpleName,
                    "Error retrieving data from: $address", e
                )
            }

            return responseString
        }
    }
}
