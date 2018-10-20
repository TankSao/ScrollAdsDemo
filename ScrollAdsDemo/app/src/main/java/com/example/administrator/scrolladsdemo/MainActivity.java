package com.example.administrator.scrolladsdemo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ScrollTextView tv;
    ListView lv;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv.setMarqueeEnable(true);
        lv = findViewById(R.id.listview);
        initData();
        LvAdapter adapter = new LvAdapter(this,list);
        lv.setAdapter(adapter);
        new Timer().schedule(new TimeTaskScroll(this, lv), 100, 100);
    }

    class TimeTaskScroll extends TimerTask {
        private ListView listView;

        public TimeTaskScroll(Context context, ListView listView) {
            this.listView = listView;
        }

        private Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                //  控制速度
                listView.smoothScrollBy(2, 5);
            }
        };


        @Override
        public void run() {
            Message msg = handler.obtainMessage();
            handler.sendMessage(msg);
        }

    }

    private void initData() {
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试4");
        list.add("测试5");
        list.add("测试6");
        list.add("测试7");
        list.add("测试8");
        list.add("测试9");
        list.add("测试10");
        list.add("测试11");
        list.add("测试12");
        list.add("测试13");
        list.add("测试14");
        list.add("测试15");
        list.add("测试16");
        list.add("测试17");
        list.add("测试18");
        list.add("测试19");
        list.add("测试20");
        list.add("测试21");
        list.add("测试22");
        list.add("测试23");
        list.add("测试24");
        list.add("测试25");
    }
}
