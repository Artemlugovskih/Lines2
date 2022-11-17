package com.example.linesandshapes

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


@Suppress("UNREACHABLE_CODE")
class PlayActivity : Activity(),OnTouchListener {
    private var mX = 0
    private var mY = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        val container=findViewById<View>(R.id.container) as ViewGroup

    }

    fun move(btnMove: BtnMove, head:View,container:ViewGroup){
        when(btnMove) {
            BtnMove.UP -> (head.layoutParams as ConstraintLayout.LayoutParams).topMargin -= 50
            BtnMove.RIGHT -> (head.layoutParams as ConstraintLayout.LayoutParams).leftMargin -= 50
            BtnMove.LEFT -> (head.layoutParams as ConstraintLayout.LayoutParams).leftMargin += 50
            BtnMove.DOWN ->(head.layoutParams as ConstraintLayout.LayoutParams).topMargin += 50
        }
   runOnUiThread { container.removeView(head)
       container.addView(head) }
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean { val head = View(this)
        head.layoutParams= ConstraintLayout.LayoutParams(30,30)
        head.background= ContextCompat.getDrawable(this,R.drawable.circle)
        head.setOnTouchListener(this)
        TODO("Not yet implemented")
        val X = event.rawX.toInt()
        val Y = event.rawY.toInt()
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                val ifDown:ImageView=findViewById(R.id.ifDown)
                ifDown.setOnClickListener {head.scaleX.toInt() }
            }
            MotionEvent.ACTION_MOVE -> {
                val ifUp:ImageView=findViewById(R.id.ifUp)

                val ifLeft:ImageView=findViewById(R.id.ifLeft)
                val ifRight:ImageView=findViewById(R.id.ifRight)
                ifUp.setOnClickListener { ifUp.rotationX }
                val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
                fun convertDpToPixels(context: Context, dp: Int) =
                    (dp * context.resources.displayMetrics.density).toInt()
                val scale = resources.displayMetrics.density
                var padding_5dp = (5 * scale + 0.5f).toInt()
            }

    }
}

}

enum class BtnMove {
    UP,
    RIGHT,
    LEFT,
    DOWN
}