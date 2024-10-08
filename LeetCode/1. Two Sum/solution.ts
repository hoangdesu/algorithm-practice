function twoSumNaive(nums: number[], target: number): number[] {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) return [i, j];
        }
    }
    return [] as number[];
};

// const test1 = [, 9]
console.log(twoSumNaive([2,7,11,15], 9));
