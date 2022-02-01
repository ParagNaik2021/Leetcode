class Solution:
    def findheightleft(self,node):
        ht=0
        while node:
            ht+=1
            node=node.left
        return ht
    
    def findheightright(self,node):
        ht=0
        while node:
            ht+=1
            node=node.right
        return ht
    
    
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        
        lh=self.findheightleft(root)
        rh=self.findheightright(root)
        
        if lh==rh:
            return pow(2,(lh))-1
        
        
        return 1+ self.countNodes(root.left)+ self.countNodes(root.right)
    