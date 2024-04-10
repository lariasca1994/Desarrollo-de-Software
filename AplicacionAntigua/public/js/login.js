$( document ).ready(function() {
    $('#email').keyup(() => { validateEmail($("#email").val()); });

    function validateEmail(string){
    	let regex = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    	return (regex.test(string)) ? $('#emailHelp').addClass("emailHelp") : $('#emailHelp').text("El correo electónico no es válido").removeClass("emailHelp");
    };
});