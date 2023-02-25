class Solution:
	def isPlaindrome(self, S):
	    left=0
	    right=len(S)-1
	    while left<right:
	        if S[left]==S[right]:
	            left+=1
	            right-=1
	        else:
	            return 0
	    return 1