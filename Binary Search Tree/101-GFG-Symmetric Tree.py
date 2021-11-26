class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isSymm(left,right):
            if left==None or right==None:
                return left==right
            if left.val!=right.val:
                return False
            return isSymm(left.left,right.right) and isSymm(left.right,right.left)
        
        return root==None or isSymm(root.left,root.right)