import java.util.ArrayList;
import java.util.List;

	    // 进行初始直接信任度计算
        public class ProduceTrustDMatrix implements Base{
		public double[][] produceTrustDMatrix(int[][] trustD) {
		double[][] trustDMatrix = new double[PREFROWCOUNT][PREFROWCOUNT];
		for (int i = 0; i < PREFROWCOUNT; i++) {
			for (int j = 0; j < PREFROWCOUNT; j++) {
				if (i == j) {
					trustDMatrix[i][j] = 1;
				}
				else {
					trustDMatrix[i][j] = 
							new ComputeTrustD().computeTrustD(trustD[i], trustD[j]);
				}			
			}
		}
		return trustDMatrix;
	}

}