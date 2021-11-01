package com.example.anim_splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView


class IntroductoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)



        val splashImg: ImageView = findViewById(R.id.img)
        val lottieAnimationView: com.airbnb.lottie.LottieAnimationView = findViewById(R.id.lottie)

        splashImg.animate().translationY(-1600F).setDuration(1000).startDelay = 4000


        lottieAnimationView.animate().translationY(1400F).setDuration(1000).startDelay = 4000

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)



    }
}