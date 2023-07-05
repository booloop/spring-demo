import java.util.*;

class MyCalendarThree {
    Map<V,Integer> map = new HashMap<>();
    List<V> list = new ArrayList<>();

    public MyCalendarThree() {

    }

    public int book(int startTime, int endTime) {
        V v = new V(startTime,endTime);
        map.put(v,1);
        System.out.println("=========>>>>"+v.startTime+"-"+v.endTime);
        for(V v1:list){
            if(haveCommonRange(v,v1)){
                System.out.println(v.startTime+"-"+v.endTime+">>>>"+v1.startTime+"-"+v1.endTime);
                map.put(v1,map.get(v1)+1);
            }
        }
        list.add(v);
        return map.values().stream().max(Comparator.comparingInt(r->r.intValue())).get();
    }


    boolean haveCommonRange(V v1,V v2){
        return (v1.startTime >= v2.startTime && v1.startTime < v2.endTime )||
                (v2.startTime >= v1.startTime && v2.startTime < v1.endTime);
    }


    static class V{
        public int startTime;
        public int endTime;
        public V(int s,int e){
            this.startTime = s;
            this.endTime = e;
        }
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */