/* *****************************************************************************
 *  Read points from a file and
 *  draw to standard draw. Highlight the closest point to the mouse.
 *
 *  The nearest neighbor according to the brute-force algorithm is drawn
 *  in red; the nearest neighbor using the k-d tree algorithm is drawn in blue.
 **************************************************************************** */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class NearestNeighborVisualizer {
	private static PointST<Integer> brute;
	private static KdTreeST<Integer> kdtree;
	private static RectHV myRect;
	private static Point2D query;

	public static void main(String[] args) throws FileNotFoundException {
		File myFile = new File("input20.txt");
		Scanner input = new Scanner(myFile);

		// initialize the two data structures with point from file
		brute = new PointST<Integer>();
		kdtree = new KdTreeST<Integer>();
		for (int i = 0; input.hasNextLine(); i++) {
			double x = input.nextDouble();
			System.out.printf("[" + i + "] x: "+ "%.3f", x);
			double y = input.nextDouble();
			System.out.printf(" \t y: " + "%.3f", y);
			System.out.println();
			Point2D p = new Point2D(x, y);
			kdtree.put(p, i);
			brute.put(p, i);
		}

		// process nearest neighbor queries
		Draw.enableDoubleBuffering();
		while (true) {

			// the location (x, y) of the mouse
			double x = Draw.mouseX();
			double y = Draw.mouseY();
			query = new Point2D(x, y);

			// draw all of the points
			Draw.clear();
			Draw.setPenColor(Draw.BLACK);
			Draw.setPenRadius(0.01);
			for (Point2D p : brute.points()) {
				p.draw();
			}

			// draw in red the nearest neighbor according to the brute-force algorithm
			Draw.setPenRadius(0.03);
			Draw.setPenColor(Draw.RED);
			Point2D bruteNearest = brute.nearest(query);
			if (bruteNearest != null) bruteNearest.draw();
			Draw.setPenRadius(0.02);

			// draw in blue the nearest neighbor according to the k-d tree algorithm
			Draw.setPenColor(Draw.BLUE);
			Point2D kdtreeNearest = kdtree.nearest(query);
			if (kdtreeNearest != null) kdtreeNearest.draw();
			Draw.show();
			Draw.pause(20);

			// draws a query rectangle and then returns all the point values within that rectangle 
			Draw.setPenColor(Draw.GREEN);
			Draw.setPenRadius(0.01);
			ArrayList<Point2D> arr = getRectPts(0.1, 0.2, 0.51, 0.80); // these are just random numbers I chose to try and show it works
			for (Point2D p : brute.points()) {
				if (arr.contains(kdtree.nearest(query))) System.out.println("x: " + kdtreeNearest.x() + "\t y: " + kdtreeNearest.y());
			}
		}

	}

	// returns an arraylist with all the points inside the rectangle
	private static ArrayList<Point2D> getRectPts(double xmin, double ymin, double xmax, double ymax) {
		myRect = new RectHV(xmin, ymin, xmax, ymax);
		myRect.draw();
		Draw.show();
		ArrayList<Point2D> arr = new ArrayList<Point2D>();
		for (Point2D p : brute.points()) {
			if (myRect.contains(brute.nearest(query)) && !arr.contains(brute.nearest(query))) { // brute.nearest(query) is the nearest point in the input file to the cursor
				// if the point nearest the cursor falls in the rectangle and arr doesn't already have that point stored in it
				// why am I getting duplicates here???? "!arr.contains(brute.nearest(query))" should take care of that
				if (p.x() >= xmin && p.x() <= xmax && p.y() >= ymin && p.y() <= ymax) {
					System.out.println("adding point p, x: " + p.x() + ", y: " + p.y());
					arr.add(p);
				}
			}

		}

		return arr;
	}
}
