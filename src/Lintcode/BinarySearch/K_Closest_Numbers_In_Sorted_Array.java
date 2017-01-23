package Lintcode.BinarySearch;

public class K_Closest_Numbers_In_Sorted_Array {

    public static int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        //base cases
        int[] arr = new int[k];
        if(A==null || A.length == 0 || k <= 0) return arr;
        //��ʼ�����������һ��Ԫ�أ�����Ԫ�غ�����Ԫ�����ϵ����
        int len = A.length;
        int start = 0;
        int end = len - 1;
        //��ʱ��������������Ԫ��
        while(start + 1 < end){
            //����mid
            int mid = start + (end - start)/2;
            //������ֵ
            int leftAbs = Math.abs(A[mid] - target);
            int rightAbs = Math.abs(A[mid+1] - target);
            //�Ƚ���ֵ��Ȼ�����ƶ�start����end�������붯����
            //�����ǳ���Ҫ����absRight>absLeft�������ң���֮�������ң����ұ������mid
            if(rightAbs>leftAbs){
                end = mid;
            }else{
                start = mid;
            }
        }
        //��ʱ����ֻ��һ����������Ԫ��
        int leftAbs = Math.abs(A[start] - target);
        int rightAbs = Math.abs(A[end] - target);
        //�õ�����Ԫ�ص��±�
        int curr = (rightAbs >= leftAbs) ? start: end; 
        
        //��0��Ԫ���Ѿ��ҵ�
        arr[0] = A[curr];
        
        //������ָ�룬�������ң�ʣ�µ�k-1��ֵ�����Ҳ���������
        int left = curr - 1;
        int right = curr + 1;
        //iΪindex����Ϊ�������ҵ�Ե�ʣ�����i�������
        //���Ա���ǵã�i������4���ط����֣�1��ʼ����2check��3��ֵ��4����
        int i  = 1;
        while( i < k ){
            //���left��right������Ч��Χ[0�� len-1]��
            //left�϶�С��len��right�϶�����0,����left--��right++
            if(left >=0  && right < len ){
                 leftAbs = Math.abs(A[left] - target);
                 rightAbs = Math.abs(A[right] - target);
                 if(leftAbs <= rightAbs){
                     curr = left;
                     left--;
                 }else{
                     curr = right;
                     right++;
                 }
                arr[i] = A[curr];
            //left����[0, len-1]��Χ
            }else if(left < 0){
                arr[i] = A[right];
                right++;
            }else{
                arr[i] = A[left];
                left--;
            }
            i++;
        }
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,8,12,16,28,38};
		int target = 26;
		int k = 4;
		int[] arr = kClosestNumbers(A, target, k);
//		System.out.println(""+Arrays.asList(kClosestNumbers(A, target, k)));
		for(int i : arr){
			System.out.print(" "+i);
		}
	}

}
