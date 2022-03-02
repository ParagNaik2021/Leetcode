class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def helper(root):
            print("Here")
            if root.left==None:
                return root.right
            elif root.right==None:
                return root.left
            rightChild=root.right
            lastRight=findLastRight(root.left)
            lastRight.right=rightChild
            return root.left
        
        def findLastRight(root):
            if root.right==None:
                return root
            return findLastRight(root.right)
        
        if root==None:
            return None
        if root.val==key:
            return helper(root)
        
        dummy=root
        while root!=None:
            if root.val>key:
                if root.left!=None and root.left.val==key:
                    root.left=helper(root.left)
                    break
                else:
                    root=root.left
            else:
                if root.right!=None and root.right.val==key:
                    root.right=helper(root.right)
                    break
                else:
                    root=root.right
        return dummy
                