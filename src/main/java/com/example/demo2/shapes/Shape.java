package com.example.demo2.shapes;
import java.awt.*;

public interface Shape {
    int getX();
    int getY();
    int getType();
    int getWidth();
    int getHeight();
    void move(int x, int y);
    boolean isInsideBounds(int x, int y);
    void select();
    void unSelect();
    boolean isSelected();
    void paint(Graphics graphics);
}


