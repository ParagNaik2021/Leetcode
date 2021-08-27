def minValue(root):
    if root==None:
        return None
        
    if root.left==None:
        return root.data
        
        
    return minValue(root.left)