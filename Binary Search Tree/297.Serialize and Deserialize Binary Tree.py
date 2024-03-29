
class Codec:
    def serialize(self, root):
        def serial(root):
            if root!=None:
                val.append(str(root.val))
                serial(root.left)
                serial(root.right)
            else:
                val.append("x")
        val=[]
        serial(root)
        return " ".join(val)
        
    def deserialize(self, data):
        def deserial():
            val1=next(val)
            if val1=="x":
                return 
            node=TreeNode(int(val1))
            node.left=deserial()
            node.right=deserial()
            return node
        
        val=iter(data.split())
        #print([val1 for val1 in val])   #output--->['1', '2', 'x', 'x', '3', '4', 'x', 'x', '5', 'x', 'x']
        return deserial()
        