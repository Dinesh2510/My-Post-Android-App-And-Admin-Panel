package com.app.mylekh.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private final int mItemOffset;
    private final int VIEW_AD = 2;

    public ItemOffsetDecoration(int itemOffset) {
        mItemOffset = itemOffset;
    }

    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
//        int position = parent.getChildAdapterPosition(view);
//        int viewType = Objects.requireNonNull(parent.getAdapter()).getItemViewType(position);
//        if (viewType == VIEW_AD) {
//            outRect.set(0, 0, 0, 0);
//        } else {
//            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
//        }
    }

}