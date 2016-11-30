package ccis.ph.edu.pup.main;


public class SampleIntegration {
	// This is just an example of how to use Naive Bayes Classifier
	final public static double RED = 1;
	final public static double YELLOW = 2;
	final public static double SPORT = 1;
	final public static double SUV = 2;
	final public static double DOMESTIC = 1;
	final public static double IMPORTED = 2;
	final public static double YES = 1;
	final public static double NO = 0;
	
		public static void main(String[] args){
			// training data for inputs
			// put this on a 2 dimensional array
			double[][] x = {{RED, SPORT, DOMESTIC},
					{RED, SPORT, DOMESTIC}, 
					{RED, SPORT, DOMESTIC}, 
					{YELLOW, SPORT, DOMESTIC},
					{YELLOW, SPORT, DOMESTIC},
					{YELLOW, SUV, IMPORTED}, 
					{YELLOW, SUV, IMPORTED},
					{YELLOW, SUV, DOMESTIC},
					{RED, SUV, IMPORTED},
					{RED, SPORT, IMPORTED}};
			
			// training data for outcomes
			double[] y = {YES,
					NO, 
					YES, 
					NO,
					YES,
					NO, 
					YES,
					NO,
					NO,
					YES};
			
			// possible outcomes
			double[] out = {NO, YES};
			String[] outcomes = {"NO", "YES"};
			// user's input
			double[] input = {RED, SUV, DOMESTIC};
			
			// Algorithm instantiation
			NaiveBayes nbc = new NaiveBayes(x,y,out);
			
			// classification
			System.out.println("Is the car stolen? " + outcomes[(int)nbc.classify(input)]);
		}
}
