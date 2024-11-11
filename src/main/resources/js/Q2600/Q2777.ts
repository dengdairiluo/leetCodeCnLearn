
// @ts-ignore
function* dateRangeGenerator(start: string, end: string, step: number): Generator<string> {
    const startTimestamp = new Date(start).getTime();
    const endTimestamp = new Date(end).getTime();
    let current: number;
    const stepMiles = 1000 * 60 * 60 * 24 * step;
    while (!current || current < endTimestamp) {
        if (current) {
            const temp = current + stepMiles;
            if (temp > endTimestamp) {
                break;
            }
            current = temp;
        } else {
            current = startTimestamp;
        }
        yield toDateString(new Date(current));
    }
};

function toDateString(date: Date) {
    // @ts-ignore
    return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${(date.getDate()).toString().padStart(2, '0')}`;
}

/**
 * const g = dateRangeGenerator('2023-04-01', '2023-04-04', 1);
 * g.next().value; // '2023-04-01'
 * g.next().value; // '2023-04-02'
 * g.next().value; // '2023-04-03'
 * g.next().value; // '2023-04-04'
 * g.next().done; // true
 */
