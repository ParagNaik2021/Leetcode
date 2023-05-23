*******************************InterviewBit- Path to Given Node*****************************************

public class Solution {
    
    public boolean rootToNode(TreeNode root, ArrayList<Integer> ans,int B)
    {
        if(root==null) return false;  
        ans.add(root.val);
        if(root.val==B) return true;
              
        if(rootToNode(root.left,ans,B) || rootToNode(root.right,ans,B)){
            return true;
        }
        
        ans.remove(ans.size()-1);
        
        return false;
            
        
    }
    
    public int[] solve(TreeNode A, int B) {
        TreeNode root=A;
        ArrayList<Integer> ans=new ArrayList<>();
        rootToNode(root,ans,B);
        int[] arr = new int[ans.size()];
        //convert ArrayList to an Array
        for(int i=0;i<ans.size();i++)
        {
            
            arr[i]=ans.get(i);
        }
        return arr;
    }
}
