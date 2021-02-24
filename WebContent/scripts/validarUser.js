/**
 * @autor FernandesJunior
 */

/*var nome  = document.getElementById("nome")
var fone  = document.getElementById("fone") // como pegar pelo id
var email = document.getElementById("email")
*/

/*let nome = document.getElementsByName("nome")[0]
let fone = document.getElementsByName("fone")[0] //como pegar pelo o nome
let email = document.getElementsByName("email")[0]
*/

let nome = frmContato.nome
let fone = frmContato.fone
let email = frmContato.email

function validar(){
	
	if(this.nome.value === ""){
		alert("Digite o nome por favor!")
		this.nome.focus()
		return false
	} else if(this.fone.value === ""){
		alert("Digite o número do telefone por favor!")
		this.fone.focus();
		return false
	} else{
		document.forms["frmContato"].submit()
	}
}

