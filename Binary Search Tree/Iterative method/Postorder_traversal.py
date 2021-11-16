class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        postorder,s1,s2=[],[],[]
        if root==None:
            return postorder
        s1.append(root)
        while len(s1)!=0:
            root=s1.pop()
            s2.append(root)
            if root.left!=None:
                s1.append(root.left)
            if root.right!=None:
                s1.append(root.right)
                
        while len(s2)!=0:
            postorder.append(s2.pop().val)

            
        return postorder