import java.util.HashMap;
import java.util.TreeSet;

public class Add {


    public static void main(String[] args) {
        System.out.println();
        TreeSet s;
//        System.out.println(add(5,17));
//        System.out.println(add(52,17));
        
        System.out.println(convertNum("0xAA"));
    }


    static int add(int num1, int num2) {
        int sum, tmp;

        do {
            System.out.println("num1==="+Integer.toBinaryString(num1));
            System.out.println("num2==="+Integer.toBinaryString(num2));
            sum = num1 ^ num2;
            tmp = (num1 & num2) << 1;
            num1 = sum;
            num2 = tmp;
            System.out.println("num1>>"+Integer.toBinaryString(num1));
            System.out.println("num2>>"+Integer.toBinaryString(num2));
            System.out.println();
        } while (num2 > 0);

        return sum;
    }

    public static int convertNum(String str)
    {
        String[] c={"A","B","C","D","E","F"};
        HashMap<String,Integer> hashmap= new HashMap<>();
        for(int i=0; i<=9;i++)
        {
            hashmap.put(i+"",i);
        }
        for(int j=10;j<=15;j++)
        {
            hashmap.put(c[j-10],j);
        }

//        String[] st=new String[str.length()];
//        for(int i=0;i<=str.length()-1;i++)
//        {
//            st[i]=str.substring(i,i+1);
//        }

        int num=0;
        for(int i=2;i<=str.length()-1;i++)
        //这里需要注意，如果输入是类似"1A"没有标识的16进制数，i的值从0开始
        //如果是"0x1A"这样有标识符的16进制，则在计算时，需要截掉0x这两位标识，i从2开始
        {
            num += hashmap.get(str.charAt(i)+"") * Math.pow(16,str.length()-1-i);
        }
        return num;
    }


}
