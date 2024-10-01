type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type InputObj = Record<string, JSONValue> | Array<JSONValue>;

// 多叉树节点：存储对象到父对象的引用
class MultiTreeNode {
    value: InputObj;
    parent: MultiTreeNode;
    key: string;

    constructor(value: InputObj, parent?: MultiTreeNode, key?: string) {
        this.value = value;
        this.parent = parent;
        this.key = key;
    }
}

// 是否为 JSON 对象：普通对象/数组
function isJSONObject(value: JSONValue): boolean {
    return typeof value === 'object' && value !== null;
}

// 浅拷贝对象/数组
function shallowCopy(obj: InputObj): InputObj {
    return Array.isArray(obj) ? [...obj] : { ...obj };
}

class ImmutableHelper {
    // 原始对象
    obj: InputObj;
    // 根对象的 Proxy
    proxy: InputObj;
    // 原始对象 -> 多叉树节点
    // @ts-ignore
    nodeMap: Map<InputObj, MultiTreeNode>;
    // 原始对象 -> 拷贝对象
    // @ts-ignore
    oldToNew: Map<InputObj, InputObj>;
    // 拷贝对象 -> 原始对象
    // @ts-ignore
    newToOld: Map<InputObj, InputObj>;

    constructor(obj: InputObj) {
        this.obj = obj;
        this.proxy = this.createProxy(obj);
        // 构建多叉树节点
        // @ts-ignore
        this.nodeMap = new Map();
        this.buildTree(obj)
        ;
    }

    produce(mutator: (obj: InputObj) => void): InputObj {
        // 初始化为空
        // @ts-ignore
        this.oldToNew = new Map();
        // @ts-ignore
        this.newToOld = new Map();
        mutator(this.proxy);
        // 返回根对象的拷贝对象，如果没有，说明整个对象没有被修改过，直接返回原始对象
        return this.oldToNew.get(this.obj) ?? this.obj;
    }

    buildTree(value: JSONValue, parent?: MultiTreeNode, key?: string) {
        // 对象才有多叉树节点，原始类型不考虑
        if (isJSONObject(value)) {
            const node = new MultiTreeNode(value as InputObj, parent, key);
            let keys: number[] | string[];
            if (Array.isArray(value)) {
                // @ts-ignore
                keys = Array.from({length: value.length}, (el, i) => i);
            } else {
                // @ts-ignore
                keys = Object.keys(value);
            }
            // 遍历对象属性/数组元素
            keys.forEach(subKey => this.buildTree(value[subKey], node, subKey));
            // 保存到 nodeMap，用于后续查询父对象
            this.nodeMap.set(value as InputObj, node);
        }
    }

    createProxy(obj: InputObj): InputObj {
        // @ts-ignore
        return new Proxy(obj, {
            set: (target, key, newVal, receiver) => {
                const oldVal = target[key];
                // 值未修改：不做处理
                if (oldVal === newVal) {
                    return true;
                }
                // target 有可能是拷贝对象，取出对应的原始对象
                const oldObj = this.newToOld.get(target) ?? target;
                // 原始对象的多叉树节点
                let node = this.nodeMap.get(oldObj);
                // 上一个对象是否拷贝过
                let lastModify = true;
                while (node) {
                    // 原始对象的拷贝对象
                    let cloned = this.oldToNew.get(node.value);
                    // 如果当前对象和上一个对象都拷贝过，则结束向上遍历
                    if (cloned && !lastModify) {
                        break;
                    }
                    lastModify = cloned === undefined;
                    // 没拷贝过则浅拷贝对象，并保存到 Map
                    if (!cloned) {
                        cloned = shallowCopy(node.value);
                        this.oldToNew.set(node.value, cloned);
                        this.newToOld.set(cloned, node.value);
                    }
                    // 在拷贝对象上修改属性
                    cloned[key] = newVal;
                    // 后续：修改父对象属性为当前拷贝对象
                    key = node.key;
                    newVal = cloned;
                    node = node.parent;
                }
                return true;
            },
            get: (target, key, receiver) => {
                // 如果 target 之前被修改过，则会创建相应的拷贝对象，优先使用拷贝对象
                const res = (this.oldToNew.get(target) ?? target)[key];
                // 每次返回都创建一次 Proxy，保证深层拦截
                return isJSONObject(res) ? this.createProxy(res) : res;
            },
        });
    }
}

/**
 * const originalObj = {"x": 5};
 * const mutator = new ImmutableHelper(originalObj);
 * const newObj = mutator.produce((proxy) => {
 *   proxy.x = proxy.x + 1;
 * });
 * console.log(originalObj); // {"x: 5"}
 * console.log(newObj); // {"x": 6}
 */