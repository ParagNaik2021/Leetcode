class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        elements=[]
        
        if root==None:
            return None
        
        if root.left:
            elements+=self.inorderTraversal(root.left)
            
        elements.append(root.val)
        
        if root.right:
            elements+=self.inorderTraversal(root.right)
            
        return elements
        