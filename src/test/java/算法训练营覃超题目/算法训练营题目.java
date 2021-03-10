package 算法训练营覃超题目;

import entity.ListNode;
import org.junit.Test;

import javax.naming.ldap.LdapReferralException;
import java.util.*;

/**
 * @Author: twc
 * @Date 2021/1/5 11:51
 **/

public class 算法训练营题目 {



    @Test
    public void test94() {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test322() {

    }

    //    public int coinChange(int[] coins, int amount) {
//
//    }
    @Test
    public void test69() {
//        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        Long head = 0l;
        Long tail = Long.valueOf(x);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > x) {
                tail = (head + tail) / 2;
            } else if (res * res < x) {
                head = (head + tail) / 2;
            } else if (res * res == x) {
                return res.intValue();
            }

            if (res == (head + tail) / 2) {
                return res.intValue();
            } else {
                res = (head + tail) / 2;
            }

        }
    }

    @Test
    public void test367() {

    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        Long head = 0l;
        Long tail = Long.valueOf(num);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > num) {
                tail = (head + tail) / 2;
            } else if (res * res < num) {
                head = (head + tail) / 2;
            } else if (res * res == num) {
//                return  res.intValue();
                return true;
            }

            if ((tail - head == 1) && head * head != num && tail * tail != num) {
                return false;
            } else if (res * res == num) {
                return true;
            } else {
                res = (head + tail) / 2;
            }
        }

    }

    @Test
    public void test191() {
        //   idea debug得知  读取成8进制的，很怪异
        System.out.println(hammingWeight(00000000000000000000000000001011));
//        System.out.println(hammingWeight(1011));
//        System.out.println(hammingWeight(00000000000000000000000000000010));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {int count = 0;
        for
         (int i = 0; i < 32; i++) {
            int a = n >> i;
            int b = a & 1;
            if (b == 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test50() {
//         System.out.println(quickMul(2.0, -2147483648));
        System.out.println(myPow(2.0, -2147483648));
        System.out.println(myPow(2.0, -4));

    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
//        if(N<0) {
//            x=1/x;
//            N=-N;
//        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    @Test
    public void test78(){
      // 测试移位运算符
        System.out.println(1 << 4);
        int[] a={2,5,9};
        System.out.println(subsets(a));
    }
    List<Integer>  t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        for (int mask = 0; mask < 1<<n; mask++) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
         return  ans;
    }
     @Test
    public void test198(){
          int[] arr= {2,7,9,3,1};
         System.out.println(rob(arr));

     }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int res = 0;
        for (int i = 2; i < len; i++) {
            int temp = second;
            res = Math.max(second, nums[i] + first);
            second = res;
            first = temp;
        }
        return res;
    }
    @Test
    public void  test121(){
        int[] arr= {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        if (prices.length==1) {
            return 1;
        }
        // int[i][是否持股]
        int[][] dp = new int[prices.length][2];
        dp[0][0]= 0;
        dp[0][1]= -prices[1];
        for (int i = 1; i < prices.length; i++) {
            // 不持股
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // 持股
            dp[i][1] = dp[i-1][0]+prices[i];

        }
       return 0;
    }
    @Test
    public  void test208(){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }

    class Trie {
         private  boolean is_string =false;
         private  Trie next[] =new Trie[26];


        //R links to node children



        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
//                  if(root.next[w[i]-'a']==null)
                if (root.next[w[i]-'a'] == null) {
                    root.next[w[i]-'a'] = new Trie();
                }
                    root = root.next[w[i]-'a'];

            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
          return  false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return  false;
        }
    }

    @Test
    public void test22(){

    }
    public List<String> generateParenthesis(int n) {
        return null;
    }


}



