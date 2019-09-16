package com.example.androidanimation

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_drawable.*

class DrawableActivity : AppCompatActivity() {

    lateinit var batteryDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)
    }

    override fun onStart() {
        super.onStart()

        drawable_image_target.setBackgroundResource(R.drawable.battery_animation_list)
        batteryDrawable = drawable_image_target.background as AnimationDrawable
        batteryDrawable.start()

        start_stop_button.setOnClickListener{
            if( batteryDrawable.isRunning)
                batteryDrawable.stop()
            else
                batteryDrawable.start()
        }

        open_vector_animation.setOnClickListener {
            val intent = Intent(this, VectorTransition::class.java)
            startActivity(intent)
        }
    }


}
