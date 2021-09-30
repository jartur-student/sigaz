package model.vo;

public class StudentVO extends UserVO {
	private String address;
	private String registration;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		if (address == null || address.isEmpty())
			System.out.println("Endereço vazio");
		else
			this.address = address;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		if (registration == null)
			System.out.println("Valor inválido");
		else if (registration.matches("\\D"))
			System.out.println("Caractere inválido, matrícula deve ter apenas dígitos");
		else if (registration.length() != 10)
			System.out.println("Tamanho inválido, matrícula deve ter 10 caracteres");
		else
			this.registration = registration;
	}

	public String toString() {
		return "ID: " + this.getId() + "\nNome: " + this.getName() + "\nEmail: " + this.getEmail() + "\nSenha: "
				+ this.getPassword() + "\nMatrícula: " + this.getRegistration() + "\nEndereço: " + this.getAddress();
	}
}
