type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Fn = (value: JSONValue) => number

function sortBy(arr: any[], fn: Function): any[] {
    return arr.sort((a, b) => fn(a) - fn(b))
};

