class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}class MaxPathSumBTree{
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode node){
        solver(node);
        return ans;
    }
    public int solver(TreeNode node){
        if(node==null) return 0;
        int l=solver(node.left);
        int r=solver(node.right);
        int temp=Math.max(Math.max(l, r)+node.val, node.val);
        //
            // If From lEAF NODE TO LEAF NODE:--
            //      if(node.left==null && node.right==null){
            //          temp=Math.max(temp, node.val);
            //      }

        //
        ans=Math.max(ans, Math.max(temp, l+r+node.val));
        return temp;
    }
}