class ArrayWrapper {
    private _nums: number[]

    constructor(nums: number[]) {
        this._nums = nums
    }

    valueOf() {
        return this._nums.reduce((sum, cur) => sum + cur, 0)
    }

    toString() {
        return `[${this._nums}]`;
    }
};



/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */