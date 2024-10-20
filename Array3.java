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

//Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). 
//Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
// SERIES UP
public int[] seriesUp(int n) {
  //the idea is to increment by the summation.
  int length = n*(n+1)/2;
  //length of 3 = 6.
  
  int[] nArray = new int[length];
   
  //the index overlaps if using [i+j-1], instead should add the current summation to the index;
  for(int i=0; i<n; i++){
    
    for(int j=1; j<=i+1;j++){
      int summation = i*(i+1)/2;
      //-1 adjusts the index.
      nArray[summation+j-1]=j;
    }  
  }
  return nArray;
}

public int maxSpan(int[] nums) {
  int maxSpan = 0;
  for(int i=0; i<nums.length; i++){
    int cN = nums[i];
    int span = 1;
    for(int j=i; j<nums.length; j++){
      if(nums[j]==cN && j!=i){
        span = 1 + (nums.length-i)-(nums.length-j);
      }
      if(span>maxSpan){
        maxSpan = span;
      }
    }
  }
return maxSpan;
}

