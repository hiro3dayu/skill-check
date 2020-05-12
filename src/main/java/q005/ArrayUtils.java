package q005;
/**
 * 配列操作に関するユーティリティクラス
 */
public class ArrayUtils {

    /**
     * 指定された要素が、参照型配列内で最初に検出された位置のインデックスを返します。
     *
     * @param array    検索する配列
     * @param obj       検索する要素
     * @return 指定された要素が配列内で最初に検出された位置のインデックス。
     *               その要素が配列にない場合は -1
     */
    public static int indexOf(Object[] array, Object obj) {
        return indexOf(array, obj, 0);
    }

    /**
     * 指定された要素が、int型配列内で最初に検出された位置のインデックスを返します。
     *
     * @param array    検索する配列
     * @param val       検索する要素
     * @return 指定された要素が配列内で最初に検出された位置のインデックス。
     *               その要素が配列にない場合は -1
     */
    public static int indexOf(int[] array, int val) {
        return indexOf(array, val, 0);
    }

    /**
     * 指定された要素が、参照型配列内で検索開始位置以降の
     * 最初に検出された位置のインデックスを返します。
     *
     * @param array    検索する配列
     * @param obj       検索する要素
     * @param start    検索開始位置
     * @return 指定された要素が配列内で最初に検出された位置のインデックス。
     *               その要素が配列にない場合は -1
     */
    public static int indexOf(Object[] array, Object obj, int start) {
        if (array.length == 0) {
            return -1;
        }
        if (obj != null) {
            for (int i = start; i < array.length; i++) {
                if (obj.equals(array[i])) return i;
            }
        } else {
            for (int i = start; i < array.length; i++) {
                if (array[i] == null) return i;
            }
        }
        return -1;
    }

    /**
     * 指定された要素が、int型配列内で検索開始位置以降の
     * 最初に検出された位置のインデックスを返します。
     *
     * @param array    検索する配列
     * @param val       検索する要素
     * @param start    検索開始位置
     * @return 指定された要素が配列内で最初に検出された位置のインデックス。
     *               その要素が配列にない場合は -1
     */
    public static int indexOf(int[] array, int val, int start) {
        if (array.length == 0) {
            return -1;
        }
        for (int i = start; i < array.length; i++) {
            if (val == array[i]) return i;
        }
        return -1;
    }
}