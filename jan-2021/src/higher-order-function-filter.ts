// map, filter, reduce, every, some
// https://jsmanifest.com/the-power-of-higher-order-functions-in-javascript/

// remove falsy value using Boolean
const falsyValues = [null, 0, undefined, false, 0n, '', NaN];

const data = falsyValues.filter(Boolean);

console.log(data);

console.log('<----------------->');

// filter helper
const myobj = [
    {
        members: ['army', 'john'],
        city: 'singapore',
    },
    {
        members: ['peter', 'vincent'],
        city: 'london',
    },
    {
        members: ['lim', 'poh'],
        city: 'china',
    },
    {
        members: ['nancy', 'limus'],
        city: 'singapore',
    },
    {
        members: ['jason', 'mary'],
        city: 'london',
    },
]
const filterByKeyValue = (data1: Record<string, any>, key: string, value: any) => data1.filter((data2: any) => data2[key] === value);

console.log(filterByKeyValue(myobj, 'city', 'singapore'));

console.log('<----------------->');

// compose filter

const mycustomfilter = myobj
    .filter((obj1) => obj1.city.length > 4)
    .filter((obj1) => obj1.members.length > 1) // change 1 > 2

console.log(mycustomfilter);

export { };
