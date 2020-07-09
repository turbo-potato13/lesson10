package com.vtb.kortunov.lesson10;

import com.vtb.kortunov.lesson10.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Race {
    public static final int COMPETITORS_COUNT = 4;

    private final List<Stage> stages;
    private final CyclicBarrier preparation = new CyclicBarrier(COMPETITORS_COUNT);
    private final CountDownLatch canStart = new CountDownLatch(COMPETITORS_COUNT);
    private final CountDownLatch canFinal = new CountDownLatch(COMPETITORS_COUNT);

    public List<Car> getCarsFin() {
        return carsFin;
    }

    private final List<Car> carsFin = new ArrayList<>();

    public CountDownLatch getCanFinal() {
        return canFinal;
    }

    public CountDownLatch getCanStart() {
        return canStart;
    }

    public CyclicBarrier getPreparation() {
        return preparation;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void begin() throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[COMPETITORS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }

        canStart.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        canFinal.await();
        System.out.println(carsFin.get(0).getName() + " WIN");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }


}

