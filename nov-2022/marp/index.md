---
marp: true
author: Joseph Gan
theme: uncover
---

# Intro to Git

Joseph Gan
9 Nov 2022

---

# Commit Message

- Based on [conventionalcommits](https://www.conventionalcommits.org/en/v1.0.0/)
- Structure

```
<type>[optional scope]: <description>
<BLANK LINE>
[optional body]
<BLANK LINE>
[optional footer(s)]

feat(profile): implement profile API

With this commit, it adds profile CRUD API with OpenAPI documentation and
controller sliced test

Close #1
```

---

# Commit Message

- Types
  - build, ci, docs, feat, fix, perf, refactor, style, test
- Scopes
  - To be defined at a later stage
- Description
  - Short summary (<= 90 characters)
- Body
  - As much as you want, be as specific as possible
- Footer
  - To reference or close an issue

---

# Enforcement

- Maven [git-build-hook](https://github.com/rudikershaw/git-build-hook) plugin
- Setup a pre-commit hook to enforce

---

# Tools

- CLI
  - git-bash
- GUI
  - [x] [GitExtensions](http://gitextensions.github.io/)
  - [SourceTree](https://www.sourcetreeapp.com/)
  - [Git-Fork](https://git-fork.com/)

---

# Tools

- IDE (Built-in)
  - IntelliJ
    - [x] [gittoolbox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
  - VSCode
    - [x] [gitlens](https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens)
    - [x] [gitextensions](https://marketplace.visualstudio.com/items?itemName=pmiossec.vscode-gitextensions)

---

# Tools

- [x] [kdiff3](https://kdiff3.sourceforge.net/)
- [diffmerge](https://sourcegear.com/diffmerge/)
- IDE built-in diff

---

# Concept / Terminology

- .gitignore
- hooks (.git/hooks)
  - pre-commit, post-commit, pre-rebase, etc

---

# Feature Demo

- Amend
- Checkout
- [Switch](https://twitter.com/pavangudiwada_/status/1579811556262658048)
- Reset
  - Mixed, Soft, Hard
- Reflog
- Revert
- Stash

---

# Feature Demo

- Merge
  - No Fast Forward
  - [Fast Forward](https://www.tutorialspoint.com/what-is-a-fast-forward-merge-in-git)
  - Dealing with Conflicts
- Rebase
  - Rebase Interactively
- Cherry Pick
- Worktree

---

# Feature No Demo

- Bisect
- Submodules

---

# Warning

- **Never** rebase + force push in `main` (or any public branch)

---

# Best Practices

- Write good commit message
- Prefer Clean History
- [Therefore] Rebase >>> Merge FF >>> Merge No FF
- Git pull (set rebase as default)
- Practice local feature-branch (easy to switch to main)
  - Practice small commits locally, squash when necessary prior to push or merge back to main

---

# Best Practices

- Gitlab
  - FF Merge as default [who looks at merge commit anyway]
  - Configure default ff merge in Gitlab

![gitlab-merge-method](./assets/gitlab-merge-method.png)

---

# Best Practices

- Pull/Merge Request
  - Team dependent
  - Small >>> Huge [reduce overhead + context]
  - Pair programming eliminates it (above)
  - Trunk based development
    - Protected by well defined pipeline