import { BadRequest } from '@feathersjs/errors';
import { HookContext } from '@feathersjs/feathers';
import { Application } from '../../declarations';

interface Context {
  type: 'WORKSPACE' | 'INCIDENT' | 'COMMENT' | 'POSTS';
  ids: string[];
}

const lookup = (context: Context[], app: Application) => {
  let count = 0;
  const result: string[] = [];
  const x = context.map((c: Context) => {
    if (c.type === 'POSTS') {
      return result.push(...c.ids);
    } else {
      if (typeof app.service(c.type) === 'undefined') throw new BadRequest('service not found');

      const query = {
        _id: {
          $in: c.ids
        }
      }
      const responses = (app as any).service(c.type).find(query);
      const output = responses.flatMap((response: any) => lookup(response.context, app));
      return result.push(...output);
    }
  })

  console.log(x);

  return result;
}

const lookupContext = async (context: HookContext) => {

  const { data, app } = context;

  lookup(data.context, app as Application);

  return context;
};

export default lookupContext;
