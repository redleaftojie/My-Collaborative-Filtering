import java.util.ArrayList;
import java.util.List;

public class GetScore implements Base {
	
	public static double [][]getScore(int[][] user_movie_base,double[][] combineMatrix ){
	
	double[][] matrix = new double[PREFROWCOUNT][COLUMNCOUNT];
	// 进行评分预测
	List<Integer> neighborSerial = new ArrayList<Integer>();
	for (int i = 0; i < PREFROWCOUNT; i++) {
		neighborSerial.clear();
		double max = 0;
		int j = 0;
		int itemSerial = 0;
		int itemId = 0;
		int valueU = 0 ;
    	double sumValueU = 0;
    	double avgValueU = 0;                  	  //添加目标用户的平均评分avgValueU                              	
    	for(int x = 0 ;x < COLUMNCOUNT; x++){
    	if(user_movie_base[i][x] > 0){
    		sumValueU += user_movie_base[i][x];
    		valueU++;
    	}  	   
    	}
    	avgValueU = sumValueU/valueU;
		for (; j < COLUMNCOUNT; j++) {
			if (user_movie_base[i][j] == 0) {
				double similaritySum = 0;
				double sum = 0;
				double score = 0;
				int num;
				int value = 0 ;
            	double sumValue = 0;
            	double avgValue = 0;
				// 该方法有三个参数，user_movie_base[i]表示某一用户对所有项目的评分；i表示某个用户的序号；combineMatrix表示用户间的相似性
				neighborSerial = new FindKNeighbors().findKNeighbors(user_movie_base[i], i, combineMatrix);
				num = neighborSerial.size();    
            	for (int m = 0; m < neighborSerial.size(); m++) {
                	 value = 0 ;
                	 sumValue = 0;
                	 avgValue = 0;
	               	for(int x = 0 ;x < COLUMNCOUNT; x++){
	                	if(user_movie_base[neighborSerial.get(m)][x] > 0){
	                		sumValue += user_movie_base[neighborSerial.get(m)][x];
	                		value++;
	                	}	    
	                	}
               	    avgValue = sumValue/value;
               	    if(user_movie_base[neighborSerial.get(m)][j] != 0){
					sum += (combineMatrix[i][neighborSerial.get(m)]) * (user_movie_base[neighborSerial.get(m)][j] - avgValue );
               	    }else {
					sum += 0;	
					}
					similaritySum += Math.abs(combineMatrix[i][neighborSerial.get(m)]);
				}
				if (similaritySum == 0)
					score = avgValueU;
				else
					score = avgValueU + (sum / similaritySum);
				itemId = j;
				matrix[i][itemId] = score;
			}			
		}
	}
	return matrix;
	}
}
