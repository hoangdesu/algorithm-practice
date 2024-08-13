package main

import "fmt"

func twoSum(nums []int, target int) []int {
	for i := 0; i < len(nums) - 1; i++ {
		for j := i+1; j < len(nums); j++ {
			if nums[i] + nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return []int{}
}

// TODO: implement two sum using map

func main() {
	fmt.Println(twoSum([]int{1, 2, 3}, 4))
	fmt.Println(twoSum([]int{2, 5, 8, 6, 1}, 9))
}
