package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floor) {
        this.area = area;
        this.floorCount = floor;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home home) {
        return Double.compare(getArea(), home.getArea());
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
