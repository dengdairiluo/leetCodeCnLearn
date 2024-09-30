
type Obj = Array<any> | Record<any, any>;

function makeImmutable(obj: Obj): Obj {
    // @ts-ignore
    let arrayHandler: ProxyHandler<Array<any>> = {
        set: (_, p) => {
            throw `Error Modifying Index: ${String(p)}`
        },
    }
    // @ts-ignore1
    let commonHandler: ProxyHandler<Record<any, any>> = {
        set: (_, p) => {
            throw `Error Modifying: ${String(p)}`
        }
    }
    // @ts-ignore
    let mutArrayHandler: ProxyHandler<Function> = {
        apply: (target: Function) => {
            // @ts-ignore
            throw `Error Calling Method: ${target.name}`
        }
    }
    let addProxy = (obj: Obj) => {
        const mutableFn = ['pop', 'push', 'shift', 'unshift', 'splice', 'sort', 'reverse']
        for (let p in obj) {
            if (typeof obj[p] === 'object' && obj[p] !== null) {
                obj[p] = addProxy(obj[p])
            }
        }
        if (Array.isArray(obj)) {
            mutableFn.forEach((fn) => {
                // @ts-ignore
                obj[fn] = new Proxy(obj[fn], mutArrayHandler)
            })
            // @ts-ignore
            return new Proxy(obj, arrayHandler)
        }
        // @ts-ignore
        return new Proxy(obj, commonHandler)
    }
    return addProxy(obj)
};

/**
 * const obj = makeImmutable({x: 5});
 * obj.x = 6; // throws "Error Modifying x"
 */
