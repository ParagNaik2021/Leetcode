***********************************Brute Force-1********************************

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        //Brute Force
          int missing=-1,repeating=-1;
        for(int i=1;i<=n;i++)
        {
            int count=0;
          
            
            for(int j=0;j<n;j++)
            {
                if(arr[j]==i)
                {
                    count++;
                }
            }
            if(count==0) missing=i;
            
            else if(count==2) repeating=i;
            
            //if(repeating==-1 && missing==-1) break;
        }
        
        return new int[]{ repeating, missing};
    }
}



********************************Brute force-2********************************
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int repeat=-1;
        int missing=-1;
        for(int i=0;i<n;i++)
        {
           if (map.containsKey(arr[i])) {
            repeat=arr[i];
            }
            else map.put(arr[i],1);
        }
        
        for(int i=1;i<=n;i++)
        {
            if(!map.containsKey(i))
            {
                missing=i;
            }
        }
        return new int[]{repeat,missing};
    }
}

********************************Optimal solution-1********************************

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long len=arr.length;//use long len not int
         long SN=(len*(len+1))/2;
         long S2N=(len*(len+1)*(2*len+1))/6;
         long S=0;
         long S2=0;
        for(int i=0;i<n;i++)
        {
            S+=(long)arr[i];
            S2+=( long)arr[i]*( long) arr[i];
        }
         long val1=(long)S-SN;//x-y
         long val2=(long)S2-S2N;
        val2=val2/val1;
         long x=(val1+val2)/2;
         long y=x-val1;
        return new int[]{(int) x,(int)y};
        
    }
}
