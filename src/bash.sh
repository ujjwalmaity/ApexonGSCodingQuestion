#1
find /var/log -name "*.log" -mtime +15 ! -size +500M

#2
find /path -type l - delete

#3
find /home/user ! -user $(whoami)

#4
find /etc -name "*config*" -perm -002

#5
grep -v "bash" /etc/passwd

#6
grep -r --exclude-binary=*.bin "specific_string" /path/to/directory

#7
grep -C 3 "error" filename

#8
grep "^root" /etc/passwd

#9 (Internet)
tar --exclude='*.mp4' -czvf user_directory.tar.gz /home/user

#10
tar -xzvf archive_name.tar.gz file.txt

#11

#12
tar -tzf archive.tar.gz

#13
ps aux | grep java | awk '{print $2, $11}'

#14
ls /var/log | grep error

#15
grep "failed" filename | wc -l
grep -c "failed" filename

#16
tail -n 20 logfile | grep "critical"

#17
du -h /home/user/* | sort -hr

#18
du -sh --exclude=/var/log /var

#19 (Internet)
find /path/to/directory -type f -size +100M -exec du -h {} +

#20
du -sh /usr/* | sort -hr | head -n 10
