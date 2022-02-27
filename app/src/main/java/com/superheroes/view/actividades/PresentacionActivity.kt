package com.superheroes.view.actividades

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.superheroes.R

class PresentacionActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_presentacion)

        Handler().postDelayed(Runnable {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        },3000)

    }

}