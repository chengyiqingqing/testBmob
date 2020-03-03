package com.sww.testbmob;

import com.sww.testbmob.model.Person;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class PersonUtil {

    public static void addData(String name, String address, SaveListener<String> saveListener) {
        // 保存一条记录
        Person p = new Person();
        p.setName(name);
        p.setAddress(address);
        p.save(saveListener);
    }

    public static void getData(String objectId, QueryListener<Person> queryListener) {
        // 查找Person表里面id为6b6c11c537的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<>();
        bmobQuery.getObject(objectId, queryListener);
    }

    public static void updateData(String objectId, String name, String address, UpdateListener updateListener) {
        // 更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”
        final Person p2 = new Person();
        p2.setAddress(address);
        p2.update(objectId, updateListener);
    }

    public static void deleteData(String objectId, UpdateListener updateListener) {
        // 删除objectId的一条数据
        final Person p2 = new Person();
        p2.setObjectId(objectId);
        p2.delete(updateListener);
    }

}
