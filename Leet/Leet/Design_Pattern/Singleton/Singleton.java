package Leet.Design_Pattern.Singleton;

import Utils.SU;

//===111====================================================================
//why final
public final class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

//	early creation
	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

}

//===222====================================================================
//Lazy instantiation using synchronized method
class Singleton2 {

	private static Singleton2 instance;//必须有一个来记忆已经创建过的instance

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}

}

//Lazy instantiation using double locking mechanism. // synchronized block
class Singleton3 {

	private static volatile Singleton3 instance;//必须有一个来记忆已经创建过的instance

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}

}

 class Singleton4 {
    private Singleton4() {
    }

    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}