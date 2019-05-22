var demo = angular.module("demo", ["RongWebIMWidget"]);

demo.config(function($logProvider) {
    // $logProvider.debugEnabled(false);
})

function GetQueryString(name)
{
    var reg = new RegExp("(^|/)"+ name +"/([^/]*)(/|$)");
    var url=location.href;
    var r = url.match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}


demo.controller("main", ["$scope", "WebIMWidget", "$http", function($scope, WebIMWidget,
            $http) {

        $scope.show = function() {
            WebIMWidget.show();
        }

        $scope.hidden = function() {
            WebIMWidget.hidden();
        }

        $scope.server = WebIMWidget;
        $scope.targetType = 1;

        $scope.setconversation = function() {
            WebIMWidget.setConversation(Number($scope.targetType), $scope.targetId, "自定义:" + $scope.targetId);
        }

        WebIMWidget.init({
            appkey: $("#chatplus").attr("appkey"),
            token: $("#chatplus").attr("token"),
            style: {
                width: 300,
                height:400,
                positionFixed: true,
                bottom: 2,
                right: 70
            },
            displayConversationList: true,
            displayMinButton:false,//最小化时是否显示最小化按钮
            conversationListPosition: WebIMWidget.EnumConversationListPosition.right,
            hiddenConversations: [{type: WebIMWidget.EnumConversationType.PRIVATE, id: '1'}],
            onSuccess: function(id) {
                //console.log(id);
            },
            onError: function(error) {
                $.ajax({
                    type:'post',
                    data:'ajax=ajax',
                    url:'http://www.cz10000.com/index.php?m=Index&a=reshtoken',
                    dataType:'json',
                    success:function(data){
                        if(data == 1){
                            location.reload();
                        }
                    }
                });
            }
        });
        //WebIMWidget.show();
        
        $("#lxkf_pc").click(function(){
            if($("input[name='lt']").val()==''){
                message2("您还未登录,请前往登录");
                return false;
            }
            WebIMWidget.show();
            WebIMWidget.setConversation(WebIMWidget.EnumConversationType.PRIVATE,"6","宠族官方客服");
        });
        $(".TEnterShop").click(function(){
            $scope.targetId = $(this).attr('alter');
           // alert( $scope.targetId);
            $http({
                url: "http://www.cz10000.com/index.php?m=Chat&a=userinfo&userid=" + $scope.targetId,
            }).success(function(data){
                var user;
                 data.userlist.forEach(function(item) {
                     if (item.id == $scope.targetId) {
                         user = item;
                     }
                 })
                 if (user) {
                    WebIMWidget.setConversation(Number($scope.targetType), $scope.targetId,user.name );
                    
                 }
            });
            WebIMWidget.show();
        });
        WebIMWidget.setUserInfoProvider(function(targetId, obj) {
            $http({
                url: "http://www.cz10000.com/index.php?m=Chat&a=userinfo&userid=" + targetId
            }).success(function(rep) {
                var user;
                rep.userlist.forEach(function(item) {
                    if (item.id == targetId) {
                        user = item;
                    }
                })
                if (user) {
                    obj.onSuccess({id: user.id, name: user.name, portraitUri: user.portraitUri});
                } else {
                    obj.onSuccess({id: targetId, name: "陌：" + targetId});
                }
            })
        });

        WebIMWidget.setOnlineStatusProvider(function(arr, obj) {
            // console.log(arr);
            $http({
                url: "http://www.cz10000.com/index.php?m=Chat&a=online&userid=" + JSON.stringify(arr)
            }).success(function(rep) {
                obj.onSuccess(rep.data);
            })
        });


        WebIMWidget.onClose = function() {
            console.log("已关闭");
        }

        //WebIMWidget.show();


    }]);