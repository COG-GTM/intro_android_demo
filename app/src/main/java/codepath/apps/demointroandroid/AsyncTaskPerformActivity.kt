package codepath.apps.demointroandroid

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.widget.Toast

class AsyncTaskPerformActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_perform)
        MyAsyncTask().execute()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_async_task_perform, menu)
        return true
    }

    fun doneCounting() {
        Toast.makeText(this, "Done Counting to 100000", Toast.LENGTH_SHORT).show()
    }

    private inner class MyAsyncTask : AsyncTask<Void?, Void?, Void?>() {
        override fun doInBackground(vararg params: Void?): Void? {
            for (i in 0 until 100000) {
                println(i)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            doneCounting()
        }
    }
}
