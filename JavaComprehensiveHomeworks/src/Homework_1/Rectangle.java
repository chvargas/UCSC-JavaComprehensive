package Homework_1;

public class Rectangle {
	
	private static double length;
    private static double width;

    public Rectangle() {
        length = 0.0;
        width = 0.0;
    }

    public Rectangle (double l, double w) {
        length = l;
        width = w;
    }

    public double FindArea() {
        return length * width;
    }

    public double FindPerim() {
        return length * 2 + width * 2;
    }   
}

