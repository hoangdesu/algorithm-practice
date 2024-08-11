class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        table = {}
        
        for num in nums:
            if num not in table:
                table[num] = 1
            else:
                table[num] += 1
        
        for v in table.values():
            if v > 1:
                return True
        
        return False
            
        
        