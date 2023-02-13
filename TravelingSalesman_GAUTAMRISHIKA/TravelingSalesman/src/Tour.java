/**
 * <pre>
 * Name: Rishika Gaautam
 * Mrs. Kankelborg
 * Period
 * Project 1 Traveling Salesman
 * Last Revised on: 12/16/22
 * </pre>
 */
public class Tour
{
    /** 
    * Internal Node class - you may add constructors
    */
    private class Node
    {
        private Point data;
        private Node next;
        
        //creating another node constructor for inserting a Point to reduce redundancy further in the code
        public Node(Point insertP) {
        	this.data = insertP; //assigning the point to the node data
        	this.next = null; //making the next node null
        }
        
        
        public Node(Point insertP, Node insertNext){
        	this.data = insertP; //assigning the point to the node data
        	this.next = insertNext; //pointing the next node to a specified node
        	
        }
    }
    
    /**
    * Required fields
    */
    private Node home;
    private int size;
    
    /**
     * Creates an empty tour.
     */
    public Tour()
    {
    	home = null;
    	size = 0;

    }
    
    
    //creating another tour constructor that accepts five points for testing purposes 
    public Tour(Point one, Point two, Point three, Point four, Point five) {
    	Node a = new Node(one);
    	Node b = new Node(two);
    	Node c = new Node(three);
    	Node d = new Node(four);
    	Node e = new Node(five);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = a;
    	
    	home = a;
    	size += 5;
    }

    /**
     * Returns the number of points in this tour.
     */
    public int size()
    {
        return size; //returning the private field 
    }

    /**
     * Returns the length of this tour.
     */
    public double length()
    {
    	Node temp = home; //assigning a temporary node to traverse through the linked list
        double distance = 0;
        
        //looping through the linked list until the tour is over by returning to the home node
	    for(int i = 0; i < size(); i++) {
	        distance += temp.data.distanceTo(temp.next.data); //adding the distance from one node to another to the double distance
	        
	        temp = temp.next; //moving further to the next node in the list
	    }
	    return distance; //returning the total distance/length of the tour

    }

    /**
     * Returns a string representation of this tour.
     */
    @Override
    public String toString()
    {
    	Node temp = home; //assigning a temporary node to traverse through the linked list
    	String points = ""; //creating an empty string to store all the coordinates
    	
    	if(size() <= 0) { //base case for if there are no points in the list
    		return null;
    	}
    	
    	//looping through the linked list until the tour is over by returning to the home node
    	for(int i = 0; i<size(); i++) {
    		points += temp.data.toString(); //adding the Point data to the string
    		if(temp.next != null) {
    			points +=  "\n"; //creating a line indent only IF there are more values to add to the string
    		}
			
    		temp = temp.next; //moving further to the next node in the list
    		
    	}
    
    	return points; //returning the list with all the point values in x and y coordinate form
        
    }

    /**
     * Draws this tour to standard drawing.
     */
    public void draw()
    {
    	Node temp = home; //assigning a temporary node to traverse through the linked list
    	
    	//looping through the linked list until the tour is over by returning to the home node
    	for(int i = 0; i <size(); i++){
        	Point data = temp.data; 
        	Point data1 = temp.next.data;
        	data.drawTo(data1); //drawing lines to connect the points
        	temp = temp.next; //moving further to the next node in the list
        	
    	}
 
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     */
    public void insertNearest(Point p)
    {
    	Node temp = home; //assigning a temporary node to traverse through the linked list
    	
    	Node minNodeDist = null; //assigning a node that will contain the minimum distance to null
    	
    	double dist; //initializing a variable to store the distance
    	
    	double minDist = Double.MAX_VALUE; //assigning a variable to the largest possible value so that it is comparable to find the smallest distance
    	
    	//looping through the linked list until the tour is over by returning to the home node
    	for(int i = 0; i < size(); i++) {
    		dist = p.distanceTo(temp.data); //finding the distance between one node and the other
    		if(dist < minDist) { //comparing the distance with the current minimum distance
    			minDist = dist; //if the distance is smaller than the minimum distance then the minimum distance value will become the same value as the current distance
    			
    			minNodeDist = temp; //setting the node that contains the minimum distance to the current node so that it can be added to the list 
    		}
    		
    		temp = temp.next;//moving further to the next node in the list
   
    		
    	}
    	
    	if(minNodeDist == null) { //if there is no node that is the smallest (hence it is empty list for example)
    		home = new Node(p); // then creating a new node for the list and assigning it to the home value
    		home.next = home; //assigning the next value to the home as well as it is a circularly linked list 
    		
    	}else {
    	
    		//if there is a node that has the smallest distance between two nodes in the list 
    		//then inserting a new Node in between that distance with the specified point
    		minNodeDist.next = new Node(p, minNodeDist.next);  

    	}
    
    	//increasing the size of linked list as we are adding a node to the list
    	this.size++;
    	
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    	Node temp = home; //assigning a temporary node to traverse through the linked list
    	Node minNodeDistance = null; //assigning a node that will contain the minimum distance to null
    	double distance; //initializing a variable to store the distance
    	double minDistance = Double.MAX_VALUE; //assigning a variable to the largest possible value so that it is comparable to find the smallest distance
    	
    	//looping through the linked list until the tour is over by returning to the home node
    	for(int i = 0; i < size(); i++) {
    		double firstDist = temp.data.distanceTo(p); //finding the distance between the current distance and the specified point
    		double secDist = p.distanceTo(temp.next.data); //finding the distance between the point and the node after the current node
    		double thirdDist = temp.data.distanceTo(temp.next.data); //finding the distance between the current distance and the next node
    		
    		//calculating the difference between the distance with point p in between and the total distance between the current node and the next node
    		//allows us to find where in the tour we will find the smallest increase by adding the specified point in between two coordinates in the tour
    		distance = ((firstDist+secDist) - thirdDist); 
    		
    		//comparing the distance calculated above with the minDistance 
    		if(distance < minDistance) {
    			//if the distance calculated above has a smaller increase minimum distance increase then the minimum distance 
    			//value will become the same value as the current distance increase
    			minDistance = distance; 
    			minNodeDistance = temp; //setting the node that contains the minimum distance to the current node so that it can be added to the list 
    		}
    		temp = temp.next; //moving further to the next node in the list
    		
    	}
    	
    	if(minNodeDistance == null) { //if there is no node that is the smallest (hence it is empty list for example)
    		home = new Node(p); // then creating a new node for the list and assigning it to the home value
    		home.next = home; //assigning the next value to the home as well as it is a circularly linked list 
    		
    	}else {
    		//if there is a node that has the smallest distance between two nodes in the list 
    		//then inserting a new Node in between that distance with the specified point
    		minNodeDistance.next = new Node(p, minNodeDistance.next );

    	}
    	
    	//increasing the size of linked list as we are adding a node to the list
    	this.size++;
    	
    	
    }
}
