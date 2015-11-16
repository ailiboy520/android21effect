package com.effect.zy.android50effect.demo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_share_view)
public class ShareViewActivity extends BaseActivity {

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setAllowEnterTransitionOverlap(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter = new RecyclerViewAdapter(this));
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShareViewActivity.this, ShareViewActivity2.class);
                intent.putExtra("res", RecyclerViewAdapter.res[position]);
                // create the transition animation - the images in the layouts
                // of both activities are defined with android:transitionName="robot"
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(ShareViewActivity.this, view, "robot");
                // start the new activity
                startActivity(intent, options.toBundle());
            }
        });
    }




}
