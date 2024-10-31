type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function deepMerge(obj1: any, obj2: any): any {
    if (typeof obj2 !== 'object' || obj2 === null) return obj2;
    if (typeOf(obj1) !== typeOf(obj2)) return obj2;
    for (const key in obj2) {
        obj1[key] = deepMerge(obj1[key], obj2[key]);
    }
    return obj1;
};

function typeOf(obj: any): string {
    return Object.prototype.toString.call(obj).slice(8, -1);
}


/**
 * let obj1 = {"a": 1, "c": 3}, obj2 = {"a": 2, "b": 2};
 * deepMerge(obj1, obj2); // {"a": 2, "c": 3, "b": 2}
 */