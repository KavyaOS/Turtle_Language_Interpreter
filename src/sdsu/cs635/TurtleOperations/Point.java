package sdsu.cs635.TurtleOperations;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.setX(0);
        this.setY(0);
    }

    public Point(double x,double y) {
        this.setX(x);
        this.setY(y);
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double bearingTo(Point point)
    {
        double Px=point.getX(), Py= point.getY();
        double Tx=this.getX(), Ty= this.getY();
        return Math.toDegrees(Math.atan((Py - Ty)/(Px -Tx)));
    }

    public double distanceTo(Point point)
    {
        double Px=point.getX() - this.getX();
        double Py=point.getY() - this.getY();
        return Math.sqrt((Px*Px)+(Py*Py));
    }
}
