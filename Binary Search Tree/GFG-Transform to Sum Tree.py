class Solution:
    def toSumTree(self, root) :
        if root==None:
            return 0
            
        a=self.toSumTree(root.left)
        b=self.toSumTree(root.right)
        c=root.data
        root.data=a+b
        
        return a+b+c