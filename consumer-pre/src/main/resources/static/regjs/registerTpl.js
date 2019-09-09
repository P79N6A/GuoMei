/*TMODJS:{"version":"1.0.0"}*/
;(function () {
    if(!this.gomeTemplate){
        function template (filename, content) {
            return (
                /string|function/.test(typeof content)
                ? compile : renderFile
            )(filename, content);
        };


        var cache = template.cache = {};

        function toString (value, type) {

            if (typeof value !== 'string') {

                type = typeof value;
                if (type === 'number') {
                    value += '';
                } else if (type === 'function') {
                    value = toString(value.call(value));
                } else {
                    value = '';
                }
            }

            return value;

        };


        var escapeMap = {
            "<": "&#60;",
            ">": "&#62;",
            '"': "&#34;",
            "'": "&#39;",
            "&": "&#38;"
        };


        function escapeFn (s) {
            return escapeMap[s];
        }


        function escapeHTML (content) {
            return toString(content)
            .replace(/&(?![\w#]+;)|[<>"']/g, escapeFn);
        };


        var isArray = Array.isArray || function(obj) {
            return ({}).toString.call(obj) === '[object Array]';
        };


        function each (data, callback) {
            if (isArray(data)) {
                for (var i = 0, len = data.length; i < len; i++) {
                    callback.call(data, data[i], i, data);
                }
            } else {
                for (i in data) {
                    callback.call(data, data[i], i);
                }
            }
        };


        function resolve (from, to) {
            var DOUBLE_DOT_RE = /(\/)[^/]+\1\.\.\1/;
            var dirname = ('./' + from).replace(/[^/]+$/, "");
            var filename = dirname + to;
            filename = filename.replace(/\/\.\//g, "/");
            while (filename.match(DOUBLE_DOT_RE)) {
                filename = filename.replace(DOUBLE_DOT_RE, "/");
            }
            return filename;
        };


        var utils = template.utils = {

            $helpers: {},

            $include: function (filename, data, from) {
                filename = resolve(from, filename);
                return renderFile(filename, data);
            },

            $string: toString,

            $escape: escapeHTML,

            $each: each
            
        };


        var helpers = template.helpers = utils.$helpers;


        function renderFile (filename, data) {
            var fn = template.get(filename) || showDebugInfo({
                filename: filename,
                name: 'Render Error',
                message: 'Template not found'
            });
            return data ? fn(data) : fn; 
        };


        function compile (filename, fn) {

            if (typeof fn === 'string') {
                var string = fn;
                fn = function () {
                    return new String(string);
                };
            }

            var render = cache[filename] = function (data) {
                try {
                    return new fn(data, filename) + '';
                } catch (e) {
                    return showDebugInfo(e)();
                }
            };

            render.prototype = fn.prototype = utils;
            render.toString = function () {
                return fn + '';
            };

            return render;
        };


        function showDebugInfo (e) {

            var type = "{Template Error}";
            var message = e.stack || '';

            if (message) {
                // 利用报错堆栈信息
                message = message.split('\n').slice(0,2).join('\n');
            } else {
                // 调试版本，直接给出模板语句行
                for (var name in e) {
                    message += "<" + name + ">\n" + e[name] + "\n\n";
                }  
            }

            return function () {
                if (typeof console === "object") {
                    console.error(type + "\n\n" + message);
                }
                return type;
            };
        };


        template.get = function (filename) {
            return cache[filename.replace(/^\.\//, '')];
        };


        template.helper = function (name, helper) {
            helpers[name] = helper;
        };

        this.gomeTemplate = template;
    }
    var gomeTemplate = template = this.gomeTemplate;

    if (typeof define === 'function') {define(function() {return template;});} else if (typeof exports !== 'undefined') {module.exports = template;}
    
    /*v:162*/
gomeTemplate('register',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,stepNum=$data.stepNum,openDingxiang=$data.openDingxiang,$escape=$utils.$escape,mobile=$data.mobile,newExclusiveFlag=$data.newExclusiveFlag,libaoUrl=$data.libaoUrl,gifeImg=$data.gifeImg,staSiteNew=$data.staSiteNew,$out='';$out+='<div class="step-slider"> <ul> ';
 if (stepNum==1){ 
$out+=' <li class="step-li1 "> </li> <li class="step-li2"></li> ';
 } else if (stepNum==2 ){ 
$out+=' <li class="step-li1 step-active-li"></li> <li class="step-li2"></li> ';
 } else { 
$out+=' <li class="step-li1 step-active-li"></li> <li class="step-li2 step-active-li"></li> ';
 } 
$out+=' </ul> <div data-id="step1" class="step-active"> ';
 if (stepNum==2 || stepNum==3){ 
$out+=' <div class="step-icon-pos stepSuc step-icon1"></div> ';
 } else { 
$out+=' <div class="step-icon-pos step-icon step-icon1">1 </div> ';
 } 
$out+=' <div class="step-info step-info1"> <div name="js_step_name_1">验证手机号</div> </div> </div> ';
 if (stepNum==2 || stepNum==3){ 
$out+=' <div data-id="step2" class="step-active"> ';
 } else { 
$out+=' <div data-id="step2"> ';
 } 
$out+=' ';
 if (stepNum==3){ 
$out+=' <div class="step-icon-pos stepSuc step-icon2"></div> ';
 } else { 
$out+=' <div class="step-icon-pos step-icon step-icon2">2</div> ';
 } 
$out+=' <div class="step-info step-info2"> <div name="js_step_name_2">填写账户信息</div> </div> </div> ';
 if (stepNum==3){ 
$out+=' <div data-id="step3" class="step-active"> ';
 } else { 
$out+=' <div data-id="step3"> ';
 } 
$out+=' ';
 if (stepNum==3){ 
$out+=' <div class="step-icon-pos stepSuc step-icon3"></div> ';
 } else { 
$out+=' <div class="step-icon-pos step-icon step-icon3">3</div> ';
 } 
$out+=' <div class="step-info step-info3"> <div name="js_step_name_3">注册成功</div> </div> </div> </div> <div class="step-content"> ';
 if (stepNum==1){ 
$out+=' <form id="verifyMobileForm" autocomplete="off"> <div class="form-group"> <input type="text" id="mobile" name="mobile" maxlength="11" onpaste="return false" tabindex="3" onkeypress="if(event.keyCode==13||event.which==13){return false;}" class="form-control" placeholder="请输入常用手机号" autocomplete="off"/> <i class="close mobile-close reg-icon"></i> <i class="inputSuc"></i> <div class="input-call-info pos-abs"></div> <div class="C_err_tips"></div> </div> ';
 if (openDingxiang){ 
$out+=' <div class="form-group" id="js-dingxiang"> <div class="dingxiang-box"> <div class="dingxiang-title">为了账号安全，完成拼图验证</div> <i class="close dingxiang-close"></i> <div id="dingxiang"></div> </div> <a class="button btn-gray" href="javascript:;">点击按钮进行验证</a> <div class="C_err_tips"></div> </div> ';
 } else { 
$out+=' <div class="form-group" id="js-oldSlider"> <div id="slider"> <div id="slider_bg"></div> <span id="label">&gt;&gt;</span> <span id="labelTip">请按住滑块,拖动到最右边</span> </div> <div style="display: none;border: 1px solid #cc0000" class="check check-border"> <a class="check-phone" href="javascript:void(0);" id="verifySliderTip" style="padding: 11px 10px 14px;color:#cc0000;">请拖动滑块，完成验证</a> </div> </div> ';
 } 
$out+=' <div class="form-group clearfix" id="js-verifyCodeBox" style="display: none"> <input type="text" name="verifyCode" id="verifyCode" maxlength="6" onkeypress="if(event.keyCode==13||event.which==13){return false;}" class="form-control col-1" placeholder="输入验证码" autocomplete="off"/> <a href="javascript:;" class="button btn-gray col-2" id="getVerifyCode">获取短信验证码</a> <a href="javascript:;" class="button btn-gray col-2 remain-btn" disabled><span id="remainSeconds">60</span>秒后重新获取</a> <div class="success-mobile-msg input-call-info top50">验证码已发送，10分钟内输入有效</div> <div class="C_err_tips top50" id="TipverifyCode" ></div> </div> <div class="form-group-submit"> <a class="button btn-primary" href="javascript:;" id="submitVerifyMobileForm">下一步</a> </div> <div class="js-change-company step-link"> <i class="company"></i> <a href="/register/index/company">企业用户注册</a> </div> </form> ';
 } 
$out+=' ';
 if (stepNum==2){ 
$out+=' <form id="verifyAccountForm" autocomplete="off"> <div class="form-group"> <input type="text" id="username" name="username" maxlength="20" onpaste="return false" tabindex="3" onkeypress="if(event.keyCode==13||event.which==13){return false;}" class="form-control" placeholder="请输入用户名" autocomplete="aaa"/> <i class="reg-icon close"></i> <i class="inputSuc"></i> <div class="input-call-info"></div> <div class="C_err_tips"></div> <div id="tj_name" class="recommended-list hide"> <p>推荐您使用：</p> <ul class="clearfix"></ul> </div> </div> <div class="form-group"> <input type="password" isClick="false" id="password" name="password" onpaste="return false" tabindex="3" onkeypress="if(event.keyCode==13||event.which==13){return false;}" class="form-control" placeholder="请设置登录密码" autocomplete="aaa"/> <i class="reg-icon close pwd-close"></i> <i class="reg-icon errOpen" id="eye"></i> <div id="capsLocked" class="capsLock">键盘大写锁定已打开，请注意大小写!</div> <div class="pw-tips" id="pwd-safe" style="display:none;"> <span class="txt">安全程度：</span> <div class="pw-safe pw-none"> <div class="pw-bar"></div> <div class="pw-letter clearfix"> <span>弱</span> <span>中</span> <span>强</span> </div> </div> <a class="pw-suggest" href="javascript:void(0);">密码设置建议</a> </div> <i class="inputSuc"></i> <div class="input-call-info"></div> <div class="C_err_tips"></div> </div> <div class="form-group"> <input type="text" id="refereeCode" name="refereeCode" class="form-control" placeholder="填写推荐人推荐码，帮好友赚收入（选填）" autocomplete="off"/> <i class="inputSuc"></i> <div class="C_err_tips"></div> </div> <div class="form-group-submit"> <a class="button btn-primary" href="javascript:;" id="submitVerifyAccountForm">下一步</a> </div> <div class="js-change-company step-link"> <i class="company"></i> <a href="/register/index/company">企业用户注册</a> </div> <div class="grey-layer"></div> <div class="bomb-box" id="pw-suggest-box"> <div class="bomb-box-posi w440"> <div class="bomb-box-title"> <h1 >密码设置建议</h1> <a href="javascript:void(0);"></a> </div> <div class="bomb-box-text"> <p>1.密码设置至少6位以上，由数字、字母和符号混合而成，安全性最高；</p> <p>2.不允许空格、特殊字符。允许的符号为：~!@#$%^&*()_+-=；</p> <p class="bomb-box-text-b">统计分析表明，账号被盗，80%由于密码简单而被猜到引起的</p> <p>1.不建议使用7位以下纯数字；</p> <p>2.不建议和用户名太相似；</p> <p>3.不建议用太多连续或重复的字符（如：1234、ssss等）；</p> <p>4.不建议用手机号，身份证号，生日等个人信息</p> </div> </div> </div> </form> ';
 } 
$out+=' ';
 if (stepNum==3){ 
$out+=' <div class="success-register"> <h3>恭喜您，<span class="hign-text">';
$out+=$escape( mobile);
$out+='</span>注册国美会员成功！</h3> ';
 if (newExclusiveFlag==='Y'){ 
$out+=' <a href="';
$out+=$escape( libaoUrl);
$out+='" class="gife-img"><img src="';
$out+=$escape( gifeImg);
$out+='"/></a> <div class="sr-text">您的账户可以在国美网站和国美旗下所有门店通用</div> <div class="sr-text">我们准备了一些礼物，已经放到您的账户中!</div> <a href="';
$out+=$escape( libaoUrl);
$out+='" class="btn-primary btn-goshop">一键查看</a> ';
 }else{ 
$out+=' <div class="sr-text">您的账号可以在国美网站和国美旗下所有门店通用</div> <div class="sr-text">快开始您的购物之旅吧</div> <a href="';
$out+=$escape( staSiteNew);
$out+='" class="btn-primary btn-goshop">去购物</a> ';
 } 
$out+=' <div class="go-index-link"><span id="remainTimes"></span>S&nbsp;后自动跳转至首页</div> </div> ';
 } 
$out+=' </div> ';
return new String($out);
});

})();