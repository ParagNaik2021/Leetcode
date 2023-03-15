 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int n=nums1.length;
        int m=nums2.length;
       // Arrays.sort(nums1);
        //Arrays.sort(nums2);
        Set<Integer> ans=new HashSet<Integer>();
        while(i<n && j<m)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else
            {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        //Insert the elements from array into an array

        int[] result=new int[ans.size()];
        int index=0;
        for(int K:ans)
            result[index++]=K;
               
        
        return result;


    }
    }