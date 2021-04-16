package com.hyeonah.javalabs.designpattern.singleton.ex1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSpeaker {
    private static final Logger log = LoggerFactory.getLogger(SystemSpeaker.class);

    private static SystemSpeaker instance;
    private int volume;

    private SystemSpeaker() {
        volume = 5;
    }

    public static SystemSpeaker getInstance(){
        if(instance == null){
            instance = new SystemSpeaker();
            log.info("new create system speaker -");
        } else {
            log.info("system speaker already exist!");
        }

        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(final int volume) {
        this.volume = volume;
    }
}
