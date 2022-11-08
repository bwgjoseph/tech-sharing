---
# try also 'default' to start simple
theme: default
# random image from a curated Unsplash collection by Anthony
# like them? see https://unsplash.com/collections/94734566/slidev
background: https://source.unsplash.com/collection/94734566/1920x1080
# apply any windi css classes to the current slide
class: 'text-center'
# https://sli.dev/custom/highlighters.html
highlighter: shiki
# show line numbers in code blocks
lineNumbers: true
# some information about the slides, markdown enabled
# info: |
#   ## Slidev Starter Template
#   Presentation slides for developers.

#   Learn more at [Sli.dev](https://sli.dev)
# persist drawings in exports and build
drawings:
  persist: true
# use UnoCSS
css: unocss
---

# Tech Sharing

Intro to Git

Joseph Gan

9 Nov 2022

---

# Agenda

- Basics
- Tools
- Enforcer
- Commit Message
- Feature Demo
- Best Practices

---

# Basics

- Source Code Managment
- .gitignore
- hooks (.git/hooks)
  - pre-commit, post-commit, pre-rebase, etc

---
layout: quote
---

# Git was originally developed by `Linus Torvalds`?

---

# Enforcer

- Maven [git-build-hook](https://github.com/rudikershaw/git-build-hook) plugin
- Install pre-commit hook to enforce
  - Git commit message
  - Code Formatter
  - ...

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

# Commit Message

- Based on [conventionalcommits](https://www.conventionalcommits.org/en/v1.0.0/)

<v-clicks>

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

</v-clicks>

---
layout: full
---

# Commit Message

```sh {1,9|2-3,10-12|4-5,13-14|all}
<type>[optional scope]: <description>
<BLANK LINE>
[optional body]
<BLANK LINE>
[optional footer(s)]

---

feat(profile): implement profile API

With this commit, it adds profile CRUD API with OpenAPI documentation and
controller sliced test

Close #1
```

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
layout: quote
---

<h1 align="center">
Demo Time!
</h1>

---

# Feature No Demo

- Bisect
- Submodules

---
layout: quote
---

# <p color="red">Warning</p>

## **Never** rebase + force push in **main** (or any public branch)

---

# Best Practices

<v-clicks>

- Write good commit message
- Prefer Clean History
- [Therefore] Rebase >>> Merge FF >>> Merge No FF
- Git pull (set rebase as default)
- Practice local feature-branch (easy to switch to main)
  - Practice small commits locally, squash when necessary prior to push or merge/rebase back to main

</v-clicks>

---

# Best Practices [Gitlab]

<v-clicks>

- FF Merge as default [who looks at merge commit anyway]
- Configure default ff merge in Gitlab

![gitlab-merge-method](/gitlab-merge-method.png)

</v-clicks>

---

# Best Practices [Pull/Merge Request]

<v-clicks>

- Team dependent
- Small >>> Huge [reduce overhead + context]
- Pair programming eliminates it (above)
- Trunk based development
  - Protected by well defined pipeline

</v-clicks>

---
layout: end
---