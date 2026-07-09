package codepath.apps.demointroandroid

import android.app.AlertDialog
import android.content.Context

// SimpleAlertDialog.displayWithOK(this, "Hello", "Title");
object SimpleAlertDialog {

    fun displayWithOK(c: Context, message: String, title: String = "CodePath Demo Intro Android") {
        val alertDialog = AlertDialog.Builder(c).create()

        // Setting Dialog Title
        alertDialog.setTitle(title)

        // Setting Dialog Message
        alertDialog.setMessage(message)

        // Setting OK Button
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _, _ -> alertDialog.hide() }

        // Showing Alert Message
        alertDialog.show()
    }
}
