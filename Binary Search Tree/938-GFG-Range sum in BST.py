Recurssive approach-

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        
        def rangesum(root):
            if root:
                #print(root.val,self.s)
                if root.val>=low and root.val<=high:
                    self.s+=root.val
                if root.val>low:
                    rangesum(root.left)
                if root.val<high:
                    rangesum(root.right)   
                    
                print(root.val,self.s)
        self.s=0
        rangesum(root)
        return self.s

------------------------------------------------------------------------------------------------------------------------
Iterative approach-

def getCount(root,low,high):
    ##Your code here
    stack=[]
    if root==None:
        return 0
    stack.append(root)
    s=0
    while stack:
        current=stack.pop()
        if low<=current.data<=high:
            s+=1
        if current.data>low and current.left!=None:
            stack.append(current.left)
            
        if current.data< high and current.right!=None:
            stack.append(current.right)
            
    return s