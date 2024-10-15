type P = Promise<number>

// @ts-ignore
async function addTwoPromises(promise1: Promise<number>, promise2: Promise<number>): Promise<number> {
    let res1 = await promise1
    let res2 = await promise2

    // @ts-ignore
    return Promise.resolve(res1 + res2)
};



/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */