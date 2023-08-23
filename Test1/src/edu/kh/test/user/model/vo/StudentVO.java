package edu.kh.test.user.model.vo;

public class StudentVO {
	
	private int StudentNo;
	private String StudentName;
	private int KoreanScore;
	private int EnglishScore;
	private int MathScore;
	
	public StudentVO() {}

	public StudentVO(int studentNo, String studentName, int koreanScore, int englishScore, int mathScore) {
		StudentNo = studentNo;
		StudentName = studentName;
		KoreanScore = koreanScore;
		EnglishScore = englishScore;
		MathScore = mathScore;
	}

	public int getStudentNo() {
		return StudentNo;
	}

	public void setStudentNo(int studentNo) {
		StudentNo = studentNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getKoreanScore() {
		return KoreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		KoreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return EnglishScore;
	}

	public void setEnglishScore(int englishScore) {
		EnglishScore = englishScore;
	}

	public int getMathScore() {
		return MathScore;
	}

	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}
	
	
	
	
	
	

}
