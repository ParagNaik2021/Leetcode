class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        elements=[]
        if root==None:
            return None
        
        elements.append(root.val)
        
        if root.left:
            elements+=self.preorderTraversal(root.left)
            
        if root.right:
            elements+=self.preorderTraversal(root.right)
            
        return elements
        