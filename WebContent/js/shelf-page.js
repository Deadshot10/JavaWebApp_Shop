$(".list-group-item").on( "click", function() {
	if($(this).parent().hasClass("showing")){
		switch ($(this).text()){
			case "Excellent":
				showInRange(4.0, 5.0);
				break;
			case "Good":
				showInRange(3.0, 4.0);
				break;
			case "Bad":
				showInRange(0.0, 3.0);
				break;
		}
	}
	if($(this).parent().hasClass("sorting")){
		switch ($(this).text()){
			case "ID":
				$('.thumbnail').sortElements(function (a, b) {
					  var contentA = parseInt( $(a).attr("sId"));
				      var contentB = parseInt( $(b).attr("sId"));
				      return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
				});
				break;
			case "Price":
				$('.thumbnail').sortElements(function (a, b) {
					  var contentA = parseInt( $(a).attr("sPrice"));
				      var contentB = parseInt( $(b).attr("sPrice"));
				      return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
				});
				break;
			case "Rating":
				$('.thumbnail').sortElements(function (a, b) {
					  var contentA = parseFloat( $(a).attr("sRating"));
				      var contentB = parseFloat( $(b).attr("sRating"));
				      return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
				});
				break;
			case "Title":
				$('.thumbnail').sortElements(function (a, b) {
					  var contentA = $(a).attr("sTitle");
				      var contentB = $(b).attr("sTitle");
				      return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
				});
				break;
		}
		
	}
});

function showInRange(low, high){
	$('.thumbnail').each(function(i, element) {
		if (parseFloat($(element).attr("sRating")) < high && $(element).attr("sRating") >= low){
			$(element).show();
		} else {
			$(element).hide();
		}
	});
}

//Thanks for https://j11y.io/javascript/sorting-elements-with-jquery/
jQuery.fn.sortElements = (function(){ 
    var sort = [].sort;
    return function(comparator, getSortable) {
        getSortable = getSortable || function(){return this;};
        var placements = this.map(function(){
            var sortElement = getSortable.call(this),
                parentNode = sortElement.parentNode,
                // Since the element itself will change position, we have
                // to have some way of storing its original position in
                // the DOM. The easiest way is to have a 'flag' node:
                nextSibling = parentNode.insertBefore(
                    document.createTextNode(''),
                    sortElement.nextSibling
                );
            return function() {
                if (parentNode === this) {
                    throw new Error(
                        "You can't sort elements if any one is a descendant of another."
                    );
                }
                // Insert before flag:
                parentNode.insertBefore(this, nextSibling);
                // Remove flag:
                parentNode.removeChild(nextSibling);
            };
        });
        return sort.call(this, comparator).each(function(i){
            placements[i].call(getSortable.call(this));
        });
    };
})();