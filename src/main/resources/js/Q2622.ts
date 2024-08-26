type Entry = { value: any, expiration: number, overwritten: boolean };

class TimeLimitedCache {
    cache = new Map<string, Entry>();

    *handleExpiredData() {
        const now = Date.now();
        for (const [key, { expiration, overwritten }] of this.cache) {
            if (!overwritten && expiration < now) {
                this.cache.delete(key);
            }
        }
    }

    set(key: string, value: any, duration: number) {
        this.handleExpiredData().next();
        const hasVal = this.cache.has(key);
        if (hasVal) {
            this.cache.get(key).overwritten = true;
        }
        this.cache.set(key, { value, expiration: Date.now() + duration, overwritten: false });
        return hasVal;
    }

    get(key: string) {
        this.handleExpiredData().next();
        if (!this.cache.has(key) || this.cache.get(key).expiration < Date.now()) {
            return -1;
        }
        return this.cache.get(key).value;
    }

    count() {
        this.handleExpiredData().next();
        return this.cache.size;
    }
}


/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */