package JavaInterviewQueston;

import org.junit.Ignore;
import org.junit.Test;

public class Problem1Test {
	Problem1 p1 = new Problem1();

	@Test
//	@Ignore
	public void test() {
//		fail("Not yet implemented");
		p1.validateString(null);
		p1.validateString("");
		p1.validateString("  ");
		p1.validateString("-");
		p1.validateString("-1");
		p1.validateString("-1");
	}

}
