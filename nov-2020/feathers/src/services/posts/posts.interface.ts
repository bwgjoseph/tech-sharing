interface Context {
    type: 'WORKSPACE' | 'INCIDENT' | 'COMMENT';
    ids: string[];
}

interface Post {
    readonly _id: string;
    title: string;
    body: string;
    comments?: string[];
    readonly createdBy: string;
    context: Context[];
}

export default Post;
