type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function jsonStringify(object: any): string {
    if (object === null)
        return "null";
    if (Array.isArray(object))
        return `[${(object.map(jsonStringify)).join(",")}]`
    if (typeof object === "object")
        return `{${Object.keys(object).map((key) => `"${key}":${jsonStringify(object[key])}`).join(",")}}`
    if (typeof object === "string")
        return `"${object}"`
    return String(object)
}
