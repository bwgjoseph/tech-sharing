// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
// To run parallel async operation instead of await individual operations to improve reduce wait-time

const gPromise = (data: string) => new Promise((resolve) => {
    setTimeout(() => resolve(data), 1000);
});

const runSequential = async () => {
    return [await gPromise('module1'), await gPromise('module2'), await gPromise('module3')];
}

console.time('seq-promise');
runSequential().then((result) => {
        console.log(result);
        console.timeEnd('seq-promise');
        console.log('<----------------->');
    }
);

console.time('par-promise');
Promise.all([gPromise('module1'), gPromise('module2'), gPromise('module3')])
    .then((result) => {
        console.log(result);
        console.timeEnd('par-promise');
        console.log('<----------------->');
    }
);

// we can run these operation like data-fetching ops in parallel like
// fetching module1, module2, and module3 independently

// instead of
// await service('module1').find();
// await service('module2').find();
// await service('module3').find();

// we can
// const fetchModule1 = service('module1').find();
// const fetchModule2 = service('module2').find();
// const fetchModule3 = service('module3').find();
// await Promise.all([fetchModule1, fetchModule2, fetchModule3])

// or it could be we need to fetch module1 first, then fetch module2 and module3 together
// const fetchModule1 = await service('module1').find();
// const fetchModule2 = service('module2').find(module1.id);
// const fetchModule3 = service('module3').find(module1.id);
// await Promise.all([fetchModule2, fetchModule3])

// look at .all, .allSettled, etc

const dataIds = [1,2,3,4,5];
const get = (id: number) => new Promise((resolve) => resolve(id));

// gives an array of promise
const promises = dataIds.map((id) => get(id));
console.log(promises);

const getAllPromises = async () => {
    return Promise.all(promises);
}

getAllPromises().then((result) => {
    console.log(result);
    console.log('<----------------->');
});

// this is not a super good example because we can use
// things like find, or $in to perform a single query rather
// than multiple calls to database but good enough to
// illustrate the example

// const userService = context.app.service('users');
// const promises = context.result.data.map(async ride => {
//   const driver = await userService.get(ride.driverId, context.params);

//   return {
//     ...ride,
//     driver
//   };
// });

// context.result.data = await Promise.all(promises);

// return context;