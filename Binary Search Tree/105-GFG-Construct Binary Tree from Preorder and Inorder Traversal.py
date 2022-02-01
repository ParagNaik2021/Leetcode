class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def buildTree(preorder,prestart,preend,inorder,instart,inend,map1):
            if prestart>preend or instart>inend:
                return None

            root=TreeNode(preorder[prestart])
            inroot=map1[root.val]
            numleft=inroot-instart

            root.left=buildTree(preorder,prestart+1,prestart+numleft,inorder,instart,inroot-1,map1)
            root.right=buildTree(preorder,prestart+numleft+1,preend,inorder,inroot+1,inend,map1)
            
            return root

        map1={}
        for i in range(len(inorder)):
            map1[inorder[i]]=i
            
        root=buildTree(preorder,0,len(preorder)-1,inorder,0,len(inorder)-1,map1)
        return root
    