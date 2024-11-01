type QueryMultipleFn = (keys: string[]) => Promise<string[]>;

type ThrottledRequest = {
    key: string;
    resolve: (result: string) => void;
};

class QueryBatcher {
    private readonly queryMultiple: QueryMultipleFn;
    private readonly throttleTime: number;
    private isThrottling: boolean;
    private throttledRequests: ThrottledRequest[];

    constructor(queryMultiple: QueryMultipleFn, t: number) {
        this.queryMultiple = queryMultiple;
        this.throttleTime = t;
        this.isThrottling = false;
        this.throttledRequests = [];
    }

    // @ts-ignore
    async getValue(key: string): Promise<string> {
        if (this.throttleTime === 0) {
            const results = await this.queryMultiple([key]);
            return results[0];
        }
        if (this.isThrottling) {
            // @ts-ignore
            return new Promise<string>((resolve) => {
                this.throttledRequests.push({ key, resolve });
            });
        }
        this.isThrottling = true;
        setTimeout(() => this.deThrottle(), this.throttleTime);
        const results = await this.queryMultiple([key]);
        return results[0];
    }

    // De-throttles and processes any pending requests.
    private deThrottle(): void {
        const throttledRequests = this.throttledRequests;
        if (throttledRequests.length === 0) {
            this.isThrottling = false;
        } else {
            const keys = throttledRequests.map((req) => req.key);
            this.queryMultiple(keys).then((results) => {
                results.forEach((result, index) => {
                    throttledRequests[index].resolve(result);
                });
            });
            setTimeout(() => this.deThrottle(), this.throttleTime);
            this.throttledRequests = [];
        }
    }
}

/**
 * async function queryMultiple(keys) {
  *   return keys.map(key => key + '!');
 * }
 *
 * const batcher = new QueryBatcher(queryMultiple, 100);
 * batcher.getValue('a').then(console.log); // resolves "a!" at t=0ms
 * batcher.getValue('b').then(console.log); // resolves "b!" at t=100ms
 * batcher.getValue('c').then(console.log); // resolves "c!" at t=100ms
 */