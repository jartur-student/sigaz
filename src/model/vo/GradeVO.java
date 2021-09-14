package model.vo;

public class GradeVO {
	private StudentVO student;
	private ClassroomVO classroom;
	private int n1;
	private int n2;
	private int n3;
	private int nfinal;
	private double frequency;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		if(id < 0)
			System.out.println("ID inválido!");
		else
			this.id = id;
	}

	private void setNFinal(int nfinal) {
		this.nfinal = nfinal;
	}

	private void calculateNFinal() {
		int gradeSum = this.getN1() + this.getN2() + this.getN3();
		int partialAverage = Double.valueOf(Math.ceil(gradeSum / 3.0)).intValue();

		this.setNFinal(partialAverage);
	}

	public StudentVO getStudent() {
		return this.student;
	}

	public void setStudent(StudentVO student) {
		if (student == null)
			System.out.println("Aluno inválido");
		else
			this.student = student;
	}

	public ClassroomVO getClassroom() {
		return this.classroom;
	}

	public void setClassroom(ClassroomVO classroom) {
		if (classroom == null)
			System.out.println("Turma inválida");
		else
			this.classroom = classroom;
	}

	public int getN1() {
		return this.n1;
	}

	public void setN1(int n1) {
		if (n1 < 0 || n1 > 100)
			System.out.println("Nota inválida, deve ser de 0 a 100");
		else {
			this.n1 = n1;
			this.calculateNFinal();
		}
	}

	public int getN2() {
		return this.N2;
	}

	public void setN2(int n2) {
		if (n2 < 0 || n2 > 100)
			System.out.println("Nota inválida, deve ser de 0 a 100");
		else {
			this.n2 = n2;
			this.calculateNFinal();
		}
	}

	public int getN3() {
		return this.n3;
	}

	public void setN3(int n3) {
		if (n3 < 0 || n3 > 100)
			System.out.println("Nota inválida, deve ser de 0 a 100");
		else {
			this.n3 = n3;
			this.calculateNFinal();
		}
	}

	public int getNFinal() {
		return this.nfinal;
	}

	public double getFrequency() {
		return this.frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public String toString() {
		return "Aluno: " + this.getStudent().getName() + "\nDisciplina: " + this.getClassroom().getSubject().getName()
				+ "\nN1: " + this.getN1() + "\nN2: " + this.getN2() + "\nN3: " + this.getN3() + "\nMédia Final: "
				+ this.getNFinal() + "\nFrequência: " + this.getFrequency() + "%";
	}
}
