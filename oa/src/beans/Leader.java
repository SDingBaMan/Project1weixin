package beans;

public abstract class Leader extends Employee {
	
	/*
	 * 后继人
	 * */
	protected Leader successor;
	
	/*
	 * 处理请假请求
	 * */
	public abstract String handleRequest(int days);
	
	/*
	 * 获得后继人
	 * */
	public Leader getSuccessor(){
		return this.successor;
	}
	
	/*
	 * 设置后继人
	 * */
	public void setSuccessor(Leader succ){
		this.successor = succ;
	}
	
}
