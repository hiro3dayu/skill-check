package q003;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */

public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }
    public static void main(String[] args) {
        int count = 1;
        String str = " ";
        //String str2 = ",";
        String str3 = "\n";
        String str4 = ".";
        String str5 = "I";
        StringBuilder s1 = new StringBuilder();
        String s2;
        char[] x = str.toCharArray();
        char[] x2 = str3.toCharArray();
        char[] x3 = str4.toCharArray();
        try {
            InputStreamReader in = new InputStreamReader(openDataFile());
            int ch;
            while ((ch = in.read()) != -1) {
                if((char)ch == x[0]) {
                    s1.append(str);
                    count++;
                }else if ((char)ch == x2[0]) {
                    s1.append(str);
                    count++;
                }else if ((char)ch == x3[0]) {
                }else {
                    s2 = String.valueOf((char) ch);
                    s1.append(s2);
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);

        }
        String str0 = s1.toString();
        String[] list;
        list = str0.split(" ");
        String[] list3 = new String[count];
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str5)) {
                list3[i] = list[i];
            }else {
                list3[i] = list[i].toLowerCase();
            }
        }
        List<String> list2 = Arrays.asList(list3);
        Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);
        int count2 = 1;
        String last = list2.get(0);
        for (int i = 0; i < list2.size(); i++) {
            if (last.equals(list2.get(i))){
                last = list2.get(i);
                count2++;
            }else{
                System.out.print(last + "=" + count2 + "\n");
                last = list2.get(i);
                count2 = 1;
            }
        }
    }
}
// 完成までの時間: 05時間 30分