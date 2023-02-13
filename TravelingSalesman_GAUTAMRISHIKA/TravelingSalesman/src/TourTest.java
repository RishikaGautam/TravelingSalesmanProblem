import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//Rishika Gautam 12/16/22



public class TourTest
{	
    @Test
    public void testSizeforNormalCase() {
    	//testing the size method for a normal tour 
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	
    	int corrSize = 5;
    	assertTrue(tour.size() == corrSize);
    	
    }
    
    @Test
    public void testSizeforEmptyList() {
    	//testing the size method for an empty list
    	Tour tour = new Tour();
    	int corrSize = 0;
    	assertTrue(tour.size() == corrSize);
    }
    

    @Test
    public void testSizeforOneAddedPointInsertNearest() {
    	//testing the value of the size method after the implementation of the insertNearest method for when the initial list is empty
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertNearest(add);
    	assertTrue(tour.size()==1);
    }
    
    @Test
    public void testSizeforAddedPointInsertNearest() {
    	//testing the value of the size method after the implementation of the insertNearest method for when there is an existing tour
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertNearest(add6);
    	assertTrue(tour.size() == 6);
    	
    }
    
    @Test
    public void testSizeforOneAddedPointInsertSmallest() {
    	//testing the value of the size method after the implementation of the insertSmallest method for when the initial list is empty
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertSmallest(add);
    	assertTrue(tour.size()==1);
    }
    
    @Test
    public void testSizeforAddedPointInsertSmallest() {
    	//testing the value of the size method after the implementation of the insertSmallest method for when there is an existing tour
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertNearest(add6);
    	assertTrue(tour.size() == 6);
    }
    
    @Test 
    public void testLengthforNormalCase() {
    	//testing the length method for a normal tour 
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(0.0, 1.0);
    	Point add3 = new Point(1.0, 0.0);
    	Point add4 = new Point(1.0, 2.0);
    	Point add5 = new Point(1.0, 1.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	

    	assertTrue(tour.length() == 6.82842712474619);
    }
    
    @Test 
    public void testLengthforEmptyList() {
    	//testing the length method for when there is no tour
    	Tour tour = new Tour();
    	int corrLength = 0;
    	assertTrue(tour.size() == corrLength);
    }
    
    @Test
    public void testLengthforOnePoint() {
    	//testing the length method for when there is only one city in the tour - the length should be 0
    	
    	Tour tour = new Tour();
    	
    	assertTrue(tour.length() == 0);
    	
    }
    
    @Test
    public void testLengthforSamePoints() {
    	//testing the length method for points with the same x and y coordinates
    	Point add1 = new Point(1.0, 1.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(1.0, 1.0);
    	Point add4 = new Point(1.0, 1.0);
    	Point add5 = new Point(1.0, 1.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	
    	assertTrue(tour.length() == 0.0);
    }
    
    
    @Test
    public void testLengthforOneAddedPointInsertNearest() {
    	//testing the value of the length method after the implementation of the insertNearest method for when there is no cities in the tour
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertNearest(add);
    	assertTrue(tour.length()==0.0);
    }
    
    @Test
    public void testLengthforAddedPointInsertNearest() {
    	//testing the value of the length method after the implementation of the insertNearest method for when there is an existing tour
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertNearest(add6);
 
    	assertTrue(tour.length() == 14.142135623730951);
    }
    
    @Test
    public void testLengthforOneAddedPointInsertSmallest() {
    	//testing the value of the length method after the implementation of the insertSmallest method for when there is no cities in the tour
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertNearest(add);
    	assertTrue(tour.length()== 0.0);
    }
    
    @Test
    public void testLengthforAddedPointInsertSmallest() {
    	//testing the value of the length method after the implementation of the insertSmallest method for when there is an existing tour
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertNearest(add6);
    	
    	assertTrue(tour.length() == 14.142135623730951);
    }
    
    @Test
    public void testtoStringforNormalCase() {
    	//testing the toString method for a normal tour 
    	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	
    	String corrString = "(0.0, 0.0)\n(1.0, 1.0)\n(2.0, 2.0)\n(3.0, 3.0)\n(4.0, 4.0)\n";
    	assertEquals(tour.toString(), corrString);
    }
    
    @Test
    public void testtoStringforEmptyList() {
    	//testing the toString method for when there is no tour
    	Tour tour = new Tour();
    	assertEquals(tour.toString(), null);
    }
    
    
    @Test
    public void testtoStringforOneAddedPointInsertNearest() {
    	//testing the value of the toString method after the implementation of the insertNearest method for when there is no cities in the tour
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertNearest(add);
    	String corrString = "(1.5, 1.5)\n";
    	assertEquals(tour.toString(), corrString);

    }
    
    @Test
    public void testtoStringforAddedPointInsertNearest() {
    	//testing the value of the toString method after the implementation of the insertNearest method for when there is an existing tour
       	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertNearest(add6);
    	 
    	String corrString = "(0.0, 0.0)\n(1.0, 1.0)\n(2.0, 2.0)\n(3.0, 3.0)\n(4.0, 4.0)\n(5.0, 5.0)\n";
    	assertEquals(tour.toString(), corrString);
    }
    
    @Test 
    public void testtoStringforOneAddedPointInsertSmallest() {
    	//testing the value of the toString method after the implementation of the insertNearest method for when there is no cities in the tour
    	Point add = new Point(1.5,1.5);
    	Tour tour = new Tour();
    	tour.insertSmallest(add);
    	String corrString = "(1.5, 1.5)\n";
    	assertEquals(tour.toString(), corrString);
    }
    
    @Test
    public void testtoStringforAddedPointInsertSmallest() {
    	//testing the value of the toString method after the implementation of the insertSmallest method for when there is an existing tour
       	Point add1 = new Point(0.0, 0.0);
    	Point add2 = new Point(1.0, 1.0);
    	Point add3 = new Point(2.0, 2.0);
    	Point add4 = new Point(3.0, 3.0);
    	Point add5 = new Point(4.0, 4.0);
    	Point add6 = new Point(5.0, 5.0);
    	Tour tour = new Tour(add1, add2, add3, add4, add5);
    	tour.insertSmallest(add6);
    	 
    	String corrString = "(0.0, 0.0)\n(1.0, 1.0)\n(2.0, 2.0)\n(3.0, 3.0)\n(5.0, 5.0)\n(4.0, 4.0)\n";
    	assertEquals(tour.toString(), corrString);
    }
    
    
}
