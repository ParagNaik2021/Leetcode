class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        preorder=[]
        stack=[]
        if root==None:
            return preorder
        stack.append(root)
        while stack:
            root=stack.pop()
            preorder.append(root.val)
            
            if root.right!=None:
                stack.append(root.right)
                
            if root.left!=None:
                stack.append(root.left)
                
        return preorder