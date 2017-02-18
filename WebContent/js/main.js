
$(document).ready( function() {
	alert("OK");
	$("#cep").change(function(){
		var cep_code = $(this).val();
		if( cep_code.length <= 0 ) return;
		$.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep_code },
				function(result){
			if( result.status!=1 ){
				alert(result.message || "Houve um erro desconhecido");
				return;
			}

			$("input#cep").val( result.code );
			$("input#estado").val( result.state );
			$("input#cidade").val( result.city );
			$("input#bairro").val( result.district );
			$("input#rua").val( result.address );
			$("input#uf").val( result.state );
		});
	});
	$("#cep-ori").change(function(){
		alert("cep");
		var cep_code = $(this).val();
		if( cep_code.length <= 0 ) return;
		$.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep_code },
				function(result){
			if( result.status!=1 ){
				alert(result.message || "Houve um erro desconhecido");
				return;
			}

			$("input#cep-ori").val( result.code );
			$("input#estado-ori").val( result.state );
			$("input#cidade-ori").val( result.city );
			$("input#bairro-ori").val( result.district );
			$("input#rua-ori").val( result.address );
			$("input#uf-ori").val( result.state );
		});
	});
	$("#cep-dest").change(function(){
		var cep_code = $(this).val();
		if( cep_code.length <= 0 ) return;
		$.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep_code },
				function(result){
			if( result.status!=1 ){
				alert(result.message || "Houve um erro desconhecido");
				return;
			}

			$("input#cep-dest").val( result.code );
			$("input#estado-dest").val( result.state );
			$("input#cidade-dest").val( result.city );
			$("input#bairro-dest").val( result.district );
			$("input#rua-dest").val( result.address );
			$("input#uf-dest").val( result.state );
		});
	});
});