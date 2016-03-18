package chapter10;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/3/18.
 * 数据无法同步访问
 */
public class StopThread1 {
    private static boolean stopRequested;
    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
