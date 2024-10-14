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

