/**
 * @author Fernandes Júnior
 */

let nome = frmEditContato.nome
let fone = frmEditContato.fone
let email = frmEditContato.email

function editarContato(){
	
	if(this.nome.value === ""){
		alert("Digite o nome por favor!")
		this.nome.focus()
		return false
	} else if(this.fone.value === ""){
		alert("Digite o número do telefone por favor!")
		this.fone.focus();
		return false
	} else{
		document.forms["frmEditContato"].submit()
	}
}



function excluirContato(){
	
	
}