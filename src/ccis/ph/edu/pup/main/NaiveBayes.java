package ccis.ph.edu.pup.main;
/*By: Ronald K. Erquiza
 *Date: 11/5/2016 7:44PM
 *Title: Naive Bayes Classifier
 */

public class NaiveBayes {
	private double[][] x; // training data for input
	private double[] y; // training data for output
	private double[] outcomes; // classes of outcomes. E.g. yes, no
	
	public NaiveBayes(double[][] x, double[] y, double[] outcomes){
		//initialization
		this.x = x;
		this.y = y;
		this.outcomes = outcomes;
	}
	
	public double classify(double[] input){
		//classifying function
		double[] classified = {-1,0};
		double[][] probXY = new double[outcomes.length][x[0].length];
		double[] probY = new double[outcomes.length];
		for(int i = 0; i < outcomes.length; i++){
			for(int j = 0; j < x[0].length; j++){
				probXY[i][j] = this.computeProbability(input[j], j, outcomes[i]);
				//probability of an attribute to a certain outcome
			}
		}
		for(int i = 0; i < outcomes.length; i++){
			probY[i] = (double)1/outcomes.length;
			for(int j = 0; j < x[0].length; j++){
				probY[i] = probY[i] * probXY[i][j];	// outcomes' probability computation
			}
		}
		for(int i = 0; i < outcomes.length; i++){
			if(probY[i] >= classified[1]){
				//comparison of outcomes' probability
				classified[0] = i; 
				classified[1] = probY[i];
			}
		}
		return outcomes[(int)classified[0]];
	}
	
	double computeProbability(double in, int col, double out){
		double n = countN(out); 				// number of outcome
		double n_c = countN_C(in, col, out); 	// number of the attribute with outcome
		double p = (double)1/outcomes.length; 	// probability of outcome
		double m = x[0].length; 				// number of attributes
		return (n_c + m * p)/(n + m);			// probability estimation
	}
	
	int countN(double out){
		int num = 0;
		for(int i = 0; i < y.length; i++){
			if(out == y[i]){
				num++;
			}
		}
		return num;
	}
	
	int countN_C(double in, int col, double out){
		int num = 0;
		for(int i = 0; i < y.length; i++){
			if(in == x[i][col] && out == y[i]){
				num++;
			}
		}
		return num;
	}
	
}
