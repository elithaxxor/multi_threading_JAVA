package Threadings;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class thread {
    public static void main (String[] args){

        int coreCount = Runtime.getRuntime().availableProcessors();

        System.out.print("[+] Core Count" + coreCount);
        ScheduledExecutorService s = Executors.newScheduledThreadPool(4);

        // task to run 10 sec delay
        s.scheduleWithFixedDelay(new Task(), 15, 1, MICROSECONDS);

        // task to run after ^ is completed
        s.scheduleWithFixedDelay(new Task(), 15,1, MICROSECONDS);

        // MULTIPLE TASKS
        for (int i=0; i <1000000000; i++){
            s.execute(new CpuIntensiveTask());
        }
    }
    static class CpuIntensiveTask implements Runnable{
        public void run(){
            for (int i = 0; i <= 200000000; i++){
                System.out.print(i + ", ");
            }
        }
    }
    static class Task implements Runnable{
        public void run(){
        for (int i = 0; i <= 200000000; i++){
            System.out.print(i + ", ");
        }
        }
    }
}
