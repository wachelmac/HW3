Create a symbol-table data type whose keys are two-dimensional points. Use a 2d-tree to support efficient range search (find all of the points contained in a query rectangle) and nearest-neighbor search (find a closest point to a query point). 2d-trees have numerous applications, ranging from classifying astronomical objects and computer animation to speeding up neural networks and data mining.
********************************************************************************************************************************
BRUTE FORCE IMPLEMENTATION

Write a mutable data type PointST.java that uses a red–black BST to represent a symbol table whose keys are two-dimensional points, by implementing the following API:

public class PointST<Value> {
    
    // construct an empty symbol table of points 
    public PointST()
    // is the symbol table empty? 
    public boolean isEmpty()
    // number of points
    public int size()
    // associate the value val with point p
    public void put(Point2D p, Value val)
    // value associated with point p 
    public Value get(Point2D p)
    // does the symbol table contain point p? 
    public boolean contains(Point2D p)
    // all points in the symbol table 
    public Iterable<Point2D> points()
    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect)
    // a nearest neighbor of point p; null if the symbol table is empty 
    public Point2D nearest(Point2D p)
    // unit testing (required)
    public static void main(String[] args)
}
Implementation requirements:  You must use RedBlackBST.java (uploaded on Blackboard); do not implement your own red–black BST.
Corner cases: Throw an IllegalArgumentException if any argument is null.
Unit testing:  Your main() method must call each public constructor and method directly and help verify that they work as prescribed (e.g., by printing results to standard output).
Performance requirements:  In the worst case, your implementation must support size() in constant time; put(), get() and contains() in Θ(logn) time; and points(), nearest(), and range() in Θ(n) time, where n is the number of points in the symbol table.
********************************************************************************************************************************
2D TREE IMPLEMENTATION 
  
Write a mutable data type KdTreeST.java that uses a 2d-tree to implement the same API (but renaming PointST to KdTreeST). A 2d-tree is a generalization of a BST to two-dimensional keys. The idea is to build a BST with points in the nodes, using the x- and y-coordinates of the points as keys in strictly alternating sequence, starting with the x-coordinates.

•	Search and insert. The algorithms for search and insert are similar to those for BSTs, but at the root we use the x-coordinate (if the point to be inserted has a smaller x-coordinate than the point at the root, go left; otherwise go right); then at the next level, use the y-coordinate (if the point to be inserted has a smaller y-coordinate than the point in the node, go left; otherwise go right); then at the next level, use the x-coordinate; and so forth.

•	Level-order traversal. The points() method must return the points in level order: first the root, then all children of the root (from left/bottom to right/top), then all grandchildren of the root (from left to right), and so forth. The level-order traversal of the above 2d-tree is (0.7, 0.2), (0.5, 0.4), (0.9, 0.6), (0.2, 0.3), (0.4, 0.7). This method is useful to assist you (when debugging) and us (when grading).



