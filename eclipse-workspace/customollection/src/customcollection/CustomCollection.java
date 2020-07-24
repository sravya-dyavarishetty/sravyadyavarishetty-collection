package customcollection;
import java.util.Arrays;

public class CustomCollection<E> {
	private Object[] x;
	private static int storage=10;
	private int size=0;
	public CustomCollection() {
		// TODO Auto-generated constructor stub
		this(10);
	}
	public CustomCollection(int cap) {
		if(cap>0)
			x=new Object[cap];
		else if(storage==0)
			x=new Object[storage];
		else
			throw new IllegalArgumentException("Invalid capacity:"+cap);
	}
	public void add(E e) {
		checkcapacity();
		x[size++]=e;
	}
	public void checkcapacity() {
		// TODO Auto-generated method stub
		if(x.length<=size) {
			int oldval=x.length;
			int newval=oldval*2;
			x=Arrays.copyOf(x, newval);
		}
	}
	public E get(int idx) {
		if(idx>=size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		return(E)x[idx];
	}
	public E remove(int idx) {
		if(idx>=size-1) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		E oldvalue=(E)x[idx];
		int numMoved=size-idx-1;
		if(numMoved>0)
			System.arraycopy(x,idx+1, x, idx, numMoved);
		x[--size]=null;
		return oldvalue;
	}
	public void print() {
		for(int i=0;i<=x.length-1;i++) {
			System.out.println(x[i]);
		}
	}
}