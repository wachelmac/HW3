//Rachel McMullan
//George O'Malley
//Group 7

public class PointST<Value>{
    
    RedBlackBST table=new RedBlackBST();
    
    //construct an empty symbol table of points
    public PointST(){  
    }
    
    //return true if symbol table is empty
    public boolean isEmpty(){
        return table.isEmpty();
    }
    
    //return number of points 
    public int size(){
        return table.size();
    }
    
    //associate the value val with point p
    public void put(Point2D p, Value val){
        table.put(p, val);
    }
    
    //return value associated with point p
    public Value get(Point2D p){
       return table.get(p); //this should not be a problem??
    }
    
    //returns true if the symbol table contains point p
    public boolean contains(Point2D p){
        return table.contains(p);
    }
    
    //all points in the symbol table
    public Iterable<Point2D> points(){
        return table.keys();
    }
    
    //all points that are inside or on the boundary of the rectangle 
    public Iterable<Point2D> range(RectHV rect){
        return range(rect);
    }
    
    //turns nearest neighbor of point p or null if the symbol table is empty
    public Point2D nearest (Point2D p) {
        return p; 
    }
}
