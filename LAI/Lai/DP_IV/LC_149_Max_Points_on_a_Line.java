package Lai.DP_IV;

import java.util.HashMap;
import java.util.Map;

import Utils.ArrayUtils;

public class LC_149_Max_Points_on_a_Line {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] points = ArrayUtils.convertStr2TwoDimensionIntArr("[[1,1],[2,2],[3,3]]");
		ArrayUtils.convertSquareBracketStr2IntArrCurlyBraceStr("[[1,1],[2,2],[3,3]]");
		int[][] points = {{1,1},{2,2},{3,3}};
		System.out.println(""+maxPoints(points));
		
	}
    public static int maxPoints(int[][] points) {
        int result = 0;
        if(points == null || points.length < 1){
            return 0;
        }        
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            int countSame = 1;//represents its self
            int countX = 0;
            int count = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j != i && j < points.length; j++){//to find others
                int[] other = points[j];
                if(other[0] == point[0] && other[1] == point[1]){
                    countSame++;
                }else if(other[0] == point[0]){
                    countX++;
                }else{
                    Double slope = (other[1] - point[1] + 0.0) / (other[0] - point[0]);
                    Integer numOfLines = map.get(slope);
                    numOfLines = numOfLines == null ? 1 : numOfLines + 1;
                    map.put(slope, numOfLines);
                    count = Math.max(count, numOfLines );
                }
            }
            count = countSame + Math.max(countX, count);
            result = Math.max(result, count);            
        }
        return result;
    }
	

}
