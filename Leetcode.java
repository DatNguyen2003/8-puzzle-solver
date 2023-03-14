import java.util.Arrays;

public class Leetcode {

  public static int firstMissingPositive(int[] nums) {
    int[] counts = new int[nums.length];
    for(int i=0;i<nums.length;i++){
      counts[i]=0;
    }
    for(int i=0;i<nums.length;i++){
      try {
        counts[nums[i]-1] ++;
        System.out.println(i);
      } catch (Exception e) {
        continue;
      }
    }
    for(int i=0;i<nums.length;i++){
      if(counts[i]==0){
        return i+1;
      }
    }
    return nums.length+1;
  }
//spilt a sorted array starting from a certain index
  public static int firstMissingPositive1(int[] nums) {
    Arrays.sort(nums);

    return nums.length+1;
  }
  public static void main(String[] args) {
    System.out.println("Leetcode");
    int[] nums = {1,2,0};
    System.out.println(firstMissingPositive1(nums));
  }
}
