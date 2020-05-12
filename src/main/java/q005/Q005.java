package q005;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q005 {
    private static InputStream openDataFile() {
        return Q005.class.getResourceAsStream("data.txt");
    }
    public static void main(String[] args) {
        int ct = 0;
        try {
            InputStreamReader in = new InputStreamReader(openDataFile());
            BufferedReader inb = new BufferedReader(in);
            String line;
            ct = 0;
            ArrayList<WorkData> memList = new ArrayList<WorkData>();
            String[] list;
            while ((line = inb.readLine()) != null) {
                if (ct == 0){
                    ct++;
                    continue;
                }
                System.out.println(line);
                list = line.split(",", 5);
                memList.add(new WorkData(list[0],list[1],list[2],list[3],Integer.parseInt(list[4])));
                System.out.format("%s - %s - %s - %s - %d時間%d分\n",
                        memList.get(ct-1).number,
                        memList.get(ct-1).department,
                        memList.get(ct-1).position,
                        memList.get(ct-1).pCode,
                        memList.get(ct-1).workTime / 60,memList.get(ct-1).workTime % 60);
                ct++;
            }
            System.out.println("以上" + ct + "行");
            inb.close();
            in.close();

            List<String> ptmp = new ArrayList<>();
            for (int k = 0; k< ct-1;k++) {
                if (ptmp.contains(memList.get(k).position)) {
                    continue;
                }
                ptmp.add(memList.get(k).position);
            }
            String[] pstr = new String[ptmp.size()];
            int[] pint = new int[ptmp.size()];
            int i = 0;
            int pos = 0;
            for (int j = 0; j < ct-1;j++) {
                pos = ArrayUtils.indexOf(pstr, memList.get(j).position);
                System.out.print(pos + "\n");
                if (pos > -1) {
                    pint[ArrayUtils.indexOf(pstr, memList.get(j).position)] += memList.get(j).workTime;
                    continue;
                }
                pstr[i] = memList.get(j).position;
                pint[i] = memList.get(j).workTime;
                i++;
            }
            for (int h = 0; h < ptmp.size();h++) {
                System.out.format("%s : %d時間%d分\n",
                        pstr[h],pint[h] / 60,pint[h] % 60);
            }



            List<String> pCtmp = new ArrayList<>();
            for (int pCk = 0; pCk< ct-1;pCk++) {
                if (pCtmp.contains(memList.get(pCk).pCode)) {
                    continue;
                }
                pCtmp.add(memList.get(pCk).pCode);
            }
            String[] pCstr = new String[pCtmp.size()];
            int[] pCint = new int[pCtmp.size()];
            int pCi = 0;
            int pCod = 0;
            for (int pCj = 0; pCj < ct-1;pCj++) {
                pCod = ArrayUtils.indexOf(pCstr, memList.get(pCj).pCode);
                System.out.print(pCod + "\n");
                if (pCod > -1) {
                    pCint[ArrayUtils.indexOf(pCstr, memList.get(pCj).pCode)] += memList.get(pCj).workTime;
                    continue;
                }
                pCstr[pCi] = memList.get(pCj).pCode;
                pCint[pCi] = memList.get(pCj).workTime;
                pCi++;
            }
            for (int pCh = 0; pCh < pCtmp.size();pCh++) {
                System.out.format("%s : %d時間%d分\n",
                        pCstr[pCh],pCint[pCh] / 60,pCint[pCh] % 60);
            }




            List<String> ntmp = new ArrayList<>();
            for (int nk = 0; nk< ct-1;nk++) {
                if (ntmp.contains(memList.get(nk).number)) {
                    continue;
                }
                ntmp.add(memList.get(nk).number);
            }
            String[] nstr = new String[ntmp.size()];
            int[] nint = new int[ntmp.size()];
            int ni = 0;
            int num = 0;
            for (int nj = 0; nj < ct-1;nj++) {
                num = ArrayUtils.indexOf(nstr, memList.get(nj).number);
                System.out.print(num + "\n");
                if (num > -1) {
                    nint[ArrayUtils.indexOf(nstr, memList.get(nj).number)] += memList.get(nj).workTime;
                    continue;
                }
                nstr[ni] = memList.get(nj).number;
                nint[ni] = memList.get(nj).workTime;
                ni++;
            }
            for (int nh = 0; nh < ntmp.size();nh++) {
                System.out.format("%s : %d時間%d分\n",
                        nstr[nh],nint[nh] / 60,nint[nh] % 60);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
// 完成までの時間: 02時間 30分