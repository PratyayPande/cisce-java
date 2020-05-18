import java.util.Arrays;

public class StackSort{
	
	StackSort(){
		
	}
	
	String[] sort(int[] nums)  throws EmptyStackException{
		String sol ="";
	//	System.out.println(Arrays.toString(nums));

		int size=0;
		boolean check=false;
		int ques=0;
		int cheq=0;
		MyStack<Integer> fak =new MyStack<Integer>();
		for (int i=0;i<nums.length;i++) {
			if(i==0||fak.isEmpty()) {
				fak.push(nums[i]);
				sol = "push"; 
				size++;
				if(ques>0&&cheq>nums[i]) {
					check = true;
					break;
				}
				continue;
			}
			if ( nums[i]>nums[i-1] ) {
				for(int k=0;(size>0)&&(fak.top()<nums[i]);k++) {
					int s =fak.pop();
					//System.out.printf(s+" ");
					sol=sol+";"+"pop";
					size--;
					ques++;
					cheq=s;
				}
				if(ques>0&&cheq>nums[i]) {
					check = true;
					break;
				}
				fak.push(nums[i]);
				sol= sol+";"+"push";
				size++;
			}
			if( nums[i]<=nums[i-1]) {
				if(ques>0&&cheq>nums[i]) {
					check = true;
					break;
				}
				fak.push(nums[i]);
				sol= sol+";"+"push";
				size++;
			}
		}
		if(check)sol="NOTPOSSIBLE";
		else {
			for(int i=0;i<size;i++) {
				//System.out.println(fak.pop());
				sol=sol+";"+"pop";
			}
		}
		
		String[]  lawde=sol.split(";");
		     		
		return lawde;
	}
	}

