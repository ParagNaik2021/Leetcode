class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p==None or q==None:
            return p==q
        
        #preorder traversal
        return p.val==q.val and self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)
        
        
        #postorder traversal
        
        #return self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right) and p.val==q.val
        
        #inorder traversal
        #return self.isSameTree(p.left,q.left) and p.val==q.val and self.isSameTree(p.right,q.right)  
        