def minDiff(self,root, K):
    if root==None:
        return 0
    mindiff=float('inf')
    closestElementNode=Node(None)

    while root:
        currdiff=abs(root.data-K)

        if currdiff< mindiff:
            mindiff=currdiff
            closestElementNode=root
        if K<root.data:
            root=root.left
        elif K>root.data:
            root=root.right
        else:
            break
    return mindiff