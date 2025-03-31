package com.example.btt8.RecyclerViewIndicator.Decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final Paint paint = new Paint();

    public LinePagerIndicatorDecoration() {
        paint.setColor(0xFFFFFFFF);
        paint.setStrokeWidth(5);
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childCount = parent.getChildCount();
        if (childCount == 0) return;

        int width = parent.getWidth();
        int height = parent.getHeight();

        int indicatorStartX = (width - (childCount * 20)) / 2;
        int indicatorPosY = height - 20;

        for (int i = 0; i < childCount; i++) {
            float cx = indicatorStartX + (i * 40);
            canvas.drawCircle(cx, indicatorPosY, 10, paint);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = 30;
    }
}
