public int countEvens(int[] nums) {
  int evenCounter = 0;
  for(int i=0; i<nums.length;i++){
    if(nums[i]%2==0){
      evenCounter++;
    }
  }
  return evenCounter;
}

// Array-2 > bigDiff
public int bigDiff(int[] nums) {
  int diff = 0;
  int counter = 0;
  int smallest = nums[0];
  int biggest = nums[0];
  
  if(nums.length==0){
    return diff;
  }
  while(counter<nums.length){
    if(nums[counter]>biggest){
      biggest = nums[counter];
    }
    else if(nums[counter]<smallest){
      smallest = nums[counter];
    }
   counter++;
  }
  return Math.abs(smallest - biggest);
}
//Return the "centered" average of an array of ints, which we'll say is the mean average of the values, 
//except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value,
//ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
//ignores the biggest outlier.
public int centeredAverage(int[] nums) {
   int smallest = Integer.MAX_VALUE;
   int biggest = Integer.MIN_VALUE;
   int sum = 0;
  for(int i=0; i<nums.length;i++){
   if(nums[i]<smallest){
     smallest=nums[i];
   }
   if(nums[i]>biggest){
     biggest=nums[i];
   }
   sum+=nums[i];   
  }
  //subtract biggest, smallest, and 2 from the sum of items.
  sum = sum - biggest - smallest;
  int avg = sum/(nums.length-2);
  return avg;
}

//Return the sum of the numbers in the array, returning 0 for an empty array.
//Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.

public int sum13(int[] nums) {
  if(nums.length<0){
    return 0;
  }
  
  int sum = 0;
  boolean thirteenFlag = false;
  for(int n:nums){
    if(n==13){
      thirteenFlag = true;
      continue;
    }
    else if(thirteenFlag){
      //flips back to false.
      thirteenFlag = !thirteenFlag;
      continue;
    }
    else {
      sum+=n;
    }
  }
  return sum;
}

/*Return the sum of the numbers in the array, except ignore sections of numbers starting with a 
6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
 */
public int sum67(int[] nums) {
  int sum = 0;
  //this flag indicates the "danger" section
  boolean ignoreNumber = false;
  for(int i=0;i<nums.length;i++){
    if(!ignoreNumber && nums[i] == 6){
      ignoreNumber = true;
      continue;
    }
    if(ignoreNumber && nums[i] == 7){
      ignoreNumber = false;
      continue;
    }
    if(!ignoreNumber){
      sum+=nums[i];
    }
  }
  return sum;
}

//Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
public boolean has22(int[] nums) {
  if(nums.length<2){
    return false;
  }
  for(int i=0; i<nums.length-1;i++){
    if(nums[i]==2 && nums[i+1]==2){
      return true;
    }
  }
  return false;
}

public boolean lucky13(int[] nums) {
   for(int i=0;i<nums.length;i++){
    if(nums[i] == 1 || nums[i] ==3){
      return false;
    }
  }
  return true;
}

public boolean sum28(int[] nums) {
  int sum = 0;
  int i = 0;
  while(i<nums.length){
    if(nums[i]==2){
      sum+=2;
    }
    i=i+1;
  }
  return sum == 8;
}

//Given an array of ints, return true if the number of 1's is greater than the number of 4's
public boolean more14(int[] nums) {
  int fours = 0; 
  int ones = 0;
  for(int i=0; i<nums.length;i++){
    switch(nums[i]){
      case 1:
        ones++;
        break;
      case 4:
        fours++;
        break;
      default:
        break;
    }
  }
  return ones>fours;
}



