class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left: int = 0
        right: int = len(nums)-1
        while(left <= right):
            mid: int = (left + right)//2
            if(nums[mid] == target):
                return mid
            else:
                if(nums[mid] < nums[right]):                # right sorted
                    if(nums[mid] < target and target <= nums[right]):
                        left = mid+1
                    else:
                        right = mid-1
                else:                                       #left sorted
                    if(nums[left] <= target and target <nums[mid]):
                        right = mid-1
                    else:
                        left = mid+1
        return -1
    
if __name__ == "__main__":
    # Create an instance of Solution to call the method
    sol = Solution()
    print(sol.search([4, 5, 6, 7, 0, 1, 2], 0))  # Output: 4
    print(sol.search([4, 5, 6, 7, 0, 1, 2], 3))  # Output: -1
    print(sol.search([1], 0))                    # Output: -1
