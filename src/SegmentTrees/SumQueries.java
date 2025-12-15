package SegmentTrees;

public class SumQueries {
    class NumArray {
        int[] t ;
        int n ;
        public NumArray(int[] nums) {
            t = new int[4*nums.length];
            n = nums.length;
            //start always with 1 index
            build(1,0,nums.length-1,nums);

        }
        public void build(int v, int l , int r, int[] arr){
            if(l==r){
                t[v] = arr[l];
                return ;
            }
            int m = (l+r)/2;
            build(v*2,l,m,arr);
            build(v*2+1,m+1,r,arr);
            t[v] = t[v*2]+t[v*2+1];

        }
        public void change(int v , int i , int val , int l , int r){
            if(l==r){
                t[v] = val;
                return ;
            }
            int m = (l+r)/2;
            if(i<=m){
                change(v*2,i,val,l,m);
            }
            else {
                change(v*2+1,i,val,m+1,r);
            }
            t[v] = t[v*2]+t[v*2+1];
        }
        public int sum(int v , int tl , int tr , int l , int r){
            if(l>r) return 0;
            if(l==tl && r==tr) return t[v];
            int m = (tl+tr)/2;
            //trying to find pieces of l-r in the segment formation
            // by matching tl-tr range to l-r range
            return sum(v*2,tl,m,l,Math.min(r,m))+sum(v*2+1,m+1,tr,Math.max(l,m+1),r);
        }

        public void update(int index, int val) {
            change(1,index,val,0,n-1);

        }

        public int sumRange(int left, int right) {
            return sum(1,0,n-1,left,right);
        }

    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
