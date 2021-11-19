def LeftView(root):
    stack=[]
    level=0
    def recurr_left_view(root,level,stack):
        if root==None:
            return 
        if len(stack)==level:
            stack.append(root.data)
        recurr_left_view(root.left,level+1,stack)
        recurr_left_view(root.right,level+1,stack)
    
    recurr_left_view(root,level,stack)
    return stack
    