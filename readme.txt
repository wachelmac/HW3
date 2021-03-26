/* *****************************************************************************
 *  Name:     
 *  NetID:     
 *
 *  Partner Name:       
 *  Partner NetID:          
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 3: K-d Trees


/* *****************************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 **************************************************************************** */
It has a private Point2D p (a point), a private int val (tree maps p to this value), 
a private RectHV rect (rectangle corresponding to the node's leftBottom and rightTop), 
and two private Nodes, leftBottom and rightTop.


/* *****************************************************************************
 *  Describe your method for range search in a k-d tree.
 **************************************************************************** */
The range method returns an Iterable<Point2D> method and took a RectHV as a parameter.
If the RectHV was null, an exception was thrown. I implemented the Queue<Point2D> class
and filled it in with all the points in the RectHV. I added a helper function that used 
nodes to help transverse through the tree.

That helper function had the same name, but returned void and took in a RectHV, a
Queue<Point2D> and a Node as parameters. If the node was null, or the RectHV intersected
node.rect, the function returned. Then, if the RectHV contained node.p, then node.p would
be added to the Queue<Point2D>. Finally, I called the function recursively using the
node's left bottom and right top.

After the helper function ended, I returned pointsInRect, the Queue that contained
all the points in the rectangle.

/* *****************************************************************************
 *  Describe your method for nearest neighbor search in a k-d tree.
 **************************************************************************** */


/* *****************************************************************************
 *  How many nearest-neighbor calculations can your PointST implementation
 *  perform per second for input1M.txt (1 million points), where the query
 *  points are random points in the unit square?
 *
 *  Fill in the table below, using one digit after the decimal point
 *  for each entry. Use at least 1 second of CPU time.
 *  (Do not count the time to read the points or to build the 2d-tree.)
 *
 *  Repeat the same question but with your KdTreeST implementation.
 *
 **************************************************************************** */


                 # calls to         /   CPU time     =   # calls to nearest()
                 client nearest()       (seconds)        per second
                ------------------------------------------------------
PointST:          60                  61.218            0.980103891

KdTreeST:         60                  61.218            0.980103891

Note: more calls per second indicates better performance.


/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
For a while I couldn't figure out how to get the drawing aspect right (how to get
the red dot to go to the nearest point to my cursor).

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings and lectures, but do
 *  include any help from people (including classmates and friends) and 
 *  attribute them by name.
 **************************************************************************** */
n/a

/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
n/a

/* *****************************************************************************
 *  If you worked with a partner, give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
I contributed most of the NearestNeighborVisual class and made some small changes to
the PointST and KdTreeST classes as well. Unfortunately, Rachel was sick and said she 
couldn't think straight, so towards the end of the project I had to do most of the work
myself because I didn't want her to be sick and stressed at the same time.

/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on  how helpful the class meeting was and on how much you learned 
 *  from doing the assignment, and whether you enjoyed doing it.
 **************************************************************************** */



/* *****************************************************************************
 *  Include the screenshots of your output.
 **************************************************************************** */
Screenshot of my output can be located at https://imgur.com/a/NQcG1ws
