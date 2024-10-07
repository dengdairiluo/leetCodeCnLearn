type Obj = Record<any, any>;

function compactObject(obj: Obj): Obj {

    return JSON.parse(
        JSON.stringify(obj, (_, value) => value || undefined)
            .replace(/null/g, "")
            .replace(/,{2,}/g, ",")
            // @ts-ignore
            .replaceAll("[,", "[")
            .replaceAll(",]", "]"),
        // 也许有个神奇的正则可以一键replace
    );
}

