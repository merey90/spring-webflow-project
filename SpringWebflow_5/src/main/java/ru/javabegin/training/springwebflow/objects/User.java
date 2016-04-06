package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class User implements Serializable {

	private static final long serialVersionUID = 7730377931313245319L;
	@Size(min = 4, message = "{name.size.error}")
	private String name;
	@Size(min = 4, max = 8, message = "{password.size.error}")
	private String password;

	public User() {
	}
 
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
