class Solution:
    def reverseString(self, s: List[str]) -> None:
        def rev_rec(left,right):
            if left< right:
                s[left],s[right]=s[right],s[left]
                rev_rec(left+1,right-1)
        rev_rec(0,len(s)-1)