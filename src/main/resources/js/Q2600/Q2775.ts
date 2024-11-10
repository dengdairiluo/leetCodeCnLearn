type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Value = undefined | null | boolean | number | string | Value[] | { [key: string]: Value };

type Obj1 = Record<string, Value> | Array<Value>
type Obj2 = Record<string, JSONValue> | Array<JSONValue>


function undefinedToNull(obj: Record<any, any>): Record<any, any> {

    Object.keys(obj).forEach((key,idx)=>{
        const value = obj[key];
        if(value===undefined){
            obj[key] = null
        }

        if(typeof value ==='object'&&value){
            undefinedToNull(value)
        }

        // if(Array.isArray(value)){
        //     value.forEach((o)=>{
        //     })
        // }
    })
    return obj;
};
