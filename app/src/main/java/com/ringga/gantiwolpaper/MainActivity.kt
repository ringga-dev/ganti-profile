package com.ringga.gantiwolpaper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_item1 = findViewById<Button>(R.id.btn_item1)
        val btn_item2 = findViewById<Button>(R.id.btn_item2)
        val cam_btn = findViewById<Button>(R.id.cam_btn)

        cam_btn.setOnClickListener(View.OnClickListener {
            val campage = Intent(applicationContext, CameraActivity::class.java)
            startActivity(campage)
        })

        btn_item1.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, ThemeActivity::class.java)
            val pathPic = "bg_item1"
            i.putExtra("PATH_PICTURE", pathPic)
            startActivity(i)
        })

        btn_item2.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, ThemeActivity::class.java)
            val pathPic = "bg_item2"
            i.putExtra("PATH_PICTURE", pathPic)
            startActivity(i)
        })
    }
}