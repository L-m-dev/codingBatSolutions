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























