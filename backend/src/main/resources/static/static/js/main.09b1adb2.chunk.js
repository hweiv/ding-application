(this.webpackJsonpfronted=this.webpackJsonpfronted||[]).push([[0],{165:function(e,t,n){},166:function(e,t,n){},487:function(e,t,n){"use strict";n.r(t);var a=n(0),s=n.n(a),r=n(32),i=n.n(r),c=(n(165),n(77)),o=n.n(c),d=n(93),u=n(62),l=(n(166),n(86)),j=n.n(l),b=n(119),m=n(156),p=n(42),f=n(492),g=n(493),h=n(491),O=n(85),x=n(40),v=n(494),I=n(16);function y(e){var t="image/jpeg"===e.type||"image/png"===e.type||"image/gif"===e.type||"image/bmp"===e.type;t||m.b.error("\u56fe\u7247\u7c7b\u578b\u652f\u6301jpg/png/gif/bmp\u683c\u5f0f");var n=e.size/1024/1024<1;return n||m.b.error("\u56fe\u7247\u6700\u5927\u4e0a\u4f201M!"),t&&n}var S=function(e){var t=f.a.useForm(),n=Object(u.a)(t,1)[0],s=Object(a.useState)(!1),r=Object(u.a)(s,2),i=r[0],c=r[1],l=Object(a.useState)(""),j=Object(u.a)(l,2),b=j[0],m=j[1],S=Object(I.jsxs)("div",{children:[i?Object(I.jsx)(x.a,{}):Object(I.jsx)(v.a,{}),Object(I.jsx)("div",{style:{marginTop:8},children:"Upload"})]}),C=function(){var t=Object(d.a)(o.a.mark((function t(){var a;return o.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return a=sessionStorage.getItem("userId"),t.next=3,n.validateFields().then((function(t){var n,s,r=t.userIdList,i=t.messageUrl,c=t.title,o=t.text,d=t.file,u=t.name,l=null===d||void 0===d||null===(n=d.file)||void 0===n||null===(s=n.response)||void 0===s?void 0:s.data,j={owner:a,name:u,userIdList:r,dingTalkMessage:{msgType:"link",link:{messageUrl:i,picUrl:l,title:c,text:o}}};e.onClick(j)}));case 3:case"end":return t.stop()}}),t)})));return function(){return t.apply(this,arguments)}}();return Object(I.jsxs)("div",{children:[Object(I.jsx)("a",{onClick:e.onClose,children:"\u2190\u8fd4\u56de"}),Object(I.jsx)("br",{}),Object(I.jsx)("br",{}),Object(I.jsx)("h4",{className:"title",children:"\u521b\u5efa\u7fa4\u6d88\u606f"}),Object(I.jsxs)(f.a,{form:n,onFinish:C,children:[Object(I.jsx)(f.a.Item,{label:"\u7fa4\u540d\u79f0",name:"name",rules:[{required:!0,message:"\u7fa4\u540d\u79f0\u5fc5\u586b"}],children:Object(I.jsx)(g.a,{placeholder:"\u8bf7\u8f93\u5165\u7fa4\u540d\u79f0"})}),Object(I.jsx)(f.a.Item,{label:"\u6d88\u606f\u6807\u9898",name:"title",rules:[{required:!0,message:"\u6d88\u606f\u6807\u9898\u5fc5\u586b"}],children:Object(I.jsx)(g.a,{placeholder:"\u8bf7\u8f93\u5165\u6d88\u606f\u6807\u9898"})}),Object(I.jsx)(f.a.Item,{label:"\u6d88\u606f\u5185\u5bb9",name:"text",rules:[{required:!0,message:"\u6d88\u606f\u5185\u5bb9\u5fc5\u586b"}],children:Object(I.jsx)(g.a,{placeholder:"\u8bf7\u8f93\u5165\u6d88\u606f\u5185\u5bb9"})}),Object(I.jsx)(f.a.Item,{label:"\u6d88\u606f\u94fe\u63a5",name:"messageUrl",rules:[{required:!0,message:"\u6d88\u606f\u94fe\u63a5\u5fc5\u586b"}],children:Object(I.jsx)(g.a,{placeholder:"\u8bf7\u8f93\u5165\u6d88\u606f\u94fe\u63a5"})}),Object(I.jsx)(f.a.Item,{label:"\u6d88\u606f\u56fe\u7247",name:"file",rules:[{required:!0,message:"\u6d88\u606f\u56fe\u7247\u5fc5\u586b"}],children:Object(I.jsx)(h.a,{listType:"picture-card",className:"avatar-uploader",showUploadList:!1,action:"/upload",beforeUpload:y,onChange:function(e){"uploading"!==e.file.status?"done"===e.file.status&&function(e,t){var n=new FileReader;n.addEventListener("load",(function(){return t(n.result)})),n.readAsDataURL(e)}(e.file.originFileObj,(function(e){m(e),c(!1)})):c(!0)},style:{overflow:"hidden"},children:b?Object(I.jsx)("img",{src:b,alt:"avatar",style:{width:"100%"}}):S})}),Object(I.jsx)(f.a.Item,{label:"\u9009\u62e9\u53d1\u9001\u4eba",name:"userIdList",rules:[{required:!0,message:"\u53d1\u9001\u4eba\u5fc5\u9009"}],children:Object(I.jsx)(O.a.Group,{children:e.userIdList.map((function(e,t){return Object(I.jsx)("div",{children:Object(I.jsx)(O.a,{value:e.userId,name:e.name,children:e.name})},"userid"+t)}))})}),Object(I.jsx)(p.a,{htmlType:"submit",type:"primary",children:"\u63d0\u4ea4"})]})]})},C=n(490),k=function(e){return Object(I.jsxs)("div",{children:[Object(I.jsx)("a",{onClick:e.onClose,children:"\u2190\u8fd4\u56de"}),Object(I.jsx)("br",{}),Object(I.jsx)("br",{}),Object(I.jsx)(C.a,{columns:[{title:"\u7528\u6237id",dataIndex:"userId",key:"userId"}],dataSource:e.readedUserList})]})};n(483);var L=function(){var e=Object(a.useState)(0),t=Object(u.a)(e,2),s=t[0],r=t[1],i=Object(a.useState)([]),c=Object(u.a)(i,2),l=c[0],f=c[1],g=Object(a.useState)([]),h=Object(u.a)(g,2),O=h[0],x=h[1];Object(a.useEffect)((function(){b.ready((function(){var e;fetch("/config").then((function(e){return e.json()})).then((function(t){e=t.data.corpId,b.runtime.permission.requestAuthCode({corpId:e,onSuccess:function(e){j.a.get("/login?authCode="+e.code).then((function(e){sessionStorage.setItem("userId",e.data.data.userid),sessionStorage.setItem("unionId",e.data.data.unionid),sessionStorage.setItem("deptId",e.data.data.deptIdList[0]),m.b.success("\u767b\u9646\u6210\u529f\uff1a"+e.data.data.name);var t=n(484);j.a.get("/users",{params:{deptIds:e.data.data.deptIdList},paramsSerializer:function(e){return t.stringify(e,{arrayFormat:"repeat"})}}).then((function(e){f(e.data.data)})).catch((function(e){alert(JSON.stringify(e))}))})).catch((function(e){alert(JSON.stringify(e))}))},onFail:function(e){alert(JSON.stringify(e))}})}))}))}),[]);var v=function(){var e=Object(d.a)(o.a.mark((function e(){return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(sessionStorage.getItem("messageId")){e.next=3;break}return m.b.error("\u8bf7\u5148\u521b\u5efa\u7fa4\u6d88\u606f"),e.abrupt("return");case 3:return j.a.get("/message/group/"+sessionStorage.getItem("messageId")).then((function(e){x(e.data.data)})).catch((function(e){console.log(e)})),e.next=6,r(2);case 6:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}();return Object(I.jsxs)("div",{className:"content",children:[Object(I.jsxs)("div",{className:"header",children:[Object(I.jsx)("img",{src:"https://img.alicdn.com/imgextra/i3/O1CN01Mpftes1gwqxuL0ZQE_!!6000000004207-2-tps-240-240.png",className:"headImg"}),"\u9489\u9489\u6a21\u677f"]}),Object(I.jsxs)("div",{className:"App",children:[1===s&&Object(I.jsx)(S,{onClick:function(e){return t=e,void j()({url:"/message/group",method:"post",data:JSON.stringify(t),headers:{"Content-Type":"application/json"}}).then((function(e){e.data.success&&(m.b.success("\u53d1\u9001\u7fa4\u6d88\u606f\u6210\u529f"),r(0),sessionStorage.setItem("messageId",e.data.data))})).catch((function(e){console.log(e)}));var t},userIdList:l,onClose:function(){return r(0)}}),Object(I.jsxs)("div",{children:[!s&&Object(I.jsx)(p.a,{type:"primary",onClick:function(){return r(1)},children:"\u53d1\u9001\u7fa4\u6d88\u606f"}),Object(I.jsx)("br",{}),Object(I.jsx)("br",{}),!s&&Object(I.jsx)(p.a,{type:"primary",onClick:v,children:"\u67e5\u770b\u5df2\u8bfb\u4eba\u5458\u5217\u8868"})]}),2===s&&Object(I.jsx)("div",{children:Object(I.jsx)(k,{readedUserList:O,onClose:function(){return r(0)}})})]})]})},w=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,495)).then((function(t){var n=t.getCLS,a=t.getFID,s=t.getFCP,r=t.getLCP,i=t.getTTFB;n(e),a(e),s(e),r(e),i(e)}))};i.a.render(Object(I.jsx)(s.a.StrictMode,{children:Object(I.jsx)(L,{})}),document.getElementById("root")),w()}},[[487,1,2]]]);
//# sourceMappingURL=main.09b1adb2.chunk.js.map