package com.ringga.gantiwolpaper

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.io.IOException

class CameraActivity : AppCompatActivity() {

    var camBitmap: Bitmap? = null
    var place_pict: ImageView? = null
    var tbCam: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val save_btn = findViewById<Button>(R.id.save_btn)
         place_pict = findViewById<ImageView>(R.id.place_pic)
        tbCam = findViewById<Toolbar>(R.id.mtbCam)
        setSupportActionBar(tbCam)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val cam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cam, 0)

        save_btn.setOnClickListener(View.OnClickListener {
            val wlp = WallpaperManager.getInstance(applicationContext)
            Toast.makeText(applicationContext, "Success Set Wallpaper", Toast.LENGTH_SHORT).show()
            try {
                wlp.setBitmap(camBitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        })
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        camBitmap = data?.extras!!["data"] as Bitmap?
        place_pict?.setImageBitmap(camBitmap)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}