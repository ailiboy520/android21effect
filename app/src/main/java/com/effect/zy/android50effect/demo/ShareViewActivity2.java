package com.effect.zy.android50effect.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_share_view2)
public class ShareViewActivity2 extends BaseActivity {

    @ViewInject(R.id.img)
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int res = intent.getIntExtra("res", 0);
        img.setImageResource(res);
    }

}
