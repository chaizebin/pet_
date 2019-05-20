 //商品规格选择
	
// $(function(){
// 	var t = $("#text_box");
// 	var m;
// 	$('#min').attr('disabled',true);
// 	 //数量增加操作
// 	 $("#add").click(function(){
// 		m = $(".math").html(); 
// 	 	if(m > 0){
// 	 	 	t.val(Math.abs(parseInt(t.val()))+1);
// 	 	 	if(t.val()>=parseInt(m)){
// 	 	 		t.val(m);
// 	 	 	}
// 			if (parseInt(t.val())!=0){
// 			  	$('#min').attr('disabled',false);
// 			 }
// 	 	 }
// 	}) 
		 
// 	//数量减少操作
// 	 $("#min").click(function(){
// 	 	$('#min').attr('disabled',false);
// 		 t.val(Math.abs(parseInt(t.val()))-1);
// 		 if(t.val()<1){
// 		 	t.val(1);
// 		 }		 
// 		 // m++;
// 	 	 // $(".math").html(m)
// 		 if(parseInt(t.val())==0){
// 			$('#min').attr('disabled',true);
// 		 };
		 
// 	 })
// })
// window.onload = function(){
// 	var oSel = document.getElementById('sel1');
// 	var aDd = oSel.getElementsByTagName('dd');
// 	var aUl = oSel.getElementsByTagName('ul');
// 	var aH2 = oSel.getElementsByTagName('h2');
	
// 	for(var i=0;i<aDd.length;i++){
// 		aDd[i].index = i;
// 		aDd[i].onclick = function(ev){
// 			var ev = ev || window.event;
// 			var This = this;
// 			$(this).find("a").eq(0).css({
// 				"background-position":"0 0"
// 			})
			
// 			for(var i=0;i<aUl.length;i++){
// 				aUl[i].style.display = 'none';
// 			}
			
// 			aUl[this.index].style.display = 'block';
			
// 			document.onclick = function(){
// 				aUl[This.index].style.display = 'none';
// 				$('#sel1 dl dd a').css({
// 					"background-position":"0 -8px"
// 				})
// 			};
			
// 			ev.cancelBubble = true;
			
// 		};
		
// 	}
	
// 	for(var i=0;i<aUl.length;i++){
		
// 		aUl[i].index = i;
		
// 		(function(ul){
			
// 			var aLi = ul.getElementsByTagName('li');
			
// 			for(var i=0;i<aLi.length;i++){
				
// 				aLi[i].onclick = function(ev){
// 					var ev = ev || window.event;
// 					aH2[this.parentNode.index].innerHTML = this.innerHTML;
// 					ev.cancelBubble = true;
// 					this.parentNode.style.display = 'none';
// 					this.parentNode.parentNode.children[1].style.backgroundPosition = '0 -8px';
// 				};
// 			}
			
// 		})(aUl[i]);
// 	}
// }
