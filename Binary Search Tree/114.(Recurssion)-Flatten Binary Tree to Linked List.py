class Solution:
    # prev=None
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        self.prev=None
        
        def helper_flat(root=root):                    
            if root==None:
                return 

            helper_flat(root.right)
            helper_flat(root.left)

            root.right=self.prev
            root.left=None
            self.prev=root
        
        helper_flat()