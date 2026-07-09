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

/**
 * Demonstrates the most basic way to download an image: opening a raw network
 * connection on the main thread and decoding the response stream into a Bitmap.
 * This is intentionally naive (blocking I/O on the UI thread) for teaching
 * purposes; StrictMode is relaxed below so the network call does not crash.
 */
class BasicImageDownloadActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_image_download)
        // Allow network access on the main thread (only acceptable for a demo).
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().permitNetwork().build()
        )
        downloadImageFromUri("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    /** Opens a connection to [address], decodes the image, and shows it. */
    private fun downloadImageFromUri(address: String) {
        // Parse the address; a malformed URL leaves us with null (mirrors the
        // original Java behavior, which then fails when the connection opens).
        val url: URL? = try {
            URL(address)
        } catch (e1: MalformedURLException) {
            null
        }

        // Fetch and decode the image; any I/O failure yields a null bitmap.
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

        // Only update the ImageView if decoding succeeded.
        if (bitmap != null) {
            val img = findViewById<ImageView>(R.id.ivBasicImage)
            img.setImageBitmap(bitmap)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_basic_image_download, menu)
        return true
    }
}
