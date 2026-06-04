package codepath.apps.demointroandroid

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.BinaryHttpResponseHandler
import okhttp3.Headers
import okhttp3.Response
import java.io.IOException

class SmartImageDownloadActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_image_download)
        downloadSmartImageFromUrl("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    private fun downloadSmartImageFromUrl(address: String) {
        val client = AsyncHttpClient()
        client.get(address, object : BinaryHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, response: Response?) {
                try {
                    val image = response!!.body!!.bytes()
                    val bitmap = BitmapFactory.decodeByteArray(image, 0, image.size)
                    val img = findViewById<ImageView>(R.id.ivSmartImage)
                    img.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int, headers: Headers?, errorResponse: String?, throwable: Throwable?
            ) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_smart_image_download, menu)
        return true
    }
}
