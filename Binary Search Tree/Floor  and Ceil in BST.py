#########################-Floor-##############################

def floorInBST(root, X):
    floor=-1
    while root:
        if root.data==X:
            floor=root.data
            return floor
        if X>root.data:
            floor=root.data
            root=root.right
        else:
            root=root.left
    return floor



#######################-Ceil-###################################

def findCeil(root, x):
    ceil=-1
    while root:
        if root.data==x:
            ceil=x
            return ceil
        if x>root.data:
            root=root.right
        else:
            ceil=root.data
            root=root.left
    return ceil