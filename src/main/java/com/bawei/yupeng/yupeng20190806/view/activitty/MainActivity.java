package com.bawei.yupeng.yupeng20190806.view.activitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.yupeng.yupeng20190806.R;
import com.bawei.yupeng.yupeng20190806.model.bean.Bean;
import com.bawei.yupeng.yupeng20190806.model.bean.HttpUtils;
import com.bawei.yupeng.yupeng20190806.view.adapter.MyAdapter;
import com.bawei.yupeng.yupeng20190806.view.adapter.MyAdapter1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String str = "http://blog.zhaoliang5156.cn/api/chathistory.json";
    private ListView listView;
    private List<Bean> list = new ArrayList<>();
    private HttpUtils httpUtils = HttpUtils.getHttpUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        getdata();
        MyAdapter1 adapter = new MyAdapter1(list,MainActivity.this);
        listView.setAdapter(adapter);
    }

    private void getdata() {
        httpUtils.Task(str, new HttpUtils.Back() {
            @Override
            public void getdata(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray data = object.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject obj = (JSONObject) data.get(i);
                        String content = obj.getString("content");
                        String avatar = obj.getString("avatar");
                        String type = obj.getString("type");
                        list.add(new Bean(content,avatar,type));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
