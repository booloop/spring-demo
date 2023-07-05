import java.util.Scanner;

public class DeleteNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入数字:");
        String a = input.nextLine();
        System.out.print("删除数字的个数:");
        int n = input.nextInt();

        char a1[] = a.toCharArray();

        if(n == 0) {
            System.out.println(a);
        }

        if(a1.length < n) {
            System.err.println("字符串长度不够");
        }else if(a1.length == n) {
            System.err.println("删完了");
        }else {
            int t = n;
            int i = 0;
            while(t > 0 && i < a.length() - 1) {
                if(a1[i] > a1[i + 1]) {
                    for(int j = i; j < a1.length - 1; j++) {
                        a1[j] = a1[j + 1];
                    }
                    i = -1;
                    t--;
                }
                i++;

            }
            for(int j = 0; j < a1.length - n;j++) {

                System.out.print(a1[j]);

            }
        }

    }

}