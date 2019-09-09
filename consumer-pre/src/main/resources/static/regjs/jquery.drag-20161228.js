/* 
 * drag 2.0
 * create by gwh
 * date 2016-09-07
 * 拖动滑块
 */
;(function ($,window,document,undefined) {
    function Drag(elm, options, success){
        var me = this;
        var $elm = me.checkElm(elm) ? $(elm) : $;
        success = me.checkFn(success) ? success : function(){};

        var opts = {
            successLabelTip:  "Successfully Verified",
            duration:  200,
            swipestart:  false,
            min:  0,
            max:  $elm.width(),
            index:  0,
            IsOk:  false,
            lableIndex:  0
        };

        opts = $.extend(opts, options||{});

        //$elm
        me.elm = $elm;
        //opts
        me.opts = opts;
        //是否开始滑动
        me.swipestart = opts.swipestart;
        //最小值
        me.min = opts.min;
        //最大值
        me.max = opts.max;
        //当前滑动条所处的位置
        me.index = opts.index;
        //是否滑动成功
        me.isOk = opts.isOk;
        //滑块宽度
        me.labelWidth = me.elm.find('#label').width();
        //滑块背景
        me.sliderBg = me.elm.find('#slider_bg');
        //鼠标在滑动按钮的位置
        me.lableIndex = opts.lableIndex;
        //success
        me.success = success;
    }

    Drag.prototype.init = function () {
        var me = this;

        me.updateView();
        me.elm.find("#label").on("mousedown", function (event) {
            var e = event || window.event;
            me.lableIndex = e.clientX - this.offsetLeft;
            me.handerIn();
        }).on("mousemove", function (event) {
            me.handerMove(event);
        }).on("mouseup", function (event) {
            me.handerOut();
        }).on("mouseout", function (event) {
            me.handerOut();
        }).on("touchstart", function (event) {
            var e = event || window.event;
            me.lableIndex = e.originalEvent.touches[0].pageX - this.offsetLeft;
            me.handerIn();
        }).on("touchmove", function (event) {
            me.handerMove(event, "mobile");
        }).on("touchend", function (event) {
            me.handerOut();
        });
    };

    /**
     * 鼠标/手指接触滑动按钮
     */
    Drag.prototype.handerIn = function () {
        var me = this;
        me.swipestart = true;
        me.min = 0;
        me.max = me.elm.width();
    };

    /**
     * 鼠标/手指移出
     */
    Drag.prototype.handerOut = function () {
        var me = this;
        //停止
        me.swipestart = false;
        //me.move();
        if (me.index < me.max) {
            me.reset();
        }
    };

    /**
     * 鼠标/手指移动
     * @param event
     * @param type
     */
    Drag.prototype.handerMove = function (event, type) {
        var me = this;
        if (me.swipestart) {
            event.preventDefault();
            event = event || window.event;
            if (type == "mobile") {
                me.index = event.originalEvent.touches[0].pageX - me.lableIndex;
            } else {
                me.index = event.clientX - me.lableIndex;
            }
            me.move();
        }
    };

    /**
     * 鼠标/手指移动过程
     */
    Drag.prototype.move = function () {
        var me = this;
        if ((me.index + me.labelWidth) >= me.max) {
            me.index = me.max - me.labelWidth -2;
            //停止
            me.swipestart = false;
            //解锁
            me.isOk = true;
        }
        if (me.index < 0) {
            me.index = me.min;
            //未解锁
            me.isOk = false;
        }
        if (me.index+me.labelWidth+2 == me.max && me.max > 0 && me.isOk) {
            //解锁默认操作,此处默认打勾，根据要求换样式
            $('#label').unbind().html("").addClass("pass").next('#labelTip').
            text(me.opts.successLabelTip).css({'color': '#5e5e5e'});

            me.success();
        }
        me.updateView();
    };


    /**
     * 更新视图
     */
    Drag.prototype.updateView = function () {
        var me = this;

        me.sliderBg.css('width', me.index);
        me.elm.find("#label").css("left", me.index + "px")
    };

    /**
     * 重置slide的起点
     */
    Drag.prototype.reset = function () {
        var me = this;

        me.index = 0;
        me.sliderBg .animate({'width':0},me.opts.duration);
        me.elm.find("#label").removeClass("pass").text(">>").animate({left: me.index}, me.opts.duration)
            .next("#lableTip").animate({opacity: 1}, me.opts.duration);
        me.updateView();
    };

    /**
     * 检测元素是否存在
     * @param elm
     * @returns {boolean}
     */
    Drag.prototype.checkElm = function (elm) {
        if($(elm).length > 0){
            return true;
        }else{
            throw "this element does not exist.";
        }
    };

    /**
     * 检测传入参数是否是function
     * @param fn
     * @returns {boolean}
     */
    Drag.prototype.checkFn = function (fn) {
        if(typeof fn === "function"){
            return true;
        }else{
            throw "the param is not a function.";
        }
    };

    window['Drag'] = Drag;
})(jQuery, window, document);
