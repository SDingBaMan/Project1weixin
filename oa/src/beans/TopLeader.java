package beans;

public class TopLeader extends Leader {

	@Override
	public String handleRequest(int days) {
		System.out.println("*****************");
		if(days > 5){

			return this.getId();	//5天以上的假,Top领导能审批;
		}else {


			return this.getSuccessor().handleRequest(days);
		}
	}

}
