package 海外兔;

import entity.ListNode;
import entity.TreeNode;
import org.junit.Test;
import util.ArrayUtil;

import java.util.*;


/**
 * @Author: twc
 * @Date 2021/6/30 21:21
 *
 * https://osjobs.net/topk/%E9%98%BF%E9%87%8C/
 **/
public class 阿里 {



    // todo 快排
    // 1.插入排序
    /**

     * @Description
     * @Date 2021/6/30 21:52
     **/
    @Test
    public void test24() {
        int[] ints = ArrayUtil.convertStringIntToArray("[5,2,3,1]");
        int[] ints1 = sortArrayInsert(ints);
         ArrayUtil.printIntArray(ints1);
    }
    public int[] sortArrayInsert(int[] nums) {
          int len= nums.length;
          //循环不变量 : 将nums[i]  fint j=i;
        //            while
        for (int i = 1; i < len; i++) {
            int temp=nums[i];
//            (j>0&&  nums[j-i]>temp){
//                nums[j]= nums[j-1];
//                j--;
//            }
//            nums[j]= temp;
        }
        return nums;
    }
////


//如何随机生成不重复的 10 个 100 以内的数字
    //不知道在问什么， 有现成的api

    /**
     * @Description
     * @Date 2021/7/5 19:05
     **/
    @Test
    public void test() {
        // ？缓存？

        //
    }



    //470. 用 Rand7() 实现 Rand10()
//    public int rand10() {
//        int num = (rand7() - 1) * 7 + rand7();
//
//    }

     //  146. LRU 缓存机制
    // todo   lru为什么可以直接用 Linkedhashmap来实现？
     class LRUCache extends LinkedHashMap<Integer, Integer> {
         private int capacity;

         public LRUCache(int capacity) {
             super(capacity, 0.75F, true);
             this.capacity = capacity;
         }

         public int get(int key) {
             return super.getOrDefault(key, -1);
         }

         public void put(int key, int value) {
             super.put(key, value);
         }

         @Override
         protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
             return size() > capacity;
         }
     }

     //236. 二叉树的最近公共祖先
    //  map dfs 记录每个节点的位置
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return  null;
     }

     //105. 从前序与中序遍历序列构造二叉树  todo 不明白
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  null;
     }
     //19. 删除链表的倒数第 N 个结点


     //1114. 按序打印  todo 阿里线程题目
     class Foo {

         public Foo() {

         }

         public void first(Runnable printFirst) throws InterruptedException {

             // printFirst.run() outputs "first". Do not change or remove this line.
             printFirst.run();
         }

         public void second(Runnable printSecond) throws InterruptedException {

             // printSecond.run() outputs "second". Do not change or remove this line.
             printSecond.run();
         }

         public void third(Runnable printThird) throws InterruptedException {

             // printThird.run() outputs "third". Do not change or remove this line.
             printThird.run();
         }
     }

     // 92 翻转链表2 //todo 思路明了 懒得写

    public ListNode reverseBetween(ListNode head, int left, int right) {
          ListNode preHead = new ListNode(-501);
          preHead.next=head;
          ListNode cur= preHead;

          ListNode leftNode =null;
          ListNode rightNode =null;
          ListNode endNode =null;
          ListNode preNode =null;

          while (cur!=null){
              if (cur.val==left) {
                  leftNode= cur;

              } else if(cur.val == right){
                  rightNode= cur;
                  endNode=cur.next;
                   break;
              }
              cur=cur.next;
          }
//          reverseNode(leftNode,rightNode);

          return  preHead.next;
    }

    //合并区间
    //todo 没时间做 试试和答案不同的map去做
    public int[][] merge(int[][] intervals) {
         Map<Integer,Integer>  map = new HashMap<>();
         int maxLeft=0;
        for (int[] interval : intervals) {
            if (map.containsKey(interval[0])) {
                 map.put(interval[0], Math.max(map.get(interval[0]),interval[1]));
            }else {
                map.put(interval[0],interval[1]);
            }
            maxLeft= Math.max(maxLeft,interval[0]);
        }
        for (int i = 0; i < maxLeft; i++) {
            if (map.containsKey(i)) {

            }
        }
        return  null;
    }


    //1143. 最长公共子序列
}
