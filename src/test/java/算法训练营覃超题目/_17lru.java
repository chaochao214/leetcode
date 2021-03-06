package 算法训练营覃超题目;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/4/23 17:06
 **/
public class _17lru {
    /**
     * @Description   LRU (最近最少使用) 缓存机制
     * @Date 2021/4/23 17:06
     *
     **/
    @Test
    public void test146() {

    }

    class LRUCache {
        private int capacity;
         Map<Integer,Integer> map;
        public LRUCache(int capacity) {
             this.capacity= capacity;
            map= new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                 return  map.get(key);
            }
            return  -1;
        }
        public void put(int key, int value) {

             map.put(key,value);
        }
    }


}


