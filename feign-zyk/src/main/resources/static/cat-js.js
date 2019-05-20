$(function(){
    initShuizuTable();
})
function searchNews(){
    $("#myTable").bootstrapTable('refresh');
}
function initShuizuTable(){
    $("#myTable").bootstrapTable({
        fit:true,
        //toolbar:'#toolbar',
        url:'/cat/queryCatForPage',
        pagination:true, //是否展示分页
        pageList:[1,3,5,8,10,20,30],//分页组件
        pageNumber:1,
        pageSize:5,//默认每页条数*/
        sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
        striped:true,
        showRefresh:true,//是否显示刷新按钮
        queryParams:function(){
            var catName = $('#catName').val();
            console.log(catName+"   catName")
            return {
                page: this.pageNumber,
                rows: this.pageSize,
                catName: catName
            }
        },

        columns:[
            {checkbox:true},
            {field:'catName',title:'标题'},
            {field:'catPrice',title:'价格'},
            {field:'baoYou',title:'是否包邮',formatter:function(value,row,index){
                    return value=="是"?"包邮":"不包邮";
                }},
            {field:'faHuoDi',title:'发货地'},
            {field:'xiaoLiang',title:'销量'},
            {field:'kuCun',title:'库存'},
            {field:'image',title:'图片',formatter:function(value,row,index){
                    var str ='<img src="'+row.image+'">'
                    return str;
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:delShuizu('+row.catId+');">删除</a> | <a href="javascript:upCatInfoById('+row.catId+');">修改</a>'
            }}
        ]
    })
}

function refreshTable() {
    $("#myTable").bootstrapTable('refresh')
}

function upCatInfoById(id) {
    $.ajax({
        url:'/cat/queryCatById',
        data:{id:id},
        success:function(result){
            addS();
            $('#catId').val(result.catId);
            $('#catName').val(result.catName);
            $('#catPrice').val(result.catPrice);
            result.baoYou == "是" ? $('#falseId').prop('checked',true) : $('#trueId').prop('checked',true)
            $('#faHuoDi').val(result.faHuoDi);
            $('#xiaoLiang').val(result.xiaoLiang);
            $('#kuCun').val(result.kuCun);
        },
        error:function(){

        }
    })
}

//单删
function delOne(id){
    delShui(id)
}
//批删
function delMany(){
    var ids = '';
    var news = $("#myTable").bootstrapTable("getSelections");
    for (var i = 0; i < news.length; i++) {
        ids += ids == '' ? news[i].catId : ","+news[i].catId
    }
    delShuizu(ids);
}
//删除提出公共代码
function delShuizu(id){

    bootbox.confirm({
        size:"small",
        message:"你确定要删除吗？",
        callback:function(result){
            if(result){
                $.ajax({
                    url:'/cat/delCatById',
                    type:'post',
                    data:{ids:id},
                    dataType:'json',
                    success:function(data){
                        if(data){
                            searchNews();
                        }else{
                            bootbox.alert({
                                size:"small",
                                title:"提示",
                                massage:'删除失败',
                            })
                        }
                    }
                })
            }
        }
    })
}

function queryRegion(regionId,id) {
    $.ajax({
        url:'/cat/queryRegion',
        async:false,
        data:{id:id},
        success:function(result){
            var html = "<option value='-1'>请选择</option>";
            $.each(result,function (index,row) {
                html += "<option value="+row.regionId+">"+row.regionName+"</option>";
            })
            var region = "#"+regionId;
            console.log(region)
            $(region).html(html)
        },
        error:function(){

        }
    })
}

//新增
var res;
function createAddContent(url){
    $.ajax({
        url:url,
        async:false,
        success:function(data){
            res = data;
        }
    });
    return res;
}


function addS(){

    var url='toCatAdd';
    var dialog=bootbox.dialog({
        title:'catInfo',
        message:createAddContent(url),
        size:'large',
        buttons:{
            cancle:{
                label:"关闭",
                className:'btn-danger',
                callback:function(){
                }
            },
            ok:{
                label:"保存",
                className:'btn-info',
                callback:function(){
                    $.ajax({
                        url:'/cat/saveOrUpCat',
                        type:'post',
                        data:$("#catForm").serialize(),
                        dataType:'json',
                        success:function(data){
                            if (data) {
                                searchNews();//刷新
                            }else{
                                bootbox.alert({
                                    size:'small',
                                    title:'提示',
                                    message:'新增失败',
                                })
                            }
                        }
                    })
                }
            }
        }
    })

}
