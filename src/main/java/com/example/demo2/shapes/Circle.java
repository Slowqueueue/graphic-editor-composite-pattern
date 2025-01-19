package com.example.demo2.shapes;

import java.awt.*;

public class Circle extends BaseShape {
    public int radius;
    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }
    public int getType() {
        return 0;
    }
    @Override
    public int getWidth() {
        return radius * 2;
    }
    @Override
    public int getHeight() {
        return radius * 2;
    }
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillOval(x,y,getWidth() - 1, getHeight() - 1);
    }
}