# Read from the file file.txt and print its transposed content to stdout.
# 获取第一行，然后用wc来获取列数
COLS=`head -1 file.txt | wc -w`
# 使用awk依次去输出文件的每一列的参数，然后用xargs做转置
for (( i = 1; i <= $COLS; i++ )); do
    # 这里col就是在代码里要替换的参数，而它等于$i
    awk -v col=$i '{print $col}' file.txt | xargs
done
