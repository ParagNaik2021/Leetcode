class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ###Morriss traversal
        preorder=[]
        curr=root
        while curr!=None:
            if curr.left==None:
                preorder.append(curr.val)
                curr=curr.right
            else:
                prev=curr.left
                while prev.right and prev.right!=curr:
                    prev=prev.right
                if prev.right==None:
                    prev.right=curr
                    preorder.append(curr.val)
                    curr=curr.left
                else:
                    prev.right=None
                    curr=curr.right
        return preorder