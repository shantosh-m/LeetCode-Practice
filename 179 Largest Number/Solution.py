from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: list[int]) -> str:
        # 1. Convert all integers to strings
        # We need strings to perform concatenation checks (e.g., "9" + "30")
        str_nums = list(map(str, nums))
        
        # 2. Define the Custom Comparator
        # Returns 1 if x should come AFTER y
        # Returns -1 if x should come BEFORE y
        # Returns 0 if they are equal
        def compare(x, y):
            if x + y > y + x:
                return 1  # x is "larger"
            elif x + y < y + x:
                return -1 # x is "smaller"
            else:
                return 0
        
        # 3. Sort using the comparator
        # We use reverse=True because we want the "largest" combinations first
        str_nums.sort(key=cmp_to_key(compare), reverse=True)
        
        # 4. Join the list into a single string
        largest_num = "".join(str_nums)
        
        # 5. Edge Case: Handle [0, 0] -> "00"
        # If the result starts with '0', the number is just 0
        if largest_num[0] == "0":
            return "0"
            
        return largest_num

if __name__ == "__main__":
    sol = Solution()
    print(sol.largestNumber([3, 30, 34, 5, 9])) # Output: "9534330"