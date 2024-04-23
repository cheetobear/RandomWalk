import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import edu.cwi.randomwalk.RandomWalkInterface;

public class RandomWalk implements RandomWalkInterface {
    private int size;
    private boolean done;
    private ArrayList<Point> path;
    private Point start;
    private Point end;
    private Point current;
    private Random generator;

    public RandomWalk(int gridSize) {
        generator = new Random();
        done = false;
        size = gridSize;
        path = new ArrayList<Point>();
        start = new Point(0, gridSize - 1);
        path.add(start);
        end = new Point(gridSize - 1, 0);
        current = new Point(start);
    }


    public RandomWalk(int gridSize, long seed) {
        generator = new Random(seed);
        done = false;
        size = gridSize;
        path = new ArrayList<Point>();
        start = new Point(0, gridSize - 1);
        path.add(start);
        end = new Point(gridSize - 1, 0);
        current = new Point(start);
    }

    public void step() {
        if (!isDone()) {
            int coinFlip = generator.nextInt(2);
            if (coinFlip == 0 && current.x < end.x) {
                current.x++;
                this.path.add(new Point(current.x, current.y));
            } else if (coinFlip == 1 && current.y > end.y) {
                current.y--;
                this.path.add(new Point(current.x, current.y));
            }
        }
    }
    
    public void createWalk() {
        while (!isDone()) {
            this.step();
        }
    }

    public boolean isDone() {
        if (getCurrentPoint().equals(getEndPoint())) {
            done = true;
        } else {
            done = false;
            }
        return done;
    }

    public int getGridSize() {
        return size;
    }

    public Point getStartPoint() {
        return start;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getCurrentPoint() {
        return current;
    }

    public ArrayList<Point> getPath() {
        return new ArrayList<Point>(this.path);
    }
    
    public String toString() {
        String results = "";
        for(Point p : this.path) {
        results += "[" + p.x + "," + p.y + "] ";
        }
        return results;
    }
}
