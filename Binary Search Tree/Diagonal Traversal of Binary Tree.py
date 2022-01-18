from collections import deque
def diagonal(root):
    Q=deque()
    ans=[]
    
    if root==None:
        return ans
        
    Q.appendleft(root)
    
    while Q:
        curr=Q.pop() 

        while curr:
            if curr.left:
                Q.appendleft(curr.left)  #check if left of curr is present and push it on Q, so that it can be access in next iteration
            
            ans.append(curr.data)  #append curr node data in the final ans list
            curr=curr.right # move to right of curr only and exit the current diagonal iteration once the root becomes null
        
    return ans
