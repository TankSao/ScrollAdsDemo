package com.example.administrator.scrolladsdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/20.
 */

@SuppressLint("AppCompatCustomView")
public class ScrollTextView extends TextView {

    private boolean isMarqueeEnable = false;

    public ScrollTextView(Context context) {
        super(context);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMarqueeEnable(boolean enable) {
        if (isMarqueeEnable != enable) {
            isMarqueeEnable = enable;
            if (enable) {
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
            } else {
                setEllipsize(TextUtils.TruncateAt.END);
            }
            onWindowFocusChanged(enable);
        }
    }

    public boolean isMarqueeEnable() {
        return isMarqueeEnable;
    }

    @Override
    public boolean isFocused() {
        return isMarqueeEnable;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(isMarqueeEnable, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(isMarqueeEnable);
    }
}
