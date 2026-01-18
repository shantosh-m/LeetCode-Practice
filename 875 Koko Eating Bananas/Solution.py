import math

class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        maxPile = max(piles)
        left = 1
        right = maxPile
        while(left < right):
            middle = left + (right - left)//2
            if(self.canFinish(piles, middle, h)):
                right = middle
            else:
                left = middle+1
        return left
    
    def canFinish(self, piles, speed, h):
        hours = 0
        for pile in piles:
            hours += math.ceil(pile/speed)
        return hours <= h 

if __name__ == "__main__":
    sol = Solution()
    print(sol.minEatingSpeed([3,6,7,11], 8))                              #4
    print(sol.minEatingSpeed([30,11,23,4,20], 5))                         #30
    print(sol.minEatingSpeed([30,11,23,4,20], 6))                         #23