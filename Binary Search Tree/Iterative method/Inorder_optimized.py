from collections import deque
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack=deque()
        inorder=[]
        node=root
        while stack or node:
            if node!=None:
                stack.append(node)
                node=node.left
                
            else:
                node=stack.pop()
                inorder.append(node.val)
                node=node.right
                
        return inorder