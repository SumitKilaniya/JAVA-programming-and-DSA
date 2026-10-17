class Solution(object):
    def minSwaps(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sorted_array=sorted(nums,key=lambda x:(sum(int(d) for d in str(x)),x))
        mapped_index={val:i for i,val in enumerate(sorted_array)}
        val_index=[mapped_index[val] for val in nums]
        visited=[False]*len(val_index)
        cycle=0
        for i in range(len(nums)):
            if not visited[i]:
                j=i
                while not visited[j]:
                    visited[j]=True
                    j=val_index[j]
                cycle+=1
        return len(nums)-cycle
        
            
        
        
        