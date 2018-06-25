package com.hencoder.hencoderpracticelayout2.practice;

import android.content.Context;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticelayout2.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * Created by wliu on 25/06/2018.
 */

public class PM25View_Practice_Exactly_MatchParent extends PM25View {
    public PM25View_Practice_Exactly_MatchParent(Context context) {
        super(context);
    }

    public PM25View_Practice_Exactly_MatchParent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PM25View_Practice_Exactly_MatchParent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = 0;
        int h = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.AT_MOST:
                break;
            case EXACTLY:
                // 指定 MATCH_PARENT，MeasureSpec.getMode 会返回 EXACTLY
//                Log.w(TAG, "width mode == exactly");
//                w = getMeasuredWidth();
                break;
        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.AT_MOST:
                break;
            case EXACTLY:
                // 指定 MATCH_PARENT，MeasureSpec.getMode 会返回 EXACTLY
//                Log.w(TAG, "height mode == exactly");
//                h = getMeasuredHeight();
                break;
        }

        // 这句代码调用了  setMeasuredDimension(width, height) - 重点
        // 并设定了一些PM25View的参数
        setSizes(w, h);
    }
}
