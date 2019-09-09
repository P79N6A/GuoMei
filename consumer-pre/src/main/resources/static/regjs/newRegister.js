
//需要应用下方黑色js代码请请让他被调用





function fpwFn1() {
    agreement.popBox();
    var myCaptcha = null;
    var $mobileInput = $('#mobile');
    var $verifyCodeInput = $('#verifyCode');
    var $getVerifyCodeBtn = $('#getVerifyCode');
    var $remainSecondsText = $('#remainSeconds');
    $mobileInput.unbind('keyup').bind('keyup', function(){
        $mobileInput.next('.close').show();
        $mobileInput.siblings('.inputSuc').hide();
        return false;
    });

    $('#verifyMobileForm  :input').blur(function (event) {
        event.preventDefault();
        var $this = $(this);
        if(($this).is('#mobile')){
            $this.removeClass("focus");
            checkMobile($this);
        }
        if(($this).is('#verifyCode')){
            $this.removeClass("focus");
            checkVerifyCode($this)
        }
        if($mobileInput.val() && $mobileInput.attr('verify')!=='true'){
            $mobileInput.next('.close').show();
        }
    }).focus(function () {
        var $this = $(this);
        focus($this,'验证完成后，你可以使用该手机登录或找回密码');
        
    })
    $('.mobile-close').click(function(){
        $(this).hide().prev('input').val("");
    })
    // 顶象滑块开启
    if (defaultData.openDingxiang) {
        var $dingxiang = document.getElementById('dingxiang');
        var $box = $('.dingxiang-box');
        var $close = $('.dingxiang-close');
        var $btn =  $('#js-dingxiang .button');
        myCaptcha = _dx.Captcha($dingxiang, {
            appId: appId_dingxiang,
            apiServer: apiServer_dingxiang,
            constIDServer: constIDServer_dingxiang,
            constID_js: constID_js_dingxiang,
            ua_js: ua_js_dingxiang,
            style: 'embed',
            isSaaS:false,
            width: 270
        })
        $btn.click(function () {
            if(verifyMobileIsTrue()){
                if($dingxiang.style.display === 'block'){
                    $box.hide();
                }else{
                    $box.show();
                }
            }else{
                $box.hide();
            }
        })
        $close.click(function(){
            $box.hide();
        })
    } else {
        $('#js-oldSlider').show();
        var nc = new NC(riskToken, {
            'mobile': true,
        }, 'label');
        nc.init();
        var drag = new Drag("#slider", {
            successLabelTip: "验证通过"
        }, function () {
            var verifyName = $mobileInput.attr('verify');
            if(!verifyName || verifyName != 'true') {
                $mobileInput.blur();
                resetDrag()
                return;
            }
            $("#verifySliderTip").parent("div").hide();
        });
        drag.init();

        function resetDrag(){
            $('#labelTip').text("请按住滑块,拖动到最右边");
            drag.reset();
            drag.init();
        }
    }
    // 点击获取验证码btn
    $getVerifyCodeBtn.click(getVerifyCodeClick)
    function getVerifyCodeClick(){
        // 点击获取验证码，置灰获取验证码
        getVerifyCodeBtnDisbaled();
        // 出现计时按钮
        showRemainTimeBtn();
        // 发送api，验证短信是否发送成功
        getVerifyCodeApi();
    }
    function getVerifyCodeBtnDisbaled() {
        $getVerifyCodeBtn.hide().attr('disabled', true );
    }
    function getVerifyCodeBtnAbled() {
        $getVerifyCodeBtn
            .show()
            .html('重新获取验证码')
            .removeAttr("disabled")
            .click(getVerifyCodeClick)
    }
    function showRemainTimeBtn() {
        var num = 60, timer = null;
        if (timer) {
            clearInterval(timer)
        }
        timer = setInterval(function () {
            num--;
            $remainSecondsText.html(num);
            if (num <= 0) {
                getVerifyCodeBtnAbled();
                clearInterval(timer);
                $('.remain-btn').hide();
                $remainSecondsText.html(60);
                $('.success-mobile-msg').hide();
            }
        }, 1000)
        $('.remain-btn').attr('style', 'display:inline-block');
    }
    function getVerifyCodeApi() {
        $('.success-mobile-msg').hide();
    }
    // 点击验证手机号-下一步
    $('#submitVerifyMobileForm').click(submitVerifyMobileFormFn)
    function submitVerifyMobileFormFn() {
        if(verifyMobileIsTrue()){
        }
    }

    // 验证手机是否verify == 'true'
    function verifyMobileIsTrue(myCaptcha) {
        var verifyMobile = $mobileInput.attr('verify');
        if( verifyMobile !== 'true') {
            $mobileInput.blur();
            myCaptcha && myCaptcha.reload();
            return false;
        }else{
            return true
        }
    }
    // 验证手机号是否输入正确
    function checkMobile($el) {
        var val = $el.val();
        if(val == ""){
            inputErrTip($el,'请输入手机号');
        }else{
            if(/^(13\d{9}|14\d{9}|15\d{9}|16\d{9}|17\d{9}|18\d{9}|19\d{9})$/.test(val)){
                //验证手机号码格式
            }else{
                inputErrTip($el,'手机号码格式有误，请重新输入');
            }
            //$el.next('.reg-icon').hide();
        }
        
    }
    function checkVerifyCode($el) {
        var val = $.trim($el.val());
        if(val == ""){
            inputErrTip($el,'请输入短信验证码');
            return;
        }else if(val.length !=6 ||(!val.match('^[0-9]{1,}$'))){
            inputErrTip($el,'短信验证码错误');
            return;
        }else{
        }
    }
}
$(function () {
    var $username = $("#username");
    var $usernameClose = $username.next('.close');
    var $password = $("#password");
    var $passwordClose = $password.next('.close');
    var $refereeCode = $('#refereeCode');
    var $tj_name = $("#tj_name");
    var $pwdSafeBox = $("#pwd-safe");
    var canBlur = true;
    var $submitVerifyAccountForm = $('#submitVerifyAccountForm');
    document.getElementById('password').onkeypress = detectCapsLock;
    // 密码设置建议
    $(".pw-suggest").bind("click",function(){
        var _bombBox = $("#pw-suggest-box");
        _bombBox.show();
        $(".grey-layer").show();
        _bombBox.find("a").click(function(){
            _bombBox.hide();
            $(".grey-layer").hide();
        })
    });
    $username.unbind('keyup').bind('keyup', function(){
        $usernameClose.show().next('.inputSuc').hide();
        return false;
    });
    $password.unbind('keyup').bind('keyup', function(){
        $passwordClose.show().siblings('.inputSuc').hide();
        $('#eye').show();
        changePasswordGrade()
        return false;
    });
    $('#verifyAccountForm  :input').blur(function () {
        var $this = $(this);
        //$this.removeClass("focus").parent().removeClass('err');
        setTimeout(function(){
            if(canBlur){
                if(($this).is('#username')){
                    showTJName(false);
                    checkUserName($this);
                }
                if($this.is('#password')){
                    $("#capsLocked").hide();//失去焦点时，隐藏大写按键开启的提示
                    var username = $username.val();
                    var password = $password.val();
                    if(username==password&&username!=""){
                        inputErrTip($this,'用户名和密码不能相同，请重新输入！');
                    }
                    if(!checkPassword($this,password, true)) {
                        $pwdSafeBox.hide();
                        return false;
                    }
                    inputSuccessTip($this);
                    $pwdSafeBox.show();
                }
            }
            
        },200)
        if($this.is('#refereeCode')){
            checkRefereeCode($this);
        }
        return false
    }).focus(function () {
        canBlur = true;
        var $this = $(this);
        var msg =''
        
        if(($this).is('#username')){
            msg = '4-20个字符，建议由汉字、字母，数字与"-"、“_”组成'
        }
        if(($this).is('#password')){
            msg = '6-20个字符，建议使用字母、数字和符号两种以上的组合'
            if ($this.value) $pwdSafeBox.show();
            if($tj_name.css("display") == "block"){
                $password.blur();
            }
        }
        focus($this,msg)
        return false;
    })
    
    $('.close').click(function(){
        canBlur = false;
        $(this).hide().prev('input').val("");
        changePasswordGrade()
        return false;
    })
    
    $('#eye').click(function(){
        canBlur = false;
        var $password = document.getElementById('password');
        var $eye = document.getElementById('eye');
        if ($password.type == "password") {
            $password.type = "text";
            $eye.className='reg-icon errClose'
        }else {
            $password.type = "password";
            $eye.className='reg-icon errOpen'
        }
        return false
    })
    // 点击验证账户信息-下一步
    $submitVerifyAccountForm.click(submitVerifyAccountFormFn)
    function submitVerifyAccountFormFn() {
        if(verifyInputIsTrue($username) && verifyInputIsTrue($password) && verifyRefereeCodeIsTrue($refereeCode)){

        }
    }

    // api验证用户名
    function checkUserName($el) {
        //去除失去焦点class
        var val = $.trim($el.val());
        if(val==""){
            inputErrTip($el,'请输入用户名');
        }else if(strlen(val) < 4 || strlen(val) > 20){
            inputErrTip($el,'用户名长度只能在4-20个字符之间');
        }else if(/^[0-9]{1,}$/g.test(val)){
            inputErrTip($el,'用户名不能全部为数字');
        }else if(containSpecial(val)){
            inputErrTip($el,'建议由汉字、字母，数字与"-"、“_”组成');
        }else{
        }
    }
    // js验证密码强度
    function changePasswordGrade(){
        var $pwStrength =  $('.pw-safe');
        var $el = $password;
        if(this.value) $pwdSafeBox.show();
        $el.siblings('.input-call-info').hide();
        var password = $el.val();
    
        //初始化为弱
        $pwStrength.removeClass('pw-halfstrong');
        $pwStrength.removeClass('pw-medium');
        $pwStrength.removeClass('pw-weak');
        $pwStrength.removeClass('pw-none');
        $pwStrength.addClass('pw-weak');
    
        //(d)密码强度判断的规则
        var matchs1 = password.match('[~!@#$%^&*()_+\\-=]');
        var matchs2 = password.match('[A-Za-z]');
        var matchs3 = password.match('[0-9]');
        var x = 0;
        if(matchs1) x++;
        if(matchs2) x++;
        if(matchs3) x++;
        if (x == 3) {
            $pwStrength.attr('class','pw-safe pw-strong');
        } else if (x == 2) {
            $pwStrength.attr('class','pw-safe pw-medium');
        } else if (x == 1) {
            $pwStrength.attr('class','pw-safe pw-weak');
        } else {
            $pwStrength.attr('class','pw-safe pw-none');
        }
        if(!checkPassword(password, false)) return false;
    
        inputSuccessTip($el);
        return true;
    }
    // js验证密码输入是否符合要求
    function checkPassword($el,password, showMessage) {
        //(b)
        if(!password) {
            if(showMessage) inputErrTip($el,'请输入密码');
            return false;
        }
        //6-20
        if(!password.match('.{6,20}')) {
            if(showMessage) inputErrTip($el,'长度应为6-20个字符');
            return false;
        }
        //不能为同一字符
        if(isSameWord(password)) {
            if(showMessage) inputErrTip($el,'不能为同一字符');
            return false;
        }
        //不能全为数字
        if(password.match('^[0-9]{1,}$')) {
            if(showMessage) inputErrTip($el,'不能全为数字');
            return false;
        }
    
        if(!password.match('[A-Za-z0-9~!@#$%^&*()_+\\-=]+') || password.match('[A-Za-z0-9~!@#$%^&*()_+\\-=]+')[0].length < password.length) {
            if(showMessage) inputErrTip($el,'非法字符，请使用字母加数字或符号的组合，6-20个字符');
            return false;
        }
    
        //密码不能与用户名相同
        var loginName = $.trim($username.val());
        if(loginName==password) {
            if(showMessage) inputErrTip($el,'用户名和密码不能相同，请重新输入！');
            return false;
        }
    
        if(showMessage) {
            inputSuccessTip($el);
        };
        return true;
    }

    // api验证推荐码
    function checkRefereeCode($el) {
        var refereeCode = $el.val();
        if(refereeCode){
        }else{
            var $parent = $el.parent();
            $parent.removeClass('err').children('.C_err_tips').text('')
            $parent.children('.inputSuc').hide();
        }
    }


    /*是否显示推荐用户名*/
    function showTJName(display) {
        if(display) {
            $tj_name.removeClass('hide');
        } else {
            $tj_name.addClass("hide");
        }
    }

    function verifyInputIsTrue($el) {
        var verify = $el.attr('verify');
        if( verify !== 'true') {
            $el.blur();
            return false;
        }else{
            return true
        }
    }
    function verifyRefereeCodeIsTrue($el) {
        var verify = $el.attr('verify');
        if( $el.val() && verify === 'false') {
            $el.blur();
            return false;
        }else{
            return true
        }
    }
})
function fpwFn3() {
    countdown($('#remainTimes'),30,function () {
        location.href= defaultData.staSiteNew;
    })
}
function iconShow($el){
    if($el.attr('verify')!=='true'){
        $el.siblings('.reg-icon').show();
    }
}
function focus($el,msg){
    $el.addClass("focus")
        .siblings('.input-call-info').text(msg)
        .parent().removeClass('err').children('.C_err_tips').text('')
}
function selectMe(option) {
    var $username = $("#username");
    var $tj_name = $("#tj_name");
    $tj_name.addClass("hide");
    $username.val(option.value);
    $username.blur();
}

function goToLogin(mobile) {
    omnitureForLink('手机号码重复，登录连接');
    var url = loginSite+'/login'+'.do?login='+mobile;
    window.location.href = url;
}
//当前页面名称:+关键按钮所处位置:+关键按钮名称
function omnitureForLink(value) {
    var s = s_gi(s_account);
    s.linkTrackVars = 'prop20';
    s.prop20 = '注册页面:个人用户注册:' + value; //记录关键按钮名称 当前页面名称:+关键按钮所处位置:+关键按钮名称
    s.tl(this, 'o', 'register_key_position');
}
// 倒计时
function countdown($dom,t,fn) {
    var timer= null;
    var t = 5;
    function time(){
        t--;
        $dom.html(t);
        if(t==0){
            clearInterval(timer);
            fn && fn()
        }
    }
    timer = setInterval(time,1000)
}
function render(data) {
    html = gomeTemplate('register', data)
    $('#container').html(html);

    $.each(arguments, function (index, args) {
        args instanceof Function && args()
    })
    return html;
}
//检测到非法请求，强制刷新
function checkRefresh(data){
    if((data) && data=='false:非法请求'){
        location.reload();
        return;
    }
}
function splitAjaxData(data) {
    var data = $.trim(data);
    // checkRefresh(data);
    var dataArray = data.split(':');
    return {
        msg: dataArray[1],
        list:dataArray[1].split(';'),
        status:dataArray[0]
    }
}

function inputErrTip($el,msg) {
    var $parent = $el.parent();
    $el.attr('verify',false);
    $parent.addClass('err').children('.C_err_tips').html(msg);
    $parent.children('.reg-icon').hide();
    $parent.children('.inputSuc').hide();
    $parent.children('.input-call-info').html('');
}
function inputSuccessTip($el) {
    var $parent = $el.parent();
    $el.attr('verify',true);
    $parent.removeClass('err').children('.C_err_tips').text('')
    $parent.children('.reg-icon').hide();
    $parent.children('.inputSuc').show();
    $parent.children('.input-call-info').html('');
}
function strlen(str){
    var len = 0;
    for (var i=0; i<str.length; i++) {
        var c = str.charCodeAt(i);
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) {
            len++;
        }else {
            len+=2;
        }
    }
    return len;
}
// 汉字、字母，数字与"-"、“_”组成
function containSpecial(s){
    return (!/^[a-zA-Z0-9\u4E00-\u9FA5_-]+$/g.test(s));
}

function isSameWord(text) {
    if(text) {
        var c = text.substr(0,1);
        for(var i = 1; i < text.length; i++) {
            var c2 = text.substr(i, 1)
            if(c != c2) {
                return false;
            }
        }
    }
    return true
}


/**
 * 判断capsLock按键的状态
 * @param event
 */
function  detectCapsLock(event){
    var e = event||window.event;
    var o = e.target||e.srcElement;
    var keyCode  =  e.keyCode||e.which; // 按键的keyCode
    var isShift  =  e.shiftKey ||(keyCode  ==   16 ) || false ; // shift键是否按住
    if (
        ((keyCode >=   65   &&  keyCode  <=   90 )  &&   !isShift) // Caps Lock 打开，且没有按住shift键
        || ((keyCode >=   97   &&  keyCode  <=   122 )  &&  isShift)// Caps Lock 打开，且按住shift键
    ){
        $("#capsLocked").show();
    }
    else{
        $("#capsLocked").hide();
    }
}