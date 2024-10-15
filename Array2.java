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

