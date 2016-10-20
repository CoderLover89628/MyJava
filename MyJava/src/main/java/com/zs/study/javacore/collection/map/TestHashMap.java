package com.zs.study.javacore.collection.map;

import java.util.*;

/**
 * Created by zhangsheng1 on 2016/7/15.
 * hashMap的遍历方式
 * 参考网址：
 * http://www.trinea.cn/android/hashmap-loop-performance/
 *
 * 注意点：
 * hashMap的遍历不一定会按照原插入顺序遍历而出，如下面的插入顺序是
 * A、B、C、D、E,但是结果并不是这样，如果有插入遍历一致要求可以使用LinkedHashMap
 */
public class TestHashMap {

    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("A","hello");
        map.put("B","world");
        map.put("C","I");
        map.put("D","love");
        map.put("E","Java");

        System.out.println("map 包含Key A: " + !map.containsKey("F"));
        // for each map.entrySet() 结构清晰
        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(entry);
        }

        // 显示调用map.entrySet()的集合迭代器 速度最快 可以对map进行增删操作
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();

            if (entry.getKey().equals("C")) {
                System.out.println("to delete key is :" + entry.getKey());
                iterator.remove();
                System.out.println("the key is deleted!");
            } else {
                print(entry);
            }
        }

        // for each map.keySet()，再调用get获取
        for (String key : map.keySet()) {
            System.out.println("key is : " + key + ",value is :" + map.get(key));
        }

        System.out.println("================================");
        Map<String,String> aMap = new HashMap<String, String>();
        aMap.put("name","zhangsan");
        aMap.put("age","24");
        Map<String,String> bMap = new HashMap<String, String>();
        bMap.put("name","lisi");
        bMap.put("age","25");
        Map<String,String> cMap = new HashMap<String, String>();
        cMap.putAll(combineHashMap(aMap,bMap));
        for (Iterator iter = cMap.keySet().iterator(); iter.hasNext();) {
            String key = (String) iter.next();
            System.out.println(key +  "<---> " + cMap.get(key));
        }

        Set<String> aSet = new HashSet<String>();
        aSet.add("a");
        aSet.add("b");

        Set<String> bSet = new HashSet<String>();
        bSet.add("a");
        bSet.add("c");
        Map<String,Map<String,Set<String>>> testMap = new HashMap<String, Map<String, Set<String>>>();
        Map<String,Set<String>> sMap = new HashMap<String, Set<String>>();
        sMap.put("a",aSet);
        testMap.put("aa",sMap);

        Map<String,Set<String>> bbMap = testMap.get("aa");
        for (Map.Entry<String,Set<String>> entry : bbMap.entrySet()) {
            if ("a".equals(entry.getKey())) {
                Set<String> names = entry.getValue();
                names.addAll(bSet);
//                bbMap.put(entry.getKey(),names);
            }
        }

        for (Map.Entry<String,Set<String>> entry : bbMap.entrySet()) {
            Set<String> names = entry.getValue();
            Iterator<String> its = names.iterator();
            while (its.hasNext()) {
                String na = its.next();
                System.out.println("na is:" + na);
            }
        }
    }

    private static Map<String,String> combineHashMap(Map<String, String> aMap, Map<String, String> bMap)
    {
        Map<String,String> map = new HashMap<String, String>();
        map.putAll(aMap);
        map.putAll(bMap);
        return map;
    }

    /**
     * print
     *
     * @param entry entry
     */
    private static void print(Map.Entry<String, String> entry)
    {
        System.out.println("key is : " + entry.getKey() + ",value is :" + entry.getValue());
    }
}
