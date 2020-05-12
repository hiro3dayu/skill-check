package q005;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {
    /** 社員番号 */
    public String number;

    /** 部署 */
    public String department;

    /** 役職 */
    public String position;

    /** Pコード */
    public String pCode;

    /** 作業時間(分) */
    public int workTime;

    public WorkData(String number, String department, String position, String pCode, int workTime){
        this.number = number;
        this.department = department;
        this.position = position;
        this.pCode = pCode;
        this.workTime = workTime;
}
