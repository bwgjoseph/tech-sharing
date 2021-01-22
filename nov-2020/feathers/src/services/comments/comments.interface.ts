interface Context {
    type: 'WORKSPACE' | 'INCIDENT' | 'COMMENT';
    ids: string[];
}

interface Comment {
    readonly _id: string;
    text: string;
    context: Context[];
}

export default Comment;
