import assert from 'assert';
import app from '../../src/app';

describe('\'posts\' service', () => {
  it('registered the service', () => {
    const service = app.service('posts');

    assert.ok(service, 'Registered the service');
  });

  it.only('as', async () => {
    const postService = app.service('posts');
    const commentService = app.service('comments');

    await postService._remove(null);
    await commentService._remove(null);

    const createdPost = await postService.create({
      body: 'hello',
      context: [
        {
          type: 'WORKSPACE' as const,
          ids: ['ws12345']
        }
      ]
    });

    await commentService.create({
      text: 'comment1',
      context: [
        {
          type: 'POSTS' as const,
          ids: [createdPost._id]
        }
      ]
    });

    console.log(JSON.stringify(await postService.find(), null, 2));
    console.log(JSON.stringify(await commentService.find(), null, 2));

    const lookupService = app.service('lookup');
    await lookupService.create({
      context: [
        {
          type: 'POSTS' as const,
          ids: [createdPost._id]
        }
      ]
    })
  });
});
