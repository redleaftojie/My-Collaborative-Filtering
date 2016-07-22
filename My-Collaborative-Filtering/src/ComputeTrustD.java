
import java.util.ArrayList;
import java.util.List;

public class ComputeTrustD {
	public double computeTrustD(int[] item1,int[] item2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> listU = new ArrayList<Integer>();
		List<Integer> listV = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < item1.length; i++) {
			if (item1[i] != 0) {
				listU.add(new Integer(item1[i]));
			}
			if (item2[i] != 0) {
				listV.add(new Integer(item2[i]));
			}
			if(item1[i] != 0 && item2[i] !=0) {
				list1.add(new Integer(item1[i]));
				list2.add(new Integer(item2[i]));
			}
			j++;
		}
		
		return new PearsonCorrelation().pearsonCorrelation(list1,list2,listU,listV);
	}

}

