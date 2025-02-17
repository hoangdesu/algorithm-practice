from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        
        for num in nums:
            if num not in seen:
                seen.add(num)
            else:
                return True
        return False
    
s = Solution()

print(s.containsDuplicate([1,2,3,1]))
print(s.containsDuplicate([1,2,3,4]))
