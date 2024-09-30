package DailyDev;

import java.util.Stack;

public class POTD30SEPT2024 {
    class CustomStack {
        Stack<Integer> stck1 = new Stack<>();
        Stack<Integer> stck2= new Stack<>();
        int maxsize=0;

        public CustomStack(int maxSize) {
            this.maxsize=maxSize;
        }
        public void push(int x) {
            if(this.stck1.size()<this.maxsize){
                this.stck1.push(x);
            }
        }

        public int pop() {
            if(!stck1.isEmpty()){
                return this.stck1.pop();
            }
            return -1;
        }

        public void increment(int k, int val) {
            int sz= this.stck1.size();
            for(int i=0;i<sz;i++){
                if(sz>k){
                    if(i<sz-k){
                        // 0 1 2 3 4 5 6 7
                        this.stck2.push(this.stck1.pop());
                    }
                    else this.stck2.push(this.stck1.pop()+val);
                }
                else this.stck2.push(this.stck1.pop()+val);
            }
            while(!stck2.isEmpty())stck1.push(stck2.pop());

        }
    }
    //SOLN2
    class CustomStack2 {
        int[] stck;
        int top=-1;
        public CustomStack2(int maxSize) {
            stck= new int[maxSize];
            top=-1;
        }

        public void push(int x) {
            if(top<stck.length-1){
                stck[++top]=x;
            }
        }

        public int pop() {
            return top>-1 ? stck[top--]:-1;
        }

        public void increment(int k, int val) {
            k = Math.min(k, top+1);
            for(int i = 0; i<k;i++){
                stck[i]+=val;
            }
        }
    }


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
