*******************************Height of Binary-->Recurssive Approach*****************************************

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0; //Base Condition
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }
}

Time Complexity: O(N) 
Space Complexity: O(1) Extra Space + O(H) Recursion Stack space, where “H”  is the height of the binary tree.

*******************************LevelOrder Traversal approach*****************************************


class Solution {
    public int maxDepth(TreeNode root) {
       // List<Integer> levelOrder=new ArrayList<>();
        Queue<TreeNode> Q=new LinkedList<>();
        if(root==null) return 0;
        int count=0;
        Q.offer(root);
        while(!Q.isEmpty())
        {
            int levelNum=Q.size();
            count+=1;
            for(int i =0;i<levelNum;i++)
            {
                
                if(Q.peek().left!=null) Q.offer(Q.peek().left);
                if(Q.peek().right!=null) Q.offer(Q.peek().right);
                Q.poll();
            }
        }
        return count;
    }   
}


Time Complexity: O(N) 
Space Complexity: O(N) ( Queue data structure is used )