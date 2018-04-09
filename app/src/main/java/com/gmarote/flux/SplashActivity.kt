package com.gmarote.flux

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animation.setAnimation(R.raw.curved_line_animation)

        animation.addAnimatorUpdateListener { valueAnimator ->
            var fraction = valueAnimator.animatedFraction
            var minVal = 0.4f

            if(fraction in minVal..(minVal + 0.25f)){
                titleView.alpha = (fraction - minVal) * 4
            } else if(fraction == 1.0f){
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        animation.playAnimation()
    }
}
