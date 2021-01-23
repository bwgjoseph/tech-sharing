const exit = (num: number): string => {
    if (num > 10) return 'hello';

    return 'world';
}

const exit1 = (num: number): string => {
    if (num < 0) throw Error('cannot be negative');
    if (typeof num !== 'number') throw Error('not a number');

    return (num > 10) ? 'hello' : 'world';
}

console.log(exit(9));

console.log('<----------------->');

console.log(exit1(11));

console.log('<----------------->');

console.log(exit1(-2));

console.log('<----------------->');

console.log(exit1('string' as any));