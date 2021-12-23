const findTheOldest = function(peopleArray) {
    peopleArray.forEach(element => {
        if(!element['yearOfDeath']){
            element['yearOfDeath'] = new Date().getFullYear();
        }
    });
    const nameOldest = peopleArray.sort((personA, personB) =>{
        let ageA = personA.yearOfDeath - personA.yearOfBirth;
        let ageB = personB.yearOfDeath - personB.yearOfBirth;
        return ageB - ageA;
    })[0].name;
    return peopleArray.find(element => element.name === nameOldest);
};

// Do not edit below this line
module.exports = findTheOldest;
