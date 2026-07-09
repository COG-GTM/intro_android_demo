package codepath.apps.demointroandroid

import android.app.AlertDialog
import android.content.Context

// SimpleAlertDialog.displayWithOK(this, "Hello", "Title");
class SimpleAlertDialog {

    companion object {
        @JvmStatic
        fun displayWithOK(c: Context, message: String) {
            displayWithOK(c, message, "CodePath Demo Intro Android")
        }

        @JvmStatic
        fun displayWithOK(c: Context, message: String, title: String) {
            // Build and populate the dialog exactly as the Java version did.
            val alertDialog = AlertDialog.Builder(c).create()

            // Setting Dialog Title
            alertDialog.setTitle(title)

            // Setting Dialog Message
            alertDialog.setMessage(message)

            // Setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _, _ ->
                alertDialog.hide()
            }

            // Showing Alert Message
            alertDialog.show()
        }
    }
}
