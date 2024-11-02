
// @ts-ignore
function* cycleGenerator(arr: number[], startIndex: number): Generator<number, void, number> {
    const arrLength = arr.length
    while (true) {
        let index = startIndex%arrLength
        index = index<0 ? index+arrLength : index
        const next = yield arr[index]
        startIndex += next
    }
};

/**
 *  const gen = cycleGenerator([1,2,3,4,5], 0);
 *  gen.next().value  // 1
 *  gen.next(1).value // 2
 *  gen.next(2).value // 4
 *  gen.next(6).value // 5
 */