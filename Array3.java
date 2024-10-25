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

public int[] fix34(int[] nums) {
  
  for(int i=0; i<nums.length-1; i++){
    if(nums[i]==3 && nums[i+1]!=4){
    for(int j=0; j<nums.length; j++){
      //bug, it's unbalancing numbers that are already balanced, fix checking that.
      //but here the 4s are never in the start, different than the following exercise
      if(nums[j]==4 && (j>0 && nums[j-1]!=3)){
        nums[j]=nums[i+1];
        nums[i+1]=4;
      }
    }
    }
  }
  return nums;
}
public int[] fix45(int[] nums) {

  for(int i=0; i<nums.length-1; i++){
    if(nums[i]==4 && nums[i+1]!=5){
    for(int j=0; j<nums.length; j++){
      //either it's at j==0 or at j>1 and the first is not a 4
       if(nums[j]==5 && (j==0 || (j>0 && nums[j-1]!=4))){
        nums[j]=nums[i+1];
        nums[i+1]=5;
      } 
    }
    }
  }
  return nums;
}


//my solution, there are better ones. 
//Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. 
//The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.

//better solution is using HashSet

public boolean linearIn(int[] outer, int[] inner) {
  //I believe the empty element is contained?
  if(inner.length==0){
    return true;
  }
  
  boolean contained = false;
  
  for(int i=0; i<inner.length; i++){
    int currentNumber = inner[i];
    for(int j=0; j<outer.length; j++){
      if(outer[j]==currentNumber){
        contained = true;
        break;
      } 
      if((j==outer.length-1 && outer[j]!=currentNumber) || outer[j]>currentNumber){
        contained = false;
        break;
      }  
    }
    if(!contained){
      break;
    }
  }
  return contained;
}

//invert
//my solution for squareUp, although the last part was more of try and error.
public int[] squareUp(int n) {
  int[] nA = new int[n*n];
  int k = nA.length-1;
  for(int i=0; i<n; i++){
    for(int j=n-1; j>=0; j--){
      if(i>j){
      nA[k--] = 0;
      } else {
      nA[k--] = (n-j);
      }
    }
  }
  return nA;
}

//Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on 
//one side is equal to the sum of the numbers on the other side.

public boolean canBalance(int[] nums) {
  //i is the boundary.
  for(int i=0; i<nums.length; i++){
    int sumL = sum(nums, 0, i);
    int sumR = sum(nums, i+1, nums.length-1);
    if(sumL==sumR){
      return true;
    }
  }
  return false;
}
//helper method
public int sum(int[] nums, int start, int end){
  int sum = 0;
  for(int i = start; i<=end; i++){
    sum+=nums[i];
  }
  return sum;
}

 
