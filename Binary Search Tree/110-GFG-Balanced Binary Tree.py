class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def isheight(root):
            if root==None:
                return 0
            l=isheight(root.left)
            r=isheight(root.right)
            
            if l==-1 or r==-1:
                return -1
            
            if abs(l-r)>1:
                return -1
            return max(l,r)+1
        
        return isheight(root) != -1