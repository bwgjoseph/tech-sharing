# Git Demo

## Preparation

- Init git repo
- Write a few commits

## Amend

```bash
git commit --amend
git commit --amend -m "update your previous commit message"
```

Caveat: Commit yet to push to remote `main/master` but is ok for your own personal branch

## Checkout

### Commits

```bash
git checkout 757c47d4
```

### Branch

```bash
git checkout my-branch
git switch my-branch
```

!Tip

Create Branch + Switch + Move Files

```bash
git switch -c my-branch
```

## Reset

### Mixed [default]

Keep your files, unstage the changes [to working]

```bash
git reset 757c47d4
```

### Soft

Keep your files, changes remains in staged

```bash
git reset --soft 757c47d4
```

### Hard

Remove your files, and any changes

```bash
git reset --hard 757c47d4
```

## Revert

Revert specific commit and reverse all committed changes via a new commit

```bash
git revert 757c47d4
```

## Stash

Moving your current uncommitted changes (staged and unstaged) to a "holding area"

```bash
git stash
git stash pop // remove from stash
git stash apply // does not remove from stash
```

## Merge

Combine 2 branches commits

```bash
git branch // my-branch
// to merge main into my-branch
git merge main
```

### Fast Forward Merge

Move branch commit to the head of main branch, similar to `rebase`

### Non Fast Forward Merge

Always create a separate merge commit

### Three Way Merge

## Rebase

Re-write commit history; moving all new commits on top

```bash
git branch // my-branch
// to merge main into my-branch
git rebase main
```

### Interactive Rebase

Manipulate commit history

```bash
git branch // my-branch
git rebase -i main
```

### Squash Commits

Since `interactive rebase` gives us the power to manipulate commit history, we can use it to clean up the history by squashing multiple commits into one, reword commits or more

```bash
pick 757c47d4 Message for commit #1
pick 857c47d5 Message for commit #2
pick 957c47d6 Message for commit #3
```

```bash
pick 757c47d4 Message for commit #1
squash 857c47d5 Message for commit #2
pick 957c47d6 Message for commit #3
```

```bash
pick 757c47d4 Message for commit #1 and #2
pick 957c47d6 Message for commit #3
```

## Cherry Pick

Picking specific commit from other branch into HEAD of current branch

```bash
git checkout main
git cherry-pick 757c47d4 // commit from my-branch
```

## Worktree

What if we want to work on multiple branch locally at the same time?

```bash
git branch
*main
feature-a
feature-b
```

```bash
git worktree add feature-a feature-a [path branch]
```

## Bisect

https://www.metaltoad.com/blog/beginners-guide-git-bisect-process-elimination

## Reflog

Record every change happened within a repository

```bash
git reflog
```