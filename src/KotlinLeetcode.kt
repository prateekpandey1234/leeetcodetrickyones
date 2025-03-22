public class KotlinLeetcode {
    fun minSteps(n: Int): Int {
            return memo(0,1,1,n)

    }
    fun memo(curr:Int, i :Int,cp:Int,n:Int):Int{
        if(i==n) return curr
        return Math.min(if(i+cp<=n) Math.min(memo(curr+2,i+cp,i,n),memo(curr+1,i+cp,cp,n)) else Int.MAX_VALUE,if(i+i<=n)(memo(curr+2,i+i,i,n)) else Int.MAX_VALUE )
    }

    public fun main(args:Array<String>){
        print(minSteps(3))
    }

}