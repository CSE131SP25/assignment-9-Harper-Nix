package assignment9;

import java.util.LinkedList;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;

    public Snake() {
        deltaX = 0;
        deltaY = 0;
        segments = new LinkedList<>();
        BodySegment newSegment = new BodySegment(0.5, 0.5, SEGMENT_SIZE); // Start in the center
        segments.add(newSegment);
    }

    public void changeDirection(int direction) {
        if (direction == 1) { // up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) { // down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) { // left
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) { // right
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    public void move() {
        for (int i = segments.size() - 1; i > 0; i--) {
            BodySegment current = segments.get(i);
            BodySegment prev = segments.get(i - 1);
            current.setPosition(prev.getX(), prev.getY());
        }

        BodySegment head = segments.getFirst();
        head.setPosition(head.getX() + deltaX, head.getY() + deltaY);
    }

    public void draw() {
        for (BodySegment seg : segments) {
            seg.draw();
        }
    }

    public boolean eatsFood(Food f) {
        BodySegment head = segments.getFirst();
        double dx = head.getX() - f.getX();
        double dy = head.getY() - f.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < (SEGMENT_SIZE / 2) + (f.getFoodSize() / 2)) {
            // Add new segment at tail position
            BodySegment tail = segments.getLast();
            BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
            segments.add(newSegment);
            return true;
        }

        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        double half = SEGMENT_SIZE / 2;
        return head.getX() - half >= 0 && head.getX() + half <= 1 &&
               head.getY() - half >= 0 && head.getY() + half <= 1;
    }
}
