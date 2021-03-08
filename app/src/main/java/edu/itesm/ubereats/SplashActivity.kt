package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.CountDownTimer
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {



    // This is the loading time of the splash screen
    private val time:Long = 5000 // 1 sec
    val timerObj = object: CountDownTimer(time, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timer.text = (timer.text.toString().toInt()-1).toString();
        }

        override fun onFinish() {}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        timerObj.start()

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,MainActivity::class.java))

            // close this activity
            finish()
        }, time)
    }
}