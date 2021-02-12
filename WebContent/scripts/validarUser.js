/**
 * @autor FernandesJunior
 */

var nome  = document.getElementById("nome")
var fone  = document.getElementById("fone")
var email = document.getElementById("email")


function validar(){
	
	if(this.nome.value === ""){
		alert("Digite o nome por favor!")
		this.nome.focus()
	} else if(this.fone.value === ""){
		alert("Digite o número do telefone por favor!")
		this.fone.focus()
	}else{
		document.forms["frmContato"].submit()
		alert("UserCadastrado")
	}
}