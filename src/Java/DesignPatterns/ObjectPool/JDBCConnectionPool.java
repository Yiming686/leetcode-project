package Java.DesignPatterns.ObjectPool;

public class JDBCConnectionPool {

	public JDBCConnectionPool(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
		f=2;
	}
	public JDBCConnectionPool() {
		// TODO Auto-generated constructor stub
		f=2;
	}

	public Connection checkOut() {
		// TODO Auto-generated method stub
		return null;
	}

	public void checkIn(Connection con) {
		// TODO Auto-generated method stub
		
	}
	private static int a = 8;
	private final int f;
//	private static final int s;
	private static final JDBCConnectionPool s2;
	static{
		s2 = new JDBCConnectionPool();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 9;
		System.out.println(""+a);
	}
}
