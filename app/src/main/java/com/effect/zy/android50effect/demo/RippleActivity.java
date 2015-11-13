package com.effect.zy.android50effect.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_ripple)
public class RippleActivity extends BaseActivity implements View.OnClickListener{

    @ViewInject(R.id.linearlayout)
    private LinearLayout linearlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
    }

    private void setupView() {
        int count = linearlayout.getChildCount();
        for(int i=0;i<count;i++){
            linearlayout.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
