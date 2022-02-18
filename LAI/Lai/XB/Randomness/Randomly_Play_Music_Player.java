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
//		[               ][queue:      大小为 k-1  ][offset在这,  剩余子区间大小为n-k+1   ]
//		
//		第一步：先对没有播放区域，随机求出需要返回的歌曲，或者确定index
//		第二步：移动更新区间，index处的Id和offset处的Id交换，offset右移一位，左边需要看是否等于k了，没有则不移动，等于则右移一位。
//		Note: 每一次调用就死，对区间的一次更新
//		Note: 结论是queue size 最大为k-1
//		Note：针对musics.length - queueSize的随机采样，一定是未在播放列表的歌曲，
//		起始状态：offset==0， queuesize==0，已经播放的列表是[], 待播放区间是[0,n-1]或者[offset,  ,offset-1]
//		状态分析：未调用前，已经播放的列表是[offset-k, offset-k+1,,,,offset-1],已经出现联系k此播放，不重复了。
//		          调用中, 如果接着在上面区间外，随机抽样，则k+1个必然是不同的歌曲，当前播放+过去k-1个播放，就可以了，所以已播放区间[offset-k+1,,,,offset-1]
//		          调用后，已经播放的列表是[offset-k, offset-k+1,,,,offset-1],已经出现联系k此播放，不重复了。
//		Note:过去连续k次播放必须不同，就是已经有k-1次不同了， 需要找第k次不同的
//		queueSize变化范围[0， k-1]
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
