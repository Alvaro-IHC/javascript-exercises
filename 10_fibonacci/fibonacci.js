const fibonacci = function(n) {
    let a = 1, b = 0;
    let c = 'OOPS';
    for(let i = 0; i < n; i++){ // 0 1 2 3 4
        c = a + b;  // 1 1 2 3
        a = b;      // 0 1 1 2
        b = c;      // 1 1 2 3
    }
    return c;
};

// Do not edit below this line
module.exports = fibonacci;
