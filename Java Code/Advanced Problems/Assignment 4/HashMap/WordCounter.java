package col106.assignment4.HashMap;

public class WordCounter {

	public WordCounter(){
		// write your code here
	}

	public int count(String str, String word){
		// write your code here
	int n=0;
		if(str!=null&&word!=null) {
			
			int l=str.length();
			int w = word.length();
			
			for(int i=0;i<l;i++) {
				String temp="";
				
				if(i+w==l) {
					temp= str.substring(i);
					if(temp.equals(word)) {
						n++;
					}
					break;	
				}else {
					temp= str.substring(i,i+w);
					if(temp.equals(word)) {
						n++;
					}
				}
				
			}
			
			
		}else {
			n=0;
		}
		
		
		
		return n;
	}
}
