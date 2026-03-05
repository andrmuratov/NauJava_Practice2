package practice2.task5;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTask implements Task {

    private Queue<String> queue;
    private boolean running;
    private Thread worker;

    public QueueTask() {
        this.queue = new LinkedList<>();
        this.running = false;
    }

    @Override
    public void start() {
        if (running) {
            System.out.println("Uzhe rabotaet");
            return;
        }

        running = true;
        queue.add("Data1");
        queue.add("Data2");
        queue.add("Data3");

        worker = new Thread(() -> {
            while (running && !queue.isEmpty()) {
                String data = queue.poll();
                System.out.println("Obrabotka: " + data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Ochered obrabotana");
        });

        worker.start();
    }

    @Override
    public void stop() {
        if (!running) {
            System.out.println("Ne rabotaet");
            return;
        }

        running = false;
        queue.clear();
        System.out.println("Ostanovleno");
    }

    public static void main(String[] args) throws InterruptedException {
        QueueTask task = new QueueTask();

        System.out.println("Zapusk...");
        task.start();

        Thread.sleep(3500);

        System.out.println("Ostanovka...");
        task.stop();
    }
}