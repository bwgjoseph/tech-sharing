// we want to ensure that each function to have only a single responsibility as much as possible

// it is not always our local data interface is the same as remote, so we need to map it after
// we fetch the data
interface LocalData {
    a: string;
    b: string;
    c: boolean;
}

interface RemoteData {
    x: string;
    y: string;
    c: boolean;
}

const remoteDataSet: RemoteData = { x: 'hello', y: 'world', c: true };

const fetchRemoteData = () => remoteDataSet;

const getData = () => {
    let local: Partial<LocalData> = {};
    const remote = fetchRemoteData();

    // performing validation, transformation, etc
    // we could extract this out
    if (remote.x && remote.y && remote.c) {
        local = {
            a: remote.x,
            b: remote.y,
            c: remote.c,
        }
    }

    return local;
}

// because this method is now extracted, it can be reused all over
const transform = (data: RemoteData): LocalData => {
    if (!data.x && !data.y && !data.c) throw Error('invalid data');

    return {
        a: data.x,
        b: data.y,
        c: data.c,
    }
}

const getData1 = () => {
    return transform(fetchRemoteData());
}

console.log(getData1());