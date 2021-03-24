//Rachel McMullan
//George O'Malley
//Group 7

import java.util.*;
import java.lang.*;

public class KdTreeST <T> {
	private int size; // size of the tree
	private Map<Point2D, Integer> map;
	private Node root;
	
	// helper class
	private class Node {
		private Point2D p; // point
		private int val; // ST maps p to this value
		private RectHV rect; // rectangle corresponding to the node
		private Node leftBottom, rightTop; // subtrees: left/bottom, right/top
	}
    
    //construct an empty symbol table of points
    public KdTreeST(){
    	size = 0;
    	map = new TreeMap<Point2D, Integer>();
        
    }
    
    //return true if symbol table is empty
    public boolean isEmpty(){
        if (size == 0) return true;
        else return false;
    }
    
    //return number of points 
    public int size(){
        return size;
    }
    
    
    //associate the value val with point p
    public void put(Point2D p, int val){
        if (p == null) throw new IllegalArgumentException("first argument to put() is null");
        map.put(p, val);
       
    }
    
    //return value associated with point p
    public int get(Point2D p){
       return map.get(p);
    }
    
    
    //returns true if the symbol table contains point p
    public boolean contains(Point2D p){
        if (p == null) throw new NullPointerException("contains(): arguments can't be null");
        return map.containsKey(p);
    }
    
    
    //all points in the symbol table
    public Iterable<Point2D> points(){
    	Queue<Point2D> returnQueue = new LinkedList<>();
    	if (size == 0) return returnQueue;
    	Queue<Node> traverse = new LinkedList<>();
    	
    	traverse.add(root);
    	while (!traverse.isEmpty()) {
    		Node temp = traverse.remove();
    		returnQueue.add(temp.p);
    		if (temp.leftBottom != null) traverse.add(temp.leftBottom);
    		if (temp.rightTop != null) traverse.add(temp.rightTop);
    	}
    	return returnQueue;
    	
    }
    
    //all points that are inside or on the boundary of the rectangle 
    public Iterable<Point2D> range(RectHV rect){
    	if (rect == null) throw new NullPointerException("range(): arguments can't be null");
    	Queue<Point2D> pointsInRect = new LinkedList<>();
    	range(rect, pointsInRect, root);
    	return pointsInRect;
    	
    }
    
    //helper function for range()
    private void range(RectHV rect, Queue<Point2D> rectPts, Node node) {
    	if (node == null || !rect.intersects(node.rect)) return;
    	if (rect.contains(node.p)) rectPts.add(node.p);
    	range(rect, rectPts, node.leftBottom);
    	range(rect, rectPts, node.rightTop);
    }
    
    //returns nearest neighbor of point p or null if the symbol table is empty
    public Point2D nearest (Point2D p) {
    	if (p == null) throw new NullPointerException("nearest(): arguments may not be null");
    	
        return nearest(p, root, root.p); 
    }
    
    // helper function for nearest
    private Point2D nearest(Point2D p, Node n, Point2D point) {
    	if (n == null) return point; // should this return null??
    	if (n.rect.distanceSquaredTo(p) > point.distanceSquaredTo(p)) return point;
    	
    }
    
}
