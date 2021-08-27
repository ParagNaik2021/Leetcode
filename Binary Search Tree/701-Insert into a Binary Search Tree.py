class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        
        if root==None:
            root=TreeNode(val)
            return root
        
        if val <root.val:
            if root.left:
                self.insertIntoBST(root.left,val)
            else:
                root.left=TreeNode(val)
        if val> root.val:
            if root.right:
                self.insertIntoBST(root.right,val)
            else:
                root.right=TreeNode(val)
                
        return root
    