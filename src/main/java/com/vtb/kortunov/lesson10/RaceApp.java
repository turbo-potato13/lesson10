package com.vtb.kortunov.lesson10;

import com.vtb.kortunov.lesson10.stages.Road;
import com.vtb.kortunov.lesson10.stages.Tunnel;

public class RaceApp {

    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        try {
            race.begin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


