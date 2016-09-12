package mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mayijun on 2016/9/11.
 */
public class MapListTest {
    public void fun(){
        int[] tieziId=new int[10];
        String[] username={"","","","","","","","","","",""};
        String[] title={"","","","","","","","","","",""};
        String[] content={"","","","","","","","","","",""};
        String[] time={"","","","","","","","","","",""};

        String[] temp={"","","",""};

        Map<Integer,String[]> idMap=new HashMap<>();


        int k=0;
        while(k<10){

            idMap.put(k,new String[]{"a","b","c","d"});
            k++;
        }
        int i=0;
        for (Map.Entry<Integer, String[]> entry : idMap.entrySet()) {
            for(int j=0;j<entry.getValue().length;j++){
                temp[j]=entry.getValue()[j];
            }
            if(i<10) {
                tieziId[i]=entry.getKey();
                username[i] = temp[0];
                title[i] = temp[1];
                content[i] = temp[2];
                time[i] = temp[3];
                System.out.println(entry.getValue().length);
                i++;
            }
            else{
                break;
            }
        }
        for(int v=0;v<10;v++) {
            System.out.println(tieziId[v] + "..." + username[v] + "..."+title[v]+"..."+content[v]+"..."+time[v]);
        }
    }

    public static void main(String[] args) {
        MapListTest mapListTest=new MapListTest();
        mapListTest.fun();
    }
}
