// this is the happy path, assuming everything works

// const config: any = {
//     app: {
//         isEnabled: true,
//     }
// }

// const getConfig = () => config;

// const method = () => {
//     const app = getConfig().app;

//     return app.isEnabled;
// }

// if (method()) console.log('ok');

// now what if the property is missing?
// we will get a exception

// const config1: any = {};
// const getConfig1 = () => config1;

// const method1 = () => {
//     const app = getConfig1().app;

//     return app.isEnabled;
// }

// if (method1()) console.log('ok1');

// comment out above
// let's make it better

const config2: any = {};
const getConfig2 = () => config2;

const method2 = () => {
    const app = getConfig2()?.app;

    return app?.isEnabled;
}

if (method2()) console.log('ok2');

console.log('<----------------->');

// still can improve?
// nothing will get run, as undefined is a falsy value

const config3: any = {};
const getConfig3 = () => config3;

const method3 = () => getConfig3()?.app?.isEnabled;

if (method3()) console.log('ok3');

console.log('<----------------->');

// say the config is set
// isEnabled will be returned and ok4 is ran

const config4: any = { app: { isEnabled: true }};
const getConfig4 = () => config4;

const method4 = () => getConfig4()?.app?.isEnabled;

if (method4()) console.log('ok4');