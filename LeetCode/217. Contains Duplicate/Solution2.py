class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        table = {}
        
        for num in nums:
            if num not in table:
                table[num] = 1
            else:
                return True
        
        return False
