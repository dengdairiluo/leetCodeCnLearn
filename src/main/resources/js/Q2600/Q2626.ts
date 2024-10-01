type Fn = (accum: number, curr: number) => number

function reduce(nums: number[], fn: Fn, init: number): number {
    if (nums.length === 0) return init;
    for (const num of nums) init = fn(init, num);
    return init;
}

