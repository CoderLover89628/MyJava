package com.zs.study.javacore.innerclass.applicationframework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description
 * @date 2016-09-02 9:59
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.innerclass.applicationframework.Controller
 * @see
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
