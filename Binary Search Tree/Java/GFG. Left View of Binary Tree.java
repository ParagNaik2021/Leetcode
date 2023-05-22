*******************************Left View of a Binary Tree*****************************************

class Tree
{
    void leftViewHelper(Node root,int level,ArrayList<Integer> ans)
    {
        
        if(root==null) return ;
        if(level==ans.size()) ans.add(root.data);
        leftViewHelper(root.left,level+1,ans);
        leftViewHelper(root.right,level+1,ans);
        
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      int level=0;
      ArrayList<Integer> ans=new ArrayList<>();
      leftViewHelper(root,level,ans);
      return ans;
    }
}