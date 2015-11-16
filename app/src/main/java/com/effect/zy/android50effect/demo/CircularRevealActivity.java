package com.effect.zy.android50effect.demo;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivityCompat;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;


@ContentView(R.layout.activity_circular_reveal)
public class CircularRevealActivity extends BaseActivityCompat implements View.OnClickListener{
    static boolean isFirst = false;

    @Event(value = R.id.btn,  type = View.OnClickListener.class)
    private void OnBtnClick(View v){
        onClick(v);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Animator createAnimation(View v, Boolean isFirst) {

        Animator animator;

        if (isFirst) {
            animator = ViewAnimationUtils.createCircularReveal(
                    v,// 操作的视图
                    0,// 动画开始的中心点X
                    0,// 动画开始的中心点Y
                    (float) Math.sqrt(v.getWidth()*v.getWidth() + v.getHeight()*v.getHeight()),// 动画开始半径
                    0);// 动画结束半径
        } else {
            animator = ViewAnimationUtils.createCircularReveal(
                    v,// 操作的视图
                    0,// 动画开始的中心点X
                    0,// 动画开始的中心点Y
                    0,// 动画开始半径
                    (float) Math.sqrt(v.getWidth()*v.getWidth() + v.getHeight()*v.getHeight()));// 动画结束半径
        }

        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(500);
        return animator;
    }

    @Override
    public void onClick(View v) {
        createAnimation(v, isFirst).start();
        isFirst = !isFirst;
    }
}
