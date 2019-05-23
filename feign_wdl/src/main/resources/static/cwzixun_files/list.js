window.onload=function(){
    $("#catshow").hover(function(){
        // $('#focus1').slideToggle(500);
        $('#focus1').show();
    },function(){
        // $('#focus1').slideUp(500);
        $('#focus1').hide();
    })
    $(".dd-inner").children(".item").hover(function() { //一级导航悬浮
        $(this).addClass("hover").siblings(".item").removeClass("hover");
       	var index = $(this).index();
       	$(".dorpdown-layer1").hide();
        $(".dorpdown-layer1").children(".item-sub").hide();
        $(".dorpdown-layer1").children(".item-sub").eq(index).show();            
       	$(".dorpdown-layer1:eq("+index+")").show();
		
    },function() {
        $(".dorpdown-layer1").hide();
    })
}