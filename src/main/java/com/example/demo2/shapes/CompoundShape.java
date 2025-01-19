package com.example.demo2.shapes;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    protected List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(Shape component) {
        children.add(component);
    }

    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Shape child) {
        children.remove(child);
    }

    public void remove(Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.size() == 0) {
            return 0;
        }
        int x = children.get(0).getX();
        for (Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.size() == 0) {
            return 0;
        }
        int y = children.get(0).getY();
        for (Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getType() {
        return children.get(0).getType();
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (Shape child : children) {
            int childsRelativeX = child.getX() - x;
            int childWidth = childsRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (Shape child : children) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : children) {
            child.unSelect();
        }
    }

    public Shape getSelected() {
        for (Shape child : children) {
            if (child.isSelected()) {
                return child;
            }
        }
        return null;
    }

    public List<Shape> getAllSelected() {
        List<Shape> newChildren = new ArrayList<>();
        for (Shape child : children) {
            if (child.isSelected()) {
                newChildren.add(child);

            }
        }
        return newChildren;
    }

    public List<Shape> getShapes() {
        return children;
    }

    public boolean selectChildAt(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    public void upLayout(Shape shape) {
        if (shape != null) {
            children.remove(shape);
            children.add(shape);
        }
    }

    public void downLayout(Shape shape) {
        if (shape != null) {
            children.remove(shape);
            children.add(0, shape);
        }
    }

    public void sizeplus(Shape shape) {
        if (shape != null) {
            Shape newShape = null;
            switch (shape.getType()) {
                case 0:
                    newShape = new Circle(shape.getX(), shape.getY(), shape.getHeight()/2 + 10, Color.ORANGE);
                    break;
                case 1:
                    newShape = new CompoundShape(
                            new Rectangle(shape.getX(), shape.getY(), shape.getWidth() + 5, shape.getHeight() + 5, Color.GREEN),
                            new Dot(shape.getX() - 10, shape.getY() - 10, Color.GREEN),
                            new Dot(shape.getX() - 10, shape.getY() + shape.getHeight() + 10, Color.GREEN),
                            new Dot(shape.getX() + shape.getWidth() + 10, shape.getY() + shape.getHeight() + 10, Color.GREEN),
                            new Dot(shape.getX() + shape.getWidth() + 10, shape.getY() - 10, Color.GREEN)
                    );
                default:
                    break;
            }
            children.remove(shape);
            children.add(newShape);
        }
    }

    public void sizeminus(Shape shape) {
        if (shape != null) {
            Shape newShape = null;
            switch (shape.getType()) {
                case 0:
                    newShape = new Circle(shape.getX(), shape.getY(), shape.getHeight()/2 - 10, Color.ORANGE);
                    break;
                case 1:
                    newShape = new CompoundShape(
                            new Rectangle(shape.getX(), shape.getY(), shape.getWidth() - 10, shape.getHeight() - 10, Color.GREEN),
                            new Dot(shape.getX() - 10, shape.getY() - 10, Color.GREEN),
                            new Dot(shape.getX() - 10, shape.getY() + shape.getHeight() + 10, Color.GREEN),
                            new Dot(shape.getX() + shape.getWidth() + 10, shape.getY() + shape.getHeight() + 10, Color.GREEN),
                            new Dot(shape.getX() + shape.getWidth() + 10, shape.getY() - 10, Color.GREEN)
                    );
                default:
                    break;
            }
            children.remove(shape);
            children.add(newShape);
        }
    }
    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (com.example.demo2.shapes.Shape child : children) {
            child.paint(graphics);
        }
    }
}
