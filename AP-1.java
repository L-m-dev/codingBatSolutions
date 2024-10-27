public boolean scoresIncreasing(int[] scores) {
  boolean biggerScore = false;
  for(int i=0; i<scores.length-1; i++){
    if(scores[i+1]>=scores[i]){
      biggerScore = true;
    } else {
      biggerScore = false;
      break;
    }
  }
  return biggerScore;
}

public boolean scores100(int[] scores) {
  for(int i=0; i<scores.length-1; i++){
    if(scores[i]==scores[i+1]){
      return true;
    }
  }
  return false;
}

public boolean scoresClump(int[] scores) {
  for(int i=0; i<scores.length; i++){
    if(i<scores.length-2){
      int range = scores[i]+2;
      if(scores[i+1]<=range && scores[i+2]<=range){
        return true;
      }
    }
  }
  return false;
}

public int scoresAverage(int[] scores) {
  int middle = scores.length/2;
  int firstHalfAverage = average(scores, 0, middle);
  int secondHalfAverage = average(scores, middle, scores.length);
  
  return Math.max(firstHalfAverage, secondHalfAverage);
}

int average(int[] scores, int start, int end){
  int sum = 0 ;
  int count = 0;
  for(int i=start; i<end; i++){
    sum+= scores[i];
    count++;
  }
  
  return sum/count;
}

public int wordsCount(String[] words, int len) {
  int count = 0;
  for(int i=0; i<words.length; i++){
    if(words[i].length() == len){
      count++;
    }
  }
  return count;
}

public String[] wordsFront(String[] words, int n) {
  String[] res = new String[n];
  for(int i=0; i<n; i++){
    res[i] = words[i];
   }
return res;
}

public List wordsWithoutList(String[] words, int len) {
  ArrayList<String> list = new ArrayList<>();
  for(String word:words){
    if(word.length() != len){
      list.add(word);
    }
  }
  return list;
}

public boolean hasOne(int n) {
  while(n>0){
    int digit = n%10;
    if(digit==1){
      return true;
    }
    n = n/10;
  }
  return false;
}

public int[] copyEvens(int[] nums, int count) {
  int[] nA = new int[count];
  int counter = 0;
  for(int i=0; i<nums.length; i++){
    if(nums[i]%2==0){
      nA[counter]=nums[i];
      counter++;
      if(counter == count){
        break;
      }
    }
  }
  return nA;
}

public int[] copyEndy(int[] nums, int count) {
  int[] nA = new int[count];
  Queue<Integer> numQueue   = new LinkedList();
  for(int n:nums){
    if(isEndy(n)){
      numQueue.add(n);
    }
  }
  for(int i=0; i<count; i++){
    nA[i] = numQueue.poll();
  }
  return nA;
}

boolean isEndy(int num){
  if((num>=0 && num<=10) || (num>=90 && num<=100)){
    return true;
  }
  return false;
} 

public int matchUp(String[] a, String[] b) {

  int maxLength = Math.max(a.length, b.length);
  int len = (a.length+b.length) -maxLength;
  int countNonEmptySameChar = 0;
  
  for(int i=0; i<maxLength; i++){
  if(a[i].equals("") || b[i].equals("")){
    continue;
  }
  if(a[i].charAt(0) == b[i].charAt(0)){
    countNonEmptySameChar++;
  }
  }
  return countNonEmptySameChar;
}


public int sumHeights(int[] heights, int start, int end) {
  int sum = 0;
  for(int i=start; i<end; i++){
    sum += Math.abs(heights[i]-heights[i+1]);
  }
  return sum;
}

public int sumHeights2(int[] heights, int start, int end) {
  int sum = 0;
  for(int i=start; i<end; i++){
    if(heights[i]<heights[i+1]){
    sum += Math.abs(2*(heights[i]-heights[i+1]));
    } else{
    sum += Math.abs(heights[i]-heights[i+1]);
    }
  }
  return sum;
}

public int bigHeights(int[] heights, int start, int end) {
  int bigSteps = 0;
  for(int i=start; i<end; i++){
    if(Math.abs(heights[i]-heights[i+1]) >= 5){
      bigSteps++;
    }
  }
  return bigSteps;
}

public int userCompare(String aName, int aId, String bName, int bId) {
  
  if(aName.compareTo(bName)<0){
    return -1;
  } 
  else if(aName.compareTo(bName)>0){
    return 1;
  } 
  if(aId < bId){
    return -1;
  } 
  else if(aId > bId){
    return 1;
  }
  else {
    return 0;
  }
}


