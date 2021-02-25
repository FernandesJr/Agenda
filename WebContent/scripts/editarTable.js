/**
 * @autor FernandesJunior
 */

let nome = frmEditContato.nome
let fone = frmEditContato.fone
let email = frmEditContato.email

function editarContatoDB(){
	 // Validação dos campos obrigatórios
	if(this.nome.value === ""){
		alert("Digite o nome por favor!")
		this.nome.focus()
		return false
	} else if(this.fone.value === ""){
		alert("Digite o número do telefone por favor!")
		this.fone.focus();
		return false
	} else{
		//Caso tudo esteja devidamente preenchido ele submete o action do formulário upd.jsp
		document.forms["frmEditContato"].submit()
	}
}


function exluirContato(id){
	
	//Recebo o ID do contato que vem da agenda.jsp e passo a requisição para o controller excluir esse
	var conf = confirm(`Você realmente deseja EXCLUIR o contato que tem o ID ${id}?`)
	
	if(conf){
		window.location = `Controller?action=del&id=${id}` // LEMBRANDO ${} é o placeholder do JS 
	}
}

function editarContato(id){
	// encaminhando ao Controller o id do contato que será editado
	window.location = `Controller?action=upd&id=${id}`
	
}