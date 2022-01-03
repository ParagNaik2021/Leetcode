Link-https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?source=youtube&amp;campaign=Striver_Tree_Videos&amp;utm_source=youtube&amp;utm_medium=affiliate&amp;utm_campaign=Striver_Tree_Videos



def changeTree(root): 
    if root==None:
        return 0
    child=0
    if root.left:
        child+=root.left.data
    if root.right:
        child+=root.right.data
    if child>root.data:
        root.data=child
    else:
        if root.left:
            root.left.data=root.data
        elif root.right:
            root.right.data=root.data
    changeTree(root.left)
    changeTree(root.right)
    
    
    total=0
    if root.left:
        total+=root.left.data
    if root.right:
        total+=root.right.data
    if root.left or root.right:
        root.data=total