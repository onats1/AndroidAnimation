package com.example.androidanimation

import android.animation.*
import android.graphics.Interpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    var translateAnimation: Animator? = null
    var scaleAnimation: Animator? = null
    var rotateAnimation: Animator? = null
    var fadeAnimation: Animator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   /* fun translateAnimation(view: View){
        translateAnimation = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimation?.apply {
            setTarget(targetImage)
            start()
        }
    }*/

    //using code instead of xml
    fun translateAnimation(view: View){
        val objectAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
        objectAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
         //   addListener(this@MainActivity)
            start()
        }
    }


    fun scaleAnimation(view: View){
        scaleAnimation = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimation?.apply {
            setTarget(targetImage)
          //  addListener(this@MainActivity)
            start()
        }
    }

    fun rotateAnimation(view: View){
        rotateAnimation = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimation?.apply {
            setTarget(targetImage)
         //   addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimation(view: View) {
        fadeAnimation = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimation?.apply {
            setTarget(targetImage)
            //addListener(this@MainActivity)
            start()
        }
    }


    override fun onAnimationRepeat(p0: Animator?) {
        when(p0) {
            translateAnimation -> Toast.makeText(this, "Translate animation repeated", Toast.LENGTH_SHORT).show()
            rotateAnimation -> Toast.makeText(this, "Rotate animation repeated", Toast.LENGTH_SHORT).show()
            fadeAnimation -> Toast.makeText(this, "Fade animation repeated", Toast.LENGTH_SHORT).show()
            scaleAnimation -> Toast.makeText(this, "Scale animation repeated", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAnimationEnd(p0: Animator?) {
        when(p0) {
            translateAnimation -> Toast.makeText(this, "Translate animation ended", Toast.LENGTH_SHORT).show()
            rotateAnimation -> Toast.makeText(this, "Rotate animation ended", Toast.LENGTH_SHORT).show()
            fadeAnimation -> Toast.makeText(this, "Fade animation ended", Toast.LENGTH_SHORT).show()
            scaleAnimation -> Toast.makeText(this, "Scale animation ended", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAnimationCancel(p0: Animator?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAnimationStart(p0: Animator?) {
        when(p0) {
            translateAnimation!! -> Toast.makeText(this, "Translate animation started", Toast.LENGTH_SHORT).show()
            rotateAnimation!! -> Toast.makeText(this, "Rotate animation started", Toast.LENGTH_SHORT).show()
            fadeAnimation!! -> Toast.makeText(this, "Fade animation started", Toast.LENGTH_SHORT).show()
            scaleAnimation!! -> Toast.makeText(this, "Scale animation started", Toast.LENGTH_SHORT).show()
        }
    }

    fun setFromXML(view: View) {

        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View) {
        val animatorSet = AnimatorSet()

        val flipAnimation = ObjectAnimator.ofFloat(targetImage, "rotationX", 0f, 1440f )
        flipAnimation.duration = 500

        val scaleSet = AnimatorSet()

        val scalexanimation = ObjectAnimator.ofFloat(targetImage, "scaleX", 1f, 1.5f)
        scalexanimation.duration = 2000
        scalexanimation.interpolator = AnticipateOvershootInterpolator()

        val scaleyanimation = ObjectAnimator.ofFloat(targetImage, "scaleY",1f, 1.5f)
        scaleyanimation.duration = 2000
        scalexanimation.interpolator = AnticipateOvershootInterpolator()

        scaleSet.playTogether(scalexanimation, scaleyanimation)
        animatorSet.playTogether(flipAnimation, scaleSet)

        animatorSet.start()


    }

}
