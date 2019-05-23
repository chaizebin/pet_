$(function () {
    sessionStorage.catId = 10;
    initCatInfo(10);
})

function initCatInfo(id) {
    $.ajax({
        url: '/cat/queryCatById',
        type:"POST",
        data:{
            id:id
        },
        success: function (result) {
            var imgStr = "<img src='"+result.catImg+"'>"
            $('#catImgId').html(imgStr)
            $('#minCatImg').prop('src',result.catImg);
            $('#catTitle').html(result.catName);
            $('#catPriceId').html(result.catPrice);
            $('#baoYouId').html(result.baoYou);
            $('#faHuoDiId').html(result.faHuoDi);
            $('#xiaoLiangId').html(result.xiaoLiang);
            $('#kuCunId').html(result.kuCun);
        },
        error: function () {

        }
    })
}