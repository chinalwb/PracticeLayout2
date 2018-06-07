package com.hencoder.hencoderpracticelayout2.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by wliu on 07/06/2018.
 */

public class Util {

    public static int getPixelsByDp(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }
}
