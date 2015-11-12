package com.effect.zy.android50effect.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.effect.zy.android50effect.R;
import com.effect.zy.android50effect.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_material_dialog)
public class MaterialDialogActivity extends BaseActivity {

    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
    }

    private void setupView() {
        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//          设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 创建Adapter，并指定数据集
        MyAdapter adapter = new MyAdapter();
        // 设置Adapter
        recyclerView.setAdapter(adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        int index = 0;
        String[] dialogs = {"base dialog(无标题)", "base dialog(有标题)", "长内容的dialog", "带ICON的dialog", "基本全属性!", "单选", "单选2", "复选", "自定义列表"};

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.material_dialog_item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.button.setText(dialogs[position]);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MaterialDialogActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                    switch (position) {
                        case 0:
                            builder.setMessage("这是一个无标题,简单的dialog!").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 1:
                            builder.setTitle("标题").setMessage("这是一个有标题,简单的dialog!").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 2:
                            builder.setTitle("这是一个有标题,长内容的dialog!").setMessage(R.string.long_content).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 3:
                            builder.setIcon(R.mipmap.ic_launcher).setTitle("标题").setMessage("这是一个带icon的dialog!").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 4:
                            builder.setIcon(R.mipmap.ic_launcher).setTitle("标题").setMessage("基本全属性的dialog!")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNeutralButton("Neutral", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 5:
                            builder.setIcon(R.mipmap.ic_launcher).setTitle("单选")
                                    .setItems(dialogs, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Snackbar.make(holder.button, dialogs[which], Snackbar.LENGTH_LONG).show();
                                            dialog.dismiss();
                                        }
                                    }).create().show();
                            break;
                        case 6:// 单选2
                            builder.setTitle("单选2").setSingleChoiceItems(dialogs, index, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    index = which;
                                }
                            }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Snackbar.make(holder.button, dialogs[index], Snackbar.LENGTH_LONG).show();
                                    dialog.dismiss();
                                    ;
                                }
                            }).create().show();
                            break;
                        case 7://复选
                            final Boolean[] b = new Boolean[dialogs.length];
                            initBoolean(b);
                            builder.setIcon(R.mipmap.ic_launcher).setTitle("复选")
                                    .setMultiChoiceItems(dialogs, null, new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                            b[which] = isChecked;
                                        }
                                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String s = "";
                                    for (int i = 0; i < b.length; i++) {
                                        if (b[i]) {
                                            s += dialogs[i] + ",";
                                        }
                                    }
                                    if (s.length() > 0) {
                                        s.substring(0, s.length() - 1);
                                    }
                                    Snackbar.make(holder.button, s, Snackbar.LENGTH_LONG).show();
                                    dialog.dismiss();
                                }
                            }).create().show();
                            break;
                        case 8: // 自定义列表
                            MyListAdapter adapter = new MyListAdapter(dialogs);
                            builder.setTitle("自定义列表").setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MaterialDialogActivity.this, String.valueOf(which)+"被点击了", Toast.LENGTH_LONG).show();
                                }
                            }).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(MaterialDialogActivity.this, String.valueOf(position)+"被点击了(onItemSelected)", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                    Toast.makeText(MaterialDialogActivity.this, "啥都没选", Toast.LENGTH_LONG).show();
                                }
                            }).create().show();
                            break;
                    }
                }


            });


        }

        class MyListAdapter extends BaseAdapter{

            String[] arr = null;

            public MyListAdapter(String[] arr){
                this.arr = arr;
            }

            @Override
            public int getCount() {
                return arr==null?0:arr.length;
            }

            @Override
            public String getItem(int position) {
                return arr[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.material_dialog_item_custom, null);
                TextView tv = (TextView) convertView.findViewById(R.id.textview);
                Button btn = (Button) convertView.findViewById(R.id.button);
                tv.setText(getItem(position));
                btn.setText(String.valueOf(position));
                return convertView;
            }

        }

        @Override
        public int getItemCount() {
            return dialogs.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            Button button;

            public ViewHolder(View itemView) {
                super(itemView);
                button = (Button) itemView;
            }
        }

        private void initBoolean(Boolean[] b) {
            if (b != null) {
                for (int i = 0; i < b.length; i++) {
                    b[i] = false;
                }
            }
        }
    }
}
