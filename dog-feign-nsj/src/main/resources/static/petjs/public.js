//登录注册公用样式表
$(function (){
	$(".l_tab li").click(function(){
    	$(".l_tab li").eq($(this).index()).addClass("cur").siblings().removeClass('cur');
		$(".l_main").hide().eq($(this).index()).show();
    });
    // ie浏览器初始化
	$('.fp_input').each(function (){
		$(this).children('input').val('');
		$(this).children('input').blur();
	});
	
	
	// 登录部分
	$('.login_auto_btn').off('click').on('click',function (){
		$(this).toggleClass('active');
	});
	
		
})			