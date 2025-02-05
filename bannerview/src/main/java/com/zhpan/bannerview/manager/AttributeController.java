/*
Copyright 2017 zhpanvip The BannerViewPager Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.zhpan.bannerview.manager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zhpan.bannerview.R;
import com.zhpan.bannerview.utils.BannerUtils;

import static com.zhpan.bannerview.manager.BannerOptions.DEFAULT_REVEAL_WIDTH;

/**
 * <pre>
 *   Created by zhpan on 2019/11/20.
 *   Description:初始化xml的自定义属性
 * </pre>
 */
public class AttributeController {

  private final BannerOptions mBannerOptions;

  public AttributeController(BannerOptions bannerOptions) {
    mBannerOptions = bannerOptions;
  }

  public void init(@NonNull Context context, @Nullable AttributeSet attrs) {
    if (attrs != null) {
      TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.UIBannerViewPager);
      initBannerAttrs(typedArray);
      initIndicatorAttrs(typedArray);
      typedArray.recycle();
    }
  }

  private void initIndicatorAttrs(TypedArray typedArray) {
    int indicatorCheckedColor =
        typedArray.getColor(R.styleable.UIBannerViewPager_ui_indicator_checked_color,
            Color.parseColor("#8C18171C"));
    int indicatorNormalColor =
        typedArray.getColor(R.styleable.UIBannerViewPager_ui_indicator_normal_color,
            Color.parseColor("#8C6C6D72"));
    int normalIndicatorWidth =
        (int) typedArray.getDimension(R.styleable.UIBannerViewPager_ui_indicator_radius,
            BannerUtils.dp2px(8));
    int indicatorGravity = typedArray.getInt(R.styleable.UIBannerViewPager_ui_indicator_gravity, 0);
    int indicatorStyle = typedArray.getInt(R.styleable.UIBannerViewPager_ui_indicator_style, 0);
    int indicatorSlideMode =
        typedArray.getInt(R.styleable.UIBannerViewPager_ui_indicator_slide_mode, 0);
    int indicatorVisibility =
        typedArray.getInt(R.styleable.UIBannerViewPager_ui_indicator_visibility, 0);
    mBannerOptions.setIndicatorSliderColor(indicatorNormalColor, indicatorCheckedColor);
    mBannerOptions.setIndicatorSliderWidth(normalIndicatorWidth, normalIndicatorWidth);
    mBannerOptions.setIndicatorGravity(indicatorGravity);
    mBannerOptions.setIndicatorStyle(indicatorStyle);
    mBannerOptions.setIndicatorSlideMode(indicatorSlideMode);
    mBannerOptions.setIndicatorVisibility(indicatorVisibility);
    mBannerOptions.setIndicatorGap(normalIndicatorWidth);
    mBannerOptions.setIndicatorHeight(normalIndicatorWidth / 2);
  }

  private void initBannerAttrs(TypedArray typedArray) {
    int interval = typedArray.getInteger(R.styleable.UIBannerViewPager_ui_interval, 3000);
    boolean isAutoPlay = typedArray.getBoolean(R.styleable.UIBannerViewPager_ui_auto_play, true);
    boolean isCanLoop = typedArray.getBoolean(R.styleable.UIBannerViewPager_ui_can_loop, true);
    int pageMargin = (int) typedArray.getDimension(R.styleable.UIBannerViewPager_ui_page_margin, 0);
    int roundCorner =
        (int) typedArray.getDimension(R.styleable.UIBannerViewPager_ui_round_corner, 0);
    int revealWidth = (int) typedArray.getDimension(R.styleable.UIBannerViewPager_ui_reveal_width,
        DEFAULT_REVEAL_WIDTH);
    int pageStyle = typedArray.getInt(R.styleable.UIBannerViewPager_ui_page_style, 0);
    int scrollDuration = typedArray.getInt(R.styleable.UIBannerViewPager_ui_scroll_duration, 0);
    mBannerOptions.setInterval(interval);
    mBannerOptions.setAutoPlay(isAutoPlay);
    mBannerOptions.setCanLoop(isCanLoop);
    mBannerOptions.setPageMargin(pageMargin);
    mBannerOptions.setRoundRectRadius(roundCorner);
    mBannerOptions.setRightRevealWidth(revealWidth);
    mBannerOptions.setLeftRevealWidth(revealWidth);
    mBannerOptions.setPageStyle(pageStyle);
    mBannerOptions.setScrollDuration(scrollDuration);
  }
}
