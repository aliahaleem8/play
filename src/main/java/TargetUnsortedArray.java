public class TargetUnsortedArray {


    public static int search(int[] nums, int target) {

        // { 0, 4, 6, 7, 9};
        System.out.println(nums.toString());
        Boolean found = false;
        int n= nums.length/2;
        while(!found){
            System.out.println (" found= ["+ found +"], n = [" + n + "], nums[n]= ["+ nums[n]+"]");
            if (target > nums[n]){
                if ((n >= nums.length-1)||(((n+1) <= nums.length) && (target < nums[n+1]))){
                    // doesn't exist in list
                    return -1;
                }
                //drop the lower end
                n = n + (n/2);
            }
            else if (target < nums[n]){
                if ((n <= 0) ||(((n-1) >=0) && (target > nums[n-1]))){
                    return -1;
                }
                if (n==1){
                    n = 0;
                }
                else n = n - (n/2);
            }
            else if (target == nums[n]){

                found = true;
                break;
            }
            else if ((n == 0) || (n == nums.length-1)) // check if your n became 0 or nums.length (i.e. not found)
                return -1;
        }

        return n;

    }

    public static void main(String[] args) {
        int [] input = {  -1,4, 6, 7, 9 };
        //even input


        //  System.out.println("output: " + search(input,4));
        //lower boundary
        //  System.out.println("output: " + search(input,0));
        //     System.out.println("output: " + search(input,7));

        //  System.out.println("output: " + search(input,5));

        //   System.out.println("output: " + search(input,8));
        System.out.println("output: " + search(input,-3));

        // odd input length


    }



}
