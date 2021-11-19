--------------------------------------------Leetcode--------------------------------------------

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        level=0
        stack=[]
        def recurrsive_right_view(root,level,stack):
            if root==None:
                return 
            if len(stack)==level:
                stack.append(root.val)
            recurrsive_right_view(root.right,level+1,stack)
            recurrsive_right_view(root.left,level+1,stack)
            
            
        recurrsive_right_view(root,level,stack)
        return stack




-------------------------------------GFG---------------------------------------------------------

class Solution:
    #Function to return list containing elements of right view of binary tree.
    def rightView(self,root):
        stack=[]
        level=0
        def recurr_rightview(root,level,stack):
            if root==None:
                return
            if len(stack)==level:
                stack.append(root.data)
            recurr_rightview(root.right,level+1,stack)
            recurr_rightview(root.left,level+1,stack)
                
        recurr_rightview(root,level,stack)
        return stack
