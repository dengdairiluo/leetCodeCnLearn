type CallbackFn = (
    next: (data: number, error: string) => void,
    ...args: number[]
) => void
type Promisified = (...args: number[]) => Promise<number>

function promisify(fn: CallbackFn): Promisified {
    return async function(...args) {

        // @ts-ignore
        return new Promise((resolve, reject) => {
            fn((data: number, error: string) => {
                if (error) reject(error);
                resolve(data);
            }, ...args);
        });
    };
};



/**
 * const asyncFunc = promisify(callback => callback(42));
 * asyncFunc().then(console.log); // 42
 */