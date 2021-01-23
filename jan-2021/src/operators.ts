const fa = (x: any) => (y: any) => x + y;

const p1 = fa(10);
const p2 = p1(30);

console.log(p2);
console.log(fa(10)(20));

console.log('<----------------->');

// conditionally insert field to array based on property

const insert = { isEnabled: false };

const arr = [
    1,
    2,
    ...(insert.isEnabled ? [3] :[]),
]

console.log(arr);

console.log('<----------------->');

// conditionally insert field to object based on property

const obj = {
    a: 'hello',
    b: 'world',
    ...(insert.isEnabled && { c: '!' })
}

console.log(obj);

console.log('<----------------->');

// optional chaining

interface Optional {
    a: string;
    b?: {
        c?: number;
        d?: string;
    }

}

let opt: Optional = { a: 'a' }

if (opt.b && opt.b.c) {
    console.log(opt.b.c)
} else {
    console.log('not set')
}

console.log('<----------------->');

opt = { a: 'a', b: { c: 1 } } // remove c and add d: 's'

// ? will check for undefined
if (opt.b?.c) {
    console.log(opt.b.c)
} else {
    console.log('not set')
}

// Nullish coalescing operator (??)
// check for null and undefined and evaluate to right
// if left is null or undefined

let data = null;
console.log(data ?? 'hello');
data = undefined;
console.log(data ?? 'world');
data = false;
console.log(data ?? '!!!');

console.log('<----------------->');

// vs Logical OR (||)
// if left is evaluate to true, return left, else return right

let data2 = null;
console.log(data2 || 'hello');
data2 = undefined;
console.log(data2 || 'world');
data2 = false;
console.log(data2 || '!!!');
data2 = 'what'
console.log(data2 || 'not this');