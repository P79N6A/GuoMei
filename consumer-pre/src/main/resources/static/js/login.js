function notifyOthers(o, i, n, e) {
    if (o && o.length > 0) {
        var t = 0;
        for (var a = 0; a < o.length; a++) {
            var c = o[a].url;
            c += c.indexOf("?") > 0 ? "&" : "?";
            c += "uuid=" + o[a].uuid;
            $.ajax({
                type: "get",
                url: c,
                dataType: "jsonp",
                timeout: 1e3,
                jsonp: "callbackparam",
                jsonpCallback: "success_jsonpCallback",
                complete: function (a) {
                    t++;
                    if (t == o.length) {
                        if ("function" == typeof e) {
                            e()
                        }
                        if (i) {
                            window.location.href = i
                        }
                        if ("function" == typeof n) {
                            n()
                        }
                    }
                },
                success: function (o) {
                },
                error: function (o) {
                }
            })
        }
    }
}

function sendOperationIframe(o, i) {
    var n = $("#callbackHost").val();
    var e = n + "?option_callback=" + o;
    if (i) {
        e += "&userName=" + i
    }
    window.location.href = e
}

function bigSend() {
    if ($.cookie("distinctId") != null && $.cookie("distinctId") != "" && bigDataSend) {
        GomeSa.login($.cookie("SSO_USER_ID"));
        var o = $.cookie("loginType");
        if ($.cookie("loginReg") == 1) {
            GomeSa.track("Login", {login_type: o})
        }
        if ($.cookie("loginReg") == 2) {
            GomeSa.track("Register", {login_type: o, phone: "", email: ""})
        }
    }
}

function nationPurchaseRedirect(o) {
    if (o) {
        window.location.href = o
    }
}

var isSubmit = true;
var isShowFindPassword = false;
var isNotInitPage = false;
var referisError = false;
var onoff = false;
var timer = null;
var ele_loginName = "loginName";
var ele_loginPassword = "loginPassword";
var ele_captcha = "captcha";
var ele_phoneNum = "phoneNum";
var ele_verifyCode = "verifyCode";
var msg_phoneErrpr = "手机号码格式有误，请重新输入";
var msg_phoneEmpty = "手机号不能为空";
var msg_phoneUse = "短信发送次数超过限制，请走普通登录";
var msg_verifyCodeNotEmpty = "短信验证码不能为空";
var msg_verifyCodeFocus = "请输入短信验证码";
var msg_verifyCodeNotError = "短信验证码错误";
var msg_verifyCodeError = "请输入正确的短信验证码";
var msg_verifyCodeTimeOut = "短信验证码超时";
var msg_verifyCodeCon = "短信验证码已过期，请重新获取";
var captchaGrade;
var ssesionId;
var hideTimeOut = null;
var hideOp = false;
var isagreeFlag = true;
var cls_success = "suc-icon";
var cls_msg_err = "err-tips";
var cls_err = "txt-error";
var cls_cur = "msg-weak";
var cls_base = "reg-items";
var cls_base_authenticCode = cls_base;
var cls_base_verifyCode = cls_base;
var cls_focus = "txt-focus";
var offSet = true;
var dataTime;
var codeState = "";
// var passwordNum = $("#loginPassword").val();
var dxCaptcha = null;
var nCode = "";
var currentUser = "";
var isQuestionUser = true;
// var passwrong = $.cookie("passwrong") || 0;

function createCaptcha(e, i) {
    dxCaptcha && (dxCaptcha = null);
    $(".btnnuw").prop("disabled", true);
    dxCaptcha = _dx.Captcha(document.getElementById(e), {
        appId: appId_dingxiang,
        apiServer: apiServer_dingxiang,
        constIDServer: constIDServer_dingxiang,
        constID_js: constID_js_dingxiang,
        ua_js: ua_js_dingxiang,
        style: "embed",
        isSaaS: false,
        width: 270,
        success: function (e) {
            if (e && isSubmit) {
                i && i(e)
            }
        },
        fail: function (e) {
            console.log(e)
        }
    })
}

function loginGome() {
    $("#loginPassword").blur();
    if (!isSubmit) {
        return false
    }
    if (typeof check == "fucntion") {
        if (!check()) {
            return
        }
    }
    var e = $("#frm #loginName").val();
    var i = $("#frm #loginPassword").val();
    $(".findpassword").hide();
    $("#err-tip .accountPassword").hide();
    if ($.trim(e) == "") {
        errorTip("请输入您的用户名");
        $("#frm #loginName").removeClass("txt-focus").addClass("txt-error");
        $("#frm #loginPassword,#frm #captcha").removeClass("txt-error");
        return
    } else if ($.trim(i) == "") {
        errorTip("请输入您的密码");
        $("#loginPassword").addClass("txt-error");
        $("#frm #captcha").removeClass("txt-error");
        return
    } else if (isNotInitPage || referisError) {
        showErrorTip();
        return
    } else {
        if (currentUser !== $.trim(e)) {
            currentUser = $.trim(e)
        }
        $("#err-tip").hide();
        $("#frm #loginPassword").removeClass("txt-error")
    }
    if (openDingxiang == "true") {
        isShowAuthenticCode("loginName")
    } else {
        loginGome1(preLogin)
    }
}

function loginGome1(e) {
    var i = 5410;
    var p = 5420;
    var o = 5430;
    var a = 5440;
    var n = 5450;
    var s = 5460;
    var r = $("#frm #loginType").val();
    var t = {
        url: contextPath + "/" + toLoginUrl + "Login.no", type: "post", dataType: "json", beforeSend: function () {
            if (r == 6) {
                $("#frm .btnnuw").attr("disabled", "disabled").val("正在升级...")
            } else {
                $("#frm .btnnuw").attr("disabled", "disabled").val("正在登录...")
            }
            isSubmit = false
        }, success: function (e) {
            if (e.code == 200) {
                // $.cookie("passwrong") && $.cookie("passwrong", null);
                bigLoginReg();
                var t = e.externalUrls;
                if (r == 0 || r == 5) {
                    notifyOthers(t, e.successUrl, "", bigSend)
                } else if (r == 6) {
                    if (e.isAuthorized == "Y") {
                        window.location.href = contextPath + "/authLogSucc.no"
                    } else {
                        var c = contextPath + "/authSucc.no";
                        notifyOthers(t, c, "", bigSend)
                    }
                } else {
                    function l() {
                        var e = "";
                        if ($("#pageType").val() == "pop") {
                            e = "1"
                        } else if ($("#pageType").val() == "embed") {
                            e = "10"
                        }
                        sendOperationIframe(e)
                    }

                    notifyOthers(t, "", l, bigSend)
                }
            } else if (e.code == i || e.code == p || e.code == o || e.code == a || e.code == n || e.code == s) {
                if (r == 1) {
                    window.parent.location.href = e.hqmBindCardUrl + "?token=" + e.token
                } else {
                    window.location.href = e.hqmBindCardUrl + "?token=" + e.token
                }
            } else if (e.code == 9202 || e.code == 9203) {
                window.parent.location.href = contextPath + "/toBindMobile.no"
            } else if (e.code == 4003 && openDingxiang == "true") {
                nCode = 4003;
                errorTip(e.message);
                $(".findpassword").show();
                $("#loginPassword").val("");
                $("#loginPasswordDiv .clear-btn").hide();
                $("#frm .btnnuw").prop("disabled", false).val("登录");
                return
            } else if (e.code == 10021) {
                $("#zhezhao").show();
                $("#frm .btnnuw").removeAttr("disabled").val("登 录")
            } else if (e.code == 10022) {
                showTips("ordinary", "该用户不存在");
                $("#frm .btnnuw").removeAttr("disabled").val("登 录")
            } else {
                if (e.code == 2002 && e.publicKey != "undefined" && e.publicKey != null && e.publicKey != "") {
                    publicKey = e.publicKey
                }
                if (r == 6) {
                    $("#frm .btnnuw").removeAttr("disabled").val("升级一账通账户")
                } else {
                    $("#frm .btnnuw").removeAttr("disabled").val("登 录")
                }
                if (e.code == 2002) {
                    if (openDingxiang == "true") {
                        // $.cookie("passwrong", ++passwrong)
                    }
                }
                isSubmit = true;
                if (e.code == 1304) {
                    window.location.href = contextPath + "/authLogError.no";
                    return
                }
                if ("weakpw" == e.codeType) {
                    if (r == 0 || r == 5 || r == 6) {
                        $("#popLogin-ifrWindow").attr("src", "/redirectResetPwd.no?loginType=0");
                        pop.layerShow("nobj", "popLogin-dytscBir")
                    } else {
                        window.location.href = $(callbackHost).val() + "?option_callback=2"
                    }
                    return
                } else {
                    nCode = e.code;
                    if (e.code == 3600) {
                        window.location.reload()
                    }
                    if (e.code == 3601 || e.code == 3602) {
                        $("#loginPassword").val("");
                        $("#loginPasswordDiv .clear-btn").hide();
                        $("#frm .btnnuw").prop("disabled", false).val("登录");
                        $("#err-tip").hide();
                        return
                    }
                    isShowFindPassword = e.isShowFindPassword;
                    showTips(e.codeType, e.message)
                }
            }
        }, error: function (e) {
            isShowFindPassword = false;
            if (r == 6) {
                $("#frm .btnnuw").removeAttr("disabled").val("升级一账通账户");
                isSubmit = true;
                showTips("system", "升级失败，请稍后再试！！")
            } else {
                $("#frm .btnnuw").removeAttr("disabled").val("登 录");
                isSubmit = true;
                showTips("system", "登录失败，请稍后再试！！")
            }
        }
    };
    if (isSubmit) {
        var c = new JSEncrypt;
        c.setPublicKey(publicKey);
        var l = c.encrypt($("#loginPassword").val());
        // passwordNum = passwordNum == "" ? "1" : "2";
        $("input[name='password']").val(l);
        $("input[name='passwordNum']").val(ele_loginPassword);
        $("input[name='publicKey']").val(publicKey);
        $("#frm").ajaxSubmit(t)
    }
}

function showTimeSpanMsbbox(e) {
    $("#timeSpanMsbbox").toggle(e)
}

var currentPhone = "";

function loginQuickGome(e) {
    if (!isSubmit) {
        return false
    }
    if (typeof e == "fucntion") {
        if (!e()) {
            return
        }
    }
    var i = $("#phoneNum").val();
    var p = $("#verifyCode").val();
    var o = $("#codeCheck").val();
    $(".findpassword").hide();
    $("#err-tip .accountPassword").hide();
    if ($.trim(i) == "") {
        errorTip(msg_phoneEmpty);
        $("#" + ele_phoneNum).removeClass("txt-focus").addClass("txt-error");
        $("#verifyCode, #codeCheck").removeClass("txt-error");
        return
    } else if ($.trim(p) == "") {
        errorTip(msg_verifyCodeFocus);
        $("#" + ele_verifyCode).removeClass("txt-focus").addClass("txt-error");
        $("#codeCheck").removeClass("txt-error");
        return
    } else if (isNotInitPage || referisError) {
        showErrorTip();
        return
    } else {
        $("#err-tip").hide();
        $("#phoneNum, #verifyCode, #codeCheck").removeClass("txt-error")
    }
    if (currentPhone && currentPhone != $.trim(i)) {
        currentPhone = $.trim(i)
    }
    var a = $("#loginType2").val();
    var n = $("#autoLoginModeNew").val();
    var s = {
        url: contextPath + "/" + quickURL + "QuickLogin.no",
        type: "post",
        dataType: "json",
        data: {phoneNum: i, msgCode: p, captcha: o, captchaType: captchaGrade, autoLoginModeNew: n},
        beforeSend: function () {
            $("#quickeLoginForm .btnnuw").attr("disabled", "disabled").val("正在快速登录...");
            isSubmit = false
        },
        success: function (e) {
            $("#quikeCode2").length && $("#quikeCode2").val("");
            if (e.code == 200) {
                codeNum = 0;
                bigLoginReg();
                var i = e.externalUrls;
                if (a == 0 || a == 5) {
                    notifyOthers(i, e.successUrl, "", bigSend)
                } else {
                    function p() {
                        var e = "";
                        if ($("#pageType").val() == "pop") {
                            e = "1"
                        } else if ($("#pageType").val() == "embed") {
                            e = "10"
                        }
                        sendOperationIframe(e)
                    }

                    notifyOthers(i, "", p, bigSend)
                }
            } else if (e.code == 201) {
                errorTip("账号异常，请切换至");
                $("#err-tip .accountPassword").show();
                $("#quickeLoginForm .btnnuw").removeAttr("disabled").val("登 录");
                isSubmit = true
            } else if (e.code == 5e3) {
                errorTip("门店用户请切换至");
                $("#err-tip .accountPassword").show();
                $("#quickeLoginForm .btnnuw").removeAttr("disabled").val("登 录");
                isSubmit = true
            } else if (e.code == 3606) {
                quickeShowTips(e.codeType, e.message);
                isSubmit = true
            } else if (e.code == 3602 || e.code == 3603 || e.code == 3006) {
                $("#quickeLoginForm .btnnuw").removeAttr("disabled").val("登 录");
                isSubmit = true;
                showKDingxiang();
                return
            } else if (e.code == 3600) {
                window.location.reload()
            } else {
                $("#quickeLoginForm .btnnuw").removeAttr("disabled").val("登 录");
                isSubmit = true;
                quickeShowTips(e.codeType, e.message)
            }
        },
        error: function (e) {
            $("#quickeLoginForm .btnnuw").removeAttr("disabled").val("登 录");
            isSubmit = true;
            quickeShowTips(e.codeType, e.message)
        }
    };
    if (isSubmit) {
        $("#quickeLoginForm").ajaxSubmit(s)
    }
}

function showCode(e) {
    if (openDingxiang == "true") return;
    if ($("#" + e + "Div").is(":visible")) {
        if (null != $("#" + e).val()) {
            if ($("#" + e).val().length == 0) {
                errorTip("请输入图片验证码");
                $("#" + e).addClass("txt-error");
                offSet = false;
                return false
            }
            if ($("#" + e).val().length > 0 && $("#" + e).val().length != 4) {
                errorTip("图片验证码错误，请重新输入");
                $("#" + e).addClass("txt-error");
                offSet = false;
                return false
            }
            offSet = true
        }
    }
}

function showTips(e, i) {
    var p = "";
    i == "您输入的用户名不存在，请核对后再重新输入" ? p = "此会员卡号不存在，请核对后重新输入" : p = i;
    var o = $("#frm #isFromHqmLogin").val();
    if (o != undefined && $.trim(o) == "true") {
        showHqmTips(e, p)
    } else {
        if (e == "login") {
            showErrorTipStage("frm", "loginName")
        } else if (e == "password") {
            showErrorTipStage("frm", "loginPassword")
        } else if (e == "captcha") {
            showErrorTipStage("frm", "captcha")
        } else if (e == "ordinary") {
            errorTip(i);
            return false
        } else if (e == "addBindChannel") {
            showErrorTipStage("frm", "loginName")
        } else if (e == "isnotmobileactive") {
            showErrorTipStage("frm", "loginName")
        } else {
            errorTip("登录失败，请稍后再试");
            showErrorTipStage("frm", "loginName");
            return false
        }
        errorTip(i);
        if (isShowFindPassword) {
            $(".findpassword").show();
            $("#loginPassword").val("");
            $("#loginPasswordDiv .clear-btn").hide();
            if (openDingxiang != "true") isShowAuthenticCode("loginName")
        } else {
            $(".findpassword").hide()
        }
    }
}

function quickeShowTips(e, i) {
    if (e == "sms") {
        showErrorTipStage("quickeLoginForm", "verifyCode")
    } else if (e == "captcha") {
        showErrorTipStage("quickeLoginForm", "codeCheck")
    } else if (e == "none") {
        errorTip(i);
        return false
    } else {
        errorTip(i);
        return false
    }
}

function showErrorTipStage(e, i) {
    if (e == "frm") {
        $("#loginPassword,#captcha,#loginName").removeClass("txt-focus").removeClass("txt-error");
        if (i == "loginName" || i == "loginPassword") {
            $("#captchaDefault").show()
        }
        if (i == "loginPassword") {
            $("#loginPassword").val("");
            $("#loginPasswordDiv .clear-btn").hide();
            $("#forgetpwdmsg").addClass("blink")
        }
        if (openDingxiang != "true") isShowAuthenticCode("loginName")
    } else {
        $("#phoneNum,#codeCheck,#verifyCode").removeClass("txt-focus").removeClass("txt-error");
        isShowAuthenticCode("phoneNum")
    }
    $("#" + i).addClass("txt-error");
    $("#" + e + " .verify-tips").hide()
}

function showHqmTips(e, i) {
    if (e == "login") {
        if (i.indexOf("请使用新绑定的手机号") >= 0) {
            var p = contextPath + "/login.no";
            i = i + "点击这里<a class='nBlue'  href=" + p + ">登录</a>"
        }
        $("#frm #valiLoginName").show();
        $("#frm #valiLoginName").html("<span class='tips' style='display: block;'>" + i + "</span>");
        $("#loginNameLi").addClass("wrong");
        $("#loginPasswordLi").removeClass("wrong");
        if (openDingxiang != "true") isShowAuthenticCode("loginName")
    } else if (e == "password") {
        $("#frm #valiPassword").show();
        $("#frm #valiPassword").html("<span class='tips' style='display: block;'>" + i + "</span>");
        $("#loginPasswordLi").addClass("wrong");
        if (openDingxiang != "true") isShowAuthenticCode("loginName")
    } else if (e == "captcha") {
        $("#captchaDiv").show();
        $("#frm #validate_captcha_login_div").html("<span class='tips' style='display: block;'>" + i + "</span>");
        $("#captchaDiv").addClass("wrong")
    } else {
        $("#frm #loginNameLi").show();
        $("#frm #loginNameLi").html("<span class='tips' style='display: block;'>" + "登录失败，请稍后再试" + "</span>");
        $("#loginNameLi").addClass("wrong")
    }
}

function focusPWInput() {
    handleFocus(ele_loginPassword);
    $("#err-tip").hide();
    isSubmit = true;
    if ($.trim($("#" + ele_loginName).val()) != "") {
        if (openDingxiang != "true") isShowAuthenticCode("loginName");
        isShowConflictOrSnsTips()
    }
    $("#frm .verify-tips").hide()
}

function blurPWInput() {
    timerchange(ele_loginPassword);
    isSubmit = true;
    $("#capital_tip").hide()
}

function focusCaptchaInput(e) {
    if (e == "captcha") {
        handleFocus(ele_captcha)
    } else {
        handleFocus("codeCheck")
    }
    var i = $("#" + e).siblings(".verify-tips").find("b");
    if ("error" == i.attr("class")) {
        $("#" + e).val("")
    }
    $(".verify-tips").hide();
    $(".verify-tips b").removeClass("current");
    $(".verify-tips b").removeClass("error")
}

function showNDingxiang() {
    $("#nomalcaptcha").show();
    $("#nomalCode").remove();
    createCaptcha("captcha-content", function (e) {
        $("#nomalcaptcha").hide();
        $(".btnnuw").prop("disabled", false);
        if (e) {
            $("#nomalcaptcha").after('<input id="nomalCode" name="dxCode" type="hidden" value="' + e + '"/>');
            loginGome1(preLogin)
        }
    })
}

function showKDingxiang() {
    $("#quikecaptcha").show();
    $("#quikeCode2").remove();
    createCaptcha("captcha-content2", function (e) {
        $("#quikecaptcha").hide();
        $(".btnnuw").prop("disabled", true);
        if (e) {
            $("#quikecaptcha").after('<input id="quikeCode2" name="dxCode" type="hidden" value="' + e + '"/>');
            loginQuickGome(preLogin)
        }
    })
}

function isShowAuthenticCode(e, i) {
    var p;
    isSubmit = false;
    if (e == "loginName") {
        var o = $("#loginName").val();
        var a = $("input[name='gomeOrCoo8']:checked").val();
        if ("coo8" == a) {
            o = $.trim(o) + "@coo8"
        }
        p = {loginName: o}
    } else {
        var n = $("#" + ele_phoneNum).val();
        p = {loginName: n}
    }
    var s = (new Date).getTime();
    var r = contextPath + "/isShowAuthenticCode.no?sendtimestamp=" + s;
    $.ajax({
        type: "post", url: r, data: p, success: function (i) {
            isSubmit = true;
            var p = $.trim(i.result);
            if (i.isNotInitPage == true) {
                showTips(i.codeType, i.message);
                isNotInitPage = true;
                return false
            }
            if (i.referisError == true) {
                showTips(i.codeType, i.message);
                referisError = true;
                return false
            }
            if (p == "false") {
                isQuestionUser = false;
                if (e == "loginName") {
                    $("#captchaDiv").hide();
                    $("#nomalcaptcha").hide();
                    if (openDingxiang == "true") {
                        if (!isQuestionUser) {
                            if (nCode == 4003) {
                                showNDingxiang();
                                return
                            }
                        }
                        loginGome1(preLogin)
                    }
                } else {
                    $("#codeCheckDiv").hide();
                    $("#quikecaptcha").hide()
                }
            } else {
                ssesionId = i.ssesionId;
                captchaGrade = i.captchaGrade;
                $("#frm .captchaType").val(captchaGrade);
                $("#quickeLoginForm .captchaType").val(captchaGrade);
                var o = $("#getVerifyCode").attr("isclick");
                if (e == "loginName") {
                    if (openDingxiang == "true") {
                        if ($.trim($("#loginPassword").val())) {
                            isQuestionUser = true;
                            showNDingxiang()
                        }
                    } else {
                        $("#captchaDiv").show();
                        if (o == "false") {
                            $("#frm .codeRefreshControlCenter").click()
                        }
                    }
                } else {
                }
            }
            if (e == "loginName") {
                $("#captcha").val("");
                timerchange(ele_captcha)
            }
        }
    })
}

function isShowConflictOrSnsTips() {
    isShowFindPassword = false;
    var e = $("#loginName").val();
    var i = (new Date).getTime();
    $("#corp-login dd a").removeClass("hover");
    if (e != " ") {
    } else {
    }
}

var snsNameHash = {gomePay: "国美支付", wechat: "微信", qq: "QQ", alipay: "支付宝", sina: "新浪微博", jixin: "极信通"};

function validateLoginCaptcha(e, i) {
    var p = $("#" + e).val();
    var o = $("#captchaUUID").val();
    var a;
    if (e == "captcha") {
        a = $("#loginName").val();
        var n = $("input[name='gomeOrCoo8']:checked").val();
        if ("coo8" == n) {
            a = $.trim(a) + "@coo8"
        }
    } else {
        a = $("#phoneNum").val()
    }
    if (captchaGrade == "login_static" || captchaGrade == "login_dynamic") {
        var s = new RegExp(/[^\u4e00-\u9fa5]/g);
        if (p == null || p.length != 4 || p.match(s)) {
            return false
        }
    }
    if (p != null && p.length == 4) {
        if (e == "captcha") {
            isShowFindPassword = false
        }
    }
}

function detectCapsLock(e) {
    var i = e || window.event;
    var p = i.keyCode || i.which;
    var o = i.shiftKey || p == 16 || false;
    if (p >= 65 && p <= 90 && !o || p >= 97 && p <= 122 && o) {
        $("#capital_tip").show()
    } else {
        $("#capital_tip").hide()
    }
}

function clearBtnKeyUp(e) {
    $("#" + e).keyup(function () {
        if ($(this).val() == "") {
            $("#" + e + "Div").find(".clear-btn").hide()
        } else {
            $("#" + e + "Div").find(".clear-btn").show()
        }
    })
}

function clearBtnBind(e) {
    $("#" + e + "Div").find(".clear-btn").click(function () {
        $("#" + e).focus();
        $("#" + e).val("");
        $("#" + e + "Div").find(".clear-btn").hide()
    })
}

function errorTip(e) {
    $("#err-tip .accountPassword").hide();
    $("#err-tip b").empty().html(e);
    $("#err-tip").show();
    $("#warmTips").hide();
    $(".warningTip").hide()
}

function warmTip(e) {
    $("#err-tip .accountPassword").hide();
    $("#err-tip").hide();
    $("#warmTips span").empty().html(e);
    $("#warmTips").show();
    $(".warningTip").hide()
}

function warningTip(e) {
    $("#err-tip").hide();
    $("#warmTips").hide();
    $("#err-tip .accountPassword").hide();
    e.parent().parent().siblings(".warningTip").show()
}

function allTipHide() {
    $("#err-tip").hide();
    $("#warmTips").hide();
    $("#err-tip .accountPassword").hide()
}

function showErrorTip() {
    $("#err-tip").show();
    $("#warmTips").hide();
    $(".warningTip").hide();
    $("#err-tip .accountPassword").hide()
}

function closeSmLogin() {
    var e = setTimeout(function () {
        $("#barcodeId").show();
        $("#sm-login .right-state").hide();
        $("#errorTipCon").show()
    }, 120 * 1e3)
}

function succesSmLogin() {
    $("#sm-login .right-state").show();
    $("#barcodeId").hide();
    $("#errorTipCon").hide()
}

function openSmLogin() {
    $("#barcodeId").show();
    $("#errorTipCon").hide();
    $("#errorTipCon2").hide();
    $("#sm-login .right-state").hide()
}

function cancelSmLogin() {
    $("#barcodeId").show();
    $("#sm-login .right-state").hide();
    $("#errorTipCon2").show()
}

function loadingBarcodeLogin(e) {
    var i = (new Date).getTime();
}

function refBarcode(e) {
    if ("f" == e) {
        var i = loginHttps + "/getQrcode.no?state=error&refreshkey=" + Math.floor(Math.random() * 100);
        var p = loginHttps + "/getQrcode.no?width=165&height=165" + "&refreshkey=" + Math.floor(Math.random() * 100);
        $("#kaptchaImage22").attr("src", p).show();
        openSmLogin();
        var o = setTimeout(function () {
            loadingBarcodeLogin("waitScan")
        }, 1e3)
    }
}

function moblieBarcode(e) {
    if (e == true) {
        openSmLogin();
        loadingBarcodeLogin("waitScan");
        onoff = false
    } else {
        $(this).attr("on-moblie", "false");
        onoff = true;
        return
    }
}

function changeImageAuthenticCode(e, i, p) {
    if (i == "captchaImg") {
        var o = $("#loginName").val();
        var a = $("input[name='gomeOrCoo8']:checked").val();
        if ("coo8" == a) {
            o = $.trim(o) + "@coo8"
        }
    }
    $("#" + p + " ." + e).attr("src", imgCodeHttps + "/getLRcaptcha.no?" + "height=42&" + captchaTypeName + "=" + captchaGrade + "&capCd=" + ssesionId + "&refreshkey=" + Math.random());
    var n = $("#" + p + " ." + e).clone();
    $("#" + p + " ." + e).parent().find("img").replaceWith(n)
}

function timerchange(e) {
    timer && clearInterval(timer);
    timer = setInterval(function () {
        var i = $("#" + e).val();
        var p = $("#" + e).parents("#" + e + "Div");
        if (i) {
            p.find(".default").hide();
            clearInterval(timer)
        } else {
            p.find(".default").show()
        }
    }, 15)
}

function hideTips() {
    hideTimeOut = setInterval(function () {
        $("#tip_con").fadeOut(1e3);
        hideOp = true
    }, "5000")
}

function handleFocus(e) {
    var i = this;
    timerchange(e);
    $("#" + e).removeClass(cls_err);
    if (!$("#" + e).hasClass(cls_focus)) {
        $("#" + e).addClass(cls_focus)
    }
    $("#" + e + "Suc").hide()
}

function autoLogin(e, i) {
    $("." + e).bind("click", function () {
        if (this.checked) {
            $("." + i).val("autoLoginWithinOneWeek");
            warningTip($(this))
        } else {
            $("." + i).val("");
            $(this).parent().parent().siblings(".warningTip").hide()
        }
    })
}

function time_js() {
    clearInterval(dataTime);
    $("#verifyCodeTips").hide();
    $("#verifyCode").removeClass("err");
    $("#getVerifyCode").hide();
    $("#timeSpan").show();
    showTimeSpanMsbbox(true);
    $("#resendSpan").hide();
    var e = 60;
    this.tAtc = function () {
        e--;
        $("#time").html(e);
        if (e == 0) {
            clearInterval(dataTime);
            $("#getVerifyCode").hide();
            $("#timeSpan").hide();
            $("#resendSpan").show();
            showTimeSpanMsbbox(false);
            $("#time").html("60")
        }
    };
    dataTime = setInterval(tAtc, 1e3)
}

function checkTelphone() {
    var e = $("#" + ele_phoneNum).val();
    var i = /^(13\d{9}|14\d{9}|15\d{9}|16\d{9}|17\d{9}|18\d{9}|19\d{9})$/;
    var e = $.trim(e);
    $("#" + ele_phoneNum + "Suc").hide();
    timerchange(ele_phoneNum);
    if (i.test(e)) {
        allTipHide();
        $("#" + ele_phoneNum).attr("verify", "yes");
        showSuccessTips("", ele_phoneNum)
    } else {
        errorTip(msg_phoneErrpr);
        $("#" + ele_phoneNum).attr("verify", "no")
    }
    if (e == "") {
        errorTip(msg_phoneEmpty);
        $("#" + ele_phoneNum).attr("verify", "no")
    }
}

var popBoxHtml1 = '';
var popBoxHtml2 = '';
var popBoxHtml3 = '';
var popBox = function () {
    var e = '<div class="popBoxWrapper dn popBoxInput" style="display: block; top: 50px; left: 491.5px;">' + '<a class="uc_closed" href="' + staSite + '"></a>' + '<div class="uc_box">' + "<h5>阅读注册协议</h5>" + "<p><b>【审慎阅读】 注册协议已更新，您在点击同意前，应当认真阅读以下协议，尤其粗体标识的重要条款。请您务必审慎阅读、充分理解协议中相关条款内容。</b></p>" + "<p><b>【特别提示】</b>当您点击同意后，即表示您已充分阅读、理解并接受协议的全部内容。如您因平台服务与国美发生争议的，适用《国美平台服务协议》处理。</p>" + '<div class="protocol">' + '<a href="' + loginHttps + '/authAgreeMent" target="_blank">国美平台服务协议</a>' + popBoxHtml1 + "</div>" + '<div class="protocol">' + '<a href="' + loginHttps + '/authAgreeMentPrivacy" target="_blank">国美平台隐私政策</a>' + popBoxHtml2 + "</div>" + '<div class="protocol">' + '<a href="' + loginHttps + '/authAgreeMentPay" target="_blank">美付宝服务协议</a>' + popBoxHtml3 + "</div>" + '<div class="popBoxBtn">' + '<a class="inpBtn">同意协议</a>' + "</div>" + "</div>" + "</div>" + '<div class="mask_lh dn" style="position:absolute; top:0; left:0; z-index:9998; width:100%; background:rgba(0, 0, 0, 0.15); opacity:0.3;opacity:0.3;filter:alpha(opacity=30); -moz-opacity:0.3;-khtml-opacity:0.3;height: 456px;">' + "</div>";
    var i = $("body").height(), p = $(window).width();
    $("body").append(e);
    $(".popBoxWrapper").show();
    $(".popBoxWrapper").css("top", "100px");
    $(".popBoxWrapper").css("left", p / 2 - 460 + "px");
    $(".mask_lh").css("height", i).show();
    $(".inpBtn").click(function () {
        $(".popBoxWrapper").remove();
        $(".mask_lh").remove()
    });
    $("#loginFrame").css({width: "892px"}, {left: "50%"}, {marginLeft: "-446px"}, {height: "628px"});
    $("#loginFrame .popBoxWrapper").css("left", "0")
};
var popBoxLogin = function () {
    var e = '<div class="popBoxWrapperLogin dn">' + '<a class="uc_closedLogin"></a>' + '<div class="uc_boxLogin">' + "<h5>服务协议</h5>" + "<p><b>【审慎阅读】 注册协议已更新，您在点击同意前，应当认真阅读以下协议，尤其粗体标识的重要条款。请您务必审慎阅读、充分理解协议中相关条款内容。</b></p>" + "<p><b>【特别提示】</b>当您点击同意后，即表示您已充分阅读、理解并接受协议的全部内容。如您因平台服务与国美发生争议的，适用《国美平台服务协议》处理。</p>" + '<div class="gomeLink">' + '<a href="' + loginHttps + '/authAgreeMent" target="_blank">《国美平台服务协议》</a>' + '<a href="' + loginHttps + '/authAgreeMentPrivacy" target="_blank">《国美平台隐私政策》</a>' + '<a href="' + loginHttps + '/authAgreeMentPay" target="_blank">《美付宝用户服务协议》</a>' + "</div>" + '<div class="popBoxBtnLogin">' + '<input class="inpBtn" type="button" value="同意协议"/>' + "</div>" + "</div>" + "</div>" + '<div class="mask_lh dn" style="position:fixed; top:0; left:0; z-index:9998; width:100%; background:#ccc; opacity:0.3;-moz-opacity :0.3; -khtml-opacity :0.3;filter:alpha(opacity=30);">' + "</div>";
    var i = $(window).height(), p = $(window).width();
    $("body").append(e);
    $(".popBoxWrapperLogin").show();
    $(".popBoxWrapperLogin").css("margin", "0 auto");
    $(".popBoxWrapperLogin").css("float", "none");
    $(".popBoxWrapperLogin").css("position", "relative");
    $(".mask_lh").css("height", i).show();
    $(".inpBtn,.uc_closedLogin").click(function () {
        $(".popBoxWrapperLogin").remove();
        $(".mask_lh").remove()
    })
};

function verifyCodeBlur() {
    timerchange(ele_verifyCode);
    $("#" + ele_verifyCode).removeClass(cls_focus);
    $("#" + ele_verifyCode).attr("verify", "false");
    var e = $.trim($("#" + ele_verifyCode).val());
    if (!e) {
        errorTip(msg_verifyCodeNotEmpty);
        return
    } else if (e.length != 6 || !e.match("^[0-9]{1,}$")) {
        errorTip(msg_verifyCodeNotError);
        return
    } else {
        allTipHide()
    }
    $("#timeSpanMsbbox").hide();
    $("#" + ele_verifyCode).attr("verify", "yes")
}

function checkMobileNumber(e) {
    var i = /^(13\d{9}|14\d{9}|15\d{9}|16\d{9}|17\d{9}|18\d{9}|19\d{9})$/;
    var e = $.trim(e);
    if (i.test(e)) {
        return true
    } else {
        return false
    }
}

function sendMobileActiveCode() {
    var e = $("#" + ele_phoneNum).val();
    var i = $("#codeCheck").val();
    var p = /^(13\d{9}|14\d{9}|15\d{9}|16\d{9}|17\d{9}|18\d{9}|19\d{9})$/;
    if (!checkMobileNumber(e)) {
        if ($("#" + ele_phoneNum).val() == "") {
            errorTip(msg_phoneEmpty)
        }
        return false
    }
    showCode("codeCheck");
    if (offSet == false) {
        return false
    }
    $.ajax({
        type: "post",
        url: contextPath + "/" + smsURL + "SendSMS.no",
        async: false,
        data: {phoneNum: e, captcha: i, captchaType: captchaGrade},
        success: function (e) {
            if (e.code == 3e3) {
                time_js()
            } else if (e.code == 5e3) {
                errorTip("短信发送已超过限制，请切换至");
                $("#err-tip .accountPassword").show()
            } else {
                if (e.code == 3005) {
                    errorTip(e.message);
                    return
                }
                errorTip(e.message)
            }
        },
        error: function (e) {
            errorTip(msg_phoneUse)
        }
    })
}

function showSuccessTips(e, i) {
    var p = "#err-tip p b";
    $(p).empty();
    p = "#" + i + "Div";
    if ($("#" + i + "Suc").length == 0) {
        $(p).append('<span id="' + i + 'Suc" class="' + cls_success + '"></span>')
    }
    p = "#" + i;
    $(p).removeClass(cls_err)
}

var preLogin = "";
preLogin = function () {
    return true
};

function hidePlay() {
    $(".play_icon a").each(function () {
        var e = $(this).index();
        if (e > 4) {
            $(".play_icon a").eq(e).addClass("hide")
        }
    })
}

function showPlay() {
    $(".play_icon a").each(function () {
        var e = $(this).index();
        if (e > 4) {
            $(".play_icon a").eq(e).removeClass("hide")
        }
    })
}

$(function () {
    $("#err-tip b").css({"font-weight": "normal"});
    hidePlay();
    $(".login-wrap .actions").css("letter-spacing", 0);
    $(".actions").on("click", ".captcha-title-right", function () {
        $(this).parent().parent().hide();
        $('input[name="dxCode"]').remove();
        dxCaptcha = null;
        $(".btnnuw").prop("disabled", false)
    });
    $(".more").click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
            hidePlay()
        } else {
            $(this).addClass("active");
            showPlay()
        }
    });
    $("#quikecaptcha,#nomalcaptcha").css({
        position: "absolute",
        zIndex: 9999,
        padding: "5px 10px 18px",
        background: "#fff",
        border: "1px solid #ccc",
        bottom: "110px",
        borderRadius: "5px",
        boxShadow: "0px 0px 1px 2px rgba(0,0,0,.1)"
    });
    $("#quikecaptcha").css("bottom", "90px");
    $(".detailContent a").bind("click", function () {
        popBoxLogin();
        $(".popBoxWrapperLogin").css({left: "0px", width: "460px", top: "98px"});
        $(".popBoxWrapperLogin").addClass("agreeBox")
    });
    autoLogin("autoLoginFlag", "autoLoginMode");
    $(".loginBoxClose").bind("click", function () {
        $(".login-box-wrap").remove()
    });
    // $(".select-segments").gclickshow({hbox: ".segmentslist"});
    hideTips();
    $("#tip_con").mouseover(function () {
        clearInterval(hideTimeOut)
    }).mouseout(function () {
        hideTips()
    });
    $("#tip_icon").bind("click", function () {
        clearInterval(hideTimeOut);
        $(".clear-btn").hide();
        if (!hideOp) {
            hideOp = true;
            $("#tip_con").stop(false, true).hide();
            $(".clear-btn").show()
        } else {
            hideOp = false;
            $("#tip_con").stop(false, true).show();
            $(".clear-btn").hide();
            hideTips()
        }
    });
    $("#tip_clo").bind("click", function () {
        $("#tip_con").stop(false, true).hide();
        hideOp = true
    });
    $("input[name='gomeOrCoo8']").bind("click", function () {
        hideOp = true;
        $("input[name='gomeOrCoo8']").each(function () {
            $(this).removeAttr("checked")
        });
        $(this).attr("checked", "checked");
        $("#tip_con").fadeOut(1e3);
        $(".clear-btn").show().fadeIn(1e3)
    });
    $("#" + ele_loginName).blur(function () {
        isShowConflictOrSnsTips()
    });
    $("#" + ele_loginName).keyup(function () {
        $("#gome-coo8-tips").hide()
    });
    $("#" + ele_loginName).focus(function () {
        $("#gome-coo8-tips").hide();
        handleFocus(ele_loginName)
    });
    $("#" + ele_loginPassword).focus(function () {
        focusPWInput()
    });
    $("#" + ele_loginPassword).blur(function () {
        blurPWInput()
    });
    $("#" + ele_phoneNum).focus(function () {
        handleFocus(ele_phoneNum)
    });
    $("#" + ele_phoneNum).blur(function () {
        $(this).removeClass(cls_focus);
        checkTelphone()
    });
    $("#getVerifyCode").click(function () {
        var e = $("#" + ele_phoneNum).val();
        $("#getVerifyCode").attr("isclick", "true");
        checkTelphone();
        sendMobileActiveCode()
    });
    $("#verifyCode").blur(verifyCodeBlur);
    $("#verifyCode").focus(function () {
        handleFocus("verifyCode")
    });
    $("#resendSpan").click(function () {
        $("#getVerifyCode").attr("isclick", "true");
        checkTelphone();
        sendMobileActiveCode()
    });
    moblieBarcode(true);
    $(".loginHead .loginTab").eq(0).find("a").addClass("cur");
    $(".loginBox .login-wrap").eq(0).show();
    $(".loginHead .loginTab").click(function () {
        var e = $(this).index();
        var i = $(".loginBox .login-wrap");
        $(".loginHead .loginTab a").removeClass("cur");
        $(this).find("a").addClass("cur");
        i.hide();
        i.eq(e).show();
        if (e == 0) {
            moblieBarcode(true)
        } else {
            moblieBarcode(false);
            if ($("#loginPassword").val() != "") {
                $("#loginPasswordDefault").hide()
            } else {
                $("#loginPasswordDefault").show()
            }
        }
    });
    $(".play_icon a").each(function () {
        var e = $(this).index();
        if (e > 4) {
            $(".play_icon a").eq(e).addClass("hide")
        }
    });
    clearBtnKeyUp(ele_loginName);
    clearBtnBind(ele_loginName);
    clearBtnKeyUp(ele_loginPassword);
    clearBtnBind(ele_loginPassword);
    $("#barcodeId .qrcode-Image").on("mouseenter", function () {
        $(this).stop().animate({left: "0px"}, function () {
            $(".qrcode-help").show()
        })
    }).off("mouseleave").on("mouseleave", function () {
        $(this).stop().animate({left: "75px"});
        $(".qrcode-help").hide()
    });
    $("#loginName").on("change", function () {
        if (openDingxiang == "true") {
            if (currentUser && currentUser !== $.trim($(this).val())) {
                currentUser = $.trim($(this).val());
                // $.cookie("passwrong", 0);
                $("#nomalcaptcha, #quikecaptcha").hide();
                $('input[name="dxCode"]').remove();
                // $.cookie("passwrong", null);
                dxCaptcha = null
            }
        }
    });
    $("#phoneNum").on("change", function () {
        if (openDingxiang == "true") {
            if (currentPhone && currentPhone !== $.trim($(this).val())) {
                currentUser = $.trim($(this).val());
                $("#nomalcaptcha, #quikecaptcha").hide();
                $('input[name="dxCode"]').remove();
                dxCaptcha = null
            }
        }
    });
    $(".phoneLoginBtn").on("click", function () {
        $("#quickeLoginForm").show();
        $("#frm").hide();
        $(".btnnuw").prop("disabled", false);
        $("#nomalcaptcha, #quikecaptcha").hide();
        $('input[name="dxCode"]').remove();
        dxCaptcha = null;
        $("input").removeClass("txt-error");
        isSubmit = true;
        allTipHide()
    });
    $(".accountLoginBtn").on("click", function () {
        $("#quickeLoginForm").hide();
        $("#frm").show();
        $(".btnnuw").prop("disabled", false);
        $("#nomalcaptcha, #quikecaptcha").hide();
        $('input[name="dxCode"]').remove();
        dxCaptcha = null;
        $("input").removeClass("txt-error");
        isSubmit = true;
        allTipHide()
    })
});