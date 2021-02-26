package com.example.crud.dtos;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.crud.entities.Telefone;
import com.example.crud.services.validations.EmailIsEmpty;
import com.example.crud.services.validations.EmailList;
import com.example.crud.services.validations.EmailUpdateNotRepeated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClienteDTO {

	
	@NotEmpty(message="O campo Nome deve ser preenchido.")
	@Size(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres.")
	@Pattern(regexp ="^[a-zA-Z0-9 ]+$", message="O campo nome deve ser preenchido apenas com caracteres alfanuméricos")
	private String nome;
	
	@NotEmpty(message="O campo CEP deve ser preenchido.")
	@Pattern(regexp="^(0|[1-9][0-9]*)$", message="Formato de CEP inválido, apenas números são permitidos.")
	private String cep;
	
	@NotEmpty(message="O campo Logradouro deve ser preenchido.")
	private String logradouro;
	
	@NotEmpty(message="O campo Complemento deve ser preenchido.")
	private String complemento;
	
	@NotEmpty(message="O campo Bairro deve ser preenchido.")
	private String bairro;
	
	@NotEmpty(message="O campo Cidade deve ser preenchido.")
	private String cidade;
	
	@NotEmpty(message="O campo Estado deve ser preenchido.")
	private String uf;
	
	@EmailUpdateNotRepeated
	@EmailList
	@EmailIsEmpty
	private Set<String> emails;
	
	@NotEmpty(message="É necessário preencher pelo o menos 1 Telefone.")
	private List<Telefone> telefones;
	
}