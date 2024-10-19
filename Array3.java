//Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.

public int countClumps(int[] nums) {
  
  int clumpCount = 0;

  //we will look ahead, so it ends at -1.
  for(int i=0; i<nums.length-1; i++){
   
    boolean clump = false;
   //compare index i+1 to current index i
    for(int j=i+1;j<nums.length; j++){
      //if not equal, early exit.
      if(nums[j] != nums[i]){
        break;
      }
      //if equal and we not inside clump, flip clump to true and increment the counter. Only once.
      if(nums[j] == nums[i] && !clump){
        clump=true;
        clumpCount++;
      } 
      //if at a clump, we increment the main index i so that when we leave the clump, the main cursor starts ahead of it.
      // example: 1 1 1 4 5 -> so that we don't start again at the second 1, instead we increment i by (three) so that we start at element 4 and not double count
      if(nums[j] == nums[i] && clump){
        i++;
      }
      
    }
  }
  return clumpCount;
}
