package string.permutation;

import com.sun.org.apache.xpath.internal.XPathVisitor;

import java.util.*;

public class Solution_traceBack {

        public List<List<Integer>> permute(int[] nums) {
            // 首先是特判
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();

            if (len == 0) {
                return res;
            }
            // 使用哈希表检测一个数字是否使用过
//           Set<Integer> used = new HashSet<>(len);
            boolean[] used = new boolean[len];
            Arrays.fill(used,false);
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
                res.add(path);
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    // 1、每一次尝试都创建新的变量表示当前的"状态"
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nums[i]);

                    boolean[] newUsed = new boolean[len];
                    System.arraycopy(used, 0, newUsed, 0, len);
                    newUsed[i] = true;

                    // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                    // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                        continue;
                    }

                    dfs(nums, len, depth + 1, newPath, newUsed, res);
                    // 2、无需回溯
                }
            }
        }


    /**
     * 另外的解法（需要回溯）
     * @param nums
     */

    public List<List<Integer>> permute2(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }
        // 使用哈希表检测一个数字是否使用过
        //Set<Integer> used = new HashSet<>(len);
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs2(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs2(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }


                dfs2(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Solution_traceBack solution = new Solution_traceBack();
            int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> res =solution.permute(nums);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }

//    public List<List<Integer>> per(int[] nums){
//        if(nums.length==0){
//            return null;
//        }
//        List<Integer> path = new ArrayList<Integer>();
//        List<List<Integer>> res = new ArrayList<>();
//        Set<Integer> used = new HashSet<Integer>();
//
//        dfstest(nums,path,res,used,nums.length,0);
//        return res;
//    }
//    public void dfstest(int[] nums,List<Integer> path,List<List<Integer>> res,Set<Integer> used,int len,int depth){
//        if(depth == len){
//            res.add(path);
//            return ;
//        }
//
//        for(int i =0;i<len;i++){
//            if(!used.contains(nums[i])){
//                path.add(nums[i]);
//                used.add(nums[i]);
//                List<Integer> newPath = new ArrayList<Integer>(path);
//                Set<Integer> newUsed = new HashSet<Integer>(used);
//
//                dfstest(nums,newPath,res,newUsed,len,depth+1);
//            }
//        }
//
//    }
}
