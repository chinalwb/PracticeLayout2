package com.hencoder.hencoderpracticelayout2.sample;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;


import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.View.MeasureSpec.getMode;

/**
 * Created by wliu on 05/06/2018.
 */

public class PM25View extends View {

    private static int mcount = 0;

    private static int STROKE_WIDTH = 30;
    private static int SWEEP_COLOR_START = Color.BLUE;
    private static int SWEEP_COLOR_END = Color.CYAN;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int mWidth, mHeight, mPadding;

    private float pollution, polutionValue = 300;

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.LTGRAY);
        mPaint.setStrokeWidth(STROKE_WIDTH);

        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeCap(Paint.Cap.ROUND);
        mPaint2.setStrokeWidth(STROKE_WIDTH);
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "pollution", 0, polutionValue);
        animator.setDuration(1000);
        animator.start();
    }

    public PM25View(Context context) {
        this(context, null);
    }

    public PM25View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PM25View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPollution(float pollution) {
        this.pollution = pollution;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ++mcount;
        Log.w("xx", "mcount == " + mcount);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.UNSPECIFIED:
                Log.w("xx", "width mode == unspecified");
                break;
            case MeasureSpec.AT_MOST:
                Log.w("xx", "width mode == at most");
                break;
            case EXACTLY:
                Log.w("xx", "width mode == exactly");
                calculateSizeExactly();
                break;
        }
    }

    /**
     *
     */
    private void calculateSizeExactly() {
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        setMeasuredDimension(w, h);

        initNumbers(w, h);
    }

    /**
     *
     * @param width
     * @param height
     */
    private void initNumbers(int width, int height) {
        mWidth = width;
        mHeight = height;

        mPadding = getPaddingTop();

        // Sets the sweep gradient
        mPaint2.setShader(new SweepGradient(mWidth / 2, mHeight / 2, SWEEP_COLOR_START, SWEEP_COLOR_END));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = STROKE_WIDTH + mPadding;
        int top = STROKE_WIDTH + mPadding;
        int right = mWidth - STROKE_WIDTH - mPadding;
        int bottom = mHeight - STROKE_WIDTH - mPadding;
        RectF rectF = new RectF(left, top, right, bottom);
        canvas.drawArc(rectF, 135, 270, false, mPaint);


        float endAngle = this.pollution / 500 * 270;
        canvas.drawArc(rectF, 135, endAngle, false, mPaint2);
    }
}
