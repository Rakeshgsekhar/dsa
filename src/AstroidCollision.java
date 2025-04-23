import java.util.Stack;

public class AstroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        // stack.push(asteroids[n-1]);
        /*for(int i = n-2;i>=0 ;i--){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            }else{
                int temp = stack.peek();
                if(asteroids[i] > 0 && temp>0 ){ //both moving right no collision
                    stack.push(asteroids[i]);
                }else if(asteroids[i] < 0 && temp<0 ){ //both moving left no collision
                    stack.push(asteroids[i]);
                }else if(asteroids[i] < 0 && temp>0){stack.push(asteroids[i]);}
                else{
                    if(asteroids[i]+temp == 0 ){
                        if(temp<0) //moving towords from each other same weight both collions destroyed
                            stack.pop();
                        else // moving away form each other same weight
                            stack.push(asteroids[i]);
                    }else{//moving towaord each other diff weight
                        int newVal = 3000;
                        while(!stack.isEmpty() && stack.peek() >0 && stack.peek() < asteroids[i] ){
                            int val = stack.pop();
                            newVal = Math.abs(asteroids[i])>Math.abs(val)?asteroids[i]:val;

                        }
                        if(newVal != 3000)
                            stack.push(newVal);

                    }
                }
            }
        }*/

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }

        return result;
    }
}
