# 剑指offer题解心得

## 数组

### 1. 二维数组中的查找

**题目描述**

一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**题解**

1. 可以对每一行进行二分查找
2. 从左下角开始（最小的值）向上向右遍历

**心得**

**答案**

```java
oolean fine2(int target, int[][] array){
        int rowCount = array.length;
        int columnCount = array[0].length;

        for(int i=rowCount-1 ,j =0; i < rowCount && j < columnCount;){
            if(target == array[i][j]){
                return true;
            }
            else if(target > array[i][j]){
                j++;
                continue;
            }
            else if(target < array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }
```





### 2. 数组中重复的数字

**题目描述**

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

**题解**

**心得**

二分查找中对于寻找第一个相同的数字解法：先排序，然后二分查找

**答案**

```java
/**
 * 归位思想
 * 一个萝卜一个坑,如果存在重复,那么自己原来的位置就迟早会被自己占据
 * 边查重边排序
 */
public boolean duplicate3(int numbers[], int length, int[] duplication) {
    if (length <= 0 || numbers == null) {
        return false;
    }

    int index = 0;
    
    while (index < length) {
        if (numbers[index] == index) { // 当前下标index的值刚好为index
            index++;
        } else {
            int tmp = numbers[index];
            if (tmp == numbers[tmp]) { // 要交换位置的两个数相同
                duplication[0] = tmp;
                return true;
            } else { // 交换位置
                numbers[index] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
    }
    return false;
}
```



### 3. 构建乘积数组

**题目描述**

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0]和B[n-1] = 1）

**心得**

关键在于如何相乘的思想上，要想到可以把B[i]=A[0]A[1]....A[i-1]A[i+1]....A[n-1]。看成A[0]A[1].....A[i-1]和A[i+1].....A[n-2]A[n-1]两部分的乘积。即通过A[i]项将B[i]分为两部分的乘积。效果相当于是个对角矩阵。

**答案**

```java
public int[] multiply2(int[] A) {
    int[] B = new int[A.length];
    int res = 1;
    for(int i=0;i<A.length;i++){
        B[i] = res;
        res *= A[i];
    }
    res= 1;
    for(int i=A.length-1;i>=0;i--){
        B[i] *= res;
        res *= A[i];
    }
    return B;
}
```



## 字符串

### 4. 替换空格

**题目描述**

请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

**心得**

暴力方法底层的实现是会执行多次resize操作。因此在数据量大的情况下，性能会降低。

将StringBuilder改成用数组构建字符串也是一种办法

此外考虑正则表达式也可



**答案**

```java
//实际上也可称之为双指针法,新旧数组利用指针一起移动
public String replaceSpace2(StringBuffer str){
    String specifiedChars = "%20";
    int isr = 0;
    //执行一次N的遍历
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
            isr++;
        }
    }
    //最后的新数组的大小
    int newCapacity = str.length() + (isr * specifiedChars.length());
    char[] newChars = new char[newCapacity];
    for (int i = 0, j = 0; i < newCapacity && j < str.length(); i++) {
        if (str.charAt(j) == ' ') {
            for (int t = 0; t < specifiedChars.length(); t++) {
                newChars[i++] = specifiedChars.charAt(t);
            }
            j++;
            continue;
        }
        //正常迁移
        newChars[i] = str.charAt(j++);
    }
    return new String(newChars);
}
```



### 5. 正则表达式匹配

**题目描述**

请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'\*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

**心得**

考虑到之前学习的回溯算法学习，但是这里存在一点区别，

常规解法就是考虑到每一种情况,注意边界问题和多个通配符联合的作用

还有就是匹配多个和1个的处理逻辑是一样的,最终都会遍历到匹配1个的问题上来

**答案**

```java
	 boolean flag2 = false;
    public boolean match2(char[] str, char[] pattern){
        if(pattern.length == 0){
            if(str.length == 0){
                return true;
            }
            return false;
        }
        match_r2(str,pattern,0,0);
        return flag2;

    }

    public void match_r2(char[] str,char[] pattern,int i,int j){
        if(flag2 == true){
            return;
        }
        if(str.length == i && j == pattern.length){
            flag2 = true;
            return;
        }
        if(j+1 > pattern.length){
            return;
        }

        if(j+1 < pattern.length && pattern[j+1] == '*' ){
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {
                match_r2(str,pattern,i,j+2);
                match_r2(str,pattern,i+1,j);
            }else{
                match_r2(str,pattern,i,j+2);
            }
        }else {
            if (i < str.length &&( pattern[j] == '.' || pattern[j] == str[i] )) {
                match_r2(str, pattern, i + 1, j + 1);
            }
        }
```

**另解:用了动态规划,比较有趣:**

如果 p.charAt ( j )  == s.charAt ( i ) : ` dp[i][j] = dp[i-1][j-1]` 

如果 p.charAt ( j ) == '.' :  `dp[i][j] = dp[i-1][j-1] `

如果 p.charAt ( j ) == '*'：

1. 如果 p.charAt ( j - 1 ) != s.charAt ( i ) : `dp[i][j] = dp[i][j-2]`  //in this case, a* only counts as empty，**e.g.  b&ba\*** 
2. 如果 p.charAt ( j - 1 ) == s.charAt ( i ) or p.charAt (j-1)  == '.'： 
   1. dp [i] [j] = dp [i-1] [j] //in this case, a* counts as multiple a , **e.g.  baaa&ba\*** 
   2. or dp [i] [j] = dp [i] [j-1] // in this case, a* counts as single a, **e.g.  ba&ba\***(注意这个条件可以忽略，它等价于dp [i-1] [j] = dp [i-1] [j-2] 的情形，即b&ba*) 
   3. or dp [i] [j] = dp [i] [j-2] // in this case, a* counts as empty, **e.g.  ba&baa\***

```python
class Solution:
    # s, pattern都是字符串
    def match(self, s, pattern):
        # write code here
        ls, lp = len(s), len(pattern)
        dp = [[False for _ in range(lp + 1)] for _ in range(ls + 1)]
        dp[0][0] = True
        for i in range(1, lp + 1):
            if i - 2 >= 0 and pattern[i - 1] == '*':
                dp[0][i] = dp[0][i - 2]
        for i in range(1, ls + 1):
            for j in range(1, lp + 1):
                m, n = i - 1, j - 1
                if pattern[n] == '*':
                    if s[m] == pattern[n - 1] or pattern[n - 1] == '.':
                        dp[i][j] = dp[i][j - 2] or dp[i - 1][j]
                    else: dp[i][j] = dp[i][j - 2]
                elif s[m] == pattern[n] or pattern[n] == '.':
                    dp[i][j] = dp[i - 1][j - 1]
        return dp[-1][-1]
```



### 6. 标识数值的字符串

**题目描述**

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

**心得**

考虑到每一种情况就好



**答案**

另解: 正则表达式熟悉一下

```java
   public static boolean isNumeric(char[] str) {
            String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
            String s = new String(str);
            return Pattern.matches(pattern,s);
    }
```



### 7. 字符流中第一个不重复的字符

**题目描述**

请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

**输出描述:**

```
如果当前字符流没有存在出现一次的字符，返回#字符。
```



**心得**

常规思路存储所有字符然后遍历判断不优雅

每次插入的时候维护一个计数器,然后利用队列先入先出,查看是否只出现了1次

**同时用到了字符存储在int数组的方法,有点类似散列表映射的思想**

**顺序有关的问题既可以用队列解决也可以用数组映射表尝试**

**答案**

```java
public class Solution {
    int[] charCnt = new int[128];
    Queue<Character> queue = new LinkedList<Character>();
 
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charCnt[ch]++ == 0) //新来的单身字符，入队;先判断后递增
            queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Character CHAR = null;
        char c = 0;
        while ((CHAR = queue.peek()) != null) {
            c = CHAR.charValue();
            if (charCnt[c] == 1) //判断是否脱单了，没脱单则输出
                return c;
            else queue.remove(); //脱单了就移出队列，它不会再回来了
        }
        return '#'; //队空，返回#
    }
}
```

另解

```java
int[] count = new int[256]; // 字符出现的次数
int[] index = new int[256]; // 字符出现的顺序
int number = 0;

public void Insert(char ch) {
    count[ch]++;
    index[ch] = number++;
}

public char FirstAppearingOnce() {
    int minIndex = number;
    char ch = '#';
    for (int i = 0; i < 256; i++) {  // !!!
        //如果该字符只出现了1次且确实出现了(指的是出现的index<minIndex)
        if (count[i] == 1 && index[i] < minIndex) {
            ch = (char) i;
            minIndex = index[i];
        }
    }
    return ch;
}
```



## 链表

### 8. 从尾到头打印链表

**题目描述**

输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

**心得**

两种思路，一种是反转链表，一种是逆序输出

注意保存前节点和后继节点



**答案**

```java
//递归打印
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
//非递归
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode tmp = listNode;
        while(tmp!=null){
            //关键在于这个add方法
            //add方法当插入的index已经有值的时候会将原来的元素向后搬移
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
```

```java
/**
     * 链表反转  ——递归法（精髓）
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
 /**
     * 单链表反转
     * @param list
     * @return
     */
    public static  Node reserve(Node list){
        Node cur = list;
        //存储链表的上一个节点，遍历完之后变成头节点
        Node pre = null;
        while(cur != null){
            //暂存指向下一个节点的引用
            Node next = cur.next;
            //反转，将存储的下一个节点指向上一个节点
            cur.next = pre;
            //下面两部将链表向下移动
            pre = cur;
            cur = next;
        }
        //遍历完之后pre变成头节点
        return pre;
    }
```

### 9. 链表中环的入口节点

**题目描述**

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

**心得**

使用快慢指针

**答案**

```java
//使用快慢指针法。追及问题，只要慢指针追上快指针，说明存在环路
public static boolean checkCircle(Node list){
    if(list== null)
    {
        return false;
    }
    Node fast = list.next;
    Node slow = list;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            return true;
        }
    }
    return false;
}
```

另解

```java
public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode head = pHead;
        while(pHead != null){
            if(map.containsKey(pHead.val)){
                break;
            }
            map.put(pHead.val,1);
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }else{
            return pHead;
        }
    }
```



### 10. 删除链表中重复节点

**题目描述**

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

**心得**

构建辅助头节点防止头部重复

注意链表是排序的

​	

**答案**

缺点：只能删除偶数个

```java
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
```



## 树

### 11. 重建二叉树

‘**题目描述**

入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

**心得**

关键在于边界条件，建议画图测试是否会出现越界行为

**答案**

```java
public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
      TreeNode root = new TreeNode(pre[0]);
      rebuild(root, pre, 0, pre.length, in, 0, in.length);
      return root;
  }

public void rebuild(TreeNode root,int[] pre,int pl,int pr,int[] in ,int il,int ir){
    for(int i=il;i<ir;i++){
        if(in[i] == pre[pl]){
            int t = i-il;
            if(t>0) {
                root.left = new TreeNode(pre[pl + 1]);
                rebuild(root.left, pre, pl + 1, pl + 1+t, in, il, i);
            }
            if(pr-pl-1-t > 0) {
                root.right = new TreeNode(pre[pl+1+t]);
                rebuild(root.right,pre,pl+1+t,pr,in,i+1,ir);
            }
            break;
        }
    }
}
```

另解：（这种递归方式比较容易理解）

```java
 public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre.length == 0 || in.length ==0){
            return null;
        }
        return rebuild(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode rebuild(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if(pl>pr || il > ir){
            return null;
        }
        TreeNode root = new TreeNode(pre[pl]);
        int mid = 0;
        for(int i=il;i<=ir;i++){
            if(pre[pl] == in[i]){
                mid = i;
                break;
            }
        }
        //剩下在pre数组里还能做根节点的个数：mid-il+1,同理右边也是一样
        int leftCount = mid-il;
        int rightCount = ir-mid;
        root.left = rebuild(pre,pl+1,pl+leftCount,in,il,mid-1);
        root.right = rebuild(pre,pr-rightCount+1,pr,in,mid+1,ir);
        return root;
    }
```



### 12. 二叉树的下一个节点

‘**题目描述** 

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。



**心得**

直接找比遍历一遍的时间复杂度要低，但是要求把所有情况都看清

建议画图尝试，注意中序遍历就是二叉树映射到数组的按序遍历

**答案**

最直白：中序遍历，存储所有节点然后选出

```java
 List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        Dfs(root);
        for(int i =0;i<list.size();i++){
            if(pNode == list.get(i)){
                if(i+1 != list.size()){
                    return list.get(i+1);
                }
            }
        }
        return null;
    }
    public void Dfs(TreeLinkNode node ){

        if(node.left != null){
            Dfs(node.left);
        }
        list.add(node);

        if(node.right != null){
            Dfs(node.right);
        }
    }
```

 另解：仔细观察，可以把中序下一结点归为几种类型：（建议画图解决）

1. 有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
2. 无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
3. 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点

```java
public TreeLinkNode GetNext(TreeLinkNode pNode) {
     // 1.
     if (pNode.right != null) {
         TreeLinkNode pRight = pNode.right;
         while (pRight.left != null) {
             pRight = pRight.left;
         }
         return pRight;
     }
     // 2.
     if (pNode.next != null && pNode.next.left == pNode) {
         return pNode.next;
     }
     // 3.
     if (pNode.next != null) {
         TreeLinkNode pNext = pNode.next;
         while (pNext.next != null && pNext.next.right == pNext) {
             pNext = pNext.next;
         }
         return pNext.next;
     }
     return null;
 }
}
```





### 13. 对称的二叉树

‘**题目描述**

请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

**心得**



**答案**

遍历

```java
boolean isSymmetrical(TreeNode pRoot)
{
    if(pRoot == null){
        return true;
    }
    return symmetrical(pRoot.left,pRoot.right);
}

boolean symmetrical(TreeNode node1,TreeNode node2){
    if(node1 == null&& node2 == null){
        return true;

    }
    if(node1 ==null || node2 ==null){
        return false;
    }
    if(node1.val != node2.val){
        return false;
    }
    return symmetrical(node1.left,node2.right) && symmetrical(node1.right,node2.left);
}
```

### 14. 按之字形顺序打印二叉树

‘**题目描述**

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

**心得**

注意反转的时候queue的offer顺序不能发生变化，否则会影响到遍历的顺序。

或者使用两个栈维护顺序，不考虑上下层的关系

看了题解要注意的优化点：

1. 少用内部函数，可以使用匿名内部类减少开销
2. 双端队列提高性能



**答案**

每一层维护一个list，如果是偶数层则反转

```java
public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int size = 1;
        //改良，直接使用boolean变量
        boolean layer = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        if (pRoot == null) {
            return list;
        }
        queue.add(pRoot);
        firstRow.add(pRoot.val);
        list.add(firstRow);
        while (!queue.isEmpty() && size != 0) {
            int tempSize = 0;
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    row.add(node.left.val);
                    tempSize++;
                }
                if (node.right != null) {
                    row.add(node.right.val);
                    tempSize++;
                }
                //queue压入顺序不变.否则遍历的顺序就会出问题
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!layer) {
                //直接使用reverse，在海量数据下效率太低
                Collections.reverse(row);
            }

            size = queue.size();
            layer = !layer;
            if (row.size() != 0) {
                list.add(row);
            }
        }
        return list;
    }
```

另解：双端队列

```java
public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
    //直接使用LinkedList底层是双向链表的特点
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        if(pRoot == null) return res;
        dq.offerFirst(pRoot);
        int thisLevel = 1;
        int nextLevel = 0;
        boolean lr = true;//奇偶层标记
        while(!dq.isEmpty()){
            TreeNode node = null;
           if(lr == true){//奇术层，队头出对，孩子从队尾入队，先左后右
              node = dq.pollFirst();
              list.add(node.val);
              thisLevel--;
              //左右孩子入队
                if(node.left!=null){
                    dq.offerLast(node.left);
                    nextLevel++;
                }
                if(node.right!=null){
                    dq.offerLast(node.right);
                    nextLevel++;
                }
           	 }else{//偶数层，队尾出队，孩子从队头入队，先右后左
                node = dq.pollLast();
                list.add(node.val);
                thisLevel--;
                //左右孩子入队
                if(node.right!=null){
                    dq.offerFirst(node.right);
                    nextLevel++;
                }
                if(node.left!=null){
                    dq.offerFirst(node.left);
                    nextLevel++;
                }
              }//if -else结束
            if(thisLevel == 0){
                thisLevel = nextLevel;
                nextLevel = 0;
                lr = !lr;
                res.add(list);
                list = new ArrayList<>();
            }
        }//结束循环
        return res;
    }
```



### 15. 把二叉树打印程多行

**题目描述**

上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

**答案**

```java
ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        int size = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer>>();
        
        if(pRoot ==null){
            return list;
        }
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                row.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
     
            if(row.size() !=0){
                list.add(row);
            }
            size = queue.size();
        }
        return list;
    }
```



### 16、序列化二叉树

‘**题目描述**

请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

**心得**

前序遍历，因为空的#填充，所以是满二叉树，前序遍历即可还原

理论上将中序和后序都可以

**答案**

```java
int index = -1;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }

    TreeNode Deserialize(String str) {
        String[] s = str.split(",");//将序列化之后的序列用，分隔符转化为数组
        index++;//索引每次加一
        int len = s.length;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[index].equals("#")) {//不是叶子节点 继续走 是叶子节点出递归
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }
```



### 17、二叉搜索树的第k个节点

‘**题目描述**

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）  中，按结点数值大小顺序第三小结点的值为4。

**心得**

**答案**

最直接方法：中序遍历,如果查找从大到小只要左右子树遍历顺序调换就可以

```java
 	int index = 0; //计数器
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
```





### 18、数据流中的中位数

‘**题目描述**

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

**心得**

`(count & 1) == 1`判断是否是奇数，位运算提高性能

**答案**

堆排序求中位数

```java
 private PriorityQueue<Integer> firstBigHeap =
            new PriorityQueue<>(                 
                    (o1, o2) -> {
                        if (o1 < o2) {
                            return 1;
                        } else if (o1 > o2) {
                            return -1;
                        }
                        return 0;
                    });

    /** 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100 */
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>();
    private int count;

    public void Insert(Integer num){
        count++;
        if(firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()){
            firstBigHeap.offer(num);
            return;
        }
        if(firstBigHeap.peek() < num){
            afterLittleHeap.offer(num);
        }else{
            firstBigHeap.offer(num);
        }
        //注意这一步
        int countValue = count/2;

        if(firstBigHeap.size()> countValue){
            move(firstBigHeap,afterLittleHeap,firstBigHeap.size()-countValue);         
        }
        if (afterLittleHeap.size() > countValue) {
            move(afterLittleHeap, firstBigHeap, afterLittleHeap.size() - countValue);
           return;
        }
    }
    private void move(PriorityQueue<Integer> firstBigHeap, 
                      PriorityQueue<Integer> afterLittleHeap, int runNum) {
        for(int i=0 ;i<runNum;i++){
            afterLittleHeap.offer(firstBigHeap.poll());
        }
    }
//注意判断是奇数还是偶数的代码    
    public  Double GetMedian(){
    double res = 0;
    // 奇数，这个代码好好学学
    if ((count & 1) == 1) {
        res = firstBigHeap.peek();
    } else {
        res = (firstBigHeap.peek() + afterLittleHeap.peek()) / 2.0;
    }
    return res;
    }
```



```java
private int cnt = 0;
    private PriorityQueue<Integer> largerHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private PriorityQueue<Integer> smallerHeap = new PriorityQueue<>();
    public void Insert(Integer num){
        // 数量++
        cnt++;
        // 如果为奇数的话
        if ((cnt & 1) == 1) {
            // 由于奇数，需要存放在大顶堆上
            // 但是呢，现在你不知道num与小顶堆的情况
            // 小顶堆存放的是后半段大的数
            // 如果当前值比小顶堆上的那个数更大
            if (!smallerHeap.isEmpty() && num > smallerHeap.peek()) {
                // 存进去
                smallerHeap.offer(num);
                // 然后在将那个最小的吐出来
                num = smallerHeap.poll();
            } // 最小的就放到大顶堆，因为它存放前半段
            largerHeap.offer(num);
        } else {
            // 偶数的话，此时需要存放的是小的数
            // 注意无论是大顶堆还是小顶堆，吐出数的前提是得有数
            if (!largerHeap.isEmpty() && num < largerHeap.peek()) {
                largerHeap.offer(num);
                num = largerHeap.poll();
            } // 大数被吐出，小顶堆插入
            smallerHeap.offer(num);
        }
    }

    public Double GetMedian() {// 表明是偶数
        double res = 0;
        // 奇数
        if ((cnt & 1) == 1) {
            res = largerHeap.peek();
        } else {
            res = (largerHeap.peek() + smallerHeap.peek()) / 2.0;
        }
        return res;
    }
```



### 34、从上往下打印二叉树节点

略

### 35、二叉搜索树的后序遍历

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

**心得**



**答案**

```java
//以标准的完美二叉搜索树为例，递归的每一层都涉及到对序列的遍历，虽然层数越深节点越少（少了子树的根节点），但是这种减少是微不足道的，即使是到了最底层，依旧有n/2的节点（完美二叉树第i层节点数是其上所有节点数之和+1），因此递归方法在每一层的遍历开销是O(n)，而对于二叉树而言，递归的层数平均是O(logn)，因此，递归方法的最终复杂度是O(n*logn)
public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
       return BST(sequence,0,sequence.length-1);
    }
    
    public boolean BST(int[] sequence,int start,int end){
        //重要！！！
        if(start >= end)return true;
        
        int key = sequence[end];
        int i;
        for(i =start;i<end;i++){
            if(sequence[i] > key){
                break;
            }
        }
        int j =i;
        for(;i<end;i++){
            if(sequence[i] < key){
                return false;
            }
        }
        return BST(sequence,start,j-1) && BST(sequence,j,end-1);
    }
```



### 36、二叉树中和为某一值得路径

输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)





## 栈和队列

### 19、用两个栈实现队列

**题目描述**

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型

**答案**

```java
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack1.isEmpty()){
        int popNode = stack1.pop();
        stack2.push(popNode);
        }
        stack1.push(node);
        while(!stack2.isEmpty()){
            int popNode = stack2.pop();
            stack1.push(popNode);
        }
    }
    
    public int pop() {
        int popNode = stack1.pop();
        return popNode;
    }
```

### 20、滑动窗口的最大值

**题目描述**

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

**心得**

注意最大值会poll出的情况

也可以尝试双端队列解决Deque

**答案**

```java
public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        Queue<Integer> queue  = new LinkedList<Integer>();
        ArrayList<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        if(size > num.length || size == 0){
            return maxList;
        }
        for(int i=0;i<size;i++){
            queue.offer(num[i]);
            if(max < num[i]){
            max  = num[i];
            }
        }
        maxList.add(max);
        int flag =size-1;
       
        while(flag != num.length-1){
            flag++;
            int pollNum = queue.poll();
            queue.offer(num[flag]);
            //分情况考虑
            if(max < num[flag]){
                max = num[flag];
                maxList.add(num[flag]);
            }else if(pollNum < max){
                maxList.add(max);
            }else{
                    max = num[flag];
                    for(int i=0;i<size;i++){
                        max = max < num[flag-i]? num[flag-i] : max; 
                    }
                    maxList.add(max);
                }
        }
 
        return maxList;
    }
```



大顶堆解决方案

```java
//大顶堆，从大到小的排列
    private PriorityQueue<Integer> heap=new PriorityQueue<Integer>((o1,o2)->o2-o1);
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        //存放结果集
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num==null||num.length==0||num.length<size||size<=0){
            return result;
        }
        for(int i=0;i<size;i++){
            heap.offer(num[i]);
        }
        result.add(heap.peek());
        //i从1到num.length-size
        for(int i=1;i<num.length+1-size;i++){
            heap.remove(num[i-1]);
            heap.offer(num[i+size-1]);
            result.add(heap.peek());
        }
        return result;
    }
```





### 32、包含min函数的栈

**题目描述**

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。

**题解**

注意是要在栈的基础上实现min函数，不是自己实现。。

**心得**

经典思路:双栈法

```java
//代码比较规范，借鉴一下
/*借用辅助栈存储min的大小，自定义了栈结构
*/
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];
    public void push(int node) {
        ensureCapacity(size+1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
    //    System.out.println(min+"");
    }
 
    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();    
        min = minStack.peek();
    //    System.out.println(min+"");
    }
 
    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }
 
    public int min() {
        return min;
    }
```



### 33、栈的压入弹出序列

**题目描述**

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

**心得**



**答案**

```java
 public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        
        return stack.empty();
        
    }
```

**另解**  需要好好思考

```java
public boolean isPopOrder(int[] pushA,int[] popA){

        Stack<Integer> stack = new Stack<Integer>();
        int a  = 0;
        int b = 0;
        boolean res = true;
        while(b<popA.length){

            if(!stack.empty() && stack.peek() == popA[b]){
                stack.pop();
                b++;
            }else if(a < pushA.length){
                stack.push(pushA[a]);
                a++;
            }else{
                res = false;
                break;
            }

        }
        return res;
    }
```



## 查找和排序

### 21、旋转数组的最小数字

**题目描述**

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

**题解**

找到更高效的查找方法

<img src="README/image-20200221212348004.png" alt="image-20200221212348004" style="zoom:50%;" />

注意存在的坑点

<img src="README/image-20200221212419880.png" alt="image-20200221212419880" style="zoom:67%;" />

**心得**

把情况考虑周到，最终始终会出现mid等于两端的情况，这时就需要考虑到位

**当两值取中的时候，mid一定会指向两值中前面一个**

**答案**

```java
public int minNumberInRotateArray(int[] array) {
        int i = 0, j = array.length - 1;
    //如果出现相等的情况，一直递增直到出现起伏或者返回最小值
        while (i < j) {
            if (array[i] < array[j]) {
                return array[i];
            }
            int mid = (i + j) >> 1;
            
            if (array[mid] > array[i]) {
                i = mid + 1;
            } else if (array[mid] < array[j]) {
                j = mid; // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
            } else i++;  // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
            //同理j--也是可以的
        }
        return array[i];
    }
```



```java
public int minNumberInRotateArray3(int[] rotateArray) {
        int left = 0,low = 0;
        int right = rotateArray.length-1,height = rotateArray.length-1;

        while(rotateArray[low] == rotateArray[height]){
            low++;
            height--;
        }
    //注意这种情况 10111 出现立即可以返回
        if(rotateArray[low] < rotateArray[height]){
            return rotateArray[low];
        }
        while(rotateArray[left] > rotateArray[right]){
            int mid = left + ((right-left)>>1);
            if(rotateArray[left] <= rotateArray[mid]){
                left = mid+1;
            }else if(rotateArray[mid] <= rotateArray[right]){
                right = mid;
            }
        }

        return rotateArray[left];
    }//针对坑点做出的解决办法，让曲线一开始就是陡峭的
public int minNumberInRotateArray3(int[] rotateArray) {
        int left = 0,low = 0;
        int right = rotateArray.length-1,height = rotateArray.length-1;

        while(rotateArray[low] == rotateArray[height]){
            low++;
            height--;
        }
        while(rotateArray[left] > rotateArray[right]){
            int mid = left + ((right-left)>>1);
            if(rotateArray[left] <= rotateArray[mid]){
                left = mid+1;
            }else if(rotateArray[mid] <= rotateArray[right]){
                right = mid;
            }
        }

        return rotateArray[left];
    }
```



## 递归和循环

### 22、跳阶梯Plus

青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

**题解**

易知 f(n)=f(n-1)+f(n-2)+……f(1)
f(n-1)=f(n-2)+……f(1)
两式相减得f(n)=2f(n-1)

**心得**

注意递归公式的计算，第一次做的就是没有推出来递归公式





### 23、矩形覆盖

**题目描述**

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

**题解**

和跳台阶类似，关键在于分析递归表达式

**答案**

```java
public class Solution {
    public int RectCover(int target) { 
        if(target<=0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover(target-1)+ RectCover(target-2);
    }
}
```



## 位运算

### 24、二进制中1的个数

**题目描述**

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

**题解**

如果一个整数不为0，那么这个整数至少有一位是1。**如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)**。其余所有位将不会受到影响。

举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，**从原来整数最右边一个1那一位开始所有位都会变成0**。如1100&1011=1000.也就是说，**把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0**.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。

**答案**

```java
public class Solution{
    public int NumberOf1(int n){
        int count =0;
        while(n!= 0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
```

**心得**

在机器中，整数的存储和运算都是其补码表示的。

- 正数右移：保持为正数，相当于/2。
- 负数右移：保持为负数，移位前是负数，移位后保持是负数，因此移位后最高位设为1。如果一直右移，最终会变成-1，即(-1)>>1是-1。
- 正数左移：不保持为正数，相当于*2。（注意：1左移31时为负数最大值）
- 负数左移：不保持为负数，在左移的过程中会有正有负的情况。所以切记负数左移不会特殊处理符号位。如果一直左移，最终会变成0。



## 数据完整性

### 25、数值的整数次方

**题目描述**

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0

**心得**

注意考虑exponent的正负

二分法和[简单快速幂算法](https://blog.csdn.net/Harington/article/details/87602682)



**答案**

```java
//位运算

public double Power(double base, int n) {
    double res = 1,curr = base;
    int exponent;
    if(n>0){
        exponent = n;
    }else if(n<0){
        if(base==0)
            throw new RuntimeException("分母不能为0"); 
        exponent = -n;
    }else{// n==0
        if(base==0){
            throw new RuntimeException("0的0次方我认为无意义")
        }
        return 1;// 0的0次方
    }
    //简单快速幂
    while(exponent!=0){
        if((exponent&1)==1)
            res*=curr;
        curr*=curr;// 翻倍
        exponent>>=1;// 右移一位
    }
    return n>=0?res:(1/res);       
}
```



```java
//递归
public double Power(double base, int exponent) { 
        if(exponent==0 && base != 0)
            return 1;
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){ 
            return 0;
        }
        int n= exponent;
        if(exponent<0){
            n = -exponent;
        }
        double  result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base; 
        if(exponent<0)
            result=1/result;
        return result;     
  }
```



### 26、调整数组顺序使得奇数位于偶数前面

**题目描述**

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

**心得**

常见的排序算法

```java

```



## 代码的鲁棒性

### 27.链表中倒数第k个节点

**题目描述**

输入一个链表，输出该链表中倒数第k个节点

**心得**

边界条件思考周全！！考虑链表的倒数第1个节点、正数第一个节点、空、k溢出等情况

**答案**

```java
public ListNode FindKthToTail(ListNode head,int k) {
            ListNode slow = head;
            ListNode fast = head;
            if(head == null || (k <=0)){
                return null;
            }
            for(int i =1;i<k;i++){
                if(fast == null){
                return null;
                }
                fast  = fast.next;
            }            
            while(fast.next != null){
                fast=  fast.next;
                slow = slow.next;
            }
            return slow;
    }
```



### 28、合并两个有序链表



**答案**

```java
//哨兵优化
public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while(list1 != null && list2 !=null){
            if(list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null) cur.next = list1;
        if(list2!=null) cur.next = list2;
        return h.next;
    }
```



### 29、树的子结构

**题目描述**

**心得**

注意看题，在遍历节点上使用了两种递归



**答案**

```java
public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
        return false;
    }
    //进入检查节点是否相等的环节
    return judgeSubTree(root1, root2) ||
            //注意这里，如果根节点没有找到就继续从子节点上查找
            HasSubtree(root1.left, root2) ||
            HasSubtree(root1.right, root2);
}

private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
    //子树必须和原来的树一起遍历到底
    if (root2 == null && root1 == null) {
        return true;
    }
    if (root1 == null) {
        return false;
    }
    if (root1.val != root2.val) {
        return false;
    }
    return judgeSubTree(root1.left, root2.left) &&
            judgeSubTree(root1.right, root2.right);
}
```



### 30、二叉树镜像

**题目描述**



**答案**

```java
public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right  = temp;
            Mirror(root.left);
            Mirror(root.right);
```



### 31、画图让抽象形象化

**题目描述**

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

**心得**

二维数组int\[row][column]先遍历列，再遍历行

注意二维数组的长度取值

关键在于代码的健壮性，考虑逻辑的严密性

名字不要太复杂，简单的up、down、left、right就完事了

**答案**

```java
   public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true){
            // 最上面一行
            for(int col=left;col<=right;col++){
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if(up > down){
                break;
            }
            // 最右边一行
            for(int row=up;row<=down;row++){
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if(left > right){
                break;
            }
            // 最下面一行
            for(int col=right;col>=left;col--){
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if(up > down){
                break;
            }
            // 最左边一行
            for(int row=down;row>=up;row--){
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if(left > right){
                break;
            }
        }
        return list;
    }
}
```

