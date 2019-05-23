$(function () {
    initLunBoTu();
})

    function initLunBoTu() {
        $.ajax({
            url:'/main/initLunBoTu',
            success:function(result){
                var html = "<ul class=\"banner_ul\">";
                $.each(result,function (index,row) {
                    html += '<li style="display: none;"><a href="javascript:void(0)"><img\n' +
                        ' src="'+row.href+'" alt=""></a></li>';
                })
                html += "</ul>";
                $('#LunBoId').html(html);
            },
            error:function(){

            }
        })
    }