//Jamie Shannon
//5/14/22
//This project makes a recursive drawing of a tree


import java.awt.Color;
import java.lang.Math;

public class ModifiedTree {
	public static void Modifiedtree(int n, double x, double y, double a, double branchRadius, double penThickness) {
        
        double bendAngle   = Math.toRadians(10);
        double branchAngle = Math.toRadians(37);
        double branchRatio = 0.65;
        Color brown = new Color(43, 29, 20);
        Color lightGreen = new Color(178, 194, 72);
        Color green = new Color(52, 124, 44);
        
        //setting up the next x and y points to draw the line with
        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;
        StdDraw.setPenRadius(penThickness);        
        
        //if statements clarifying which parts of the recursive pattern to color
        if (n >= 5) {
        	StdDraw.setPenColor(brown);
        }
        
        if (n < 5 && n >= 2) {
        	StdDraw.setPenColor(green);
        }
        
        if (n == 1) {
        	StdDraw.setPenColor(lightGreen);
        }
        
        if (n == 0) {
        	StdDraw.setPenColor(green);
        }
        
        StdDraw.line(x, y, cx, cy);
        if (n == 0) return;
         
        //recursive tree patterns with equal angles
        Modifiedtree(n-1, cx, cy, (a - bendAngle + branchAngle), branchRadius * branchRatio, penThickness * branchRatio);
        Modifiedtree(n-1, cx, cy, (a - bendAngle + (.5 * branchAngle)), branchRadius * branchRatio, penThickness * branchRatio);
        Modifiedtree(n-1, cx, cy, a - bendAngle, branchRadius * branchRatio, penThickness * branchRatio);
        Modifiedtree(n-1, cx, cy, (a -bendAngle - (.5 * branchAngle)), branchRadius * branchRatio, penThickness * branchRatio);
        Modifiedtree(n-1, cx, cy, (a - bendAngle - branchAngle), branchRadius * branchRatio, penThickness * branchRatio);
                     
    }
    
    public static void main(String[] args) {
        int n = 8;
        StdDraw.enableDoubleBuffering();      
        Modifiedtree(n, 0.5, 0, Math.PI/2, .3, .0125);
        StdDraw.show();
    }
   
}

