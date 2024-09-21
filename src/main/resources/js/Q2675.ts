type Item = (string | number | boolean | null)[]

function jsonToMatrix(arr: any[]): Item[] {
    const result: Item[] = []
    const set = new Set<string>()

    function resolveHead(o: object, prefix: string) {
        for (const k of Object.keys(o)) {
            if (typeof o[k] === "object" && o[k] !== null)
                resolveHead(o[k], prefix + k + ".")
            else
                set.add(prefix + k)
        }
    }

    arr.forEach((o) => resolveHead(o, ""))
    const titles = Array.from(set).sort()
    const map = new Map<string,number>();
    result.push(titles)
    titles.forEach((v, i) => map.set(v, i))

    function resolveRow(o: object, prefix: string, row: Item) {
        for (const k of Object.keys(o)) {
            if (typeof o[k] === "object" && o[k] !== null)
                resolveRow(o[k], prefix + k + ".", row)
            else
                row[map.get(prefix + k)] = o[k]
        }
    }

    arr.forEach((o) => {
        const row: Item = new Array(map.size).fill("")
        resolveRow(o, "", row)
        result.push(row)
    })

    return result
}