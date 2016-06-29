package beans;

public class DepLeader extends Leader {

	@Override
	public String handleRequest(int days) {
		if(days <= 2){
			return this.getId();	//2天之内的假,部门领导就能审批；大于2天，向上级申请。
		}else {
			return this.getSuccessor().handleRequest(days);
		}
		
	}

}
