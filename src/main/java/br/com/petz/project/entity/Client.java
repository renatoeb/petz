package br.com.petz.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5732587776590033357L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long idClient;
	
	@NotBlank(message = "Nome do cliente e obrigatorio")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Sobrenome do cliente e obrigatorio")
	@Column(name="last_name")
	private String lastName;

	

	

}
