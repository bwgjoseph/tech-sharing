// use .catch rather than try catch for async ops

const gPromise1 = () => new Promise((resolve, reject) => {
    setTimeout(() => reject('error here'), 1000);
});

// more verbose

const runAsync = async () => {
    try {
        await gPromise1();
    } catch (error) {
        console.log(error);
    }
}

runAsync();

// more concise

gPromise1().catch((error) => console.log(error));
