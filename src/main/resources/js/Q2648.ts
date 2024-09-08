
function* fibGenerator(): Generator<number, any, number> {
    const dp = Array(51);
    dp[0] = 0;
    dp[1] = 1;
    for (let i = 2; i <= 50; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    while(dp.length) {
        yield dp.shift();
    }
};



/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */