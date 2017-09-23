---
title: Linux Common Commands
date: 2017-09-14 11:05:00
categories: Linux
tags: 
- command
---

最近在用 Mac 电脑，系统跟 Linux 有些相似，所以整理下常用的命令以备不时之需。

<!--more-->

## File Commands
```shell
ls - directory listing
ls -al = formatted listing with hidden files
cd dir - change directory to dir
cd - change to home
pwd - show current directory
mkdir dir - create directory dir
rm file - delete file
rm -r dir - delete directory dir
rm -f file - force remove file
rm -rf dir - remove directory dir

cp file1 file2 - copy file1 to file2
mv file1 file2 - rename file1 to file2
ln -s file link - create symbolic link 'link' to file
touch file - create or update file
cat > file - place standard input into file
more file - output the contents of the file
less file - output the contents of the file
head file - output first 10 lines of file
tail file - output last 10 lines of file
tail -f file - output contents of file as it grows
```

## SSH
```shell
ssh user@host - connet to host as user
ssh -p port user@host - connect using port p
ssh -D port user@host - connect and use bind port
```

## Installation
```shell
./configure
make
make install
```

## NetWork
```shell
ping host - ping host 'host'
whois domain - get whois for domain
dig domain - get whois for domain
dig -x host - reverse lookup host
wget file - download file
wget -c file - continue stopped download
wget -r url - recursively download files from url
```

## System Info
```shell
date - show current date/time
cal - show this month's calendar
uptime - show uptime
w - display who is online
whoami - who are you logged in as
uname -a - show kernel config
cat /proc/cpuinfo - cpu info
cat /proc/meminfo - memory information
man command - show manual for command
df - show disk usage
du - show directory space usage
du -sh - human readable size in GB
free - show memory and swap usage
whereis app - show possible locations of app
which app - show which app will be run by default
```

## Searching
```shell
grep pattern files - search for pattern in files
grep -r pattern dir - search recursively for pattern in dir
command | grep pattern - search for pattern in dir
locate file - find all instances of file
```

## Process Management
```shell
ps - display currently active processes
ps aux - ps with a lot of detail
lsof -i tcp:1099
kill pid - kill process with pid 'pid'
killall proc - kill all processes named proc
bg - lists stopped/background jobs, resume stopped job in the background
fg - bring most recent job to foreground
fg n - brings job n to foreground
```

## File Permissions
```shell
chmod octal file - change permission of file
    4 - read(r)
    2 - write(w)
    1 - execute(x)
    
    order: owner/group/world
    
    eg:
    chmod 777 - rwx for everyone
    chmod 755 - rw for owner, rx for group/world
```

## Compression
```shell
tar cf file.tar files - tar files into file.tar
tar xf file.tar - untar into current directory
tar tf file.tar - show contents of archive

    tar flags:
    c - create archive
    t - table of contents
    x - specifies filename
    z - use zip/gzip
    j - bzip2 compression
    k - do not overwrite
    T - files from file
    w - ask for confirmation
    v - verbose
gzip file - compress file and rename to file.gz
gzip -d file.gz - decompress file.gz
```

## Shortcuts
```shell
ctrl+c - halts current command
ctrl+z - stops current command
fg - resume stopped command in foreground
bg - resume stopped command in background
ctrl+d - log out of current session
ctrl+w - erases one word in current line
ctrl+u - erases whole line
ctrl+r - reverse lookup of previous commands
!! - repeat last command
exit - log out of current session
```

## Vim
```shell
quitting
    :x - exit, saving changes
    :wq - exit, saving changes
    :q - exit, if no changes
    :q! - exit, ignore changes
inserting text
    i - insert before cursor
    I - insert before line
    a - append after cursor
    A - append after line
    o - open new line after cur line
    O - open new line before cur line
    r - replace one character
    R - replace many characters
motion
    w - move to next word
    W - move to next blank delimited word
    b - move to beginning of the word
    B - move to beginning of blank delimited word
    e - move to end of word
    E - move to end of blank delimited word
    ( - move a sentence back
    ) - move a sentence forward
    { - move paragraph back
    } - move paragraph forward
    0 - move to beginning of line
    $ - move to end of line
    nG - move to nth line of file
    :n - move to nth line of file
    G - move to last line of file
    fc - move forward to 'c'
    Fc - move backward to 'c'
    H - move to top of screen
    M - move to middle of screen
    L - move to bottom of screen
    % - move to associated (),{},[]
deleting text
    x - delete character to the right
    X - delete character to the left
    D - delete to the end of line
    dd - delete current line
    :d - delete current line
searching
    /string - search forward fo string
    ?string - search back for string
    n - search for next instance of string
    N - search fo previous instance of string
replace
    :s/pattern/string/flags - replace pattern with string, according to flags
    g - flag, replace all occurences
    c - flag, confirm replaces
    & - rpeat last :s command
files
    :w file - write to file
    :r file - read file in after line
    :n - go to next file
    :p - go to previous file
    :e file - deit file
    !!cmd - replace line with output of cmd
other
    u - undo last change
    U - undo all changes to line
```