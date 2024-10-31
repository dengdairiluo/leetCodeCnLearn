

type Fn = (...args) => any

// @ts-ignore
declare global {
    interface Function {
        bindPolyfill(obj: Record<any, any>): Fn;
    }
}

// @ts-ignore
Function.prototype.bindPolyfill = function(obj) {
    const fn = this;
    return function(...args){
        return fn.apply(obj,args)
    }
}
