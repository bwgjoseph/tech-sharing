// map, filter, reduce, every, some

// boolean check if some of the data satisfy your condition
const numbers = [1,2,3,4,5];

const isAllEven = numbers.some((number) => number > 3);

console.log(isAllEven);

console.log('<----------------->');

const isGreaterThanZero = numbers.some((number) => number > 0);

console.log(isGreaterThanZero);

console.log('<----------------->');

const isLesserThanZero = numbers.some((number) => number < 0);

console.log(isLesserThanZero);

export { };

