# Git & Github
## Git
### Useful commands
### See git tree with brances on CLI
git log --graph --oneline --decorate --all

### Create a new branch called 'readme'
git checkout -b readme

## Resolving a merge conflict
### You first try to merge
git merge anotherbranch

### You get a merge conflict
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.

### You open the file and see the conflict
```` <<<<<<< HEAD
changes in your branch 
=======
changes in another branch
>>>>>>> anotherbranch ````

You fix the conflict and save the file

### You add the file to the staging area

git add README.md

### You commit the file
git commit

# Creating a pull request on Github
Go to the repository on Github
Fork the repository under your own account
Clone the repository to your local machine
Make changes to the repository, commit those changes and push them to your forked repository
Go to your forked repository on Github and click on the 'New pull request' button
Click on the 'Create pull request' button
