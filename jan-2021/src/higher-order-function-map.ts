// map, filter, reduce, every, some

// map before
let data: string[] = [];
const incomingdata = [1,2,3,4,5];

incomingdata.forEach((data1: number) => {
    if (data1 % 2 === 0) {
        data.push('even');
    } else {
        data.push('odd');
    }
})

console.log(data);

console.log('<----------------->');

// map after p1
// no need to declare extra variable outside of scope
const mapdata = incomingdata.map((data2: number) => {
    if (data2 % 2 === 0) {
        return 'even';
    }

    return 'odd';
});

console.log(mapdata);

console.log('<----------------->');

// map after p2

// this could then be resuable, even if not, this is easier to know the intention of
// what this is doing
const isEvenOrOdd = (data3: number) => (data3 % 2 === 0) ? 'even' : 'odd';
const mapdata1 = incomingdata.map(isEvenOrOdd);

console.log(mapdata1);

export { };
