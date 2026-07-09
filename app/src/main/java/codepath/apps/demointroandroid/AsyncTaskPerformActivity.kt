package codepath.apps.demointroandroid

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.widget.Toast

/**
 * Demonstrates a legacy AsyncTask that counts in the background and notifies the UI.
 */
class AsyncTaskPerformActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_perform)
        MyAsyncTask().execute()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_async_task_perform, menu)
        return true
    }

    fun doneCounting() {
        Toast.makeText(this, "Done Counting to 100000", Toast.LENGTH_SHORT).show()
    }

    @Suppress("DEPRECATION")
    private inner class MyAsyncTask : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            for (i in 0L until 100000L) {
                println(i)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            doneCounting()
        }
    }
}
