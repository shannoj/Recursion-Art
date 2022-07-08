//Jamie Shannon
//5/14/22
//This project makes a recursive drawing of the logistic equation using random colors

import java.util.Random;
import java.awt.Color;

public class MyRecursiveArt {
	public static void myRecursiveArt(int n, double lambda, double x, double y){
		
		//base case
		if (n == 0) return;
		
		//This is the difference equation for the logistic equation which exhibits chaos when lambda is > 3.6 and < 4
		double cx = y;
		double cy = lambda * x * (1-x);
		
		StdDraw.line(x, y, cx, cy);
		
		Random rand = new Random();
		float randomRedFloat = rand.nextFloat();
		float randomGreenFloat = rand.nextFloat();
		float randomBlueFloat = rand.nextFloat();
		
		Color color = new Color(randomRedFloat, randomGreenFloat, randomBlueFloat);
		
		StdDraw.setPenColor(color);
		
		//recursive step
		myRecursiveArt(n-1,lambda, cx, cy);
		
	}
	
	public static void main(String[] args) {
        int n = 5250;
        StdDraw.enableDoubleBuffering();
        Random rand = new Random();
        
        //creating a random lambda value in the chaotic range because all the drawings are interesting 
        double rLambda = 3.6 + rand.nextDouble() * .4;
        
        //x-value starts at 0.2 and y at 0.7
        myRecursiveArt(n, rLambda , 0.2 , 0.7);
        StdDraw.show();
    }
}
