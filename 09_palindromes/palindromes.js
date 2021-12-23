const palindromes = function (string) {
    array = string.toUpperCase().split('');
    const filteredArray = array.filter((item) => {
        if(item >= 'A' && item <= 'Z'){
            return true;
        }
    });
    const len = filteredArray.length;
    for(let i = 0; i < len/2; i++){
        if(filteredArray[i] != filteredArray[len-i-1]){
            return false;
        }
    }
    return true;
};

// Do not edit below this line
module.exports = palindromes;
