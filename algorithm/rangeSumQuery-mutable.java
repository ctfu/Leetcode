/* segment tree */
class NumArray {
    private int[] tree;
    private int size;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            size = nums.length;
            tree = new int[size * 2];
            buildTree(nums);
        }
    }

    public void update(int i, int val) {
        i += size;
        tree[i] = val;
        while (i > 0) {
            int left = i;
            int right = i;
            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }
            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        i += size;
        j += size;
        int sum = 0;
        while (i <= j) {
            if (i % 2 != 0) {
                sum += tree[i];
                i++;
            }
            if (j % 2 != 1) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }

    public void buildTree(int[] nums) {
        for (int i = size, j = 0; j < nums.length; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
