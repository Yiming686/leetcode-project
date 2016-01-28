package Lintcode.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
	  final Lock lock = new ReentrantLock();          //������  
	  final Condition notFull  = lock.newCondition(); //д�߳���  
	  final Condition notEmpty = lock.newCondition(); //���߳���  
	  
	  final Object[] items = new Object[100];//�������  
	  int putptr;  //д����  
	  int takeptr; //������  
	  int count;   //������������Ŀ  
	  
	  //д  
	  public void put(Object x) throws InterruptedException {  
	    lock.lock(); //����  
	    try {  
	      // �����������������<д�߳�>  
	      while (count == items.length) {  
	        notFull.await();   
	      }  
	      // д����У�������д����  
	      items[putptr] = x;   
	      if (++putptr == items.length) putptr = 0;   
	      ++count;  
	  
	      // ����<���߳�>  
	      notEmpty.signal();   
	    } finally {   
	      lock.unlock();//�������   
	    }   
	  }  
	  
	  //��   
	  public Object take() throws InterruptedException {   
	    lock.lock(); //����   
	    try {  
	      // ������пգ�������<���߳�>  
	      while (count == 0) {  
	         notEmpty.await();  
	      }  
	  
	      //��ȡ���У������¶�����  
	      Object x = items[takeptr];   
	      if (++takeptr == items.length) takeptr = 0;  
	      --count;  
	  
	      // ����<д�߳�>  
	      notFull.signal();   
	      return x;   
	    } finally {   
	      lock.unlock();//�������   
	    }   
	  }   
}
