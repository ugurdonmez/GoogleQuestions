package maze.rectangle;

/**
 * Created by ugurdonmez on 29/07/16.
 */
public class Test {

    public static void main(String [] args) {

        Point upper = new Point(0, 20);
        Point lower = new Point(30, 0);

        int radius = 4;

        Point sensor1 = new Point(10, 0);
        Point sensor2 = new Point(5, 5);
        Point sensor3 = new Point(10, 10);
        Point sensor4 = new Point(30, 0);

        Point [] sensors = {sensor1, sensor2, sensor3, sensor4};

        Maze maze = new Maze(upper, lower, radius, sensors);

        maze.getPath();

    }

}
