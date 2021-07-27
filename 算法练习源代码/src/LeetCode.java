public class LeetCode {

    public static void main(String[] args) {
        String text = "mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf";
        System.out.println(maxNumberOfBalloons(text));
        int[] num = {2,0,1,0,3,12};
        moveZeroesTes(num);
        for (int i=0; i< num.length; i++ ) {
            System.out.print(num[i]+ ",");
        }


    }

    /**
     *
     * 十种排序算法
     *  1.选择排序
     *  2.冒泡
     *  3.插入
     *  4.希尔
     *  5.快速
     *  6.归并（分而治之，归并）
     *  7.堆排序
     *  8.桶排序
     *  9.基数排序
     *  10.计数排序
     *
     *  查找
     *      1。二分查找
     *
     */


    public static int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        char[] chars = text.toCharArray();
        for (char temp: chars) {
            switch(temp) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
                default:
                    break;
            }
        }
        return compareMin(b, a, l / 2, o / 2, n);
    }

    public static int compareMin(int ...num) {
        int result=num[0];
        for(int i=0; i< num.length-1 ; i++) {
            if(num[i]<num[i+1]&& num[i]< result) {
                result=num[i];
            }else if(num[i]>num[i+1]&& num[i]< result){
                result=num[i+1];
            }
        }
        return result;
    }
   /* public static int compareMin(int a, int b) {
        return a>b? b:a;
    }*/

    public static void moveZeroesTes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 移动零
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int left=0,right=0, len = nums.length;
        while(right <len) {
            if (nums[left] != 0) {
                left++;
                right++;
                continue;
            }
            if ( nums[left] == 0 && nums[right] != 0) {
                int temp =  nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }

    public void rotateT(int[] nums, int k) {
        int len = nums.length;
        int[] numsTemp= new int[len];
        for (int i=0; i< len; i++) {
            numsTemp[(i+k)%len]=nums[i];
        }
        for(int j=0; j<len; j++) {
            nums[j] = numsTemp[j];
        }
    }

    public static int[] rotate(int[] nums, int k) {
        int len = nums.length;
        int[] numsTemp= new int[len];
        for (int i=0; i< len; i++) {
            numsTemp[(i+k)%len]=nums[i];
        }

        System.arraycopy(numsTemp, 0, nums, 0, len);
        return nums;
    }

    public static int[] sortedSquares(int[] nums) {
        int left=0, right = nums.length-1, len = nums.length-1;
        int[] resultArr = new int[nums.length];
        for (int i=0; i< resultArr.length; i++) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                resultArr[len-i]=nums[left]*nums[left];
                left++;
            } else {
                resultArr[len-i]=nums[right]*nums[right];
                right--;
            }
        }
        return resultArr;
    }
    public  static boolean isBadVersion(int bad) {
        return  true;
    }

    public int searchInsert(int[] nums, int target) {

        int low =0, up = nums.length-1, temp;
        while(low < up) {
            temp = low + (up-low)/2;
            if (target == nums[temp]) {
                return temp;
            } else if (target > nums[temp]) {
                low = temp+1;
            } else {
                up = temp-1;
            }
        }
        return up + 1;

    }


    public int firstBadVersion(int n) {
        if (n==1)  {
            return 1;
        }
        int low =0, up =n, badV=1;

        while(low <= up ) {
            badV = low +(up-low)/2;
            if (isBadVersion(badV)== true && isBadVersion(badV-1)==false) {
                return badV;
            } else if (isBadVersion(badV)== true) {
                up = badV;
            } else {
                low = badV+1;
            }
        }
        return badV;
    }

    public int firstBadVersionGF(int n) {

        int low =0, up =n, temp;

        while(low < up ) {
            temp = low +(up-low)/2;
            if (isBadVersion(temp)== true) {
                //在低区间
                up = temp;
            } else {
                //在高区间
                low = temp+1;
            }
        }
        // 此时有 low == up，区间缩为一个点，即为答案
        return low;
    }



    public int search(int[] nums, int target) {
        //边界判断
        if(target <nums[0] || target>nums[nums.length-1]) {
            return -1;
        }
        return -1;
    }
}
