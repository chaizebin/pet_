(function(){function p(){this.c="1263419271";this.ca="z";this.Y="";this.V="";this.X="";this.D="1558336336";this.$="z8.cnzz.com";this.W="";this.H="CNZZDATA"+this.c;this.G="_CNZZDbridge_"+this.c;this.O="_cnzz_CV"+this.c;this.P="CZ_UUID"+this.c;this.K="UM_distinctid";this.A="0";this.J={};this.a={};this.Ca()}function h(a,
    b){try{var c=[];c.push("siteid=1263419271");c.push("name="+g(a.name));c.push("msg="+g(a.message));c.push("r="+g(l.referrer));c.push("page="+g(e.location.href));c.push("agent="+g(e.navigator.userAgent));c.push("ex="+g(b));c.push("rnd="+Math.floor(2147483648*Math.random()));(new Image).src="http://jserr.cnzz.com/log.php?"+c.join("&")}catch(d){}return!0}var q=function(){for(var a=document.getElementsByTagName("script"),b=0,c=a.length;b<c;b++){var d,f=a[b];if(f.src&&(d=/^(https?:)\/\/[\w\.\-]+\.cnzz\.com\//i.exec(f.src)))return d[1]}return window.location.protocol}(),
    l=document,e=window,g=encodeURIComponent,m=decodeURIComponent,x=unescape,z=q+"//c.cnzz.com/core.php",A=q+"//ca.cnzz.com";p.prototype={Ca:function(){try{this.ma(),this.ja(),this.ha(),this.U(),this.ya(),this.S(),this.Ba(),this.w(),this.wa(),this.va(),this.za(),this.o(),this.ua(),this.xa(),this.Aa(),this.sa(),this.qa(),this.ta(),this.Ga(),e[this.G]=e[this.G]||{},this.ra("_cnzz_CV")}catch(a){h(a,"i failed")}},ja:function(){for(var a=document.getElementsByTagName("script"),b=new RegExp("^(https:|http:)?//.+\\.cnzz\\.com/[a-z0-9_]+\\.php\\?.*id="+
    this.c,"i"),c=a.length-1;0<=c;c--){var d=a[c];d.src&&b.test(d.src)&&d.async&&(this.A="1")}},Ea:function(){try{var a=this;e._czc={push:function(){return a.L.apply(a,arguments)}}}catch(b){h(b,"oP failed")}},qa:function(){try{var a=e._czc;if("[object Array]"==={}.toString.call(a))for(var b=0;b<a.length;b++){var c=a[b];switch(c[0]){case "_setAccount":e._cz_account="[object String]"==={}.toString.call(c[1])?c[1]:String(c[1]);break;case "_setAutoPageview":"boolean"===typeof c[1]&&(e._cz_autoPageview=c[1])}}}catch(d){h(d,
    "cS failed")}},Ga:function(){try{if("undefined"===typeof e._cz_account||e._cz_account===this.c){e._cz_account=this.c;if("[object Array]"==={}.toString.call(e._czc))for(var a=e._czc,b=0,c=a.length;b<c;b++)this.L(a[b]);this.Ea()}}catch(d){h(d,"pP failed")}},L:function(a){try{if("[object Array]"==={}.toString.call(a))switch(a[0]){case "_trackPageview":if(a[1]){this.a.f=q+"//"+e.location.host;"/"!==a[1].charAt(0)&&(this.a.f+="/");this.a.f+=a[1];if(""===a[2])this.a.g="";else if(a[2]){var b=a[2];"http"!==
    b.substr(0,4)&&(b=q+"//"+e.location.host,"/"!==a[2].charAt(0)&&(b+="/"),b+=a[2]);this.a.g=b}this.s();"undefined"!==typeof this.a.g&&delete this.a.g;"undefined"!==typeof this.a.f&&delete this.a.f}break;case "_trackEvent":var c=[];a[1]&&a[2]&&(c.push(g(a[1])),c.push(g(a[2])),c.push(a[3]?g(a[3]):""),a[4]=parseFloat(a[4]),c.push(isNaN(a[4])?0:a[4]),c.push(a[5]?g(a[5]):""),this.v=c.join("|"),this.s(),delete this.v);break;case "_setCustomVar":if(3<=a.length){if(!a[1]||!a[2])return!1;var d=a[1],f=a[2],k=
    a[3]||0;a=0;for(var n in this.a.b)a++;if(5<=a)return!1;var u=0==k?"p":-1==k||-2==k?k:(new Date).getTime()+1E3*k;this.a.b[d]={};this.a.b[d].da=f;this.a.b[d].h=u;this.I()}break;case "_deleteCustomVar":2<=a.length&&(d=a[1],this.a.b[d]&&(delete this.a.b[d],this.I()));break;case "_trackPageContent":a[1]&&(this.F=a[1],this.s(),delete this.F);case "_trackPageAction":c=[];a[1]&&a[2]&&(c.push(g(a[1])),c.push(g(a[2])),this.u=c.join("|"),this.s(),delete this.u);break;case "_setUUid":var w=a[1];if(128<w.length)return!1;
    var v=new Date;v.setTime(v.getTime()+157248E5);this.aa(this.P,w,v)}}catch(r){h(r,"aC failed")}},ta:function(){try{var a=this.m(this.O);this.a.b={};if(a){var b=a.split("&");for(a=0;a<b.length;a++){var c=m(b[a]);var d=c.split("|");this.a.b[m(d[0])]={};this.a.b[m(d[0])].da=m(d[1]);this.a.b[m(d[0])].h=m(d[2])}}}catch(f){h(f,"gCV failed")}},ia:function(){try{var a=(new Date).getTime(),b;for(b in this.a.b)"p"===this.a.b[b].h?this.a.b[b].h=0:"-1"!==this.a.b[b].h&&a>this.a.b[b].h&&delete this.a.b[b];this.I()}catch(c){h(c,
    "cCV failed")}},I:function(){try{var a=[],b;for(b in this.a.b){var c=[];c.push(b);c.push(this.a.b[b].da);c.push(this.a.b[b].h);var d=c.join("|");a.push(d)}if(0===a.length)return!0;var f=new Date;f.setTime(f.getTime()+157248E5);var k=this.O+"=";this.b=g(a.join("&"));k+=this.b;k+="; expires="+f.toUTCString();l.cookie=k+"; path=/"}catch(n){h(n,"sCV failed")}},sa:function(){try{return this.N=e.location.href}catch(a){h(a,"gCP failed")}},o:function(){try{return this.a.Ha=l.referrer||""}catch(a){h(a,"gR failed")}},
    ua:function(){try{return this.a.B=e.navigator.systemLanguage||e.navigator.language,this.a.B=this.a.B.toLowerCase(),this.a.B}catch(a){h(a,"gL failed")}},xa:function(){try{return this.a.ba=e.screen.width&&e.screen.height?e.screen.width+"x"+e.screen.height:"0x0",this.a.ba}catch(a){h(a,"gS failed")}},w:function(){try{return this.a.Da=this.i("ntime")||"none"}catch(a){h(a,"gLVST failed")}},T:function(){try{return this.a.ea=this.i("ltime")||(new Date).getTime()}catch(a){h(a,"gFVBT failed")}},wa:function(){try{var a=
    this.i("cnzz_a");if(null===a)a=0;else{var b=1E3*this.w(),c=new Date;c.setTime(b);(new Date).getDate()===c.getDate()?a++:a=0}return this.a.La=a}catch(d){h(d,"gRT failed")}},va:function(){try{return this.a.C=this.i("rtime"),null===this.a.C&&(this.a.C=0),0<this.T()&&432E5<(new Date).getTime()-this.T()&&(this.a.C++,this.a.ea=(new Date).getTime()),this.a.C}catch(a){h(a,"gRVT failed")}},za:function(){try{return"none"===this.w()?this.a.Ka=0:this.a.Ka=parseInt(((new Date).getTime()-1E3*this.w())/1E3)}catch(a){h(a,
    "gST failed")}},ya:function(){try{var a=this.i("sin")||"none";if(!l.domain)return this.a.Ja="none";this.o().split("/")[2]!==l.domain&&(a=this.o());return this.a.Ja=a}catch(b){h(b,"gS failed")}},S:function(){try{return this.a.l=this.i("cnzz_eid")||"none"}catch(a){h(a,"gC failed")}},Ia:function(){try{var a=z+"?",b=[];b.push("web_id="+g(this.c));this.Y&&b.push("show="+g(this.Y));this.X&&b.push("online="+g(this.X));this.V&&b.push("l="+g(this.V));this.ca&&b.push("t="+this.ca);a+=b.join("&");this.na(a,
    "utf-8")}catch(c){h(c,"rN failed")}},ha:function(){try{return!1===e.navigator.cookieEnabled?this.a.la=!1:this.a.la=!0}catch(a){h(a,"cCE failed")}},aa:function(a,b,c,d,f,k){a=g(a)+"="+g(b);c instanceof Date&&(a+="; expires="+c.toGMTString());d&&(a+="; path="+d);f&&(a+="; domain="+f);k&&(a+="; secure");l.cookie=a},m:function(a){try{a+="=";var b=l.cookie,c=b.indexOf(a),d="";if(-1<c){var f=b.indexOf(";",c);-1===f&&(f=b.length);d=m(b.substring(c+a.length,f))}return d?d:""}catch(k){h(k,"gAC failed")}},
    ra:function(a){try{l.cookie=a+"=; expires="+(new Date(0)).toUTCString()+"; path=/"}catch(b){h(b,"dAC failed")}},Aa:function(){try{var a=l.title;1<e._cz_loaded[this.c]&&(a="__cnzz,pv,"+e._cz_loaded[this.c]+"__"+a);40<a.length&&(a=a.substr(0,40),a+="...");this.a.Fa=a}catch(b){h(b,"gT failed")}},ma:function(){e._cz_loaded=e._cz_loaded||{};e._cz_loaded[this.c]?e._cz_loaded[this.c]++:e._cz_loaded[this.c]=1},M:function(a){try{return"http"!==a.substr(0,4)?"":(new RegExp(q+"//.*?/","i")).exec(a)}catch(b){h(b,
    "cH failed")}},U:function(){try{var a=this.H,b={},c=this.m(this.H);if(0<c.length)if(1E8<this.c){var d=c.split("|");b.cnzz_eid=m(d[0]);b.ntime=m(d[1])}else{d=c.split("&");for(var f=0,k=d.length;f<k;f++){var n=d[f].split("=");b[m(n[0])]=m(n[1])}}this.J=b}catch(u){h(u,"iC failed:"+a+":"+c)}},Z:function(){try{var a=this.H+"=",b=[],c=new Date;c.setTime(c.getTime()+157248E5);if(1E8<this.c){if("none"!==this.a.l)b.push(g(this.a.l));else{var d=Math.floor(2147483648*Math.random())+"-"+this.D+"-"+this.M(this.o());
    b.push(g(d))}b.push(this.D);0<b.length?(a+=g(b.join("|")),a+="; expires="+c.toUTCString(),a+="; path=/"):a+="; expires="+(new Date(0)).toUTCString()}else"none"!==this.a.l?b.push("cnzz_eid="+g(this.a.l)):(d=Math.floor(2147483648*Math.random())+"-"+this.D+"-"+this.M(this.o()),b.push("cnzz_eid="+g(d))),b.push("ntime="+this.D),0<b.length?(a+=g(b.join("&")),a+="; expires="+c.toUTCString(),a+="; path=/"):a+="; expires="+(new Date(0)).toUTCString();l.cookie=a}catch(f){h(f,"sS failed")}},i:function(a){try{return"undefined"!==
    typeof this.J[a]?this.J[a]:null}catch(b){h(b,"gCPa failed")}},na:function(a,b){try{if(b=b||"utf-8","1"===this.A){var c=l.createElement("script");c.type="text/javascript";c.async=!0;c.charset=b;c.src=a;var d=l.getElementsByTagName("script")[0];d.parentNode&&d.parentNode.insertBefore(c,d)}else l.write(x("%3Cscript src='"+a+"' charset='"+b+"' type='text/javascript'%3E%3C/script%3E"))}catch(f){h(f,"cAS failed")}},pa:function(a,b){try{var c=l.getElementById("cnzz_stat_icon_"+this.c);if(c){var d=l.createElement("script");
    d.type="text/javascript";d.async=!0;d.charset=b;d.src=a;c.appendChild(d)}else"0"===this.A&&l.write(x("%3Cscript src='"+a+"' charset='"+b+"' type='text/javascript'%3E%3C/script%3E"))}catch(f){h(f,"cSI failed")}},oa:function(a){try{for(var b=a.length,c="",d=0;d<b;d++)a[d]&&(c+=x(a[d]));var f=l.getElementById("cnzz_stat_icon_"+this.c);f?f.innerHTML=c:"0"===this.A&&l.write(c)}catch(k){h(k,"cI failed")}},s:function(){try{this.Z();this.U();this.S();this.ia();var a=this.m(this.P),b=[];b.push("id="+g(this.c));
    this.a.g||""===this.a.g?b.push("r="+g(this.a.g)):b.push("r="+g(this.a.Ha));b.push("lg="+g(this.a.B));b.push("ntime="+g(this.a.Da));b.push("cnzz_eid="+g(this.a.l));b.push("showp="+g(this.a.ba));this.a.f?b.push("p="+g(this.a.f)):"[object String]"==={}.toString.call(this.N)&&b.push("p="+g(this.N));"[object String]"==={}.toString.call(this.v)&&b.push("ei="+g(this.v));"[object String]"==={}.toString.call(this.b)&&b.push("cv="+this.b);"[object String]"==={}.toString.call(this.F)&&b.push("pc="+g(this.F));
    "[object String]"==={}.toString.call(this.u)&&b.push("ai="+this.u);a&&b.push("uuid="+g(a));b.push("t="+g(this.a.Fa));b.push("umuuid="+g(this.a.R));b.push("h=1");var c=b.join("&");"[object String]"==={}.toString.call(this.v)?this.j([q+"//ei.cnzz.com/stat.htm?"+c]):this.F||this.u?this.j([A+"/stat.htm?"+c]):(this.W&&this.j([q+"//"+this.W+"/stat.htm?"+c]),this.$&&this.j([q+"//"+this.$+"/stat.htm?"+c]))}catch(d){h(d,"sD failed")}},fa:function(){function a(){function c(w,v){var r,y=0;for(r=0;r<v.length;r++)y|=
    k[r]<<8*r;return w^y}var d=e.navigator.userAgent,f,k=[],n=0;for(f=0;f<d.length;f++){var u=d.charCodeAt(f);k.unshift(u&255);4<=k.length&&(n=c(n,k),k=[])}0<k.length&&(n=c(n,k));return n.toString(16)}function b(){for(var c=1*new Date,d=0;c==1*new Date;)d++;return c.toString(16)+d.toString(16)}return function(){var c=(e.screen.height*e.screen.width).toString(16);return b()+"-"+Math.random().toString(16).replace(".","")+"-"+a()+"-"+c+"-"+b()}}(),Ba:function(){try{var a=this.a,b;if(!(b=this.m(this.K))){var c=
    this.fa(),d=new Date;d.setTime(d.getTime()+157248E5);var f=document.location.hostname.match(/[a-z0-9][a-z0-9\-]+\.[a-z\.]{2,6}$/i);this.aa(this.K,c,d,"/",f?f[0]:"");b=c}a.R=b;return this.a.R}catch(k){h(k,"gC failed")}},j:function(a){try{for(var b=a.length,c=null,d=0;d<b;d++)a[d]&&(c="cnzz_image_"+Math.floor(2147483648*Math.random()),e[c]=new Image,e[c].ka=c,e[c].onload=e[c].onerror=e[c].onabort=function(){try{this.onload=this.onerror=this.onabort=null,e[this.ka]=null}catch(f){}},e[c].src=a[d]+"&rnd="+
    Math.floor(2147483648*Math.random()))}catch(f){h(f,"cR failed")}},ga:function(){for(var a=e.navigator.userAgent.toLowerCase(),b=0;12>b;b++)if(-1<a.indexOf("#mobileconf#"[b]))return"mobile";return"pc"}};try{var t=new p;e[t.G].bobject=t;!1!==e._cz_autoPageview?t.s():t.Z();p.prototype.getACookie=p.prototype.m;p.prototype.callRequest=p.prototype.j;p.prototype.createScriptIcon=p.prototype.pa;p.prototype.createIcon=p.prototype.oa;t.Ia();t.ga()}catch(a){h(a,"main failed")}})();