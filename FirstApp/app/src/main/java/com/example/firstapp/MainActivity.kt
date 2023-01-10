package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.sql.Time

class MainActivity : AppCompatActivity() {
    lateinit var userScoreView: TextView
    lateinit var timeLeftView: TextView
    lateinit var buttonScore: Button
    var score = 0
    var gameStart = false
    var initialCountDownTime: Long = 20000
    var intervalTime: Long = 1000
    var timeLeft = 20
    var bonusTime = 10
    val TAG = MainActivity::class.java.simpleName
    lateinit var countDownTimer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userScoreView = findViewById(R.id.playerScore)
        timeLeftView = findViewById(R.id.timeLeft)
        buttonScore = findViewById(R.id.buttonScore)
        buttonScore.setOnClickListener { view ->
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)
            increaseScore()
        }
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE_KEY)
            timeLeft = savedInstanceState.getInt(TIME_LEFT_KEY)
            if (timeLeft > 0) {
                restoreMainGame()
            } else {
                bonusTime = savedInstanceState.getInt(BONUS_TIME_KEY)
                restoreBonusGame()
            }
        } else {
            resetGame()
        }
    }

    private fun increaseScore() {
        if (!gameStart) {
            startGame()
        }
        score++
        userScoreView.text = getString(R.string.user_score, score)
    }

    private fun startGame() {
        countDownTimer.start()
        gameStart = true
    }

    private fun resetGame() {
        score = 0
        timeLeft = 20
        bonusTime = 10
        userScoreView.text = getString(R.string.user_score, score)
        timeLeftView.text = getString(R.string.time_left, timeLeft)
        countDownTimer = object : CountDownTimer(initialCountDownTime, intervalTime) {
            override fun onTick(p0: Long) {
                timeLeft = p0.toInt() / 1000
                timeLeftView.text = getString(R.string.time_left, timeLeft)
            }

            override fun onFinish() {
                bonusTime()
            }
        }
        gameStart = false
    }

    private fun restoreMainGame() {
        userScoreView.text = getString(R.string.user_score, score)
        timeLeftView.text = getString(R.string.time_left, timeLeft)
        countDownTimer = object : CountDownTimer((timeLeft * 1000).toLong(), intervalTime) {
            override fun onTick(p0: Long) {
                timeLeft = p0.toInt() / 1000
                timeLeftView.text = getString(R.string.time_left, timeLeft)
            }

            override fun onFinish() {
                bonusTime()
            }
        }.start()
    }

    private fun restoreBonusGame() {
        userScoreView.text = getString(R.string.user_score, score)
        timeLeftView.text = getString(R.string.time_left, bonusTime)
        countDownTimer = object : CountDownTimer((bonusTime * 1000).toLong(), intervalTime) {
            override fun onTick(p0: Long) {
                bonusTime = p0.toInt() / 1000
                timeLeftView.text = getString(R.string.time_left, bonusTime)
            }

            override fun onFinish() {
                endGame()
            }
        }.start()
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.user_score, score), Toast.LENGTH_LONG).show()
        resetGame()
    }

    private fun bonusTime() {
        Toast.makeText(this, getString(R.string.bonus_time, bonusTime), Toast.LENGTH_SHORT).show()
        timeLeftView.text = getString(R.string.time_left, bonusTime)
        countDownTimer = object : CountDownTimer((bonusTime * 1000).toLong(), intervalTime) {
            override fun onTick(p0: Long) {
                bonusTime = p0.toInt() / 1000
                timeLeftView.text = getString(R.string.time_left, bonusTime)
            }

            override fun onFinish() {
                endGame()
            }
        }.start()
    }

    companion object {
        const val SCORE_KEY = "SCORE_KEY"
        const val TIME_LEFT_KEY = "TIME_LEFT_KEY"
        const val BONUS_TIME_KEY = "BONUS_TIME_KEY"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, score)
        outState.putInt(TIME_LEFT_KEY, timeLeft)
        outState.putInt(BONUS_TIME_KEY, bonusTime)
        countDownTimer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Your bonus time is ${bonusTime}")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_item) {
            showInfo()
        }
        return true
    }

    private fun showInfo() {
        val dialogTitle = getString(R.string.about_title, BuildConfig.VERSION_NAME)
        val dialogMessage = getString(R.string.about_message)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }
}
