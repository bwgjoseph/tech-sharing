import { NedbServiceOptions, Service } from 'feathers-nedb';
import { Application } from '../../declarations';

export class Lookup extends Service {
  //eslint-disable-next-line @typescript-eslint/no-unused-vars
  constructor(options: Partial<NedbServiceOptions>, app: Application) {
    super(options);
  }

  async create(data: any) {
    return 1;
  }
};
