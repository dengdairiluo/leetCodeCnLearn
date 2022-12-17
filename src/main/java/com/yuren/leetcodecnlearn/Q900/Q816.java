package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-25 23:09
 */
public class Q816 {
    public List<String> ambiguousCoordinates(String s) {
        //回溯：用一个flag=1,2,3,4分别表示当前插入第一个小数点，逗号加空格，第二个小数点，添加当前数字到temp.
        //注意排除异常情况：主要在flag==2和4时：要注意当前temp的最后一个是否是小数点，是小数点则需要注意不能以0结尾。
        //具体的过程：flag==1和3处理了以0开始的异常情况。flag==2,4处理以0结尾的异常情况。
        //flag==1表示当前插入的是第一个'.'。第一种情况：开始是0，此时又分为不要小数点（是整数了。逗号只能加在第一个0后面）；要小数点：（小数点加在第一个0后面）第二种情况：开始不是0，同样分为要小数点和不要，然后小数点可以插入第一个，第二个...不同的位置（需要回溯）。flag==1不用当心以0结尾的异常，后面flag==2和4中会处理掉。
        //flag==2表示当前插入的是逗号加空格。第一种情况：前面添加的是整数（即没有小数点），可以通过判断temp当前最后一个字符是否是'.'来判断。此时逗号可以直接插入到index后的每一个位置，（不用当心多个0开始的异常情况，前面flag==1已经过滤了）。第二种情况：前面添加了'.',此时需要找到不为0的位置，在其后面插入逗号（防止以0结尾）。
        //flag==3表示当前插入的是第二个'.'。小数点可以插入Index后不同位置，最后一个数字后面不用插入了（成整数的情况了）。第一种：index位置是0，此时小数点只能加到该0后面。第二种：index位置不为0：此时小数点可以加到index后的不同位置。最后一个数字后面不用加，拎出来单独处理。（不用担心以0结尾，flag==4会处理掉）
        //flag==4表示将index位置的数字加入temp。此时判断若前面有'.'且最后一个数字是0，则直接返回（防止以0结尾了）。否则，直接一个一个数字加入temp，然后回溯即可。
        //昨天眼睛痛的不行，写半天都是bug。今天情况都模清楚了，写好了，哈哈。
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append('(');
        char[] source = s.toCharArray();
        process(source, 1, 1, res, temp);
        return res;
    }

    private void process(char[] source, int index, int flag, List<String> res, StringBuilder temp) {
        //第一个和最后一个位置有个括号
        if (index == source.length) {
            res.add(new String(temp));
            return;
        }
        if (flag == 4) {
            if (temp.charAt(temp.length() - 1) == '.' && source[source.length - 2] == '0') {
                return;//排除异常：小数点后是以0结尾的情况
            }
            temp.append(source[index]);
            process(source, index + 1, 4, res, temp);
            temp.delete(temp.length() - 1, temp.length());
            return;
        }
        if (flag == 1) {
            if (source[1] == '0') {
                //小数点插入的位置只有一种可能即插在0后面。然后有两种：要或不要小数点情况
                temp.append('0');
                temp.append(',');
                temp.append(' ');
                process(source, index + 1, 3, res, temp);//不要小数点的情况，这里index就等于0
                temp.delete(temp.length() - 2, temp.length());
                temp.append('.');//'0'没有回溯出来，所以可以不同添加了
                process(source, index + 1, 2, res, temp);
                //这里可以不用回溯了，反正是最开始的地方。
                //return;
            } else {
                //不要的情况：直接跳到flag==2:
                process(source, index, 2, res, temp);
                //要小数点:
                //最后有个括号，所以到length-3
                for (int i = index; i < source.length - 3; i++) {
                    temp.append(source[i]);
                    temp.append('.');
                    process(source, i + 1, 2, res, temp);
                    //只需删除'.'，前面的数字还需累积
                    temp.delete(temp.length() - 1, temp.length());
                }
                //这里可以不用一个一个都回溯删除掉，这是开始。这里return直接就结束了
                //return;
            }
            return;
        }
        if (flag == 3) {
            //最后一个为0在下面进行
            if (source[index] == '0' && index != source.length - 2) {
                //这是小数点也只能在0后面一种情况.且必须要小数点
                temp.append('0');
                temp.append('.');
                process(source, index + 1, 4, res, temp);
                temp.delete(temp.length() - 2, temp.length());
                //return;
            } else {
                //最后有个括号
                for (int i = index; i < source.length - 2; i++) {
                    temp.append(source[i]);
                    temp.append('.');
                    process(source, i + 1, 4, res, temp);
                    temp.delete(temp.length() - 1, temp.length());
                }
                //最后一个不用小数点
                temp.append(source[source.length - 2]);
                process(source, source.length - 1, 4, res, temp);
                //一个个回溯到index位置:
                temp.delete(temp.length() - (source.length - 1 - index), temp.length());
            }
            return;
        }
        //flag == 2:
        if (temp.charAt(temp.length() - 1) != '.') {
            //前面是整数的情况:
            for (int i = index; i < source.length - 2; i++) {
                temp.append(source[i]);
                temp.append(',');
                temp.append(' ');
                process(source, i + 1, 3, res, temp);
                temp.delete(temp.length() - 2, temp.length());
            }
            //回溯
            temp.delete(temp.length() - (source.length - 2 - index), temp.length());
        } else {
            int i = index;
            while (source[i] == '0') {
                temp.append('0');
                i++;
            }
            while (i < source.length - 2) {
                temp.append(source[i]);
                temp.append(',');
                temp.append(' ');
                process(source, i + 1, 3, res, temp);
                temp.delete(temp.length() - 2, temp.length());
                i++;
                //后面可能又有连续的0
                while (source[i] == '0') {
                    temp.append('0');
                    i++;
                }
            }
            //最后一个是1
            if (i == source.length - 2) {
                temp.delete(temp.length() - (source.length - 2 - index), temp.length());
            } else {//这种是i到)位置了。前面一直是0
                temp.delete(temp.length() - (source.length - 1 - index), temp.length());
            }
        }
    }
}
