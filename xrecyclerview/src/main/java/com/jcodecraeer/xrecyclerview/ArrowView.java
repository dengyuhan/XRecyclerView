package com.jcodecraeer.xrecyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 箭头图像
 * Created by SCWANG on 2018/2/5.
 *
 * @see <a href="https://github.com/scwang90/SmartRefreshLayout/blob/release/refresh-layout/src/main/java/com/scwang/smartrefresh/layout/internal/ArrowDrawable.java">ArrowDrawable</a>
 */
public class ArrowView extends View {

    private Path mPath = new Path();
    private Paint mPaint;

    public ArrowView(Context context) {
        super(context);
        initView(context, null);
    }

    public ArrowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ArrowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ArrowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);

    }

    protected void initView(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        int defaultColor = Color.GRAY;
        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ArrowView);
            mPaint.setColor(a.getColor(R.styleable.ArrowView_arrowColor, defaultColor));
            a.recycle();
        } else {
            mPaint.setColor(defaultColor);
        }
    }

    @Override
    public void onDraw(@NonNull Canvas canvas) {

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int lineWidth = width * 30 / 225;
        mPath.reset();

        float vector1 = (float) (lineWidth * Math.sin(Math.PI / 4));
        float vector2 = (float) (lineWidth / Math.sin(Math.PI / 4));
        mPath.moveTo(width / 2, height);
        mPath.lineTo(0, height / 2);
        mPath.lineTo(vector1, height / 2 - vector1);
        mPath.lineTo(width / 2 - lineWidth / 2, height - vector2 - lineWidth / 2);
        mPath.lineTo(width / 2 - lineWidth / 2, 0);
        mPath.lineTo(width / 2 + lineWidth / 2, 0);
        mPath.lineTo(width / 2 + lineWidth / 2, height - vector2 - lineWidth / 2);
        mPath.lineTo(width - vector1, height / 2 - vector1);
        mPath.lineTo(width, height / 2);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }
}