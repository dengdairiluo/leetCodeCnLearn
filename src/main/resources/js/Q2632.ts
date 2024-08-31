function curry(fn: Function): Function {
    return function curried(...args: any[]) {
        if (args.length >= fn.length) { // 满足原函数的要求
            return fn.apply(this, args)
        } else {
            return function(...newArgs) { // 不满足原函数的要求
                return curried.apply(this, args.concat(newArgs))
            }
        }
    };
};


/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */