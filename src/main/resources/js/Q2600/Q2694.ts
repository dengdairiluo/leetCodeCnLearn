type Callback = (...args: any[]) => any;
type Subscription = {
    unsubscribe: () => void;
};

class EventEmitter {
    // @ts-ignore
    map: Record<string, Set<Callback>> = {}
    subscribe(eventName: string, callback: Callback): Subscription {
        if (!this.map[eventName]) {
            // @ts-ignore
            this.map[eventName] = new Set();
        }
        this.map[eventName].add(callback);
        return {
            unsubscribe: () => {
                this.map[eventName].delete(callback);
            },
        };
    }

    emit(eventName: string, args: any[] = []): any {
        // @ts-ignore
        return Array.from(this.map[eventName] ?? []).map(fn => fn(...args));
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */