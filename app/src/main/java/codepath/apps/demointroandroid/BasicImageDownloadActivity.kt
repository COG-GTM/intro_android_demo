package codepath.apps.demointroandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.view.Menu
import android.widget.ImageView
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

class BasicImageDownloadActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_image_download)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitNetwork().build())
        downloadImageFromUri("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    private fun downloadImageFromUri(address: String) {
        val url: URL? = try {
            URL(address)
        } catch (e1: MalformedURLException) {
            null
        }

        val bitmap: Bitmap? = try {
            val conn = url!!.openConnection()
            conn.connect()
            val input = conn.getInputStream()
            val decoded = BitmapFactory.decodeStream(input)
            input.close()
            decoded
        } catch (e: IOException) {
            null
        }

        if (bitmap != null) {
            val img = findViewById<ImageView>(R.id.ivBasicImage)
            img.setImageBitmap(bitmap)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_basic_image_download, menu)
        return true
    }
}
