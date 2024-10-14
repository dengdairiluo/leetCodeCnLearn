async function promiseAll<T>(functions: (() => Promise<T>)[]): Promise<T[]> {
    return new Promise((resolve, reject) => {
        const resArr = []
        let resCount = 0;
        functions.forEach((fn, i) => {
            fn().then(res => {
                resArr[i] = res;
                if (++resCount == functions.length) {
                    resolve(resArr)
                }
            }).catch(reject)
        })
    })
};

--
--  const promise = promiseAll([() => new Promise(res => res(42))])
--  promise.then(console.log); // [42]
--

