package ru.job4j.multithereading.threads.pinpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {

    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int stepX = 1;
        int stepY = 1;
        int k = 0;
        while (!Thread.interrupted()) {
            if (rect.getX() >= 300 || rect.getX() <= 0) {
                stepX *= -1.7;
            }
            if (rect.getY() >= 300 || rect.getY() <= 0) {
                stepY *= -1.5;
            }
            this.rect.setX(this.rect.getX() + stepX);
            this.rect.setY(this.rect.getY() + stepY);
            k++;

            if (k <= 320) {
                System.out.println(rect);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }


}
