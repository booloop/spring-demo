class MyCalendar {
    class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int start;
        private int end;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;

            int end1 = root.end;
        }
    }

    private TreeNode root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }
        TreeNode cur = root;
        while (true) {
            if (start >= cur.end) {
                if (cur.right == null) {
                    cur.right = new TreeNode(start, end);
                    return true;
                }
                cur = cur.right;
            } else if (end <= cur.start) {
                if (cur.left == null) {
                    cur.left = new TreeNode(start, end);
                    return true;
                }
                cur = cur.left;
            } else {
                return false;
            }
        }
    }
}

