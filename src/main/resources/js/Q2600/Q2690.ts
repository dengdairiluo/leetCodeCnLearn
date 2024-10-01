function createInfiniteObject(): Record<string, () => string> {
    // @ts-ignore
    return new Proxy({}, {
        get: (_: any, prop: any) => () => prop,
    });
}


/**
 * const obj = createInfiniteObject();
 * obj['abc123'](); // "abc123"
 */