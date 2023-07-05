import java.util.*;

public class UnHappyChildrens {

    public static void main(String[] args) {
        int[] childrens = new int[]{1,2,1,2};
        System.out.println(getUnHappy(childrens,1));
        getUnHappy2(childrens,1);
        getUnHappy3(childrens,1);
        calculateUnhappyChildren(childrens,1);

        childrens = new int[]{1,2,2,3,1,3};
        System.out.println(getUnHappy(childrens,1));
        getUnHappy2(childrens,1);
        getUnHappy3(childrens,1);
        calculateUnhappyChildren(childrens,1);

    }

    private static int calculateUnhappyChildren( int[] children,int carCount) {
        Set<Integer> occupiedCars = new HashSet<>();
        int unhappyChildrenCount = 0;

        for (int childCode : children) {
            if (occupiedCars.contains(childCode)) {
                // 如果小朋友的摇摇车已经被占用，则记录不开心的小朋友
                unhappyChildrenCount++;
            } else if (occupiedCars.size() < carCount) {
                // 如果有空闲的摇摇车，则小朋友玩耍后离开
                occupiedCars.add(childCode);
            }
        }
        System.out.println(unhappyChildrenCount);
        return unhappyChildrenCount;
    }


     static void getUnHappy2(int[] children, int carCount) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("请输入摇摇车数量（1<N<10）：");
//        int carCount = scanner.nextInt();

        Set<Integer> occupiedCars = new HashSet<>();
        int unhappyChildrenCount = 0;

        System.out.print("请输入小朋友的来去情况（使用编码，以空格分隔）：");
//        while (scanner.hasNextInt()) {
         for(int childCode:children){
//            int childCode = scanner.nextInt();
            if (occupiedCars.contains(childCode)) {
                // 如果小朋友的摇摇车已经被占用，则不开心
                unhappyChildrenCount++;
            } else if (occupiedCars.size() < carCount) {
                // 如果有空闲的摇摇车，则小朋友玩耍后离开
                occupiedCars.add(childCode);
            } else {
                // 如果没有空闲的摇摇车，则小朋友离开
                unhappyChildrenCount++;
            }
        }

        System.out.println("不开心的小朋友数量：" + unhappyChildrenCount);
    }

    static void getUnHappy3(int[] children, int carCount) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入摇摇车数量（1 < N < 10）：");
//        int carCount = scanner.nextInt();

        Set<Integer> occupiedCars = new HashSet<>();
        List<Integer> unhappyChildren = new ArrayList<>();

        System.out.print("请输入小朋友的来去情况（使用编码，以空格分隔）：");
//        while (scanner.hasNextInt()) {
//            int childCode = scanner.nextInt();
        for(int childCode:children){
            if (occupiedCars.contains(childCode)) {
                // 如果小朋友的摇摇车已经被占用，则记录不开心的小朋友
                unhappyChildren.add(childCode);
            } else if (occupiedCars.size() < carCount) {
                // 如果有空闲的摇摇车，则小朋友玩耍后离开
                occupiedCars.add(childCode);
            } else {
                // 如果没有空闲的摇摇车，则小朋友离开
                unhappyChildren.add(childCode);
            }
        }

        System.out.println("不开心的小朋友数量：" + unhappyChildren.size());
    }


    static int getUnHappy(int[] children, int n) {
        int unHappy = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : children) {
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    n++;
                } else {
                    if (n <= 0) {
                        unHappy++;
                    }
                }
            } else {
                if (n > 0) {
                    n--;
                    map.put(c, 1);
                } else {
                    map.put(c, -1);
                }
            }
        }
        return unHappy;
    }

}
