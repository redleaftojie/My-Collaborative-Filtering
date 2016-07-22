

import java.util.List;

public class PearsonCorrelation implements Base {
	
	public double pearsonCorrelation(List<Integer> a,List<Integer> b,List<Integer> c,List<Integer> d) {
		int num = a.size();
		int numU = c.size();
		int numV = d.size();
		double sum_prefOne = 0;
		double avg_prefOne = 0;
		double sum_prefTwo = 0;
		double avg_prefTwo = 0;
		double total1 = 0;
		double total2 = 0;
		double total3 = 0;
		double result;
		for (int i = 0; i < numU; i++) {
				sum_prefOne += c.get(i);
		}
		for (int i = 0; i < numV; i++) {
			    sum_prefTwo += d.get(i);
	}
		if (numU != 0) {
				avg_prefOne = sum_prefOne / numU;	
		}
		if (numV != 0) {
		        avg_prefTwo = sum_prefTwo / numV;	
			}
		for (int i = 0; i < num; i++){
			if (a.get(i) != 0 && b.get(i) != 0) {
				total1 += (a.get(i) - avg_prefOne) * (b.get(i) - avg_prefTwo);
				total2 += (a.get(i) - avg_prefOne) * (a.get(i) - avg_prefOne);
				total3 += (b.get(i) - avg_prefTwo) * (b.get(i) - avg_prefTwo);
			}
		}
		if (total1 != 0 && total2 != 0 && total3 != 0) {
			result = (double) (total1 / Math.sqrt(total2 * total3));
		}else {
			result = 0;
		}
	/*	double sum = num * sum_product - sum_prefOne * sum_prefTwo;
		double den = Math.sqrt((num * sum_squareOne - Math.pow(sum_squareOne, 2)) * (num * sum_squareTwo - Math.pow(sum_squareTwo, 2)));
		double result;
		if(den==0) result=0;
		else result = sum / den;*/
		return result;
	}

}
