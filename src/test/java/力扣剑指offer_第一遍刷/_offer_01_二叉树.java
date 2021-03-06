package 力扣剑指offer_第一遍刷;

import entity.ListNode;
import entity.Node;
import entity.TreeNode;
import org.junit.Test;
import util.ArrayUtil;

import java.util.*;

/**
 *  https://leetcode-cn.com/problemset/lcof/
 * @Author: twc
 * @Date 2021/4/30 17:08
 **/
public class _offer_01_二叉树 {
    /**
     * @Description   剑指offer 03:数组中重复的数字   todo   超时？
     * @Dat
     * 30 17:08
     **/
    @Test
    public void test03() {


    }
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return  num;
            }
             list.add(num);
        }
        return  -1;
    }

    //04
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) {
             return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]> target || matrix[i][matrix[0].length-1]<target) {
                 continue;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] ==  target) {
                     return  true;
                }
            }
        }
        return  false;
    }

    //05
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    //06
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (Objects.nonNull(head)){
               list.add(head.val);
               head = head.next;
        }
        int[] res =new int[list.size()];
        for (int i = list.size()-1; i>=0; i--) {
             res[i]= list.get(i);
        }
        return res;
    }
    // todo 没做出来
    //07  重建二叉树 .

    /**
     * @Description
     * @Date 2021/5/7 11:00
     **/
    @Test
    public void testOffer07() {

    }
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTreeOffical(int[] preorder, int[] inorder) {
        int n= preorder.length;
        //构造哈希映射，定位根节点
         indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
             indexMap.put(inorder[i],i);
        }

        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    // 0 n-1 0 n-1
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
             return null;
        }
        //前序遍历中的第一个节点就是根节点
        int  preorder_root= preorder_left;
        //在中序遍历中定位根节点
        int  inorder_root = indexMap.get(preorder[preorder_root]);
        //建立根节点
        TreeNode root =new TreeNode(preorder[preorder_root]);
        //以下的看不懂。。。

         return null;
    }

    // 09  两个栈实现队列  todo
    class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1= new LinkedList<Integer>();
            stack2= new LinkedList<Integer>();
        }

        public void appendTail(int value) {
             stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty()) {
                 return  -1;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            //删除尾元素
            Integer pop = stack2.pop();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }

            return pop;
        }
    }

    /**
     * @Description
     * @Date 2021/5/7 11:43
     **/
    @Test
    public void test10_1() {
        System.out.println(fib(45));
    }

    //10-1
    public int fib(int n) {
        if (n==0) {
            return  0;
        }
        if (n==1) {
             return  1;
        }
        int[]  arr = new int[n+1];
        arr[0]= 0;
        arr[1]=1;
        for (int i = 2; i <= n; i++) {
            arr[i] =(arr[i-1]+arr[i-2])% 1000000007;
        }
        return  arr[n];
    }

    /**
     * @Description
     * @Date 2021/5/7 12:02
     **/
    @Test
    public void test10_2() {

        System.out.println(numWays(46));
    }

    //10-2
    public int numWays(int n) {
        if (n==0) {
             return  1;
        }
        if (n==1) {
             return  1;
        }
        if (n==2) {
             return  2;
        }

        int[] arr= new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i <= n; i++) {
             arr[i]= ( arr[i-1]+arr[i-2])%1000000007;

        }
        return  arr[n];
    }

    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                 return  numbers[i];
            }
        }

        return numbers[0];
    }

    /**
     * @Description
     * @Date 2021/5/7 14:29
     **/
    @Test
    public void test12() {
  /*      //demo1  true
        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
        boolean abcced = exist(chars, "ABCCED");
        System.out.println(abcced);

        //demo2  true
        char[][] charsA  = new char[1][1];
        charsA[0][0] ='a';
        System.out.println(exist(charsA, "a"));


        //demo3 false
        char[][] chars1 = ArrayUtil.convertStringCharTwoDimensionArray("[[\"a\",\"a\"]]");
        System.out.println(exist(chars1, "aaa"));

        //demo4  true
        char[][] demoChar4 = ArrayUtil.convertStringCharTwoDimensionArray("[[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]]");
        System.out.println(exist(demoChar4,"AAB"));*/


        //demo5 true
        //todo  路径看不清楚
        char[][] demoChar5 = ArrayUtil.convertStringCharTwoDimensionArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
        System.out.println(exist(demoChar5,"ABCESEEEFS"));
    }

    //12
    public boolean exist(char[][] board, String word) {
        StringBuilder flag = new StringBuilder("a");
        char startChar = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == startChar) {
                      List<String> footage = new ArrayList<>();
                      dfs12(board,word,flag,i,j,footage);
                }
            }
        }
        return  flag.toString().equals("ab");
    }

    private void dfs12(char[][] board, String sb, StringBuilder flag, int i, int j, List<String> footage) {

        if (flag.toString().equals("ab") || sb.length()==0) {
            return;
        }
        if(i<0 || i>=board.length  || j<0 || j>=board[0].length){
             return;
        }
        if (sb.charAt(0) ==  board[i][j]  && !footage.contains("i:"+ i +"j:"+ j)) {
            footage.add("i:"+ i +"j:"+ j);
            if (sb.length()==1) {
                  flag.append("b");
                  return;
            }
            String shortedSb = sb.substring(1);
            System.out.println();
            dfs12(board,shortedSb,flag,i+1,j, footage);
            dfs12(board, shortedSb, flag,i-1,j, footage);
            dfs12(board, shortedSb, flag,i,j+1, footage);
            dfs12(board, shortedSb, flag,i,j-1, footage);

        }else {
            return;
        }
    }

    /**
     * @Description
     * @Date 2021/5/8 11:43
     **/
    @Test
    public void test13() {
        System.out.println(movingCount(11, 8, 16));
    }

    //13
    public int movingCount(int m, int n, int k) {
        if (k>m+n) {
              k=Integer.MAX_VALUE;
        }

        System.out.println(k);
        List<String> list= new ArrayList<>();
        dfs13(m,n,k,0,0,list);
        return list.size();
    }

    private void dfs13(int m, int n, int k, int r, int c, List<String> list) {
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }
        if (list.contains("r" + r + "r" + c)) {
            return;
        }
        if(get(r)+get(c)> k){
            return;
        }
        list.add("r" + r + "r" + c);
        dfs13(m,n,k,r+1,c,list);
        dfs13(m,n,k,r-1,c,list);
        dfs13(m,n,k,r,c+1,list);
        dfs13(m,n,k,r+1,c-1,list);

    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    // todo 数学推导
    //14-1
    public int cuttingRope(int n) {
         return  0;
    }


    //15
    public int hammingWeight(int n) {
        int count =0;
        for (int i = 0; i < 32; i++) {
            int a= n>>i ;
            if ((a&1)==1) {
                 count++;
            }
        }

         return  count;
    }

    //16  todo  快速幂
    public double myPow(double x, int n) {

         return  0;
    }

    //17

    /**
     * @Description
     * @Date 2021/5/10 16:25
     **/
    @Test
    public void test() {
        int[] ints = printNumbers(1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public int[] printNumbers(int n) {
        double pow = Math.pow(10, n)-1;
        Integer maxLne = (int) pow;
        int[] res = new int[maxLne];
        for (Integer i = 0; i < maxLne; i++) {
               res[i]= i+1;
        }
        return  res;
    }

    //18
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pointer = dummyHead;
        while (pointer.next != null) {
            if(pointer.next.val==val){
                pointer.next=pointer.next.next;
            }else {
                pointer = pointer.next;
            }
        }

        return dummyHead.next;
    }

    //19  hard dp
    public boolean isMatch(String s, String p) {

        return  true;
    }

    //20  todo   状态机
    public boolean isNumber(String s) {
//         s.matches()
        return  false;
    }

    //21

    /**
     * @Description
     * @Date 2021/5/10 17:28
     **/
    @Test
    public void test21() {
        int[] ints = ArrayUtil.convertStringIntToArray("[1,2,3,4]");
        System.out.println(Arrays.toString(exchange(ints)));
    }
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                res[count] = nums[i];
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[count] = nums[i];
                count++;
            }
        }
        return res;
    }

    /**
     * @Description
     * @Date 2021/5/10 17:42
     **/
    @Test
    public void test22() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(getKthFromEnd(node1, 2).val);
    }
    //22
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length =1;
        ListNode countHead= head;
        while (countHead.next!=null){
            countHead= countHead.next;
            length++;
        }
        int countNum = length-k+1;
        int count=1;
        ListNode res= head;
        while(count!=countNum){
            count++;
            res= res.next;
        }
        return res;
    }

    //24
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur= head;
        while(cur!=null){
            ListNode next= cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return  pre;
    }

    //25  合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummpyHead = new ListNode(-1);
        ListNode cur = dummpyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummpyHead.next;
    }

    /**
     * @Description
     * @Date 2021/5/14 14:38
     **/
    @Test
    public void test26() {


         //demo1   123   31  false
         /*TreeNode node2 = new TreeNode(2);
         TreeNode node3 = new TreeNode(3);
         TreeNode node1 = new TreeNode(1,node2,node3);

         TreeNode sNode1 = new TreeNode(1);
         TreeNode sNode3 = new TreeNode(3,sNode1,null);

         System.out.println(isSubStructure(node1, sNode3));*/
        //demo2  [1,0,1,-4,-3]
        //[1,-4]   false


    }

    //26  todo 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (Objects.isNull(B)) {
            return true;
        }

        int[] res = new int[1];
        foreachNode(A, B, res);
        return res[0] == 1;
    }

    //遍历a的每一个节点是否和b相等
    private void foreachNode(TreeNode a, TreeNode b, int[] res) {
        if (res[0]==1) {
            return;
        }
        int[] flag= new int[1];

        judgeEqual(a,b,flag);
        //
        if (flag[0]==0) {
             res[0]=1;
        }
        if (Objects.nonNull(a.left)) {
        foreachNode(a.left,b,res);
        }
        if (Objects.nonNull(a.right)) {
        foreachNode(a.right,b,res);
        }

    }
    //判断两个树是否相等
    private void judgeEqual(TreeNode a, TreeNode b, int[] flag) {
        if (flag[0]==1) {
            return;
        }

        if (a==null && b==null) {
             return;
        }
        if (a ==null && b!=null) {
             return;
        }
        if (a.val!=b.val) {
            flag[0]= 1;
            return;
        }
        if (b.left==null && b.right==null) {
            return;
        }

        judgeEqual(a.left,b.left, flag);
        judgeEqual(a.right,b.right, flag);
    }


    // 题解， 题解和我的思路一样， 但我的过于麻烦了
    boolean recur(TreeNode A,TreeNode B){
        if (B==null) {
            return  true;
        }
        if(A==null || A.val!=B.val ){
            return false;
        }
        return recur(A.left,B.right) && recur(A.right, B.right);

    }

    //27
    public TreeNode mirrorTree(TreeNode root) {
        if (Objects.nonNull(root)) {
            switchNode(root);
        }
        return root;
    }

    private void switchNode(TreeNode root) {
          if(Objects.isNull(root.left) && Objects.isNull(root.right)){
               return;
          }
          TreeNode temp =root.left;
          root.left= root.right;
          root.right=temp;
        if (Objects.nonNull(root.left)) {
            switchNode(root.left);
        }
        if (Objects.nonNull(root.right)) {
            switchNode(root.right);
        }
    }

    //28 对称二叉树
    //demo1  [1,2,2,null,3,null,3]
    public boolean isSymmetric(TreeNode root) {
        TreeNode ori= root;
        switchNode(root);
        return equalNode(root,ori);
    }
    public boolean equalNode(TreeNode a,TreeNode b){
        if (b==null && a==null) {
             return  true;
        }
        if(a==null && b!=null){
            return false;
        }
        if(a!=null && b==null){
            return  false;
        }
        return equalNode(a.right,b.right) &&  equalNode(a.left, b.left);

    }



    public boolean isSymmetric2(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
         return  compareSymme(root.left,root.right);
    }

    private boolean compareSymme(TreeNode left, TreeNode right) {
        if (left==null && right!=null) {
            return false;
        }
        if (left!=null && right==null) {
            return false;
        }
        if (left==null && right==null) {
            return true;
        }
        if (left.val!=right.val) {
             return false;
        }
       return  compareSymme(left.left,right.right) &&compareSymme(left.right,right.left);
    }

    //29  todo 不难，但是很麻烦
    public int[] spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i=0;
        int j=0;
        String direction = "left";
        List list =new ArrayList();
        while(true){
            list.add(matrix[i][j]);
            matrix[i][j]=-1;
            if (j+1<r) {
                  j=j+1;
                  continue;
            }
            if(j+1==r && i+1<c){


            }
        }
    }

    //30,  todo 没做出 包含min函数的栈
    class MinStack {
        Stack<Integer> A;
        Stack<Integer> B;

        /** initialize your data structure here. */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if(B.isEmpty() || B.peek() >= x)
                B.add(x);
        }

        public void pop() {
            if(A.pop().equals(B.peek()))
                B.pop();
        }

        public int top() {
         return  A.peek();
        }

        public int min()  {
            return B.peek();
        }
    }

    //31,     todo 看不懂题目 ，自己做一遍
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return true;
    }

    public boolean validateStackSequencesOfficial(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i =0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty()  && stack.peek()==popped[i]){
                 stack.pop();
                 i++;
            }
        }
        return stack.isEmpty();
    }

    // 32
    public int[] levelOrder(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        printNode(root,list);
       int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
             res[i]= list.get(i);
        }
       return res;
    }

    // todo 自己写的 dfs 深度优先
    private void printNode(TreeNode root, List<Integer> list) {
        if (Objects.isNull(root)) {
            return;
        }
        list.add(root.val);
        if (root.left !=null) {
            list.add(root.left.val);
        }
        printNode(root.left,list);
        printNode(root.right,list);
    }

    // bfs 遍历二叉树
    public int[] levelOrderOffical(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll==null) {
                continue;
            }
            list.add(poll.val);
            if (poll.left!=null) {
                queue.add(poll.left);
            }
            if (poll.right!=null) {
                queue.add(poll.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]= list.get(i);
        }
        return res;
    }

    //32 -2
    public List<List<Integer>> levelOrderOfficial(TreeNode root) {
        if (root==null) {
             return  new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null) {
                      queue.add(poll.left);
                }
                if (poll.right!=null) {
                    queue.add(poll.right);
                }
            }
            res.add(list);
        }
        return  res;
    }

    //32-3  todo 没做出来
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root==null) {
            return  new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag=true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode node = new TreeNode();
                if (flag){
                    node = queue.poll();
                    if (node.left!=null) {
                        queue.add(node.left);
                    }
                    if (node.right!=null) {
                        queue.add(node.right);
                    }
                }else {
                    node = queue.pollLast();
                    if (node.right!=null) {
                        queue.add(node.right);
                    }
                    if (node.left!=null) {
                        queue.add(node.left);
                    }
                }
                list.add(node.val);

            }
            flag= !flag;
            res.add(list);
        }
        return  res;
    }

    //33 todo  二叉搜索树的后序遍历序列   二叉树左节点小于跟节？
    public boolean verifyPostorder(int[] postorder) {
         return recur33(postorder,0,postorder.length-1);
    }

    private boolean recur33(int[] postorder, int i, int j) {
        if (i>=j) {
             return true;
        }
        int p=i;
        while(postorder[p]<postorder[j]){
             p++;
        }
        int m=p;
        while(postorder[p]>postorder[j]) p++;
        return  p==j && recur33(postorder,i,m-1)&&recur33(postorder,m,j-1);
    }


    //34

    /**
     * @Description
     * @Date 2021/5/24 18:25
     **/
    @Test
    public void test34() {
        //demo1
//        TreeNode node1 =new TreeNode(1);
//        TreeNode node3 =new TreeNode(3);
//        TreeNode node2 =new TreeNode(2,node1,node3);
//        System.out.println(pathSum(node2, 3));


        TreeNode node7  =new TreeNode(7);
        TreeNode node2  =new TreeNode(2);
        TreeNode node11  =new TreeNode(11,node2,node7);
        TreeNode node4  =new TreeNode(4,node11,null);
        TreeNode node5  =new TreeNode(5,node4,null);
        System.out.println(pathSum(node5,22));
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if (null==root) {
             return res;
        }
        List list = new ArrayList();
        list.add(root.val);
        recur34(root,list,res,target);
        return res;
    }

    private void recur34(TreeNode root, List<Integer> list, List<List<Integer>> res, int target) {
        Integer sum = list.stream().reduce(0, Integer::sum);
        //   if (Math.abs(sum) > Math.abs(target)) {
        //     return;
        // }
        if (sum == target) {
            // System.out.println("")
            if (root.left == null && root.right == null) {
                res.add(list);
            }
        }
        List newList = new ArrayList();
        newList.addAll(list);
        if (Objects.nonNull(root.left)) {
            list.add(root.left.val);
            recur34(root.left, list, res, target);
        }
        if (Objects.nonNull(root.right)) {
            newList.add(root.right.val);
            recur34(root.right, newList, res, target);
        }
    }
    //35  todo 没有题解，也 看不懂题目
    public Node copyRandomList(Node head) {
          return null;
    }

    //36 todo 中序遍历
    class Solution36 {
        Node pre,head;
        public Node treeToDoublyList(Node root) {
            if (root==null) {
                return  null;
            }
            dfs36(root);
            head.left=pre;
            pre.right = head;
            return  head;
        }

        void dfs36(Node cur){
            if (cur==null) {
                return;
            }
            dfs36(cur.left);
            if (pre!=null) {
                pre.right = cur;
            } else {
                head= cur;
            }
            cur.left= pre;
            pre = cur;
            dfs36(cur.right);
        }
    }

    //37 todo 序列化 反序列化二叉树
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
             List<Integer>  list = new ArrayList<>();
             List<TreeNode> nodeList=new ArrayList<>();
             nodeList.add(root);
             bfs37Ser(list,nodeList);
             return  list.toString();
        }

        private void bfs37Ser(List<Integer> list, List<TreeNode> nodeList) {
            if (!nodeList.isEmpty()) {
                List<TreeNode> newList = new ArrayList<>();
                for (TreeNode node : nodeList) {
                    if (node!=null) {
                        list.add(node.val);
                        if (node.left != null) {
                            newList.add(node.left);
                        }
                        if (node.right != null) {
                            newList.add(node.right);
                        }
                    }
                }
                nodeList= newList;
            }else{
                //nodelist 为空
                 return;
            }
            bfs37Ser(list,nodeList);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

             return null;
        }
    }

}
