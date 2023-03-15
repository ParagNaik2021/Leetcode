
//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
       /* //Brute force approach
        TC---->O(N1 Log N + N2 Log N) +O(N1 + N2)
        SC---->O(N)
        Set<Integer> set=new HashSet<Integer>();
        ArrayList<Integer> union_arr=new ArrayList<Integer>();
        for(int i=0;i<arr1.length;i++)
        {
            set.add(arr1[i]);
        }
        
         for(int i=0;i<arr2.length;i++)
        {
            set.add(arr2[i]);
        }
        
        for(Integer k:set)
        union_arr.add(k);
        
        Collections.sort(union_arr);
        return union_arr;*/
        
        
        //Optimal Aproach---->
        
        int i = 0;
        int j = 0;
        ArrayList<Integer> union_arr = new ArrayList<Integer>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) 
            {
                if (union_arr.size() == 0 || union_arr.get(union_arr.size() - 1) != arr1[i])
                    union_arr.add(arr1[i]);
                i++;
            }
             else 
             {
                if (union_arr.size() == 0 || union_arr.get(union_arr.size() - 1) != arr2[j])
                   union_arr.add(arr2[j]);
                j++;
                }
            
            
        }
            
            
            while (i < n) // IF any element left in arr1
                  {
                    if (union_arr.get(union_arr.size()-1) != arr1[i])
                      union_arr.add(arr1[i]);
                    i++;
                  }
            
            while (j < m) // If any elements left in arr2
                  {
                    if (union_arr.get(union_arr.size()-1) != arr2[j])
                        union_arr.add(arr2[j]);
                    j++;
                  }
                            
            
        
        
        return union_arr;
    }
}

