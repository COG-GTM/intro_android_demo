package codepath.apps.demointroandroid

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView

class GridViewDemoActivity : Activity() {

    private lateinit var gvImages: GridView
    private lateinit var adapter: GridImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_demo)
        populateGridViewImages()
    }

    private fun populateGridViewImages() {
        gvImages = findViewById(R.id.gvImages)
        val numbers = arrayOf("ad", "ae", "af", "ag", "ai", "al")
        adapter = GridImageAdapter(this, android.R.layout.simple_list_item_1, numbers)
        gvImages.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_grid_view_demo, menu)
        return true
    }

    inner class GridImageAdapter(context: Context, textViewResourceId: Int, numbers: Array<String>) :
        ArrayAdapter<String>(context, textViewResourceId, numbers) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = ImageView(context)
            val resId = context.resources.getIdentifier(getItem(position), "drawable", context.packageName)
            v.setImageDrawable(context.resources.getDrawable(resId))
            return v
        }
    }
}
