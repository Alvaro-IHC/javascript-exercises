const add = function(a, b) {
	return a + b;
};

const subtract = function(a, b) {
	return a - b;
};

const sum = function(array) {
	return array.reduce((storage, item)=>{
    return storage + item;
  }, 0);
};

const multiply = function(array) {
  return array.reduce((storage, item)=>{
    return storage * item;
  }, 1);
};

const power = function(a, b) {
	return Math.pow(a, b);
};

const factorial = function(n) {
	let facto = 1;
  for(let i = 2; i <= n; i++){
    facto *= i;
  }
  return facto;
};

// Do not edit below this line
module.exports = {
  add,
  subtract,
  sum,
  multiply,
  power,
  factorial
};
