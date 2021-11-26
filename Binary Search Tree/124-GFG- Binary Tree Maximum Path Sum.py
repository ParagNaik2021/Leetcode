class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxi=[0]
        maxi[0]=float("-inf")
        
        def max_path(root,maxi):
            if root==None:
                return 0 
            l=max(0,max_path(root.left,maxi))
            r=max(0,max_path(root.right,maxi))
            maxi[0]=max(maxi[0],l+r+root.val)
            return max(l,r)+root.val
        
        
        max_path(root,maxi)
        return maxi[0]