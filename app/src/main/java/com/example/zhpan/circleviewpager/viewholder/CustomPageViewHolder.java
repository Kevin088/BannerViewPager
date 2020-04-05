package com.example.zhpan.circleviewpager.viewholder;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.zhpan.circleviewpager.R;
import com.example.zhpan.circleviewpager.bean.CustomBean;
import com.zhpan.bannerview.holder.BaseViewHolder;

public class CustomPageViewHolder extends BaseViewHolder<CustomBean> {

    private OnSubViewClickListener mOnSubViewClickListener;

    public CustomPageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(CustomBean data, int position, int pageSize) {
        ImageView imageView = itemView.findViewById(R.id.banner_image);
        ImageView imageStart = itemView.findViewById(R.id.iv_logo);
        imageView.setImageResource(data.getImageRes());
        imageStart.setOnClickListener(view -> {
            if (null != mOnSubViewClickListener)
                mOnSubViewClickListener.onViewClick(view, getAdapterPosition());
        });
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imageStart, "alpha", 0, 1);
        alphaAnimator.setDuration(1500);
        alphaAnimator.start();
    }

    public void setOnSubViewClickListener(OnSubViewClickListener subViewClickListener) {
        mOnSubViewClickListener = subViewClickListener;
    }

    public interface OnSubViewClickListener {
        void onViewClick(View view, int position);
    }
}
