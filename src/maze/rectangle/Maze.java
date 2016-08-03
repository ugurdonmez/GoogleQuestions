package maze.rectangle;

import java.util.List;
import java.util.Stack;

/**
 * Created by ugurdonmez on 28/07/16.
 */

/*

Given a rectangle with top-left(a,b) and bottom-right(c,d) coordinates.
Also given some coordinates (m,n) of sensors inside the rectangle.
All sensors can sense in a circular region of radius r about their centre (m,n).
Total N sensors are given. A player has to reach from left side of rectangle to its right side
(i.e. he can start his journey from any point whose y coordinate is b and x coordinate is a<=x<=c.
He has to end his journey to any point whose y coordinate is d and x coordinate is a<=x<=c).

Write an algorithm to find path (possibly shortest but not necessary) from start to end as described above.

Note: all coordinates are real numbers

(a,b)
|----------------------------------------------|
|.......................................................|end
|.......................................................|
|start................................................|
|.......................................................|
|----------------------------------------------|(c,d)

Edit: You have to avoid sensors.
Also u can move in any direction any time.
 */

public class Maze {

    private final Point upperCorner;
    private final Point lowerCorner;

    private final int radius;

    private final Point [] sensors;

    public Maze(Point upperCorner, Point lowerCorner, int radius, Point[] sensors) {
        this.upperCorner = upperCorner;
        this.lowerCorner = lowerCorner;
        this.radius = radius;
        this.sensors = sensors;
    }

    public List<Point> getPath() {

        boolean [][] map = new boolean[upperCorner.y-lowerCorner.y+1][lowerCorner.x-upperCorner.x+1];

        for (Point sensor : sensors) {
            for (int i = sensor.y - radius; i <= sensor.y + radius; i++) {
                for (int j = sensor.x - radius; j <= sensor.x + radius; j++) {
                    if (i >= lowerCorner.y && i <= upperCorner.y && j >= upperCorner.x && j <= lowerCorner.x) {
                        map[i][j] = true;
                    }
                }
            }
        }

        for (int i = lowerCorner.y; i <= upperCorner.y; i++ ) {
            if (map[i][upperCorner.x] == false) {
                // DFT search for solution

                Stack<Point> stack = new Stack<>();
                stack.add(new Point(i, upperCorner.x));
                boolean [][] visited = new boolean[upperCorner.y-lowerCorner.y+1][lowerCorner.x-upperCorner.x+1];

                while (!stack.isEmpty()) {
                    Point p = stack.pop();

                    if (visited[p.y][p.x]) {
                        continue;
                    }

                    visited[p.y][p.x] = true;

                    if (p.x == lowerCorner.x) {
                        // we found solution
                        // TODO: get the path
                    }

                    // add all child to stack if they are not visited
                    if (p.y+1 <= upperCorner.y && map[p.y+1][p.x] == false) {
                        stack.add(new Point(p.y+1, p.x));
                    }

                    if (p.y-1 >= lowerCorner.y && map[p.y-1][p.x] == false) {
                        stack.add(new Point(p.y-1, p.x));
                    }

                    if (p.x+1 >= lowerCorner.x && map[p.y][p.x+1] == false) {
                        stack.add(new Point(p.y, p.x+1));
                    }

                    if (p.x-1 >= upperCorner.x && map[p.y][p.x-1] == false) {
                        stack.add(new Point(p.y, p.x-1));
                    }
                }
            }
        }

        // no solution
        return null;
    }
}
