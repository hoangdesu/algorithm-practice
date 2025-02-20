def findMaxAverage(nums: list, k: int) -> float:
    head = 0
    tail = head + k - 1
    
    total = 0
    for i in range(tail+1):
        total += nums[i]
    
    average = float(total / k)
    
    while tail < len(nums) - 1:
        total -= nums[head]
        head += 1
        tail += 1
        total += nums[tail]
        
        new_avg = float(total / k)
        if new_avg > average: 
            average = new_avg
    
    return average
    
print(findMaxAverage([1,12,-5,-6,50,3], 4))