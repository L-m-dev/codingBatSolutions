# codingBatSolutions

String-2 > endOther  
public boolean endOther(String a, String b) {  
//normalize   
  a = a.toLowerCase();  
  b = b.toLowerCase();  
  
// storing length as aL for ease      
  int aL = a.length();     
  int bL = b.length();     
// if a substring of A that starts in the middle or 0 and ends at the end equals B, return true.    
// Math.max is used in case B.length is longer than A.length. In that case the index goes into the negatives - should not happen        

  if(a.substring(Math.max(0, aL-bL), aL).equals(b)){   
    return true;   
  }       
//same as above   
  if(b.substring(Math.max(0,bL-aL), bL).equals(a)){   
    return true;
  }   
  return false;
}  
  
String-2 > xyzThere   
public boolean xyzThere(String str) {  
  if(str.length()<4){  
    return str.equals("xyz");  
    }  
  for(int i=0; i<str.length()-2; i++){  
    if(str.substring(i, i+3).equals("xyz")){  
      if(i==0){  
        return true;  
      }  
      else {  
      if(!(str.substring(i-1,i).equals("."))){  
        return true;  
      } else {  
        continue;
      }  
    }  
  }  
  }  
  return false;
 }  


String-2 > bobThere

 public boolean bobThere(String str) {
 //Using while instead of for-loop
  while(str.indexOf('b') >= 0 && str.length()>2){
    int currentIndex = str.indexOf('b');
    //if "b" is at the last or before-last index, should return false, else it goes Out of Bounds.    
    if(str.length()-currentIndex <2){  
      return false;
    }   
    if(str.substring(currentIndex+2, currentIndex+3).equals("b")){
      return true;
    } 
    else {  
    //Partitions input to remove the "b"s that have already been checked    
      str = str.substring(currentIndex+1, str.length());  
    }  
  }  
  return false;
}  


String-2 > xyBalance

public boolean xyBalance(String str) {
  //early return for empty string.
 if(str.length()<1){
   return true;
 }
  for(int i=str.length()-1;i>=0;i--){
    char currentChar = str.charAt(i);
    //last char is X, therefore it's not balanced
    if(currentChar == 'x'){
      return false;
    } 
    //last char is Y, therefore it is balanced, regardless of other characters
    else if(currentChar == 'y'){
      return true;
    } 
    else {
      continue;
    }
   }
  return true;
}


String-2 > mixString

public String mixString(String a, String b) {
  String result = "";
  String biggerString = "a";
  int minLength = Math.min(a.length(), b.length());
  int maxLength = Math.max(a.length(), b.length());
   
 if(a.length()>b.length()){
    biggerString = a;
  } 
  else{
    biggerString = b;
  }
  
  for(int i=0; i<maxLength;i++){
    //if index has passed the point where it's adding letters intercalled from each string, add the rest of the longer string.
    if(i>=minLength){
      result+=biggerString.substring(i, biggerString.length());
      break;
    } else{
      result+= a.substring(i, i+1);
      result+= b.substring(i, i+1);
    }
  }
return result;
}

//repeat end
//Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive.
  
public String repeatEnd(String str, int n) {
  String end = str.substring(str.length()-n, str.length());
  String result = "";
  //starting at 1 for simplicity.
  for (int i = 1; i <=n ; i++){
    result+=end;
  }
  return result;
}

//Given a string and an int n, return a string made of the first n characters of the string, followed by the 
//first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).

 public String repeatFront(String str, int n) {
  String prefix = str.substring(0, n);
  String result = "";
  //Starting at 1. When starting at 1, careful with middle condition.
  for(int i=1; i<=n; i++){
    result += prefix;
    prefix = str.substring(0, n-i);
  }
  return result;
}

/* Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string. */
public String repeatSeparator(String word, String sep, int count) {
  String result = "";
  if(count <1){
    return "";
  } 
  if(count==1){
    return word;
  }
  for(int i=0; i<count; i++){
    if(i>0){
      result+=sep;
    }
    result+=word;
  }
  return result;
}

//Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? 
//Assume that the string is not empty and that N is in the range 1..str.length().
//String-2 Prefix Again
public boolean prefixAgain(String str, int n) {
  String prefix = str.substring(0, n);
  for(int i = (0+n); i<=str.length()-n; i++){
    if(str.substring(i,i+n).equals(prefix)){
      return true;
    }
  }
  return false;
}

// A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string ""
//if there are not two pieces of bread.


public String getSandwich(String str) {
  if(str.length()<5){
    return "";
   }
  String result = "";
  int breadCount = 0;
  int firstBreadEndIndex = -1;
  int secondBreadStartIndex = -1;

  //decided this style instead of substring
  for(int i=0; i<str.length()-4;i++){
    if(str.charAt(i) == 'b'){
      if(str.charAt(i+1) == 'r'){
        if(str.charAt(i+2) == 'e'){
          if(str.charAt(i+3) == 'a'){
            if(str.charAt(i+4) == 'd'){
              //increment bread count;
              breadCount++;
              //if the first bread ending index wasn't set, set it
              if(firstBreadEndIndex<0){
              firstBreadEndIndex = i+5;
              }
              //the first bread ending index was set, so if there is another bread, its starting index will be set.
              else {
                secondBreadStartIndex = i;
              }
            }
          }
        }
      }
    }    
  }
  if(breadCount<2){
    return "";
  }
  result = str.substring(firstBreadEndIndex, secondBreadStartIndex);
  return result;
}


