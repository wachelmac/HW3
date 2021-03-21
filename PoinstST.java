//Rachel McMullan
//George O'Malley
//Group 7

public class PointST {
    
    //construct an empty symbol table of points
    public PointST(){
        
    }
    
    //return true if symbol table is empty
    public boolean isEmpty(){
        return true;
    }
    
    //return number of points 
    public int size(){
        return 0;
    }
    
    /*
    //associate the value val with point p
    public void put(Point2D p, Value val){
        
    }
    
    //return value associated with point p
    public Value get(Point2D p){
       
    }
    */
    
    //returns true if the symbol table contains point p
    public boolean contains(Point2D p){
        return true;
    }
    
    /*
    //all points in the symbol table
    public Iterable<Point2D> points(){
    }
    
    //all points that are inside or on the boundary of the rectangle 
    public Iterable<Point2D> range(RectHV rect){
    }
    */
    //returns nearest neighbor of point p or null if the symbol table is empty
    public Point2D nearest (Point2D p) {
        return p; 
    }
}
