class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack=[]
        inorder=[]
        node=root
        while True:
            if node!=None:
                stack.append(node)
                node=node.left
            else:
                if len(stack)==0:
                    break
                node=stack.pop()
                inorder.append(node.val)
                node=node.right
                
        return inorder