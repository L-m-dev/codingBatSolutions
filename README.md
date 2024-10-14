# codingBatSolutions

String-2 > endOther
public boolean endOther(String a, String b) {
  a = a.toLowerCase();
  b = b.toLowerCase();
  
  int aL = a.length();
  int bL = b.length();
  
  if(a.substring(Math.max(0, aL-bL), aL).equals(b)){
    return true;
  }
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


