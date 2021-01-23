const isPath = (path: string) => {
    if (path === 'moduleA') {
        return true;
    }

    return (path === 'moduleB')
}

const isPath1 = (path: string) => {
    if (path === 'moduleA') return true;

    return (path === 'moduleB')
}

const isPath2 = (path: string) => {
    return (path === 'moduleA')
}

const isPath3 = (path: string) => path === 'moduleA';

console.log(isPath('moduleA'));

console.log('<----------------->');

console.log(isPath1('moduleA'));

console.log('<----------------->');

console.log(isPath2('moduleA'));

console.log('<----------------->');

console.log(isPath3('moduleA'));

console.log('<----------------->');

console.log(isPath3('moduleB'));