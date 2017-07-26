$(document).ready(function(){
	var errorMessage = "Допустимы только кириллица и пробелы";
	$(this).find("textarea").on("input", function(){
		hasError = !$(this).val().match(/^[А-Яа-я0-9\s]+$/);
		if(hasError){
			$(this).attr("title", errorMessage);
			$(".glyphicon").addClass("glyphicon-remove").removeClass("glyphicon-ok");
			$("input[name=OK]").prop("disabled", true);
		} else {
			$(this).removeAttr("title");
			$(".glyphicon").addClass("glyphicon-ok").removeClass("glyphicon-remove");
			$("input[name=OK]").prop("disabled", false);
		}
	});
});