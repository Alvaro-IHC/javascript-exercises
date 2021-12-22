const ftoc = function(fahrenheit) {
  let celcius = (fahrenheit - 32)*5/9;
  if (Number.isInteger(celcius)) return celcius;
  else return +celcius.toFixed(1);
};

const ctof = function(celcius) {
  let fahrenheit = celcius*9/5 + 32;
  if (Number.isInteger(fahrenheit)) return fahrenheit;
  else return +fahrenheit.toFixed(1);
};

// Do not edit below this line
module.exports = {
  ftoc,
  ctof
};
