class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        elements=[]
        if root==None:
            return None
        
        if root.left:
            elements+=self.postorderTraversal(root.left)
            
        if root.right:
            elements+=self.postorderTraversal(root.right)
            
        elements.append(root.val)
        
        return elements
        