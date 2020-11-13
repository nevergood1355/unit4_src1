package com.skill_factory.unit4

import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 420F, resources.displayMetrics).toInt()
        val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280F, resources.displayMetrics).toInt()
        val rect1 = Rect(0, 0, width/2, height/2)
        val rect2 =  Rect(0, 0, width, height)
        img.clipBounds = rect1
        img.setOnClickListener {
            TransitionManager.beginDelayedTransition(root, ChangeClipBounds())
            img.clipBounds = if(img.clipBounds == rect1) rect2 else rect1
        }
    }
}
