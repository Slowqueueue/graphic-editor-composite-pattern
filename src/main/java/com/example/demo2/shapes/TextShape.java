package com.example.demo2.shapes;
import java.awt.*;
public class TextShape extends BaseShape {
    public String str;
    public TextShape( int x, int y, String str, Color color) {
        super(x, y, color);
        this.str = str;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getWidth() {
        return str.length()*27;
    }
    @Override
    public int getHeight() {
        return 35;
    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        graphics.drawString(str, x, y+35);
    }
}
