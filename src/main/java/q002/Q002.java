package q002;

/**
 * Q002 並べ替える
 *
 * dataListに "ID,名字" の形式で20個のデータがあります。
 * これをID順に並べて表示するプログラムを記述してください。
 *
 * dataListの定義を変更してはいけません。
 *
 *
 [出力結果イメージ]
 1,伊藤
 2,井上
 （省略）
 9,清水
 10,鈴木
 11,高橋
 （省略）
 20,渡辺
 */
import java.util.ArrayList;
import java.util.Collections;

public class Q002 {

    private static final String[] dataList = {
            "8,佐藤",
            "10,鈴木",
            "11,高橋",
            "12,田中",
            "20,渡辺",
            "1,伊藤",
            "18,山本",
            "13,中村",
            "5,小林",
            "3,加藤",
            "19,吉田",
            "17,山田",
            "7,佐々木",
            "16,山口",
            "6,斉藤",
            "15,松本",
            "2,井上",
            "4,木村",
            "14,林",
            "9,清水"
    };

    public static void main(String[] args) {
        String[] list = new String[2];


        // ソートするList
        ArrayList<Person> memberList = new ArrayList<Person>();
        for (int i = 0; i < dataList.length; i++) {
            list = dataList[i].split(",", 2);
            int identity = Integer.parseInt(list[0]);
            String list2 = list[1];
            memberList.add(new Person(identity,list2));
        }

        for (int i = 0; i < memberList.size(); i++) {
            System.out.format("%d - %s\n",
                    memberList.get(i).id,
                    memberList.get(i).name);
        }

        Collections.sort(memberList, new PersonComparator());
        System.out.println("--- Sorted ---");

        for (int i = 0; i < memberList.size(); i++) {
            System.out.format("%d - %s\n",
                    memberList.get(i).id,
                    memberList.get(i).name);
        }
    }
}

// 完成までの時間: 06時間 00分
