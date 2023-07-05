//import java.util.*;

import java.util.*;

class FreqStack {

    List<Integer> list = null;
    Map<Integer, Deque<Integer>> map=null;
    int maxCount;
    int maxVal;

    public FreqStack() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public void push(int val) {
        list.add(val);
        Deque<Integer> q= map.getOrDefault(val, new ArrayDeque<Integer>());
        q.push(list.size()-1);
        map.put(val,q);
        if(q.size()>=maxCount){
            maxCount = q.size();
            maxVal = val;
            //    System.out.println("push maxCount--->"+maxCount);
            //    System.out.println("push maxVal--->"+maxVal);
            //    System.out.println();
        }
        //    System.out.println("map--->"+map);
        // System.out.println("after push list--->"+list);
    }

    public int pop() {
        // System.out.println("map--->"+map);
        //         System.out.println("maxVal--->"+maxVal);
        int idx = map.get(maxVal).pop();
        // System.out.println("popIdx--->"+idx);

        list.set(idx,null);
        int max = maxVal;
        int maxCnt = 0;
        for(int i=list.size()-1;i>=0;i--){
            Integer o = list.get(i);
            if(o!=null){
                // System.out.println("map.get(o).size()="+map.get(o).size()+";o-->"+o);
                if(map.get(o).size()>maxCnt){
                    maxCnt = map.get(o).size();
                    maxVal = o;
                }
                // System.out.println("maxVal--->"+maxVal);
                // System.out.println("maxCount--->"+maxCount);
            }
        }
        maxCount = maxCnt;
        // System.out.println("after pop list--->"+list);
        // System.out.println();
        return max;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */