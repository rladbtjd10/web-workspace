package edu.kh.test.user.model.vo;

public class ManagerVO {
	
	private int ManagerNumber;
	private String ManagerName;
	private String ManagerHireDate;
	
	public ManagerVO() {}

	public ManagerVO(int managerNumber, String managerName, String managerHireDate) {
		ManagerNumber = managerNumber;
		ManagerName = managerName;
		ManagerHireDate = managerHireDate;
	}

	public int getManagerNumber() {
		return ManagerNumber;
	}

	public void setManagerNumber(int managerNumber) {
		ManagerNumber = managerNumber;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public String getManagerHireDate() {
		return ManagerHireDate;
	}

	public void setManagerHireDate(String managerHireDate) {
		ManagerHireDate = managerHireDate;
	}

	
	
	
	

}
