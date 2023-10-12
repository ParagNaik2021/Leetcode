**********************************Coding Ninja - Square Root of a number *****************************************


Binary Search :-

import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 long low=1;
		 long high= N;
		 long ans=1;
		 while(low<=high){
			  long mid=(long) (low+high)/2;
			 if(mid*mid==N){
				 return (int) mid;
			 }
			 else if(mid*mid<N){
				 low=mid+1;
				  ans=mid;
			 }
			 else{
				 high=mid-1;
				
			 }
		 }
		 return (int) ans;
	}
}
 

 Naive Approach :-

 import java.util.* ;
import java.io.*; 

public class Solution {
//Naive Approach
	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 int ans=1;
		 for(int i=0;i<=N;i++){
			 if(i*i<=N){
				 ans=i;
				 continue;
			 }
			 else{
				 break;
			 }
		 }
		 return ans;
	}
}
