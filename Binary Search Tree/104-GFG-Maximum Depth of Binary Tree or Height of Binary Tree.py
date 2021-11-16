
--------------------------------------------------------Iterative method-------------------------------------------------------------

import queue
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth=0
        if root==None:
            return depth
        Q=queue.Queue()
        Q.put(root)
        while Q.qsize()!=0:
            depth+=1
            for i in range(Q.qsize()):
                node=Q.get()
                if node.left!=None:
                    Q.put(node.left)
                if node.right!=None:
                    Q.put(node.right)
        return depth



---------------------------------------------------------Recursive method---------------------------------------------------------------

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        left= self.maxDepth(root.left)
        right= self.maxDepth(root.right)
        return 1+max(left,right)

