class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValidBST(root,minVal,maxVal):
            if root==None:
                return True
            if root.val>=maxVal or root.val<=minVal:
                return False
            return isValidBST(root.left,minVal,root.val) and isValidBST(root.right,root.val,maxVal)
