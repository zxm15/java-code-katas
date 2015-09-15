package Math;

import java.util.HashMap;

/**
 * Created by ZXM on 6/11/15.
 * Given an array of 2d points, find the line which passes through most points
 *
 * Analysis:
 * Use hashmap to store a line as a key and number of points lying on that line as value
 * check every pair of points and calculate line from them
 * if it is in the map, then update; otherwise set it in the map
 * O(n^2) time and O(n^2) space
 *
 * Pseudo code
 * function getMostPointsLine(Points[]) {
 *     HashMap<Line, Integer> map
 *     for i in n;
 *      for j in (i+1, n)
 *          Line l = calculateLine(Points[i], Points[j])
 *          if (map.containsKey(l)) map.put(l, map.get(l) + 1)
 *          else map.put(l, 1)
 *          update bestLine;
 *     return bestLine
 * }
 */


public class MostPointsOnLine {
    public Line findBestLineWithMostPoints(Point[] points) {
        if (points == null || points.length < 2) return null;
        HashMap<Line, Integer> map = new HashMap();
        Line bestLine = null;
        int maxPoint = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line l = new Line(points[i], points[j]);
                if (map.containsKey(l)) map.put(l, map.get(l) + 1);
                else map.put(l, 1);
                if (maxPoint < map.get(l)) {
                    maxPoint = map.get(l);
                    bestLine = l;
                }
            }
        }
        return bestLine;
    }

}
