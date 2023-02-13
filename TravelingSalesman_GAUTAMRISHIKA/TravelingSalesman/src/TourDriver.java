import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Test driver for the Tour class that reads in sample input files, outputs basic metrics such as
 * length and size (number of points), and draws the resulting tour.
 */
public class TourDriver
{
    public static void main(String[] args)
    {
        Tour test = new Tour();	
        try
        {
            String filename = "./input/mona-20k.txt"; // Try out different sample input files!
            BufferedReader bf = new BufferedReader(new FileReader(new File(filename)));
            String scale = bf.readLine();
            String[] points = scale.split(" ");
            StdDraw.setXscale(0, Double.parseDouble(points[0]));
            StdDraw.setYscale(0, Double.parseDouble(points[1]));
            String nextLine = bf.readLine();
            while (nextLine != null && !nextLine.equals(""))
            {
                // Add your code here to parse each line of the input.
            	if(nextLine.length() != 0) {
            		
            		String[] pointCoordinates = nextLine.trim().split(" "); //getting rid of excess space and making the file readable 
            		
            		double[] point = new double[2]; //creating an array to hold x and y coordinates for a point
            		
            		int count = 0; 
            		//traversing through the array holding all the point coordinates and converting it from a string representation of 
            		//the coordinates into a double integer representation of the coordinates
            		for(int i = 0; i < pointCoordinates.length; i++) {
            				
            			if(pointCoordinates[i].length()>1) {
            				point[count] = Double.parseDouble(pointCoordinates[i]); //converting the string into a double 
            				count++;
            			}
            			
            		}
            		
    
            		Point p = new Point(point[0], point[1]); //creating a point to use in the tour class - specifically insertSmallest and insertNearest
            		
            		test.insertSmallest(p); //passing point p as a parameter in the insertSmallest method
            		//test.toString();
            		//test.insertNearest(p); //passing point p as a parameter in the insertNearest method
            		//test.toString();
            		}
            	
            	
            	
                nextLine = bf.readLine();
            }
            bf.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(test);
        System.out.println("Tour length = " + test.length());
        System.out.println("Number of points = " + test.size());

        test.draw();
    }
}
