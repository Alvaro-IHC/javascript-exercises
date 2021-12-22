const removeFromArray = function() {
    array = arguments[0];
    for(let i = 1; i < arguments.length; i++){
        let elementToRemove = arguments[i];
        for(let j = 0; j < array.length; j++){
            if (elementToRemove === array[j]){
                array.splice(j, 1);
                j--;
            }
        }
    }
    return array;
};

// Do not edit below this line
module.exports = removeFromArray;
