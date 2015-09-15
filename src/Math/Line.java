package Math;

/**
 * Created by ZXM on 6/11/15.
 */
public class Line {
    static final double EPSILON = 0.000001;
    double slope;
    double intercept;
    boolean isVertical;

    public Line(double slope, double intercept, boolean isVertical) {
        this.slope = slope;
        this.intercept = intercept;
        this.isVertical = isVertical;
    }

    public Line(Point a, Point b) {
        if (isEqual(a.x, b.x)) {
            slope = Integer.MAX_VALUE;
            intercept = a.x;
            isVertical = true;
        } else {
            slope = (a.y - b.y) / (a.x - b.x);
            intercept = a.y - slope * a.x;
            isVertical = false;
        }
    }

    public boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    @Override
    public int hashCode() {
        int sl = (int) (slope * 1000);
        int in = (int) (intercept * 1000);
        return sl | in;
    }

    @Override
    public boolean equals(Object o) {
        Line l = (Line) o;
        if (isEqual(slope, l.slope) &&
                isEqual(intercept, l.intercept) &&
                isVertical == l.isVertical) return true;
        return false;
    }

}
