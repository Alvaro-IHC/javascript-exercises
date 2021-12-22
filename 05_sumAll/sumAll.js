const sumAll = function(number1, number2) {
    if (typeof number1 !== 'number' || typeof number2 !== 'number'){
        return 'ERROR';
    }
    if (number1 < 0 || number2 < 0){
        return 'ERROR';
    }

    let minorNumber = number2 < number1 ? number2: number1;
    let majorNumber = number1 + number2 - minorNumber;
    let sum = 0;
    for(let i = minorNumber; i <= majorNumber; i++){
        sum += i;
    }
    return sum;
};

// Do not edit below this line
module.exports = sumAll;
