package view;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.vo.*;

public class View extends Application {
	private static Stage primaryStage;
	private static Stage secondaryStage;
	private static ViewMode viewMode = ViewMode.RESTRICTED;

	public static ViewMode getViewMode() {
		return viewMode;
	}

	public static void setViewMode(ViewMode mode) {
		viewMode = mode;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	private static Stage setPrimaryWindow(Scene scene, String title) throws Exception {
		primaryStage.show();
		closeSecondaryWindow();
		primaryStage.setScene(scene);
		primaryStage.setTitle(title);
		return primaryStage;
	}

	private static void hidePrimaryWindow() {
		if (primaryStage != null) {
			primaryStage.hide();
		}
	}

	private static Stage setSecondaryWindow(Scene scene, String title) throws Exception {
		closeSecondaryWindow();
		secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle(title);
		secondaryStage.centerOnScreen();
		secondaryStage.setResizable(false);
		secondaryStage.show();
		return secondaryStage;
	}

	public static void closeSecondaryWindow() {
		if (secondaryStage != null) {
			secondaryStage.close();
			secondaryStage = null;
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		primaryStage.setResizable(false);
		login();
	}

	public static void login() throws Exception {
		hidePrimaryWindow();
		Parent root = FXMLLoader.load(View.class.getResource("xml/login.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Entrar");
	}

	public static void home() throws Exception {
		Parent root = FXMLLoader.load(View.class.getResource("xml/home.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Home");
		primaryStage.centerOnScreen();
	}

	public static void classrooms() throws Exception {
		ClassroomController.setClassroom(null);
		ClassroomController.setProfessor(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/searchClassroom.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Turmas");
	}

	public static void classrooms(ProfessorVO professor) throws Exception {
		ClassroomController.setClassroom(null);
		ClassroomController.setProfessor(professor);
		Parent root = FXMLLoader.load(View.class.getResource("xml/searchClassroom.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Turmas");
	}

	public static void classroom(ClassroomVO classroom) throws Exception {
		ClassroomController.setClassroom(classroom);
		ClassroomController.setProfessor(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/classroom.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Turma");
	}

	public static void createClassroom() throws Exception {
		RegisterClassroomController.setClassroom(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/registerClassroom.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Cadastrar Turma");
	}

	public static void associateStudents() throws Exception {
		Parent root = FXMLLoader.load(View.class.getResource("xml/associateStudent.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Associar Alunos");
	}

	public static void editClassroom(ClassroomVO classroom) throws Exception {
		RegisterClassroomController.setClassroom(classroom);
		Parent root = FXMLLoader.load(View.class.getResource("xml/editClassroom.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Editar Turma");
	}

	public static void subjects() throws Exception {
		SubjectController.setSubject(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/searchSubject.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Disciplinas");
	}

	public static void subjects(StudentVO student) throws Exception {
		ConcludedSubjectsController.setStudent(student);
		Parent root = FXMLLoader.load(View.class.getResource("xml/concludedSubjects.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Disciplinas");
	}

	public static void createSubject() throws Exception {
		SubjectController.setSubject(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/registerSubject.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Cadastrar Disciplina");
	}

	public static void editSubject(SubjectVO subject) throws Exception {
		SubjectController.setSubject(subject);
		Parent root = FXMLLoader.load(View.class.getResource("xml/editSubject.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Editar Disciplina");
	}

	public static void professors() throws Exception {
		ProfessorController.setProfessor(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/searchProfessor.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Professores");
	}

	public static void createProfessor() throws Exception {
		ProfessorController.setProfessor(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/registerProfessor.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Cadastrar Professor");
	}

	public static void editProfessor(ProfessorVO professor) throws Exception {
		ProfessorController.setProfessor(professor);
		Parent root = FXMLLoader.load(View.class.getResource("xml/editProfessor.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Editar Professor");
	}

	public static void students() throws Exception {
		StudentController.setStudent(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/searchStudent.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Alunos");
	}

	public static void createStudent() throws Exception {
		StudentController.setStudent(null);
		Parent root = FXMLLoader.load(View.class.getResource("xml/registerStudent.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Cadastrar Aluno");
	}

	public static void editStudent(StudentVO student) throws Exception {
		StudentController.setStudent(student);
		Parent root = FXMLLoader.load(View.class.getResource("xml/editStudent.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Editar Aluno");
	}

	public static void grade(ClassroomVO classroom) throws Exception {
		GradeController.setClassroom(classroom);
		Parent root = FXMLLoader.load(View.class.getResource("xml/gradesFrequency.fxml"));
		setSecondaryWindow(new Scene(root), "SIGAZ - Notas e Frequência");
	}

	public static void grade(StudentVO student) throws Exception {
		BoletimController.setStudent(student);
		Parent root = FXMLLoader.load(View.class.getResource("xml/grades.fxml"));
		setPrimaryWindow(new Scene(root), "SIGAZ - Boletim");
	}
}
