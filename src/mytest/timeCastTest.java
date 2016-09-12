package mytest;

/**
 * Created by Mayijun on 2016/9/12.
 */
public class TimeCastTest {
    public void fun(){
        char[] time="2016-09-12 16:58:02".toCharArray();
        StringBuffer tablename=new StringBuffer();
        tablename.append("table_");
        for(int i=0;i<time.length;i++){
            if(time[i]=='-'||time[i]==' '||time[i]==':'){
                continue;
            }
            else {
                System.out.print(time[i]);
            }
        }
    }

    public static void main(String[] args) {
        TimeCastTest timeCastTest=new TimeCastTest();
        timeCastTest.fun();
    }
}
