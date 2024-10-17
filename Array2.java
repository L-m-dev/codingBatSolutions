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

public String[] fizzArray2(int n) {
  String[] res = new String[n];
  for(int i=0;i<n;i++){
    res[i]=Integer.toString(i);
  }
  return res;
}

//We'll say that a value is "everywhere" in an array if for every pair of 
//adjacent elements in the array, at least one of the pair is that value. Return true if the given value is everywhere in the array.
public boolean isEverywhere(int[] nums, int val) {
   for(int i=0;i<nums.length-1;i++){
     //early return
    if(nums[i] != val && nums[i+1] != val){
      return false;
    }
  }
  return true;
}

//Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.

public boolean either24(int[] nums) {
  boolean foundPair=false;
  for(int i=0;i<nums.length-1;i++){
    if((nums[i]==2 && nums[i+1]==2||
        (nums[i]==4 && nums[i+1]==4))){
          if(!foundPair){
            foundPair = true;
          } else {
            return false;
          }
        }
      }
return foundPair;
}

//Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in nums2 (at the same index). 
//Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
public int matchUp(int[] nums1, int[] nums2) {
  int count = 0;
  for(int i=0;i<nums1.length;i++){
    if(Math.abs(nums1[i]-nums2[i]) > 0 && Math.abs(nums1[i]-nums2[i])<3){
      count++;
    }
  }
  return count;
}

//Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's separated by one element, such as with {7, 1, 7}.

public boolean has77(int[] nums) {
  for(int i=0; i<nums.length-1; i++){
    if(nums[i]==7){
      if(nums[i+1]==7){
        return true;
      }
      else if (nums.length-i>2 && nums[i+2]==7){
        return true;
      }
    }
  }
  return false;
}

//Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.

public boolean has12(int[] nums) {
  int onePos = -1;
  boolean hasFlag = false;
  for(int i=0;i<nums.length;i++){
    if(nums[i]==1){
      onePos = i;
    }
    else if(nums[i]==2 && onePos>=0 && i>onePos){
      hasFlag = true;
      break;
    }
  }
  return hasFlag;
}
//Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.

public boolean modThree(int[] nums) {
  boolean modThree = false;
  for(int i=0; i<nums.length-2;i++){
    if(nums[i]%2==0 && nums[i+1]%2==0 && nums[i+2]%2==0){
      modThree = true;
      break;
    } 
    else if (nums[i]%2!=0 && nums[i+1]%2!=0 && nums[i+2]%2!=0){
      modThree = true;
      break;
    }
  }
  return modThree;
}

//Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.

public boolean haveThree(int[] nums) {
  int threeCount = 0;
  boolean collision = false;
  for(int i=0;i<nums.length-1;i++){
    if(i==nums.length-2){
      if(nums[i+1]==3){
        threeCount++;
      }
    }
    if(nums[i]==3){
      threeCount++;
    }
    if(nums[i] == 3 && nums[i+1] == 3){
      collision = true;
      break;
    }
  }
  return (threeCount==3 && !collision);
}

//logic for checking neighbors.
public boolean twoTwo(int[] nums) {
  for(int i=0;i<nums.length;i++){
    if(nums[i]==2){
    boolean hasLeftNeighbor = (i>0 && nums[i-1]==2);
    boolean hasRightNeighbor = (i<nums.length-1 && nums[i+1]==2);
    if(!hasLeftNeighbor && !hasRightNeighbor){
      return false;
    }
    }
  }
  return true;
}

//Return true if the group of N numbers at the start and end of the array are the same. 
  //For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3. 
  //You may assume that n is in the range 0..nums.length inclusive.

public boolean sameEnds(int[] nums, int len) {
  if(len==0){
    return true;
  }
  int[] startGroup = new int[len];
  int[] endGroup = new int[len];
  
  int arrayCounter = 0;
  for(int i=0;i<len;i++){
    startGroup[arrayCounter] = nums[i];
    arrayCounter++;
  }
  arrayCounter = 0;
  for(int i=(nums.length-len);i<nums.length;i++){
    endGroup[arrayCounter] = nums[i];
    arrayCounter++;
  }
  
  for(int i=0; i<len; i++){
  if(!(startGroup[i]==endGroup[i])){
    return false;
  }    
  else
  {
    return true;
  }
  }
  return false;
}

//Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
public boolean tripleUp(int[] nums) {
  for(int i=0;i<nums.length-2;i++){
      int n = nums[i];
      if(nums[i+1]==n+1 && nums[i+2]==n+2){
        return true;
    } 
  }
  return false;
}

//Given start and end numbers, return a new array containing the sequence of integers from start up to but not 
//including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. 
//The end number will be greater or equal to the start number. Note that a length-0 array is valid. (See also: FizzBuzz Code)


public int[] fizzArray3(int start, int end) {
  if(start>end){
    return new int[0];
  }
  int[] resultArray = new int[end-start];
  int counter = start;
  for(int i=0; i<resultArray.length;i++){
    resultArray[i] = counter++;
  }
  return resultArray;
}


//Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array.
  
public int[] shiftLeft(int[] nums) {
  int[] shiftedArray = new int[nums.length];
  for(int i=nums.length-1;i>=0;i--){
    if(i==nums.length-1){
      shiftedArray[i] = nums[0];
    } else{
    shiftedArray[i] = nums[i+1];
    }
  }
  return shiftedArray;
}

/* this is not a good solution though... shifts can be in place*/

//THIS IS A SHIFT IN PLACE, save the first element, shift every other

public int[] shiftLeft(int[] nums) {
  if(nums.length<=0){
    return nums;
  }
   int aux = nums[0];
   for(int i=0; i<nums.length;i++){
     if(i==nums.length-1){
       nums[i] = aux;
     } else{
     nums[i]=nums[i+1];
     }
   }
  return nums;   
 }
 
//For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10. 
//So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.

public int[] tenRun(int[] nums) {
  Integer currentNum = null;
  for(int i=0;i<nums.length;i++){
    if(nums[i]%10==0){
      currentNum = nums[i];
      continue;
    } 
    if(currentNum != null){
      nums[i] = currentNum;
    }
  }
  return nums;
}

// Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array. 
//The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.


public int[] pre4(int[] nums) {
  if(nums.length==0){
     return new int[0];
  }
  int fourIndex = -1;
  for(int i=0; i<nums.length;i++){
    if(nums[i]==4){
      fourIndex = i;
    }
    if(fourIndex>-1){
      int[] resultArray = new int[fourIndex];
      for(int j=0; j<resultArray.length;j++){
        resultArray[j] = nums[j];
      }
     return resultArray;
    }
  }
  return new int[0];
}

//Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 in the original array.
//The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.

public int[] post4(int[] nums) {
  if(nums.length==0){
    return new int[0];
  }
  int fourIndex = -1;
  for(int i=nums.length-1;i>=0;i--){
    if(nums[i]==4){
      fourIndex = i;
      break;
    }
  }
  if(fourIndex == -1 || fourIndex == nums.length-1){
    return new int[0];
  }
  int[] resultArray = new int[nums.length-fourIndex-1];
  
  for(int i=0;i<resultArray.length;i++){
    resultArray[i] = nums[fourIndex+1+i];
  }
  return resultArray;
}

//We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it.
//Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.


public int[] notAlone(int[] nums, int val) {
  if(nums.length<3){
    return nums;
  }
  for(int i=0;i<nums.length;i++){
 
    if(nums[i]==val){
      if(i>0 && i<nums.length-1 &&
      (nums[i-1] != val && nums[i+1] !=val)){
        if(nums[i-1]>nums[i+1]){
          nums[i] = nums[i-1];
        } else if(nums[i-1]<nums[i+1]){
          nums[i] = nums[i+1];
        } else {
          continue;
        }
      }
    } 
  }
  return nums;
}

/*Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are grouped at the start of the array.
The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
  */
public int[] zeroFront(int[] nums) {
  if(nums.length<2){
    return nums;
  }
  //track last index of zero...
  int indexPlaceZero = 0;
  for(int i=0;i<nums.length;i++){
    if(nums[i]==0){
      int aux = nums[indexPlaceZero];
      nums[indexPlaceZero] = nums[i];
      nums[i] = aux;
      indexPlaceZero++;
    }
  }
  return nums;
}

   //Return a version of the given array where all the 10's have been removed. 
  //The remaining elements should shift left towards the start of the array as needed, and the empty spaces a the end of the array should be 0. 
  //So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.

public int[] withoutTen(int[] nums) {
  int insertIndex=0;
  //insert the things that aren't 10
  for(int i=0; i<nums.length;i++){
   if(nums[i]!=10){
     nums[insertIndex] = nums[i];
     insertIndex++;
   } 
  }
  //then fill the rest, starting by the last index of valid number.
  for(int i=insertIndex;i<nums.length;i++){
    nums[i]=0;
  }
  return nums;
}

//Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of 
  //the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.

public int[] zeroMax(int[] nums) {
  for(int i=0;i<nums.length;i++){
    if(nums[i]==0){
      int max = 0;
      for(int j=i+1;j<nums.length;j++){
        if(nums[j]%2!=0 && nums[j]>max){
          max=nums[j];
          }
      }
      nums[i]=max;
    }
  }
  return nums;
}

//inefficient but works.....

public int[] evenOdd(int[] nums) {
  int oddIndex = nums.length-1;
  int evenIndex = 0;
  int aux = 0;
  int c=0;
  while(c<2){
  for(int i=0; i<nums.length;i++){
    if(nums[i]%2==0 && i>evenIndex){
    aux = nums[evenIndex];
    nums[evenIndex] = nums[i];
    nums[i] = aux;
    evenIndex++;
    } 
    if(nums[i]%2!=0 && i<oddIndex){
    aux = nums[oddIndex];
    nums[oddIndex] = nums[i];
    nums[i] = aux;
    oddIndex--;
    }
  }
  c++;
  }
  return nums;
}


public String[] fizzBuzz(int start, int end) {
  String[] resArray = new String[end-start];
  int currentIndex=0;
  for(int i=start;i<end;i++){
    if(i%3==0 && i%5==0){
      resArray[currentIndex++]= "FizzBuzz";
    } 
    else if(i%3==0){
      resArray[currentIndex++]="Fizz";
    }else if(i%5==0){
      resArray[currentIndex++]="Buzz";
    }
    else{
      resArray[currentIndex++] = String.valueOf(i);
    }
    }
  return resArray;
}

