const caesar = function(string, n) {
    n = n % 26;
    n = n >= 0? n: 26+n;
    const alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
    const array = string.split('');
    for(let i = 0; i < array.length; i++){
        if(array[i].toUpperCase() >= 'A' && array[i].toUpperCase() <= 'Z'){
            const index = alpha.findIndex(item => item == array[i].toUpperCase());
            const newIndex = (index + n)%26;
            if(array[i].toUpperCase() == array[i]){
                array[i] = alpha[newIndex];
            }else{
                array[i] = alpha[newIndex].toLowerCase();
            }
        }
    }
    return array.join('');
};

// Do not edit below this line
module.exports = caesar;
