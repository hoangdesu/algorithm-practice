from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        i = 0
        common_prefix = ''
        while i < len(strs[0]):
            char_to_compare = strs[0][i]
            for word in strs:
                # return if index is out of range for the current word
                # OR current char is not the same with the compare char
                if i >= len(word) or word[i] != char_to_compare:
                    return common_prefix
            common_prefix += char_to_compare
            i += 1
        return common_prefix

            
# --TESTS--

strs1 = ["flower","flow","flight"]
strs2 = ["dog","racecar","car"]
        
sol = Solution()
print(sol.longestCommonPrefix(strs1))
print(sol.longestCommonPrefix(strs2))

sol.test1()
