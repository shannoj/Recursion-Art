//Jamie Shannon
//5/14/22
//This project makes a recursive drawing of a tree but the tree has random branch angles, branch length, and color


import java.awt.Color;
import java.util.Random;

public class RandomizedRecursiveTree {
	
	public static void randomizedRecursiveTree(int n, double x, double y, double a, double branchRadius, double penThickness, float rRed, float rGreen, float rBlue){
		Random rand = new Random();
		
		//initializing the random variables
		int randomBranchAngle1 = rand.nextInt(85) + 55;
		int randomBranchAngle2 = rand.nextInt(85) + 55;
		int randomBranchAngle4 = rand.nextInt(85) + 55;
		int randomBranchAngle3 = rand.nextInt(85) + 55;
		int randomBranchAngle5 = rand.nextInt(85) + 55;
		
		//setting the range for randomBranchRadius
		double randomBranchRadius = 0.3 + rand.nextDouble() * (0.6);		
        double branchAngle1 = Math.toRadians(randomBranchAngle1);
        double branchAngle2 = Math.toRadians(randomBranchAngle2);
        double branchAngle3 = Math.toRadians(randomBranchAngle3);
        double branchAngle4 = Math.toRadians(randomBranchAngle4);
        double branchAngle5 = Math.toRadians(randomBranchAngle5);
        double branchRatio = .65;
        
        Color color = new Color(rRed, rGreen, rBlue);
        
        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;
        StdDraw.setPenRadius(penThickness);
        StdDraw.setPenColor(color);
        
        StdDraw.line(x, y, cx, cy);
        
        if (n == 0) return;
        
        randomizedRecursiveTree(n-1, cx, cy, branchAngle1, randomBranchRadius * branchRadius, penThickness * branchRatio, rRed, rGreen, rBlue);
        randomizedRecursiveTree(n-1, cx, cy, branchAngle2, randomBranchRadius * branchRadius, penThickness * branchRatio, rRed, rGreen, rBlue);
        randomizedRecursiveTree(n-1, cx, cy, branchAngle3, randomBranchRadius * branchRadius, penThickness * branchRatio, rRed, rGreen, rBlue);
        randomizedRecursiveTree(n-1, cx, cy, branchAngle4, randomBranchRadius * branchRadius, penThickness * branchRatio, rRed, rGreen, rBlue);
        randomizedRecursiveTree(n-1, cx, cy, branchAngle5, randomBranchRadius * branchRadius, penThickness * branchRatio, rRed, rGreen, rBlue);        
             
	}
	
	public static void main(String[] args) {
        int n = 8;
        Random rand = new Random();
        
        //created random colors here so the whole tree is one color
        float randomRedFloat = rand.nextFloat();
		float randomGreenFloat = rand.nextFloat();
		float randomBlueFloat = rand.nextFloat();
	
		
        StdDraw.enableDoubleBuffering();
        randomizedRecursiveTree(n, 0.5, 0, Math.PI/2, .25 , 0.015, randomRedFloat, randomGreenFloat, randomBlueFloat);
        StdDraw.show();
    }
	
}
