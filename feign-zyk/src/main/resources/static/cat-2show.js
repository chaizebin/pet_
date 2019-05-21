$(function () {
    initCatList();
})
var page = 1;
var rows = 16;
function initCatList() {
    $.ajax({
        url: '/cat/queryCatForPage',
        type:"POST",
        data:{
            page:page,
            rows:rows
        },
        success: function (result) {
            var html = "";
            $.each(result, function (index, row) {
                html += "<li class=\"shop-list\">" +
                    "<div class=\"sub_img\">" +
                    "<a href=\"javascript:void(0)\">" +
                    "<img src=\""+row.catImg+"\" alt=\"\" title=\"\">" +
                    "</a>" +
                    "</div>" +
                    "<div class=\"listPrice\">¥ "+row.catPrice+"</div>" +
                    "<span class=\"xl\">销量:"+row.xiaoLiang+"&nbsp;&nbsp;</span>" +
                    "<div class=\"sub_title\">" +
                    "<a href=\"http://www.cz10000.com/Shop/6900\">"+row.catName+"</a></div>" +
                    "<div class=\"sub_adress\"><span class=\"sub_adress_price\">" +
                    /*"<a href=\"http://www.cz10000.com/Store/index/id/8800\">多格漫宠物食品旗舰店</a>" +*/
                    "</span><span class=\"sub_adress_dz\">"+row.faHuoDi+"</span></div></li>";
            })
            $('#catList').html(html);
        },
        error: function () {

        }
    })
}