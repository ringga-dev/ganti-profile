package com.ringga.gantiwolpaper

import android.Manifest
import android.app.WallpaperManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import java.io.IOException

class ThemeActivity : AppCompatActivity() {

    var newString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        //permission
        ActivityCompat.requestPermissions(
            this@ThemeActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )

        val theme_preview = findViewById<RelativeLayout>(R.id.theme_preview)
        val save_btn = findViewById<Button>(R.id.save_btn)
        val tbSet = findViewById<Toolbar>(R.id.mtbSet)
        setSupportActionBar(tbSet)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val extras = intent.extras
            if (extras == null) {
                newString = null
            } else {
                newString = extras.getString("PATH_PICTURE")
                if (newString == "bg_item1") {
                    theme_preview.setBackgroundResource(R.drawable.bg_item1)
                    save_btn.setOnClickListener(View.OnClickListener {
                        val wlp = WallpaperManager.getInstance(applicationContext)
                        Toast.makeText(
                            applicationContext,
                            "Success Set Wallpaper",
                            Toast.LENGTH_SHORT
                        ).show()
                        try {
                            wlp.setResource(+R.drawable.bg_item1)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    })
                } else if (newString == "bg_item2") {
                    theme_preview.setBackgroundResource(R.drawable.bg_item2)
                    save_btn.setOnClickListener(View.OnClickListener {
                        val wlp = WallpaperManager.getInstance(applicationContext)
                        Toast.makeText(
                            applicationContext,
                            "Success Set Wallpaper",
                            Toast.LENGTH_SHORT
                        ).show()
                        try {
                            wlp.setResource(+R.drawable.bg_item2)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    })
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}