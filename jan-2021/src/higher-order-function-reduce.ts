// map, filter, reduce, every, some

// sum array
const numbers = [1,2,3,4,5];

const sum = numbers.reduce((acc, val) => {
    return acc + val;
}, 0);

console.log(sum);

console.log('<----------------->');

// putting into buckets

interface MyObj {
    members: string[];
    city: string;
}

const myobj: MyObj[] = [
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

// group by city > members
const cityGroupBucket = myobj.reduce((acc, val) => {
    const { members, city } = val;

    if (!acc[city]) {
        acc[city] = members;
    } else {
        acc[city].push(...members);
    }

    return { ...acc };
}, {} as any);

console.log(cityGroupBucket);

console.log('<----------------->');

// group by city > number of members
const cityGroupBucket1 = myobj.reduce((acc, val) => {
    const { members, city } = val;

    if (!acc[city]) {
        acc[city] = members.length;
    } else {
        acc[city] += members.length;
    }

    return { ...acc };
}, {} as any);

console.log(cityGroupBucket1);