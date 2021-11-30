----------------------------------------------Leetcode-----------------------------------------------------------------

import queue
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root==None:
            return result
        Q=queue.Queue()            
        Q.put(root)
        LTR=True

        while Q.qsize():
            size=Q.qsize()
            row=[0]*size 
            if LTR:
                for i in range(size):
                    node=Q.get()

                    if node.left:
                        Q.put(node.left)

                    if node.right:
                        Q.put(node.right)
                    row[i]=node.val
            else:
                for i in range(size):
                    node=Q.get()

                    if node.left:
                        Q.put(node.left)

                    if node.right:
                        Q.put(node.right)
                    row[size-1-i]=node.val

            LTR=not LTR
            result.append(row)


        return result




---------------------------------------GFG----------------------------------------------------------------

from collections import deque
class Solution:
    #Function to store the zig zag order traversal of tree in a list.
    def zigZagTraversal(self, root):
        if not root:
            return []
        
        queue = deque([root])
        results = []
        flag = True
        while queue:
            subset = []
            
            for _ in range(len(queue)):
                node = queue.popleft()
                subset.append(node.data)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            if flag!=True:
                results.append(subset[::-1])
            else:
                results.append(subset)
            flag = not flag
        
        return [j for i in results for j in i]





