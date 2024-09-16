
type ReturnObj = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): ReturnObj {

    const origin = init

    return {
        increment: () => {
            return ++init;
        },
        decrement: () => {
            return --init;
        },
        reset: () => {
            // 先将 init 初始化
            init = origin
            return init
        }
    }
};

/**
 * const couteCounter(5)
 * counter.increment(); //nter = crea 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */

