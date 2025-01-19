package com.example.demo2;

import com.example.demo2.editor.ImageEditor;
import com.example.demo2.shapes.Circle;
import com.example.demo2.shapes.Polygon;
import com.example.demo2.shapes.CompoundShape;
import com.example.demo2.shapes.TextShape;
import com.example.demo2.shapes.Dot;
import com.example.demo2.shapes.Rectangle;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        int[] xPoints = {250, 300, 320, 300, 250, 230};
        int[] yPoints = {120, 120, 80, 40, 40, 80};
        editor.loadShapes(
                new Circle(240, 150, 40, Color.ORANGE),
                new CompoundShape(
                        new Polygon(xPoints, yPoints, 6, Color.CYAN),
                        new Dot(225, 35, Color.CYAN),
                        new Dot(225, 125, Color.CYAN),
                        new Dot(325, 35, Color.CYAN),
                        new Dot(325, 125, Color.CYAN)
                ),
                new CompoundShape(
                        new TextShape(50, 150, "Увы", Color.BLACK)
                ),
                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
