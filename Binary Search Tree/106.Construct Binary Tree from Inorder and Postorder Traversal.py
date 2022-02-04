class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def buildTreePostorder(inorder,ins,ine,
                              postorder,pos,poe,map1):
            if pos>poe or ins>ine:
                return None
            
            root=TreeNode(postorder[poe])
            inroot=map1[postorder[poe]]
            numleft=inroot-ins
            
            root.left=buildTreePostorder(inorder,ins,inroot-1,
                                        postorder,pos,pos+numleft-1,map1)
            
            root.right=buildTreePostorder(inorder,inroot+1,ine,
                                         postorder,pos+numleft,poe-1,map1)
            return root
            
            
        
        if len(inorder)!=len(postorder):
            return None
        
        map1={}
        for i in range(len(inorder)):
            map1[inorder[i]]=i
        return buildTreePostorder(inorder,0,len(inorder)-1,
                                 postorder,0,len(postorder)-1,map1)
        
            
        