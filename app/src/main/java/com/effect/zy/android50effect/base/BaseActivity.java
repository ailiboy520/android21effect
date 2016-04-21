package com.effect.zy.android50effect.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import org.xutils.x;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    public static void reSetTitle(Activity activity) {
        String st =  activity.getTitle().toString();
        if (!TextUtils.isEmpty(st)) {
            String[] sp = st.split("/");
            if (sp.length > 0) {
                activity.setTitle(sp[sp.length - 1]);
            }
        }
    }
}
