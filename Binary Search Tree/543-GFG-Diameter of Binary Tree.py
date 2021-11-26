---------------------Leetcode----------------------------

#we need to pass a list to the function

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        def diameter(root,max_dia):
            
            if root==None:
                return 0
            
            
            l=diameter(root.left,max_dia)
            r=diameter(root.right,max_dia)
            
            max_dia[0]=max(max_dia[0],l+r)
            return max(l,r)+1
            
        max_dia=[0]
        diameter(root,max_dia)
        return max_dia[0]
            



----------------------------GFG------------------------
#Another way in which we not pass a list

class Solution:
    
    #Function to return the diameter of a Binary Tree.
    def diameter(self,root):
        # Code here
        self.maxi=0
        self.is_diameter(root)
        return 1+self.maxi
        
    def is_diameter(self,root):
        if root==None:
            return 0
        
        l=self.is_diameter(root.left)
        r=self.is_diameter(root.right)
        self.maxi=max(self.maxi,l+r)
        return 1+max(l,r)
