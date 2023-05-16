*******************************PostOrder Traversal-->Iterative 2 stack appraoch Approach*****************************************

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

     List<Integer> postorder=new ArrayList<>();
     Stack<TreeNode> st1=new Stack<>();
    Stack<TreeNode> st2=new Stack<>();
      if(root==null) return postorder; 
        st1.push(root);
        while(!st1.isEmpty())
        {
            root=st1.pop();
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);

            st2.push(root);
        }
        while(!st2.isEmpty())  
        postorder.add(st2.pop().val);
    
    return postorder;

    }
}
