(this.webpackJsonpfronted=this.webpackJsonpfronted||[]).push([[0],{276:function(e,t,n){"use strict";n.r(t);var s=n(8),o=n.n(s),a=n(29),i=n.n(a),r=(n(34),n(35),n(6)),c=n.n(r),d=n(13),u=n(3);d.ready((function(){var e;fetch("/config").then((function(e){return e.json()})).then((function(t){e=t.data.corpId,d.runtime.permission.requestAuthCode({corpId:e,onSuccess:function(e){c.a.get("/login?authCode="+e.code).then((function(e){sessionStorage.setItem("userId",e.data.data.userid),sessionStorage.setItem("unionId",e.data.data.unionid),sessionStorage.setItem("deptId",e.data.data.deptIdList[0]);var t=n(273);c.a.get("/users",{params:{deptIds:e.data.data.deptIdList},paramsSerializer:function(e){return t.stringify(e,{arrayFormat:"repeat"})}}).then((function(e){console.log(e),sessionStorage.setItem("userIdList",sessionStorage.getItem("userId"))})).catch((function(e){alert(JSON.stringify(e))}))})).catch((function(e){alert(JSON.stringify(e))}))},onFail:function(e){alert(JSON.stringify(e))}})}))}));var g=function(){return Object(u.jsx)("div",{className:"App",children:Object(u.jsxs)("header",{className:"App-header",children:[Object(u.jsx)("button",{onClick:function(){c()({url:"/upload",method:"post",data:{},headers:{"Content-Type":"application/json"}}).then((function(e){console.log(e),sessionStorage.setItem("mediaId",e.data.data.mediaId)})).catch((function(e){console.log(e)}))},children:"\u4e0a\u4f20\u5a92\u4f53\u6587\u4ef6"}),Object(u.jsx)("button",{onClick:function(){var e=sessionStorage.getItem("userId"),t=(sessionStorage.getItem("unionId"),sessionStorage.getItem("userIdList")),n=(sessionStorage.getItem("deptId"),{owner:e,name:"\u7fa4\u6d88\u606f",userIdList:[t],dingTalkMessage:{msg:"link",link:{messageUrl:"dingtalk://dingtalkclient/page/link?url="+encodeURIComponent("https://www.dingtalk.com")+"&pc_slide=true",picUrl:sessionStorage.getItem("mediaId"),title:"\u6d4b\u8bd5",text:"\u6d4b\u8bd5"}}});c()({url:"/message/group",method:"post",data:n,headers:{"Content-Type":"application/json"}}).then((function(e){console.log(e),sessionStorage.setItem("messageId",e.data.data.messageId)})).catch((function(e){console.log(e)}))},children:"\u53d1\u9001\u7fa4\u6d88\u606f"}),Object(u.jsx)("button",{onClick:function(){c()({url:"/message/group/"+sessionStorage.getItem("messageId"),method:"put",headers:{"Content-Type":"application/json"}}).then((function(e){})).catch((function(e){console.log(e)}))},children:"\u67e5\u770b\u5df2\u8bfb\u4eba\u5458\u5217\u8868"})]})})},l=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,277)).then((function(t){var n=t.getCLS,s=t.getFID,o=t.getFCP,a=t.getLCP,i=t.getTTFB;n(e),s(e),o(e),a(e),i(e)}))};i.a.render(Object(u.jsx)(o.a.StrictMode,{children:Object(u.jsx)(g,{})}),document.getElementById("root")),l()},34:function(e,t,n){},35:function(e,t,n){}},[[276,1,2]]]);
//# sourceMappingURL=main.319fbd96.chunk.js.map