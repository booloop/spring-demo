import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    static int getMaxDrink(int n) {
        int max = 0;
        int k = 0;
        do {
            n = n + k;
            k = n % 3;
            n = n / 3;
            max += n;
        } while ((n+k) >= 3);

        if ((n+k) == 2) {
            max++;
        }

        return max;
    }


    public int[][] reconstructQueue(int[][] people) {
        Integer[] test = new Integer[0];

        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, test);

//        HashSet<Integer> d = new HashSet<>(Collections.);

        Collections.addAll(new ArrayList<>(), 1, 2, 3, 4);

        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[][]{});
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(getMaxDrink(10));
        System.out.println(getMaxDrink(3));
        System.out.println(getMaxDrink(10));
        System.out.println(getMaxDrink(81));


        Queue<Integer> queVal = new LinkedList<Integer>();

        String ss = "";

        queVal.poll();

        ArrayDeque xx;

        TreeSet<Integer> s = new TreeSet<>();
        s.add(11);


        List<Character> list2 = null;
//        list.stream().collect(Collectors.joining(""))
        String result = list2.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        ArrayList sd;
        s.pollLast();

        threeSumClosest(new int[]{-1, 2, 1, -4}, 1);


        Map<String, Integer> map = new HashMap<>();

//        map.values().stream().max(Comparator.comparingInt(v->v.intValue())).get();


        List<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(20, 666);

        System.out.println(list);

    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        int result = Math.abs(sum - target);
        int tmp = 0;
        int tmpSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    tmpSum = nums[i] + nums[k] + nums[j];
                    tmp = Math.abs(tmpSum - target);
                    if (tmp < result) {
                        result = tmp;
                        sum = tmpSum;
                    }
                }
            }
        }
        return result;
    }

    public int removeElement(int[] nums, int val) {
        int endIdx = nums.length - 1;
        for (int i = 0; i <= endIdx; ) {
            if (nums[i] == val) {
                if (i < nums.length - 1) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = nums[endIdx];
                }
                endIdx--;
            } else {
                i++;
            }
        }
        return endIdx + 1;
    }

    public int removeElement2(int[] nums, int val) {
        int idx = 0;
        for (int v : nums) {
            if (v != val) {
                nums[idx] = v;
                idx++;
            }
        }
        return idx;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int min = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[0] + nums[1] + nums[2];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }

    static int dd(int a, int b) {
        int k = a / 3 + b / 3;
        System.out.println(k);
        return a / 3 + b / 3;
    }

    static void tt() {


        String str = "acf";
        Stream<String> t = Stream.of(str.split(""));
//str:{"h","e","l","l","o"}
//        Stream<Character> chStream = t.map(s -> (char)((s.charAt(0)-'a')%26+'a'));


        List<Character> collect1 = t.map(v -> v.charAt(0)).collect(Collectors.toList());

//        List<Character> collect = chStream.collect(Collectors.toList());

        System.out.println();

        /*
         * 也可直接一步完成操作：
         * s -> (char)((s.charAt(0)-'a'+1)%26+'a')
         */
    }


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, List<String>> collect = Stream.of(words).collect(Collectors.groupingBy(v -> v));
        Map<String, Integer> map = new HashMap<>();
        for (String key : collect.keySet()) {
            map.put(key, collect.get(key).size());
        }
        int len = words[0].length();
        int totalLen = len * words.length;

        int begin = 0;
        int end = begin + totalLen;

        while (end <= s.length()) {
            Map<String, Integer> tmpMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                int tmpBegin = i * len + begin;
                String substring = s.substring(tmpBegin, tmpBegin + len);
                Integer integer = tmpMap.get(substring);
                if (integer == null) {
                    integer = 0;
                }
                tmpMap.put(substring, ++integer);
            }
            if (tmpMap.equals(map)) {
                result.add(begin);
            }
            begin++;
            end = begin + totalLen;
        }
        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        String w = Arrays.stream(Arrays.stream(words).collect(Collectors.joining("")).split("")).sorted().collect(Collectors.joining(""));

        for (int i = 0; i < s.length(); i++) {
            if (w.length() > s.length() - i) {
                break;
            }
            String t = s.substring(i, i + w.length());
            String sort = Stream.of(t.split("")).sorted().collect(Collectors.joining());
            if (w.equals(sort)) {
                result.add(i);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//
//
//        findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
//
//        tt();
//
//        System.out.println("abc".substring(1, 2));
//
//        String sf = Arrays.stream(Arrays.stream(new String[]{"abfgc", "xxff"}).collect(Collectors.joining("")).split("")).sorted().collect(Collectors.joining(""));
//
//        String[] ar = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams(ar);
//
//
//        Integer studentId = Stream.of(2, 2, 3).parallel().reduce(0,
////                (sum, v) -> {
////                    return sum + v;
////                },
//                (s1, s2) -> s1 * s2);
//        System.out.println(studentId);
//
//        int i = Stream.of(12, 6, 24).reduce(0, (a, b) -> a / 3 + b / 3).intValue();
//        int i2 = Stream.of(12, 6, 24).reduce(0, (a, b) -> dd(a, b)).intValue();
//
//        int k = ((0 + 12 / 3) / 3 + 6 / 3) / 3 + 24 / 3;
//
//
//        Map<String, List<String>> collect = Arrays.stream(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).collect(Collectors.groupingBy(v -> {
//            char[] array = v.toCharArray();
//            Arrays.sort(array);
//            return new String(array);
//        }));
//
//        Collection<List<String>> values = collect.values();
//
//        ArrayList<List<String>> lists1 = new ArrayList<>(values);
//
//
//        Character d = 'x';
//
////        Double doubleStream = "".chars().mapToDouble(v -> v).max().stream().max().getAsDouble();
//
//        char reduce = (char) "".chars().reduce(0, (a, b) -> a ^ b);
//
//        Map<String, Integer> map1 = new LinkedHashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//
//        map1.put("a", 1);
//        map2.put("a", 2);
//
//        System.out.println(map1.equals(map2));
//
//
//        getMaxSubStrLen(" ");
//
//        dd();
//        int[] ss = new int[10];
//        int[] array = Arrays.asList(1, -3, 4, -2, 5, -9, 6).stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(getMaxSum(array));
//        System.out.println(getMaxSum2(array));
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }

    static void dd() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        System.out.println("===============");
    }


    static void transCo() {

        String str = "中文测试";

        Charset utf8 = StandardCharsets.UTF_8;

        byte[] array = utf8.encode(str).array();

        byte[] bytes = Arrays.copyOfRange(array, 0, 11);

        ByteBuffer bbuf = ByteBuffer.allocate(12);
        CharBuffer cbuf = CharBuffer.allocate(12);

        bbuf.put(bytes);
        bbuf.flip();

        utf8.newDecoder().decode(bbuf, cbuf, true);
        cbuf.flip();

        char[] chars = new char[cbuf.length()];

    }

    static int getMaxSubStrLen(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        Set<String> set = new HashSet<>();
        if (charArray.length == 1) {
            return 1;
        }
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (maxLen >= len - i) {
                break;
            }
            set.add(charArray[i] + "");
            for (int j = i + 1; j < len; j++) {
                if (set.contains(charArray[j] + "")) {
                    maxLen = Math.max(maxLen, set.size());
                    set.clear();
                    break;
                } else {
                    set.add(charArray[j] + "");
                }
            }
        }
        return maxLen;
    }


    static int getMaxSum2(int nums[]) {
        int max = nums[0];
        int sum = 0;
        for (int i : nums) {
            if (sum < 0) {
                sum = i;
            } else {
                sum = sum + i;
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    static int getMaxSum(int nums[]) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int total = 0;
                for (int k = i; k <= j; k++) {
                    total += nums[k];
                }
                System.out.println(String.format("max=%d total=%d", max, total));
                max = Math.max(max, total);

                System.out.println(String.format("%d,%d", i, j));
            }
        }
        return max;
    }
}
