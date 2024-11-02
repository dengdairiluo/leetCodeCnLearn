
// @ts-ignore

declare global {
    interface Date {
        nextDay(): string;
    }
}

// @ts-ignore
Date.prototype.nextDay = function(){
    const date = new Date(this);
    date.setDate(this.getDate() + 1);
    return date.toISOString().slice(0, 10);
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */

