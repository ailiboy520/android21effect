package com.effect.zy.android50effect.demo;

import android.graphics.Outline;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivityCompat;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_tinting)
public class TintingActivity extends BaseActivityCompat {

    @ViewInject(R.id.tv1)
    private TextView tv1;

    @ViewInject(R.id.tv2)
    private TextView tv2;

    @ViewInject(R.id.tv3)
    private TextView tv3;

    @ViewInject(R.id.tv4)
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
            }
        };
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2);
            }
        };
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, view.getWidth()/4, view.getWidth(), view.getHeight()/2);
            }
        };
        ViewOutlineProvider viewOutlineProvider3 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                Path path = new Path();
                path.moveTo(0, 0);
                path.lineTo(view.getWidth(), view.getHeight() / 2);
//                path.lineTo(view.getWidth()/2, view.getHeight() );
                path.quadTo(view.getWidth(), view.getHeight(), view.getWidth() / 2, view.getHeight());
                path.close();
                outline.setConvexPath(path);
            }
        };
        tv1.setOutlineProvider(viewOutlineProvider);
        tv2.setOutlineProvider(viewOutlineProvider1);
        tv3.setOutlineProvider(viewOutlineProvider2);
        tv4.setOutlineProvider(viewOutlineProvider3);
    }
}
