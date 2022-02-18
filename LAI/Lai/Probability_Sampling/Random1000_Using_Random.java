package Lai.Probability_Sampling;

public class Random1000_Using_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("random1000:"+random1000());
	}

	//5,25,125,625,3125,3000+
	public static int random1000() {
		while (true) {
			int num = 0;
			for (int i = 0; i < 2; i++) {
				num = num * 5 + RandomFive.random5();
				System.out.println("num:"+num);
			}
			if (num < 21) {
				return num % 1000;
			}
		}
	}
	
	static class RandomFive{
		static int random5() {
			return (int)(Math.random() * 5);
		}
	}

}
