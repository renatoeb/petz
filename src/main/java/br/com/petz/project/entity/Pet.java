package br.com.petz.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.petz.project.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pet")
public class Pet implements Serializable {


	private static final long serialVersionUID = -8257112364072594987L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pet")
	private Long idPet;
	
	@NotBlank(message = "Nome do Pet obrigatorio")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	@NotNull
	private Double weight;
	
	@NotBlank(message = "Raça obrigatorio")
	private String breed;
	
	@ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
	
	



}
