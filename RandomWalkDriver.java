import java.util.Scanner;

public class RandomWalkDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gridSize;
        long seed;

        // Grid Size
        System.out.println("Enter the grid size: ");
        gridSize = scan.nextInt();
        while (gridSize < 0) {
            System.out.println("Please enter a positive number: ");
            gridSize = scan.nextInt();
        }

        // Seed Value
        System.out.println("Enter seed value (0 for no seed): ");
        seed = scan.nextLong();
        while (seed < 0) {
            System.out.println("Please enter a valid seed value: ");
            seed = scan.nextLong();
        }
        
        RandomWalk randomWalk;
        if (seed == 0) {
            randomWalk = new RandomWalk(gridSize);
        } else {
            randomWalk = new RandomWalk(gridSize, seed);
        }

        // Create walk
        randomWalk.createWalk();

        // Print walk
        System.out.println(randomWalk.toString());
    }
}