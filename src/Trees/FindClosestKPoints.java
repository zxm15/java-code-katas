package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ZXM on 12/7/15.
 */
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Wrapper implements Comparable<Wrapper>{
    Point point;
    int distance;
    public Wrapper(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }
    @Override
    public int compareTo(Wrapper wrapper) {
        return this.distance - wrapper.distance;
    }
}
public class FindClosestKPoints {
    public List<Point> findClosestKPointsWithHeap(List<Point> points, Point center, int k) {
        List<Point> res = new ArrayList<>();
        if (points == null || center == null) return res; //need more constriants
        if (points.size() <= k) return points;
        List<Wrapper> wrappers = findDistanceBetweenPointers(points, center);
        PriorityQueue<Wrapper> heap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < wrappers.size(); i++) {
            if (heap.size() < k) {
                heap.offer(wrappers.get(i));
            } else {
                if (heap.peek().distance > wrappers.get(i).distance) {
                    heap.poll();
                    heap.offer(wrappers.get(i));
                }
            }
        }

        while (! heap.isEmpty()) {
            res.add(heap.poll().point);
        }

        return res;
    }

    private List<Wrapper> findDistanceBetweenPointers(List<Point> points, Point center) {
        List<Wrapper> res = new ArrayList<>();
        for (Point point : points) {
            int distance = calculateDistance(point, center);
            res.add(new Wrapper(point, distance));
        }

        return res;
    }

    private int calculateDistance(Point a, Point b) {
        int dx = Math.abs(a.x - b.x);
        int dy = Math.abs(a.y - b.y);
        return dx * dx + dy * dy;
    }

    public List<Point> findClosestKPointersWithSelection(List<Point> points, Point center, int k) {
        List<Point> res = new ArrayList<>();
        if (points == null || center == null) return res; //need more constriants
        if (points.size() <= k) return points;
        List<Wrapper> wrappers = findDistanceBetweenPointers(points, center);
        findKthSmallestDistance(wrappers, k);
        for (int i = 0; i < k; i++) {
            res.add(wrappers.get(i).point);
        }

        return res;
    }

    private void findKthSmallestDistance(List<Wrapper> wrappers, int k) {
        int s = 0, e = wrappers.size() - 1;
        while (s < e) {
            int m = (s + e) / 2;
            int index = partition(wrappers, m, s, e);
            int rank = index - s + 1;
            if (rank < k) {
                k -= rank;
                s = m + 1;
            } else {
                e = m;
            }
        }

    }

    private int partition(List<Wrapper> wrappers, int pivotIndex, int start, int end) {
        int pivotDistance = wrappers.get(pivotIndex).distance;
        swap(wrappers, pivotIndex, end);
        int leftIndex = start;
        for (int i = start; i < end; i++) {
            if (wrappers.get(i).distance < pivotDistance) {
                swap(wrappers, i, leftIndex++);
            }
        }
        swap(wrappers, end, leftIndex);

        return leftIndex;
    }

    private void swap(List<Wrapper> wrappers, int i, int j) {
        Wrapper temp = wrappers.get(i);
        wrappers.set(i, wrappers.get(j));
        wrappers.set(j, temp);
    }
}
