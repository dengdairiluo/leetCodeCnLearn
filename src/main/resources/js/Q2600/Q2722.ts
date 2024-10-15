function join(arr1: any[], arr2: any[]): any[] {
    // @ts-ignore
    return [...arr2.reduce((res, x) => res.set(x.id, {...(res.get(x.id) ?? {}), ...x}), new Map(arr1.map(x => [x.id, x]))).values()].sort((a, b) => a.id - b.id);
}

