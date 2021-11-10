Leetcode-

import queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        l=[]
        if root==None:
            return l
        Q=queue.Queue()
        Q.put(root)
        while Q.qsize()!=0:
            level=[]
            for i in range(Q.qsize()):
                node=Q.get()
                if node.left!=None:
                    Q.put(node.left)
                if node.right!=None:
                    Q.put(node.right)
                level.append(node.val)
                
            l.append(level)
        return l



-------------------------------------------------------GFG------------------------------------------------------------


import queue
class Solution:
    #Function to return the level order traversal of a tree.
    def levelOrder(self,root ):
        ans=[]
        if root==None:
            return 0
        Q=queue.Queue()
        Q.put(root)
        
        while Q.qsize()!=0:
            for i in range(Q.qsize()):
                node=Q.get()
                if node.left!=None:
                    Q.put(node.left)
                if node.right!=None:
                    Q.put(node.right)
                ans.append(node.data)
        return ans