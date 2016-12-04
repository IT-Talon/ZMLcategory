package com.talon.zmlcategory;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * des:
 * Created by Talon.
 * on 2016/11/30 18:39.
 */

public class MyGridView extends GridView {
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重写的onMeasure方法
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
