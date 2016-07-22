
public class ProduceMAE implements Base{
	/**
	 * MAE
	 * @param m
	 * @param test
	 * @return
	 */
	public double[] produceMAE(double[][] m,int[][]test){ 
	    double mae= 0.0;
	    double []mm=new double[TESTROWCOUNT ];
	    for(int i=0;i<TESTROWCOUNT ;i++ )  {
			 double sum_fencha= 0.0;   
			 int num=0;
		  for(int j=0;j<COLUMNCOUNT;j++){ 
		   if(test[i][j]!=0 && m[i][j]!=0.0 ){
			   sum_fencha+=Math.abs(m[i][j]-(double)test[i][j]);
			   num++;
			  }
		  }
		  if (num==0) 
			  mae=0;
		  else 
			  mae= sum_fencha/num;
		   mm[i]=mae;	
		 }
		return mm;
	  }
	/**
	 * RSME
	 * @param m
	 * @param test
	 * @return
	 */
	public double[] produceRSME(double[][] m,int[][]test){ 
	    double RSME= 0.0;
	    double []mm=new double[TESTROWCOUNT ];
	    for(int i=0;i<TESTROWCOUNT ;i++ )  {
			 double sum_fencha= 0.0;   
			 int num=0;
		  for(int j=0;j<COLUMNCOUNT;j++){ 
		   if(test[i][j]!=0 && m[i][j]!=0){
			   sum_fencha+=Math.pow(Math.abs(m[i][j]-(double)test[i][j]), 2);
			   num++;
			  }
		  }
		  if (num==0) 
			  RSME=0;
		  else 
			  RSME= Math.sqrt(sum_fencha/num);
		   mm[i]=RSME;	
		 }
		return mm;
	  }
}
