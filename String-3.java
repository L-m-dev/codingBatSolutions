public int countYZ(String str) {
  int count = 0;
  List charList = Arrays.asList('y', 'z', 'Y', 'Z');
  for(int i=0; i< str.length(); i++){
    if(charList.contains(str.charAt(i))){
      if(i==str.length()-1 || !Character.isLetter(str.charAt(i+1))){
        count++;
      }
    }
  }
  return count;
}

public String withoutString(String base, String remove) {
  while(base.toLowerCase().indexOf(remove.toLowerCase())>=0){
    int iR = base.toLowerCase().indexOf(remove.toLowerCase());
    base = base.substring(0, iR) + base.substring(remove.length()+iR, base.length());
  }
  return base;
}


public boolean gHappy(String str) {
  if(str.length()==0){
    return true;
  }
  if(str.length()==1 && str.charAt(0) == 'g'){
    return false;
  }
  
  for(int i=0; i<str.length(); i++){
    if(str.charAt(i)=='g'){
    boolean happy=false;
    if((i>0&& str.charAt(i-1)=='g')|| (i<str.length()-1 && str.charAt(i+1)=='g')){
      happy = true;
    }
    if(!happy){
      return false;
    }
    }
  }
  return true;
}

public int countTriple(String str) {
  int count =0;
  for(int i=0; i<str.length(); i++){
    if(i<str.length()-2){
      if(str.charAt(i)==str.charAt(i+1) && str.charAt(i+1)==str.charAt(i+2)){
        count++;
      }
    }
  }
  return count;
}


public int sumDigits(String str) {
  // Could use a replace all str = str.replaceAll("\\D", "");
  int count = 0;
  if(str.length()==0){
    return 0;
  }
  for(int i=0; i<str.length();i++){
    if(Character.isDigit(str.charAt(i))){
      count += Integer.parseInt(str.substring(i,i+1));
    }
  }
  return count;
}



//credit: JavaProblems.com
public String sameEnds(String string) {
 int len = string.length();
 String fin = "";
 String tmp = "";
 
 for(int i=0; i<len; i++){
   tmp += string.charAt(i);
   int tmplen = tmp.length();
   if(i<len/2 && tmp.equals(string.substring(len-tmplen, len))){
     fin = tmp;
   }
 }
 return fin;
}

public String mirrorEnds(String string) {
  if(string.length()==0){
    return "";
  }
  String result = "";
  int len = string.length();
  int endIndex = len-1;
  
  for(int i=0; i<len; i++){
    if(string.charAt(i) == string.charAt(endIndex)){
      result += string.charAt(i);
      endIndex--;
    } else {
      break;
    }
  }
  return result;
}


public int maxBlock(String str) {
  if(str.length()==0){
    return 0;
  }
  
  int biggestLength = 0; 
  int currentLength = 0;
  char currentChar; 
  
  for(int i=0; i<str.length(); i++){
  currentChar = str.charAt(i);
  currentLength = 0;
  
  for(int j=i; j<str.length(); j++){
    if(str.charAt(j) == currentChar){
      currentLength++;
      if(currentLength>biggestLength){
        biggestLength = currentLength;
      }
    }
    else {
      currentLength = 0;
      break;
    }
  }
}
return biggestLength;
}


public int sumNumbers(String str) {
  
  ArrayList<Integer> numList = new ArrayList<>();
  String currentNumber = "";
  
  for(int i=0; i<str.length(); i++){ 
    if(Character.isDigit(str.charAt(i))){
      currentNumber += str.charAt(i);
      //if this is the last index or there is no neighbor number, parse what has been built (Ex. 151), add to the list and reset the currentNumber builder.
      if(i == str.length() -1 || 
      (i<str.length()-1 && !Character.isDigit(str.charAt(i+1)))){
        numList.add(Integer.parseInt(currentNumber));
        currentNumber = "";
       }
    }
  }
  int sum = 0;
  for(int num:numList){
  sum+=num;
  }
  return sum;
}


















