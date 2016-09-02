package com.zs.study.javacore.innerclass.applicationframework;

import java.util.Arrays;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description
 * @date 2016-09-02 10:04
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.innerclass.applicationframework.GreenhouseController
 * @see
 */
public class GreenhouseController extends Controller {

    private boolean light = false;
    // 开灯
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void action()
        {
            light = true;
        }

        @Override
        public String toString()
        {
            return "Light is on...";
        }
    }

    // 关灯
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        public void action()
        {
            light = false;
        }

        @Override
        public String toString()
        {
            return "Light is off...";
        }
    }

    private boolean water = false;
    // 浇水
    public class WaterOn extends Event{
        public WaterOn(long delayTime)
        {
            super(delayTime);
        }

        public void action()
        {
            water = true;
        }

        @Override
        public String toString()
        {
            return "Water is on...";
        }
    }

    // 停止浇水
    public class WaterOff extends Event{
        public WaterOff(long delayTime)
        {
            super(delayTime);
        }

        public void action()
        {
            water = false;
        }

        @Override
        public String toString()
        {
            return "Water is off...";
        }
    }

    public class Restart extends Event{
        private Event[] events;
        public Restart(long delayTime, Event[] events)
        {
            super(delayTime);
            this.events = events;
            for (Event e : events)
                addEvent(e);
        }

        public void action()
        {
            for (Event e: events) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString()
        {
            return "Restarting system...";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime)
        {
            super(delayTime);
        }

        public void action()
        {
            System.exit(0);
        }

        @Override
        public String toString()
        {
            return "Terminate";
        }
    }

    public class Bell extends Event{

        public Bell(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public String toString()
        {
            return "Bing!";
        }

        public void action()
        {

            addEvent(new Bell(delayTime));
        }
    }

    private String thermostat = "Day";
    public class ThermostatNight extends Event{

        public ThermostatNight(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public String toString()
        {
            return "Thermostat on night setting...";
        }

        public void action()
        {
            thermostat = "Night";
        }
    }

    public class ThermostatDay extends Event{

        public ThermostatDay(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public String toString()
        {
            return "Thermostat on day setting...";
        }

        public void action()
        {
            thermostat = "Day";
        }
    }
    public static void main(String[] args)
    {
        GreenhouseController gc = new GreenhouseController();
        gc.addEvent(gc.new Bell(900));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };

        gc.addEvent(gc.new Restart(2000,events));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseController.Terminate(new Integer(args[0])));
            gc.run();
        }
    }
}
