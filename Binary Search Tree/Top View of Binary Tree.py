class Solution:
    #Function to return a list of nodes visible from the top view 
    #from left to right in Binary Tree.
    def topView(self,root):
        dic = {}
        view=[]
        if not root:
            return ret
        q = deque([(root, 0)])
        while q:
            cur = q.popleft()
            line=cur[1]
            node=cur[0]
            if line not in dic:
                dic[line] = node.data    
            if node.left:
                q.append((node.left, line - 1))
            if cur[0].right:
                q.append((node.right, line + 1))
                
        for i in sorted(dic):
            view.append(dic[i])
        return view