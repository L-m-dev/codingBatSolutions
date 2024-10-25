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











