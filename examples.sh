$PATH
#searches in these directories for files and folders with name of leading variable in a command
which java
#returns location where $PATH finds this variable
#alternative: type java
ls -l
#returns location symlinks point to
sudo find / -iname java -exec echo {} \; -exec ls -l {} \;
#returns all java files and folders and subfiles and subfolders

grep tom /etc/passwd
#searches passwd for tom
grep "advance-component" -ir .
#searches curr directory for any file with advance-component, ignores case

find . -type f -exec <command> {} \;
#Locate all regular files in the current directory, and execute the given command on each one.
#-P  #Never follow symbolic links
#-mtime -1  #files last accessed less than a day ago #-amin #for minutes
#-cmin n #File's status was last changed n minutes ago. #also -ctime n
#-name pattern #finds file name
find . -type d -maxdepth 1 -execdir echo {} \;
#prints the immediate subfolders
find . -name "*.clj" -exec grep "/status" -rn {} \;
find . -path "./sr*sc"
#will print an entry for a directory called `./src/misc'
find . -depth 2 -name "*.clj"

stty -a
#shows terminal shortcuts (isn't always correct)
^w (mac) or opt-backspace (centos)
#delete from cursor to word beginning
^w (centos)
#delete from cursor to line end (centos)
altd
#delete from cursor to line end (mac) from cursor to word end (centos)
^c  ^u ^k
#exit command, clear line before cursor (mac) clear line (centos), clear line after and including cursor
^a ^e ^t
#line start, line end, swaps this char with previous and advances cursor,

alt<leftclick>
#position cursor

cmd+ cmd-
#change font size

##continue here
https://support.apple.com/en-ca/guide/terminal/trmlshtcts/mac
@ Select and find text in a Terminal window


head –n <num> <file>
#First n lines #tail is last

echo "tye" | tr -d "e"
#ty
echo "tyye" | tr -s "y" "f"
#tfe
echo "t.t--y__yee" | tr -cd 'a-zA-Z0-9'
#ttyyee
echo "t.t--y__yee" | tr -s 'a-zA-Z0-9'
#t.t--y__ye
echo "t.t" | fold -w 2 .
#t.
#t #(inserted new line)
find . -type f -exec grep -nH "regex" {} \; #or grep "regex" -rn .
grep -RnH --exclude-dir={"./Library/Application Support","./whatever"} "regex" .
#doesn't work
find . -name '*.txt'

USER=mitch-kyle
PARENT_USER=SerenovaLLC
PARENT_LABEL=upstream
PROJECT=$1
pushd ~/Sources
git clone git@github.com:$USER/$PROJECT.git
pushd $PROJECT
git remote add $PARENT_LABEL git@github.com:$PARENT_USER/$PROJECT.git
popd

##when in ~
pushd ~/codebase
#directory stack becomes ~/codebase ~
#directory becomes ~/codebase
pushd
#directory stack becomes ~ ~/codebase
#directory becomes ~

chmod +x *.sh
#gives permission to all scripts in dir

#!/bin/bash
#put at start of script to give permission

rm -rf toran
#removes toran directory recursively without prompt

source ~/.bash_profile
#refreshes terminal

qdir $pwd #or pwd | qdir
#evaluates pwd then runs qdir with the result

history
#shows history of commands (saved on exit)

echo "hi $(pwd)."
#hi /Users/tshutty/codebase/teleopti-gateway.

for i in $( ls ); do
    echo item: $i
done

open .
gio open .
#opens current dir in finder
open -a /Applications/Microsoft\ Word.app project.clj

ls -I */
#lists all contents of all folders in directory
ls -S
#sort by file size
ls -sh
#print allocated file space in human readable form
ls -t
#last modified first
find . -maxdepth 1 -type f
#prints all files in dir
ls -FA | grep -v /
#excludes all strings with /
ls -al | grep '^-'
#excludes all strings starting with -

du -d 1 -h | sort -hr
#lists folders by disk size

less <path/filename>
#type /<word><enter> to search, press n to go to next instance, N to go to previous. option-u unhighlights search.
#CTRL+F – forward one window
#CTRL+B – backward one window
#CTRL+D – forward half window
#CTRL+U – backward half window
#G – go to the end of file g – go to the start of file
#CTRL-g show numbers of lines displayed
#10j – 10 lines forward. 10k – 10 lines backward. (or up and down keys)
#press v to edit with configured editor

find -E
#means ERE not BRE regex will be used
find . #or find .  -name "*"
#finds everything
find -E . -regex .*testy.*
#finds files and folders with testy in them
find -E . -regex .*temp\ dir3.* -prune -o -name "*"
#will not search file paths with temp dir3 (but will return file and folder names with it)
find -E . -regex .*temp\ dir3.* -prune -o -name "*" | grep -Ev "temp dir3"
#will also exclude file and folder names
find -E . -regex .*temp\ dir3.* -prune -o -name "*" 2>&1 | grep -Ev "(Not a directory|Permission denied|Operation not permitted)"
#need 2>&1 to send stderr to stdout so grep can parse
find . -name *em*
#./tempdir2 #requires kleene stars

find / \! -name "*.c" -print
#Print out a list of all the files whose names do not end in .c.
find / \! \( -newer ttt -user wnj \) -print
#Print out a list of all the files which are not both newer than ttt and owned by ``wnj''

##Strings Maniipulation
#http://tldp.org/LDP/abs/html/string-manipulation.html
stringZ=*hi*
echo "${stringZ//\*/~}"
#~hi~
suffix= `expr match "$i" '.*\(\..*\)'`
#removes .whatever ending from i

if [ 0 -lt 1 ]; then echo sup; fi
#sup #spaces are important
if [ ${#2} -gt 0 ]
#if string is non-empty
find . -type f \( -name "*.sh" -o -name "*.txt" \)

for i in *.jar; do jar -tvf "$i" | grep -Hsi ClassName && echo "$i"; done
#searches jar files for classname
#to also use with find: https://stackoverflow.com/questions/1342894/find-a-class-somewhere-inside-dozens-of-jar-files

echo hi | pbcopy
#puts hi in the clipboard

> output.txt
#sends regular output to here
2> /dev/null
#sends exception output here

perl -0pi.bak -e 's:<a\ href=\"signup.html\">Signup</a>\n:test:gi' webapp/*.html
#finds and replaces multiline regex across multiple files

htop
top
#see running processes

rename a2 a3 */a2*
#replaces all instance of a2 with a3 in filenames starting with a2 in subfolders of current dir

sed -n '1,10p' file1 > file2
#copy first 10 lines into file2
find . -type f -name '*.java' -exec sed -i '1 i\package Quarto;' {} \;
#add new first line to multiple files.
find . -type f -name '*.java' -exec sed -i '1d' {} \;
#remove first line

source tests; test1
#calls the test1 function in the tests file

diff 	<(printf "2 5\n40 10\n" | ./d F 20 a)
<(printf "Head movement required = 20\nTime required = 45\n")
#compares string to result of string piped to ./d call

printf "hi\nyou\n" | diff - t
# compares piped string to contents of file t

grep "+" -irn --include *.clj
#searches for plus recursively with line numbers in all clj files

grep "+" -irn --include *.clj | wc -l
#counts lines returned

cat > may1.txt
#prints following text to file, until EOF

which java
#prints location of program

tput reset
#really clears terminal 
