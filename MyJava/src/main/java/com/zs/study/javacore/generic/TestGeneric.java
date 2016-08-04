package com.zs.study.javacore.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsheng1 on 2016/7/22.
 * 泛型
 */
public class TestGeneric<T> implements Serializable {
    private T obj;
    private List<T> dataList;

    public T getObj()
    {
        return obj;
    }

    public void setObj(T obj)
    {
        this.obj = obj;
    }

    public List<T> getDataList()
    {
        return dataList;
    }

    public void setDataList(List<T> dataList)
    {
        this.dataList = dataList;
    }

    public static void main(String[] args)
    {
        TestGeneric tg = new TestGeneric();
        tg.setObj("clusterName");
        List list = new ArrayList();
        tg.setDataList(list);
    }
}
