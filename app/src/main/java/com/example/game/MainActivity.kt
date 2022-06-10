package com.example.game

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import com.example.game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    class MySurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs),SurfaceHolder.Callback2 {
        val metric = DisplayMetrics()
        var w : Int = metric.widthPixels // 螢幕寬度（畫素）
        val h : Int = metric.heightPixels // 螢幕高度（畫素）

        var surfaceHolder: SurfaceHolder = holder
        var ball :Bitmap = BitmapFactory.decodeResource(resources,R.drawable.ball)
        override fun surfaceCreated(p0: SurfaceHolder) {
            var canvas: Canvas = surfaceHolder.lockCanvas()
            drawSomething(canvas)
            surfaceHolder.unlockCanvasAndPost(canvas)

        }

        private fun drawSomething(canvas: Canvas) {
            var xPos:Int = 0
            var yPos:Int = 0
            var deltaX:Int = 5
            var deltaY:Int = 5
            var SrcRect: Rect = Rect(0, 0, ball.width, ball.height) //裁切

            xPos += deltaX
            yPos += deltaY
            if (xPos >= getWidth()-w || xPos<=0){
                deltaX*=-1
            }
            if (yPos >= getHeight()-h || yPos<=0){
                deltaY*=-1
            }

            //var DestRect:Rect = Rect(0, 0, w, h)
            var DestRect:Rect = Rect(xPos, yPos, w + xPos, h + yPos)
            canvas.drawBitmap(ball, SrcRect, DestRect, null)




        }


        override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

        }

        override fun surfaceDestroyed(p0: SurfaceHolder) {

        }

        override fun surfaceRedrawNeeded(p0: SurfaceHolder) {

        }

    }
}