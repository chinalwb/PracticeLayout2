package com.hencoder.hencoderpracticelayout2.sample;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;

/**
 * Created by wliu on 05/06/2018.
 */

public class PM25View extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float pollution = 117;

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.LTGRAY);
        mPaint.setStrokeWidth(20);

        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeCap(Paint.Cap.ROUND);
        mPaint2.setColor(Color.BLUE);
        mPaint2.setStrokeWidth(20);

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "pollution", 0, 117);
        animator.setDuration(1000);
        animator.start();
    }

    public PM25View(Context context) {
        super(context);
    }

    public PM25View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PM25View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPollution(float pollution) {
        this.pollution = pollution;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // canvas.drawLine(100, 100, 500, 100, mPaint);
        RectF rectF = new RectF(100, 100, 300, 300);
        canvas.drawArc(rectF, 135, 270, false, mPaint);


        float endAngle = this.pollution / 500 * 270;
        Log.e("x", "end angle == " + endAngle);
        canvas.drawArc(rectF, 135, endAngle, false, mPaint2);
    }
}
