$(function () {
    sessionStorage.catPage = 1;
    initCatList(1);
})
var pageCount = sessionStorage.catPage;
var rows = 16;
function queryCatList(temp) {
    if (temp == 'pageup'){
        pageCount--;
        if (pageCount < 1){
            pageCount = 1;
        }
    }else {
        pageCount++;
    }
    initCatList(pageCount);
}
function initCatList(page) {
    pageCount = page;
    $.ajax({
        url: '/cat/queryCatForPage',
        type:"POST",
        data:{
            page:page,
            rows:rows
        },
        success: function (result) {
            $('[name="pageCount"]').removeClass("cur");
            $('#page_'+pageCount).addClass("cur");
            var data = result.rows;
            var html = "";
            var page1 = '<span>共找到' + result.total + '件商品  <i class="yellow">'+page+'</i>/' + Math.ceil(result.total/rows) + '</span>';
            $('.navList-page').find('span').html(page1);
            if (data==null){
                $('#catList').html("");
                return;
            }
            $.each(data, function (index, row) {
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