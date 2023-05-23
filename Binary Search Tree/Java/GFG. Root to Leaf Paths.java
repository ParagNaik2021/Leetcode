*******************************GFG. Root to Leaf*****************************************

class Tree{
    public void leafPath(Node root,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> ans)
    {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            ans.add(res);
            
        }
        res.add(root.data);
        
       leafPath(root.left,new ArrayList<Integer>(res), ans);
      //  leafPath(root.left,res, ans); this will not work because
        leafPath(root.right,res, ans);
        
    }
    
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        leafPath(root,res,ans);
        return ans;
    }
    
}
