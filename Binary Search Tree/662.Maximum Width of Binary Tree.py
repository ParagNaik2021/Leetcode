class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        ans=0
        Q=[(root,0)]
        while Q:
            size=len(Q)
            mmin=Q[0][1]
            for i in range(size):
                q1=Q.pop(0)
                node=q1[0]
                curr_id=q1[1]
                if i==0:
                    first=curr_id    
                if i==size-1:
                    last=curr_id
                if node.left:
                    Q.append((node.left,2*curr_id+1))
                if node.right:
                    Q.append((node.right,2*curr_id+2))
            ans=max(ans,last-first+1)        
        return ans
                