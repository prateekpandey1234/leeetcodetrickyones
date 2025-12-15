package SegmentTrees;

public class CountNumberOfTeams {

        public int numTeams(int[] rating) {
            int max = 0;
            for(int i:rating)max=Math.max(max,i);
            SegTree s1 = new SegTree(max);
            SegTree s2 = new SegTree(max);
            // s1 is our complerte segment tree which holds Total count for each segment
            for(int i:rating){
                s1.update(i,1,0,0,max);
            }
            int res=0;
            // now the math part
            // for any number if we fix it in position and look how many numbers greater and lower than it are
            // total count of teams using that fixed number = (count of numbers lower than fixed number)*(count of numbers higher than fixed number)
            // but here we also need to keep track of order :-
            // total count of teams using that fixed number = (count of numbers lower than fixed number on left)*(count of numbers higher than fixed number on right ) + (count of numbers higher than fixed number on left)*(count of numbers lower than fixed number on right )
            // so now we use another untouched segment tree which we use to keep track count when updating that tree one by one as we go from left to right
            // we get count of numbers on left which are working in our condition and we already have total count of numbers which are working in our condition
            // so ,  right = total - left
            //
            for(int i=0;i<rating.length;i++){
                // explained query in segment tree
                int SmallOnLeft = s2.query(0,0,max,0,rating[i]-1);
                int GreatOnLeft = s2.query(0,0,max,rating[i]+1,max);
                int SmallOnRight = s1.query(0,0,max,0,rating[i]-1)-SmallOnLeft;//s1 holds total count of numbers smaller than rating[i] so we subtract it to count from s2 to remove overlapping
                int GreatOnRight = s1.query(0,0,max,rating[i]+1,max)-GreatOnLeft;
                s2.update(rating[i],1,0,0,max);
                res+=SmallOnLeft*GreatOnRight+GreatOnLeft*SmallOnRight;
            }
            return res;

        }
        class SegTree{
            int[] t ;
            int len ;
            public SegTree(int len){
                //here we have made seg point to values of rating so they can be sorted and we dont need to
                // check for any order as we they are selected and put in order
                this.t = new int[4*len+1];
            }

            // our update query is simple we reach a node we make it a length 1
            // ans combine the length to parent segment which holds how many number are selected in that segment

            public void update(int i , int val , int v , int l , int r){
                if(l==r){
                    t[v] = val;
                    return;
                }
                int  m = (l+r)/2;
                if(i<=m){
                    update(i,val,v*2+1,l,m);
                }
                else {
                    update(i,val,v*2+2,m+1,r);
                }
                t[v] = t[v*2+1]+t[v*2+2];
            }
            // the query is tricky part , we want to know how many values are lower than our current number
            // therefore , to get count of lower nums , we range query over 0->num-1 to get count of numbers selected in that segment
            // to gte count of higher nums , we range query over num+1->max to get count of number selected in that segment
            int query(int v , int tl , int tr , int l , int r){
                if(l>r) return 0;//this happens when we go to territory which is not needed
                if(l==tl && r==tr)return t[v];
                int m = (tl+tr)/2;
                // we always take sum of those queries where our segment falls into
                return query(v*2+1,tl,m,l,Math.min(r,m))+query(v*2+2,m+1,tr,Math.max(l,m+1),r);
            }
        }
    }

