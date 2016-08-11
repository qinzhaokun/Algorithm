package Round367;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/12.
 */
public class C_Hard_problem {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        //String [] a = new String[100005];
        int [] pay = new int[100005];
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            for(int i = 0;i < n;i++) pay[i] = scanner.nextInt();

            scanner.nextLine();
            String last = "";
            long doRe = 0;long doNotRe = 0;
            for(int i = 0;i < n;i++){
                String tmp = scanner.nextLine();
                if(i == 0){
                    last = tmp;
                    doRe = pay[i];
                    doNotRe = 0;
                }
                else{
                    //if(tmp.equals(last)) continue;
                    long tmpNot = -1;
                    long tmpRe = -1;
                    // tmp do not re
                    if(tmp.compareTo(last) >= 0 && doNotRe != -1){
                        if(tmpNot == -1 || tmpNot > doNotRe) tmpNot = doNotRe;
                    }

                    if(doRe != -1){
                        String last1 = new StringBuffer(last).reverse().toString();
                        if(tmp.compareTo(last1) >= 0){
                            if(tmpNot == -1 || tmpNot > doRe) tmpNot = doRe;
                        }
                    }

                    //tmp do re
                    String tmp1 = new StringBuffer(tmp).reverse().toString();
                    if(tmp1.compareTo(last) >= 0 && doNotRe != -1){
                        if(tmpRe == -1 || tmpRe > doNotRe+ pay[i]) tmpRe = doNotRe + pay[i];
                    }

                    if(doRe != -1){
                        String last1 = new StringBuffer(last).reverse().toString();
                        if(tmp1.compareTo(last1) >= 0){
                            if(tmpRe == -1 || tmpRe > doRe+ pay[i]) tmpRe = doRe + pay[i];
                        }
                    }

                    doNotRe = tmpNot; doRe = tmpRe;
                    last = tmp;
                }

            }
            if(doNotRe == -1){
                System.out.println(doRe);
            }
            else if(doRe == -1){
                System.out.println(doNotRe);
            }
            else
            System.out.println(Math.min(doNotRe,doRe));
        }
    }
}
