
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        Boolean flag=false;
        HashMap<Long,Long> map=new HashMap<>();
        
        long val=1;
        
        for(int i=0;i<a1.length;i++)
        {
            if(map.containsKey(a1[i]))
            {
             
                map.put(a1[i],val+1);
            }
            else
            {
                map.put(a1[i],val);
            }
        }
        
        
        for(Long j:a2)
        {
            if(map.containsKey(j) && map.get(j)>=1)
            {
              flag=true;
              val = map.get(j);
              map.put(j,val-1);
           
            }
            else
            {
                flag=false;
                break;
            }
            
        }
        if(flag==true)
        {
            return "Yes";
        }
         
        else
        {
            return "No";
        }
        
        
    }
}