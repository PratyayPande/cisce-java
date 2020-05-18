
import java.util.Arrays;
import java.lang.reflect.Array;

class EmptyStackException extends Exception
{
	public EmptyStackException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}
public class MyStack<T> {
	
	public T[] array;
	private int length=0;
	
	public MyStack(){
	   array = (T[])new Object[1000000];
		
	}
	
	void push(T value) {
		if(length<0)length =0;
		array[length] = value;
		length++;
	}
	T pop() throws EmptyStackException{
		
		if(length>0){
		
			T jay = null;
		for ( int i =0;i < 1000000;i++){
			if(array[i]==null) {
				jay = array[i-1];
				array[i-1] = null;
				break;
			}
		}
		length--;
		return jay;
		}
		else {
			throw new EmptyStackException("array is empty");
		}
		
	}
	T top() throws EmptyStackException{
		if(length>0){
			
			
			T pay =array[length-1];
			
			return pay;
		}
		else {
			throw new EmptyStackException("array is empty");
		}
	}
	boolean isEmpty() {
		boolean t=false;
		if(length<=0)t=true;
		return t;
	}
	void popall() {
		 T[] narray=(T[])new Object[1000000];
		 array=narray;
		 length=0;
	}

	void removnad(int i,T value) {
		array[i-1] = value;
		
		for(int k=i;k<length-2;k++) {
			array[k]=array[k+2];
		}
		array[length-1]=null;
		array[length-2]=null;
		length=length-2;
	}
	T get(int ha) {
		return array[ha];
	}
	int size() {
		return length;
	}
	
	
		
}
