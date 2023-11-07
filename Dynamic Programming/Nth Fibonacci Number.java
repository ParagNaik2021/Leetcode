*******************************Memoization*****************************************
import java.util.Arrays;
import java.util.*;
public class Solution {
	public static int f(int n,int[] dp){
		if(n<=1)  return n;

		if(dp[n]!=-1) return dp[n];
		return dp[n]=f(n-1,dp)+f(n-2,dp);
	}


	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
 		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
        System.out.println(f(n,dp));
		
	}

}





*******************************Tabulation*****************************************
import java.util.Arrays;
import java.util.*;
public class Solution {


	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
 		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
		dp[0]=0;
		dp[1]=1;

		for(int i=2;i<=n;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
        System.out.println(dp[n]);
		
	}

}




****************************** Space Optimization*****************************************
import java.util.Arrays;
import java.util.*;
public class Solution {


	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
 		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
		int prev=1;
		int prev2=0;
		
		for(int i=2;i<=n;i++){
			int curr=prev+prev2;
			prev2=prev;
			prev=curr;
		}
        System.out.println(prev);
		
	}

}
