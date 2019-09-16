package com.example.androidanimation

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_vector_transition.*


class VectorTransition : AppCompatActivity() {

    lateinit var animatedDrawable: AnimatedVectorDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_transition)

        var isClicked = true
        image_target.setBackgroundResource(R.drawable.check_to_close)


        image_target.setOnClickListener{
            if(isClicked)
                forward()
            else
                back()

            isClicked = !isClicked
        }
    }




    override fun onStart() {
        super.onStart()

    }

    fun forward(){
        image_target.setBackgroundResource(R.drawable.check_to_close)
        animatedDrawable = image_target.background as AnimatedVectorDrawable
        animatedDrawable.start()

    }

    fun back(){
        image_target.setBackgroundResource(R.drawable.close_to_check)
        animatedDrawable = image_target.background as AnimatedVectorDrawable
        animatedDrawable.start()

    }



}
