$(document).ready(function(){
	//鼠标的移入移出  
	(function (){
		$(".drop").mouseover(function (){  
	        $(".static").show();  
	    }).mouseleave(function (){  
	        $(".static").hide();  
	    }); 
		$(".drp").mouseover(function (){  
	        $(".loginout").show();
	        $('.drp a').css({'cursor':'pointer'});
	        // $('.header-side').css({'margin-top':'14px'});  
	    }).mouseleave(function (){  
	        $(".loginout").hide();
	        // $('.header-side').css({'margin-top':'28px'});  
	    });
		
	})();
    // 切换搜索框
	(function (){
		var aLi = $('#menu li');
		var oText = $('#search').find('.search-panel .searchText');
		// var arrText = [
		// 	'请输入您要的宝贝啦啦啦~~~',
		// 	'请输入您要的店铺啦啦啦~~~'
		// ];
		var iNow = 0;
		
		// oText.val(arrText[iNow]);
		
		aLi.each(function ( index ){
			$(this).click(function (){
				aLi.attr('class', '');
				$(this).attr('class', 'active');
				if($(this).attr('type')==1){
					$(".sps").show();
					$(".dps").hide();
				}else{
					$(".sps").hide();
					$(".dps").show();
				}
				iNow = index;
				$('#type').val($(this).attr('type'));
				// oText.val(arrText[iNow]);
			});
		});
		
		// oText.focus(function (){
		// 	if( $(this).val() == arrText[iNow] ) {
		// 		$(this).val('');
		// 	}
		// });
		// oText.blur(function (){
		// 	if( $(this).val() == '' ) {
		// 		oText.val(arrText[iNow]);
		// 	}
		// });
	})();
	//  
    // 切换搜索框
	(function (){
		var num=$('.banner_span span').length;
		var i_mun=0;
		var timer_banner=null;
	
		$('.banner_ul li:gt(0)').hide();//页面加载隐藏所有的li 除了第一个
		
	//底下小图标点击切换
		$('.banner_span span').mouseover(function(){
			$(this).addClass('banner_span_one').siblings('span').removeClass('banner_span_one');
			var i_mun1=$('.banner_span span').index(this);
			$('.banner_ul li').eq(i_mun1).fadeIn('slow').siblings('li').fadeOut('slow');
			i_mun=i_mun1;
		});
		
		//自动播放函数
		function bannerMoveks(){
			timer_banner=setInterval(function(){
				move_banner()
			},2000)
		};
		bannerMoveks();//开始自动播放
	
		//鼠标移动到banner上时停止播放
		$('.banner_ul li,.banner_span span').mouseover(function(){
			clearInterval(timer_banner);
		});
	
		//鼠标离开 banner 开启定时播放
		$('.banner_ul li,.banner_span span').mouseout(function(){
			bannerMoveks();
		});
	
		//banner 右边点击执行函数
	   function move_banner(){
			if(i_mun==num-1){
				i_mun=-1
			}
			//大图切换
			$('.banner_ul li').eq(i_mun+1).fadeIn('slow').siblings('li').fadeOut('slow');
			//小图切换
			$('.banner_span span').eq(i_mun+1).addClass('banner_span_one').siblings('span').removeClass('banner_span_one');	
			i_mun++			
		}
	   
	})();
	//左侧二级菜单
	(function (){
        $(".dd-inner").children(".item").hover(function() { //一级导航悬浮
            $(this).addClass("hover").siblings(".item").removeClass("hover");
            var index = $(this).index();
           	$(".dorpdown-layer").hide();
            $(".dorpdown-layer").children(".item-sub").hide();
            $(".dorpdown-layer").children(".item-sub").eq(index).show();            
           	$(".dorpdown-layer:eq("+index+")").show();
			
        },function() {
        	var ind = $(this).index;
            $(".dorpdown-layer").hide();
            $(".dd-inner").children(".item").removeClass("hover");
        })

    })();
	
   //加入购物车
   (function (){
   		var total = 0;
   		$('.list_wrap_b').find("span:eq(1)").click(function(){
   			total++;;
   			$('.header-side').find("b").show();
   			$('.header-side').find("b").html(total);
   		})
   })();
})
function message(content) {
    if (content == '') {
        console.log("提醒内容不得为空");
    } else {
        $("body #message").stop(true).remove();
        $("body").stop(true).append("<div id='message'>" + content + "</div>");
        $("#message").stop(true).delay(950).fadeOut(500, '', function() {
            $(this).remove();
        });
    }
}
function message2(content) {
    if (content == '') {
        console.log("提醒内容不得为空");
    } else {
        $("body #message").stop(true).remove();
        $("body").stop(true).append("<div id='message'>" + content + "</div>");
        $("#message").stop(true).delay(950).fadeOut(500, '', function() {
            $(this).remove();
        });
    }
}	















