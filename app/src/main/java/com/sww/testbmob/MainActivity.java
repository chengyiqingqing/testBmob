package com.sww.testbmob;

import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sww.testbmob.model.Person;

/**
 * 只提供平台
 * 1.让这一个行业的人都没法存在。不赚钱，将自己的广告费用全部分享给用户。
 * 2.收取手续费和税收。（版本1）
 * 3.采用会员制，我只是赚取会员的钱，每月10元。帮助会员学习广告，获取利润。（版本2）
 * 4.让他们体现提取不出来。这样的事儿不干。做正规的事情。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void addData(View view) {
        PersonUtil.addData("luckyssww", "北京海淀", new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    toast("添加数据成功，返回objectId为：");
                } else {
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    public void getData(View view) {
        PersonUtil.getData("c316289e5b", new QueryListener<Person>() {
            @Override
            public void done(Person object, BmobException e) {
                if (e == null) {
                    toast("查询成功" + object.toString());
                } else {
                    toast("查询失败：" + e.getMessage());
                }
            }
        });
    }

    public void updateData(View view) {
        //更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”
        PersonUtil.updateData("c316289e5b", "张三", "张三家", new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    toast("更新成功:");
                } else {
                    toast("更新失败：" + e.getMessage());
                }
            }
        });
    }

    public void deleteData(View view) {
        PersonUtil.deleteData("c316289e5b", new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    toast("删除成功:");
                } else {
                    toast("删除失败：" + e.getMessage());
                }
            }
        });
    }
}
