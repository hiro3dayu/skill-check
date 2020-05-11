package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
    public static void main(String[] args) {
        ListManager data = new ListManager();
        // TODO 並び換え
        int s = data.size();
        System.out.print(s + "\n");
        for (int j = 0; j < data.size();j++) {
            for (int i = 1; i < data.size() - j; i++) {
                if (data.compare(i - 1, i) == 1) {
                    data.exchange(i - 1, i);
                }
            }
        }
        data.checkResult();
    }
}
// 完成までの時間: 03時間 00分