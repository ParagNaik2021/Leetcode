------------------------------------Leetcode----------------------------------------------

class Solution:
    def printBoundaryView(self, root):
        result=[]
        if root==None:
            return result
        #result.append(root.data)
        
        def isleaf(root):
            if root==None:
                return False
            if root.left==None and root.right==None:
                return True
        
        def addleftBoundary(root,res):
            cur=root.left
            temp=[]
            while cur:
                if not isleaf(cur):
                    temp.append(cur.data)
                if cur.left:
                    cur=cur.left
                else:
                    cur=cur.right
            for i in temp:
                res.append(i)
                
        def addrightBoundary(root,res):
            cur=root.right
            temp=[]
            while cur:
                if not isleaf(cur):
                    temp.append(cur.data)
                if cur.right:
                    cur=cur.right
                else:
                    cur=cur.left
            for i in temp[::-1]:
                res.append(i)
        
        def addLeaves(root,res):
            if  isleaf(root):
                res.append(root.data)
                return 
            if root.left:
                addLeaves(root.left,res)
            if root.right:
                addLeaves(root.right,res)
                
        if not isleaf(root):
            result.append(root.data)
        addleftBoundary(root,result)
        addLeaves(root,result)
        addrightBoundary(root,result)
        return result