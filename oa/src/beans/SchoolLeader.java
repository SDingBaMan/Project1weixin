package beans;

public class SchoolLeader extends Leader {

	@Override
	public String handleRequest(int days) {
		if(days <= 5){
			return this.getId();	//5天之内的假,校领导能审批；大于5天，向上级申请。
		}else {
			return this.getSuccessor().handleRequest(days);
		}
	}

}
