package JavaInterviewQueston;

import java.util.SortedMap;

interface BeaconEncoder {
	enum TruncationStyle {
		INTEGER, STRING_LEFT, STRING_RIGHT
	}

	void addFieldTruncationRule(String fieldName, TruncationStyle style,
			int maxWidth);

	void addArrayTruncationRule(String fieldName, int maxArrayWidth,
			TruncationStyle elemStyle, int maxElemWidth);

	String encode(SortedMap<String, Object> data);
}

public class AppDynamics_BeaconEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
