/**
 * proxy代理来解决Object.keys(this)问题
 */
// @ts-ignore
Function.prototype.callPolyfill = function (context, ...args) {
    context ||= window;
    const fn = this;
    // @ts-ignore
    const proxy = new Proxy(context, {
        get(target, prop) {
            if (prop === "fn") {
                return fn;
            }
            // @ts-ignore
            return Reflect.get(...arguments);
        },
    });
    return proxy["fn"](...args);
};


/**
 * function increment() { this.count++; return this.count; }
 * increment.callPolyfill({count: 1}); // 2
 */