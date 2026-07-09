package codepath.apps.demointroandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.content.CursorLoader
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.ArrayList

/**
 * Loads contacts through the contacts provider after the runtime permission is granted.
 */
class ContactListActivity : Activity() {

    private val names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            loadContacts()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                REQUEST_READ_CONTACTS
            )
        }
        populateListView()
    }

    private fun populateListView() {
        // Bind the loaded names to a simple one-line list item layout.
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        val listView = findViewById<ListView>(R.id.lvContacts)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@ContactListActivity, names[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Toast.makeText(this, "Permission Denied, Not able to load contact", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("NewApi")
    private fun loadContacts() {
        val allContacts = Uri.parse("content://contacts/people")
        val cursorLoader = CursorLoader(
            this,
            allContacts,
            null, // the columns to retrive
            null, // the selection criteria
            null, // the selection args
            null // the sort order
        )

        val c: Cursor = cursorLoader.loadInBackground()!!
        if (c.moveToFirst()) {
            do {
                // Get Contact ID
                val idIndex = c.getColumnIndex(ContactsContract.Contacts._ID)
                val contactID = c.getString(idIndex)

                // Get Contact Name
                val nameIndex = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val contactDisplayName = c.getString(nameIndex)
                names.add(contactDisplayName)

                Log.d("debug", "$contactID, $contactDisplayName")
            } while (c.moveToNext())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_contact_list, menu)
        return true
    }

    companion object {
        private const val REQUEST_READ_CONTACTS = 1
    }
}
