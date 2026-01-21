class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if(len(nums1) > len(nums2)):
            return self.findMedianSortedArrays(nums2, nums1)
        
        x = len(nums1)
        y = len(nums2)

        start = 0
        end = x

        while(start <= end):

            xPart = (start + end)//2
            yPart = (x+y+1)//2 - xPart

            xLeft = -(float('inf')) if xPart == 0 else nums1[xPart-1]
            xRight = (float('inf')) if xPart == x else nums1[xPart]

            yLeft = -(float('inf')) if yPart == 0 else nums2[yPart-1]
            yRight = (float('inf')) if yPart == y else nums2[yPart]

            if(xLeft <= yRight and yLeft <= xRight):
                if((x+y+1)%2 == 0):
                    return max(xLeft, yLeft)
                else:
                    return (max(xLeft, yLeft) + min(xRight, yRight))/2
            elif(xLeft > yRight):
                end = xPart - 1
            else:
                start = xPart + 1
        return 0

if __name__ == "__main__":
    sol = Solution()
    print(sol.findMedianSortedArrays([1, 3] , [2]))                 #2.00000
    print(sol.findMedianSortedArrays([1, 2] , [3, 4]))              #2.50000
