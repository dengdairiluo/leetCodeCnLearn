# Read from the file file.txt and output the tenth line to stdout.
head -n 10 file.txt | awk '{if (NR==10)print $0}'
