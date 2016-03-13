package com.example.customviewworking;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by NguyenNghia on 3/13/2016.
 */
public class NghiaView extends ViewGroup {


    private final String TAG = "NghiaView";
    private Context mContext;
    private int mMaxColumn;
    private int mMaxRow;
    private int mSizeColumn;
    private int mPadding = 2;
    private List<Rect> mRectCoordinates;
    private Random mRandom;
    private List<Data> mDataPadding;

    class Data{
        int paddingLeft;
        int paddingTop;
        int paddingRight;
        int paddingBottom;
        public Data(){

        }

        public void setData(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom){
            this.paddingLeft = paddingLeft;
            this.paddingTop = paddingTop;
            this.paddingRight = paddingRight;
            this.paddingBottom = paddingBottom;
        }
    }

    public NghiaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRandom = new Random();
        mContext = context;
        mRectCoordinates = new ArrayList<>();
        mDataPadding = new ArrayList<>();
    }

    public NghiaView(Context context) {
        super(context);
        mContext = context;
    }

    public void addData(Rect rect){
        View v = new View(mContext);
        v.setBackgroundColor(Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256)));
        this.addView(v);
        mRectCoordinates.add(rect);
        mDataPadding.add(new Data());
    }

    public void setMaxColumnAndMaxColumn(int maxColumn, int mMaxRow){
        this.mMaxColumn = maxColumn;
        this.mMaxRow = mMaxRow;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        long start = System.nanoTime();
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        mSizeColumn = widthSize / mMaxColumn;
        int heightSize = mSizeColumn * mMaxRow;
        setMeasuredDimension(widthSize, heightSize);

        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++){
            Rect rect = mRectCoordinates.get(i);
            View child = getChildAt(i);
            Data data = mDataPadding.get(i);

            int leftPadding = rect.left > 0 ? mPadding : 0;
            int topPadding = rect.top > 0? mPadding : 0;
            int wPadding = rect.right < mMaxColumn ? leftPadding > 0 ? (mPadding << 1) : mPadding : 0;
            int hPadding = rect.bottom < mMaxRow ? topPadding > 0 ? (mPadding << 1) : mPadding : 0;

            data.setData(leftPadding, topPadding, wPadding, hPadding);

            int w = (int)((rect.width() * mSizeColumn) - wPadding);
            int h = (int)((rect.height() * mSizeColumn) - hPadding);

            int widthChildMeasureSpec = MeasureSpec.makeMeasureSpec(w, MeasureSpec.EXACTLY);
            int heightChildMeasureSpec = MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY);
            child.measure(widthChildMeasureSpec, heightChildMeasureSpec);
        }

        Log.i(TAG, "onMeasure Time = " + (System.nanoTime() - start));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        long start = System.nanoTime();
        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++) {
            Rect rect = mRectCoordinates.get(i);
            View child = getChildAt(i);
            Data data = mDataPadding.get(i);
            int measuredWidth = child.getMeasuredWidth();
            int measureHeight = child.getMeasuredHeight();

            int startLeft = rect.left * mSizeColumn;
            int startTop = rect.top * mSizeColumn;

            child.layout(startLeft + data.paddingLeft, startTop + data.paddingTop, startLeft + measuredWidth + data.paddingRight, startTop + measureHeight + data.paddingBottom);
        }

        Log.i(TAG, "onLayout Time = " + (System.nanoTime() - start));
    }
}
