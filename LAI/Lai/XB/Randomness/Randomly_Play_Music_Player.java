package Lai.XB.Randomness;

import static Utils.ArrayUtils.swap;

import java.util.Arrays;
import java.util.Random;

public class Randomly_Play_Music_Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,2,8,3,6,9};
		MusicPlayer player = new MusicPlayer(arr, 3);
		System.out.println(""+player.playRandom());
	}
	static class MusicPlayer{
		private final int[] musics;
		private final int k;
		private int queueSize = 0;		
		private int offset;
		private Random random;
		
//		k must be >0 and < musics.length
		MusicPlayer(int[] musics, int k) {
			if(musics == null || musics.length == 0) {
				throw new IllegalArgumentException("Musics arr is Null or Empty");
			}
			if(k < 1 || k >= musics.length) {
				throw new IllegalArgumentException("K should be greater than 0 and less than arrLength!");
			}
			this.musics = Arrays.copyOf(musics, musics.length);
			this.k = k;
			this.offset = 0;
			this.queueSize = 0;
			this.random = new Random();
		}
//		[                                                                            ]
//		[0,    ,offset-k][offset-k+1, ,offset - 1][offset,                       ,n-1]
//		[               ][queue:      ��СΪ k-1  ][offset����,  ʣ���������СΪn-k+1   ]
//		
//		��һ�����ȶ�û�в���������������Ҫ���صĸ���������ȷ��index
//		�ڶ������ƶ��������䣬index����Id��offset����Id������offset����һλ�������Ҫ���Ƿ����k�ˣ�û�����ƶ�������������һλ��
//		Note: ÿһ�ε��þ������������һ�θ���
//		Note: ������queue size ���Ϊk-1
//		Note�����musics.length - queueSize�����������һ����δ�ڲ����б�ĸ�����
//		��ʼ״̬��offset==0�� queuesize==0���Ѿ����ŵ��б���[], ������������[0,n-1]����[offset,  ,offset-1]
//		״̬������δ����ǰ���Ѿ����ŵ��б���[offset-k, offset-k+1,,,,offset-1],�Ѿ�������ϵk�˲��ţ����ظ��ˡ�
//		          ������, ������������������⣬�����������k+1����Ȼ�ǲ�ͬ�ĸ�������ǰ����+��ȥk-1�����ţ��Ϳ����ˣ������Ѳ�������[offset-k+1,,,,offset-1]
//		          ���ú��Ѿ����ŵ��б���[offset-k, offset-k+1,,,,offset-1],�Ѿ�������ϵk�˲��ţ����ظ��ˡ�
//		Note:��ȥ����k�β��ű��벻ͬ�������Ѿ���k-1�β�ͬ�ˣ� ��Ҫ�ҵ�k�β�ͬ��
//		queueSize�仯��Χ[0�� k-1]
		public int playRandom() {
			int randomIndex = random.nextInt(musics.length - queueSize);
			int musicsIndex = (offset + randomIndex) % musics.length;
			swap(musics, offset, musicsIndex);
			offset = (offset++) % musics.length;
			if(queueSize < k) {//if(queueSize < k - 1	) {
				queueSize++;//update queue size	
			}
			return musics[musicsIndex];
		}
		
	}
  
  
}
