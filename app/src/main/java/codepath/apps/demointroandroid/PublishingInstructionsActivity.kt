package codepath.apps.demointroandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu

/**
 * Shows the publishing instructions screen from the demo selector.
 */
class PublishingInstructionsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publishing_instructions)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_publishing_instructions, menu)
        return true
    }
}
