*************************Optimal Solution********************************************

TC-->O(Summation of Number of nodes)
SC-->O(1)

class GfG
{
    Node mergeTwoLists(Node a ,Node b)
    {
        Node temp=new  Node(0);
        Node res=temp;
        
        while(a!=null && b!=null)
        {
            if(a.data<b.data)
            {
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }
            else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
        }
        //if a or b remain after comparision we will direct add it to temp
        if(a!=null) temp.bottom=a;
        else temp.bottom=b;
        
        return res.bottom;
        
    }
    Node flatten(Node root)
    {
   // Your code here
   if(root==null || root.next==null) return root;
   
   //start recurssion till you reach the last LL
   root.next=flatten(root.next);
   
   //Now start merging based on which is big
   root=mergeTwoLists(root,root.next);
   
   return root;
   
    }
}