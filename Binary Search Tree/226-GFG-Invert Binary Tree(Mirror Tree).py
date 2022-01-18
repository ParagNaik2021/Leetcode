################################## GFG-solution #################################################################################


class Solution:
    def mirror(self,root):
        # Code here
        if root==None:
            return 
        
        self.mirror(root.left)
        self.mirror(root.right)
        
        root.left,root.right=root.right,root.left  #python inbuilt function to swap two number or nodes
        
        #temp=root.right              #Method used is of swapping of two number with a temperory number
        #root.right=root.left
        #root.left=temp
        
        return root


################################## Leetcode-solution #########################################################################

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root==None:
            return 
    
        self.invertTree(root.left)
        self.invertTree(root.right)
    
        root.left,root.right=root.right,root.left
        
        
        return root