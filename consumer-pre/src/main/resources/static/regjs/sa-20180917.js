;
/*! Mon Jul 01 2019 08:59:18 GMT+0800 (CST) */
!function (e) {
    var o = {};

    function t(n) {
        if (o[n]) return o[n].exports;
        var r = o[n] = {i: n, l: !1, exports: {}};
        return e[n].call(r.exports, r, r.exports, t), r.l = !0, r.exports
    }

    t.m = e, t.c = o, t.d = function (e, o, n) {
        t.o(e, o) || Object.defineProperty(e, o, {enumerable: !0, get: n})
    }, t.r = function (e) {
        "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(e, "__esModule", {value: !0})
    }, t.t = function (e, o) {
        if (1 & o && (e = t(e)), 8 & o) return e;
        if (4 & o && "object" == typeof e && e && e.__esModule) return e;
        var n = Object.create(null);
        if (t.r(n), Object.defineProperty(n, "default", {
                enumerable: !0,
                value: e
            }), 2 & o && "string" != typeof e) for (var r in e) t.d(n, r, function (o) {
            return e[o]
        }.bind(null, r));
        return n
    }, t.n = function (e) {
        var o = e && e.__esModule ? function () {
            return e["default"]
        } : function () {
            return e
        };
        return t.d(o, "a", o), o
    }, t.o = function (e, o) {
        return Object.prototype.hasOwnProperty.call(e, o)
    }, t.p = "", t(t.s = 0)
}([function (e, o, t) {
    var n = t(1);
    try {
        var r = "", c = /([?&])cmpid=(.+?)(&(.+))?(#.*)?$/;
        r = (q = window.location.href.match(c)) && q[2] || "";
        var a = "https://report.gome.com.cn/sa?project=production", d = !1,
            i = navigator.userAgent.match(/(gome(plus|backup)|GomeSeller)?\/[iphone\/]{0,7}(\d*)\//);
        d = 126 != +(i ? i[3] : -1)
    } catch (H) {
        console.log(H)
    }
    !function (e) {
        var o = e.sdk_url, t = e.name, n = window, r = document, c = "script", a = null, d = null;
        n.sensorsDataAnalytic201505 = t, n[t] = n[t] || function (e) {
            return function () {
                (n[t]._q = n[t]._q || []).push([e, arguments])
            }
        };
        for (var i = ["track", "quick", "register", "registerPage", "registerOnce", "trackSignup", "trackAbtest", "setProfile", "setOnceProfile", "appendProfile", "incrementProfile", "deleteProfile", "unsetProfile", "identify", "login", "logout", "trackLink", "clearAllRegister", "getAppStatus"], m = 0; m < i.length; m++) n[t][i[m]] = n[t].call(null, i[m]);
        n[t]._t || (a = r.createElement(c), d = r.getElementsByTagName(c)[0], a.async = 1, a.src = o, a.setAttribute("charset", "UTF-8"), d.parentNode.insertBefore(a, d), n[t].para = e)
    }({
        sdk_url: "https://js.gomein.net.cn/sitemonitor/tjs/sensorsdata/sensorsdata.min.js",
        heatmap_url: "https://js.gomein.net.cn/sitemonitor/tjs/sensorsdata/heatmap.min.js",
        name: "GomeSa",
        server_url: a,
        use_app_track: d,
        show_log: !1,
        heatmap: {
            custom_property: function (e) {
                if (e.getAttribute("data-code")) return {data_code: e.getAttribute("data-code")}
            }, setContent: function (e) {
                return e.getAttribute("data-code") ? e.getAttribute("data-code") : "没有data-code"
            }
        },
        source_channel: ["cmpid"]
    });
    try {
        var m, u, l = function (e) {
                var o, t = new RegExp("(^| )" + e + "=([^;]*)(;|$)");
                return (o = document.cookie.match(t)) ? decodeURIComponent(o[2]) : null
            }, s = null, w = (r = null, null), h = null, p = null, k = null, g = null, f = null, b = null, _ = null,
            y = window.location.host, v = [{key: "dc-bi", rule: /^(.+\.)*cb\.ds\.gome\.com\.cn/}, {
                key: "dc-big",
                rule: /^(.+\.)*bigdata\.ds\.gome\.com\.cn/
            }, {key: "dc-2", rule: /^(.+\.)*m\.gome\.com\.cn/}, {key: "dc-6", rule: /^(.+\.)*gomehigo\.hk/}, {
                key: "dc-10",
                rule: /^(.+\.)*diy\.gome\.com\.cn/
            }, {key: "dc-12", rule: /^(.+\.)*m\.gomehigo\.hk/}, {key: "dc-13", rule: /^(.+\.)*gomegj\.com/}, {
                key: "dc-14",
                rule: /^(.+\.)*wap\.gomegj\.com/
            }, {key: "dc-25", rule: /^(.+\.)*gomehome\.com/}, {key: "dc-26", rule: /^(.+\.)*gomeart\.com/}, {
                key: "dc-1",
                rule: /^(.+\.)*gome\.com\.cn/
            }, {key: "dc-7", rule: /^(.+\.)*atguat\.com\.cn/}];
        !function () {
            var e = document.getElementById("application-site");
            if (!(s = e && e.getAttribute("tid"))) for (var o = 0, t = v.length; o < t; o++) if (v[o].rule.exec(y)) return s = v[o].key;
            s = s || "未知站点"
        }();
        var q, S = l("sensorsdata2015jssdkcross"), j = (S ? JSON.parse(S) : {}).props, P = j && j._latest_cmpid;
        if (r = (q = decodeURIComponent(window.location.href).match(c)) && q[2] || null) ; else if (window.document.referrer) {
            for (var O = -1, U = 0, x = n.seoUrls.length; U < x; U++) {
                var R = n.seoUrls[U], A = new RegExp(R.h), I = decodeURIComponent(window.document.referrer).match(A);
                if (I) {
                    h = I[0], O = U;
                    break
                }
            }
            ~O ? (p = "weizhi", r = "".concat(w = "seo", "_").concat(h, "_").concat(p), GomeSa.register({_latest_cmpid: r})) : r = P ? decodeURIComponent(P) : P
        } else r = P ? decodeURIComponent(P) : P;
        if (r) {
            var G = r.split("_");
            w = G[0], h = G[1], p = G[2]
        }
        var C = window.location.href.match(/([?&])intcmp=(.+?)(&(.+))?(#.*)?$/);
        if ((k = C && C[2]) && "undefined" !== k) {
            var E = k.split("-");
            f = E[0], g = E[1] + "-" + E[2], b = E[1], _ = E[2]
        }
        var $ = window.location.href.match(/([?&])search_id=(.+?)(&(.+))?(#.*)?$/);
        m = $ && $[2];
        var N = window.location.href.match(/([?&])mid=(.+?)(&(.+))?(#.*)?$/) || window.location.href.match(/([?/])mshop-(.+?)(&(.+))?(#.*)?(\..*)?$/),
            M = N && N[2], z = l("__gmwsid"), T = l("DNY_USER_ID"), D = l("share_userId"), B = l("punionid");
        GomeSa.registerPage({
            tid: s,
            $url: decodeURIComponent(window.location.href),
            $referrer: decodeURIComponent(document.referrer),
            cmpid: r,
            intcmp: k,
            url_data_code: g,
            now_page: f,
            module_id: b,
            position: _,
            first_channel: w,
            second_channel: h,
            third_channel: p,
            mshop_id: M,
            unionid: z,
            sharer_userid: D,
            sharer_unionid: B,
            userid: T
        }), (u = l("SSO_USER_ID")) && GomeSa.login(u), GomeSa.quick("autoTrack", {search_id: m}), GomeSa.setProfile({_latest_cmpid: r}), document.onclick = function (e) {
            var o = (e = e || window.e).target || e.srcElement, t = o.parentNode;
            ~o.className.indexOf("submit_element") ? GomeSa.quick("trackHeatMap", o) : ~t.className.indexOf("submit_element") && GomeSa.quick("trackHeatMap", t)
        }
    } catch (H) {
        console.log(H)
    }
}, function (e, o) {
    e.exports = {
        seoUrls: [{h: "www.baidu.com", k: ["word", "wd"]}, {h: "www.so.com", k: ["m"]}, {
            h: "m.baidu.com",
            k: ["word", "wd"]
        }, {h: "www.sogou.com", k: ["query"]}, {h: "m.so.com", k: ["m"]}, {
            h: "cn.bing.com",
            k: ["q"]
        }, {h: "m.sogou.com", k: ["keyword"]}, {h: "so.m.sm.cn", k: ["q"]}, {
            h: "wap.sogou.com",
            k: ["keyword"]
        }, {h: "yz.m.sm.cn", k: ["q"]}, {h: "www.bing.com", k: ["q"]}, {h: "m.sm.cn", k: ["q"]}, {
            h: "m.yz.sm.cn",
            k: ["q"]
        }, {h: "m.sp.sm.cn", k: ["q"]}, {h: "search.yahoo.com", k: ""}, {
            h: "www.haosou.com",
            k: ["q"]
        }, {h: "3g.baidu.com", k: ["word", "wd"]}, {h: "www.google-cn.net", k: ["q"]}, {
            h: "baidu.mobi",
            k: ["word"]
        }, {h: "wap.baidu.com.cn", k: ["word"]}, {h: "wap.baidu.com", k: ["word", "wd"]}, {
            h: "m.haosou.com",
            k: ["q"]
        }, {h: "so.com", k: ["m"]}, {h: "m.sj.sm.cn", k: ["q"]}, {h: "m.sa.sm.cn", k: ["q"]}, {
            h: "m.xm.sm.cn",
            k: ["q"]
        }, {h: "www.youdao.com", k: ["q"]}, {h: "m.youdao.com", k: ["q"]}, {
            h: "www1.baidu.com",
            k: ["word", "wd"]
        }, {h: "www5.baidu.com", k: ["word", "wd"]}, {h: "baidu.cn", k: ["word", "wd"]}, {
            h: "m.baidu.cn",
            k: ["word", "wd"]
        }, {h: "m1.baidu.com", k: ["word", "wd"]}, {h: "m3.baidu.com", k: ["word", "wd"]}, {
            h: "m5.baidu.com",
            k: ["word", "wd"]
        }, {h: "m9.baidu.com", k: ["word", "wd"]}, {h: "3g.baidu.cn", k: ["word", "wd"]}, {
            h: "wap.baidu.cn",
            k: ["word", "wd"]
        }, {h: "bzclk.baidu.com", k: ["word", "wd"]}, {
            h: "baidu.com",
            k: ["word", "wd"]
        }, {h: "(www.)?google(.com?)?(.[a-z]{2})?", k: ["q"]}]
    }
}]);