package edu.kh.test.user.model.vo;

public class StudentVO {
	
	private int studentno;
	private String studentname;
	private int koreanscore;
	private int englishscore;
	private int mathscore;
	
	public StudentVO() {}

	public StudentVO(int studentno, String studentname, int koreanscore, int englishscore, int mathscore) {
		this.studentno = studentno;
		this.studentname = studentname;
		this.koreanscore = koreanscore;
		this.englishscore = englishscore;
		this.mathscore = mathscore;
	}

	public int getStudentno() {
		return studentno;
	}

	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getKoreanscore() {
		return koreanscore;
	}

	public void setKoreanscore(int koreanscore) {
		this.koreanscore = koreanscore;
	}

	public int getEnglishscore() {
		return englishscore;
	}

	public void setEnglishscore(int englishscore) {
		this.englishscore = englishscore;
	}

	public int getMathscore() {
		return mathscore;
	}

	public void setMathscore(int mathscore) {
		this.mathscore = mathscore;
	}

	
	
	
	
	
	
	
	
	

}
