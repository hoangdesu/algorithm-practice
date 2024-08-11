from typing import List

class Solution:
    def twoSum_naive(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    def twoSum_improved(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in seen:
                return [seen.get(complement), i]
            else:
                seen[nums[i]] = i
                    

test1 = ([2,7,11,15], 9)
test2 = ([3,2,4], 6)

solution = Solution()


# unpackaging argument lists (splat operator)
print(solution.twoSum_naive(*test1))
print(solution.twoSum_naive(*test2))

print(solution.twoSum_improved(*test1))
print(solution.twoSum_improved(*test2))
