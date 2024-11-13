package system;

public class Reputation {
	private Satisfaction satisfaction;
	private int score;
	
	public Reputation(Satisfaction satisfaction) {
		this.satisfaction = satisfaction;
		this.score = 0;
	}
	
	public void setSatisfaction(Satisfaction satisfaction) {
		this.satisfaction = satisfaction;
	}

	public int getScore() {
		return score;
	}
	
	public void calculScoreReputation() {
		int satisfactionScore = satisfaction.calculScoreSatisfaction();
		
		 switch(satisfactionScore) {
		     case 0:
		         score -= 10;
		     case 1:
		         score -= 5;
		     case 2:
		         score -= 2;
		     case 3:
		         score += 2;
		     case 4:
		         score += 5;
		     case 5:
		         score += 10;
		     default:
		         System.out.println("Out of range");
		 }
	}
}
