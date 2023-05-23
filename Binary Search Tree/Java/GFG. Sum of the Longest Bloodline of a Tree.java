*******************************GFG. Sum of the Longest BloodLine of a Tree*****************************************

class Solution{
    void sumOfHelper(Node root,int level,int sum,int[] ans)
    {
        if(root==null)
        {
            if(level>ans[0])
            {
                ans[0]=level;
                ans[1]=sum;
            }
            else if(level==ans[0])
            {
                ans[1]=Math.max(sum,ans[1]);
            }
            return;
        }
        sum+=root.data;
        sumOfHelper(root.left,level+1,sum,ans);
        sumOfHelper(root.right,level+1,sum,ans);
        
    }
    
    
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        int[] ans=new int[]{0,0};
        int level=1;
       // int maxLevel=ans[0];
        int sum=0;
        //int maxSum=ans[1];
        
        
        sumOfHelper(root,level,sum,ans);
        return ans[1];
    }
}
