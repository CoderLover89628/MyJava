package com.zs.study.javacore.innerclass.applicationframework;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description 内部类与应用框架
 * @date 2016-09-02 9:46
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.innerclass.applicationframework.Event
 * @see
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime)
    {
        this.delayTime = delayTime;
        start();
    }

    public void start()
    {
        eventTime = System.nanoTime() + delayTime;
        System.out.println("nanoTime is :" + System.nanoTime());
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
