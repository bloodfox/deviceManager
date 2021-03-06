/*
 * My97 DatePicker Ver 4.0 Beta3
 * SITE: http://dp.my97.net
 * BLOG: http://blog.csdn.net/my97/
 * MAIL: smallcarrot@163.com
 */
var $dp, WdatePicker;
(function() {
	var $ = {

		/* Config Begin */
		$wdate : true,
		$dpPath : "",
		position : {},
		lang : "auto",
		skin : "default",
		dateFmt : "yyyy-MM-dd",
		realDateFmt : "yyyy-MM-dd",
		realTimeFmt : "HH:mm:ss",
		realFullFmt : "%Date %Time",
		minDate : "1900-01-01 00:00:00",
		maxDate : "2099-12-31 23:59:59",
		startDate : "",
		alwaysUseStartDate : false,
		yearOffset : 1911,
		isShowWeek : false,
		highLineWeekDay : true,
		isShowClear : true,
		isShowToday : true,
		isShowOthers : true,
		readOnly : false,
		errDealMode : 0,
		autoPickDate : null,
		qsEnabled : true,
		/* Config End */
		disabledDates : null,
		disabledDays : null,
		onpicking : null,
		onpicked : null,
		onclearing : null,
		oncleared : null,
		eCont : null,
		errMsg : "",
		quickSel : [],
		has : {}
	}, J = window, _ = "document", C = "getElementsByTagName", Q, A, H = navigator.product == "Gecko";
	Q = J;
	while (Q.parent[_] != Q[_] && Q.parent[_][C]("frameset").length == 0)
		Q = Q.parent;
	A = L();
	if ($.$wdate)
		K(A + "skin/WdatePicker.css");
	var P = (Q.$dp && Q.$dp.status == 3);
	if (!Q.$dp || P) {
		$dp = B( {
			ff : H,
			el : null,
			win : J,
			status : P ? 2 : 1,
			defMinDate : $.minDate,
			defMaxDate : $.maxDate,
			$ : function($) {
				return (typeof $ == "string") ? this.win[_].getElementById($)
						: $
			},
			$D : function($, _) {
				return this.$DV(this.$($).value, _)
			},
			$DV : function(_, $) {
				if (_ != "") {
					this.dt = $dp.cal.splitDate(_, $dp.cal.dateFmt);
					if ($) {
						for ( var A in $) {
							if (this.dt[A] === undefined)
								this.errMsg = "invalid property:" + A;
							this.dt[A] += $[A]
						}
						if (this.dt.refresh())
							return this.dt
					}
				}
				return ""
			},
			attachEvent : F
		});
		if (!P)
			F(J, "onload", function() {
				WdatePicker()
			})
	} else
		$dp = Q.$dp;
	if (!J[_].docMD) {
		F(J[_], "onmousedown", D);
		J[_].docMD = true
	}
	if (!Q[_].docMD) {
		F(Q[_], "onmousedown", D);
		Q[_].docMD = true
	}
	F(J, "onbeforeunload", function() {
		$dp.dd.style.display = "none";
		Q.$dp.status = 3
	});
	function B(_) {
		Q.$dp = Q.$dp || {};
		for ( var $ in _)
			Q.$dp[$] = _[$];
		return Q.$dp
	}
	function F(A, $, _) {
		if (H) {
			var B = $.replace(/on/, "");
			_._ieEmuEventHandler = function($) {
				return _($)
			};
			A.addEventListener(B, _._ieEmuEventHandler, false)
		} else
			A.attachEvent($, _)
	}
	function L() {
		var _, A, $ = document.getElementsByTagName("script");
		for ( var B = 0; B < $.length; B++) {
			_ = $[B].src.substring(0, $[B].src.toLowerCase().indexOf(
					"wdatepicker_href.js"));
			if (_)
				break
		}
		return _
	}
	function G(F) {
		var E, C;
		if (F.substring(0, 1) != "/" && F.indexOf("://") == -1) {
			E = Q.location.href;
			C = location.href;
			if (E.indexOf("?") > -1)
				E = E.substring(0, E.indexOf("?"));
			if (C.indexOf("?") > -1)
				C = C.substring(0, C.indexOf("?"));
			var _ = "", D = "", A = "", H, G, B = "";
			for (H = 0; H < Math.max(E.length, C.length); H++)
				if (E.charAt(H).toLowerCase() != C.charAt(H).toLowerCase()) {
					G = H;
					while (E.charAt(G) != "/") {
						if (G == 0)
							break;
						G -= 1
					}
					_ = E.substring(G + 1, E.length);
					_ = _.substring(0, _.lastIndexOf("/"));
					D = C.substring(G + 1, C.length);
					D = D.substring(0, D.lastIndexOf("/"));
					break
				}
			if (_ != "")
				for (H = 0; H < _.split("/").length; H++)
					B += "../";
			if (D != "")
				B += D + "/";
			F = B + F
		}
		$.$dpPath = F
	}
	function K(D, $, E) {
		var B = J[_], F = B[C]("HEAD").item(0), A = B.createElement("link");
		A.href = D;
		A.rel = "stylesheet";
		A.type = "text/css";
		if ($)
			A.title = $;
		if (E)
			A.charset = E;
		F.appendChild(A)
	}
	function M($, _) {
		$.onload = $.onreadystatechange = function() {
			if (this.readyState && this.readyState == "loading")
				return;
			_()
		}
	}
	function E($) {
		$ = $ || Q;
		var B = 0, A = 0;
		while ($ != Q) {
			var E = $.parent[_][C]("iframe");
			for ( var G = 0; G < E.length; G++) {
				try {
					if (E[G].contentWindow == $) {
						var F = I(E[G]);
						B += F.left;
						A += F.top;
						break
					}
				} catch (D) {
					continue
				}
			}
			$ = $.parent
		}
		return {
			"leftM" : B,
			"topM" : A
		}
	}
	function I(C) {
		if (H) {
			var E = null, _ = C.offsetTop, D = C.offsetLeft, B = C.offsetWidth, A = C.offsetHeight;
			while (C = C.offsetParent) {
				_ += C.offsetTop;
				D += C.offsetLeft;
				if (C.tagName.toLowerCase() == "body")
					E = C.ownerDocument.defaultView
			}
			var $ = N(E);
			D -= $.left;
			_ -= $.top;
			B += D;
			A += _;
			return {
				"left" : D,
				"top" : _,
				"right" : B,
				"bottom" : A
			}
		} else
			return C.getBoundingClientRect()
	}
	function O($) {
		$ = $ || Q;
		var A = $[_];
		A = A.documentElement && A.documentElement.clientHeight ? A.documentElement
				: A.body;
		return {
			"width" : A.clientWidth,
			"height" : A.clientHeight
		}
	}
	function N($) {
		$ = $ || Q;
		var A = $[_];
		A = (A.documentElement && !(A.documentElement.scrollTop == undefined || A.documentElement.scrollTop == 0)) ? A.documentElement
				: A.body;
		return {
			"top" : A.scrollTop,
			"left" : A.scrollLeft
		}
	}
	function D(_) {
		src = _ ? (_.srcElement || _.target) : null;
		if ($dp && $dp.dd && $dp.dd.style.display == "block" && src != $dp.el) {
			var A = $dp.el, B = $dp.cal, $ = $dp.el[$dp.elProp];
			if ($) {
				$dp.$w.hideSel();
				if ($ != "" && !$dp.readOnly)
					B.date.loadFromDate(B.splitDate($, B.dateFmt));
				if ($ == ""
						|| (B.isDate(B.date) && B.isTime(B.date) && B
								.checkValid(B.date))) {
					B.mark(true);
					if ($ != "")
						B.update();
					else
						A.setAttribute("realValue", "");
					$dp.dd.style.display = "none"
				} else
					B.mark(false)
			} else
				$dp.dd.style.display = "none"
		}
	}
	WdatePicker = function(P) {
		$dp.win = J;
		P = P || {};
		if (!$dp.dd || P.eCont) {
			if (P.eCont) {
				P.eCont = $dp.$(P.eCont);
				P.autoPickDate = true;
				P.qsEnabled = false
			}
			P.el = {
				innerHTML : ""
			}
		} else {
			//if ($dp.status != 2)
				//return;
			var L, K = B();
			if (K) {
				L = K.srcElement || K.target;
				K.cancelBubble = true
			}
			P.el = $dp.$(P.el || L);
			if (!P.el
					|| P.el
					&& P.el.disabled
					|| (P.el == $dp.el && $dp.dd.style.display != "none" && $dp.dd.style.left != "-1970px"))
				return
		}
		for ( var F in $)
			if (F.substring(0, 1) != "$")
				$dp[F] = $[F];
		for (F in P)
			if ($dp[F] === undefined)
				$dp.errMsg = "invalid property:" + F;
			else
				$dp[F] = P[F];
		$dp.elProp = $dp.el && $dp.el.nodeName == "INPUT" ? "value"
				: "innerHTML";
		if ($dp.el[$dp.elProp] == null)
			return;
		if ($dp.lang == "auto")
			$dp.lang = H ? navigator.language.toLowerCase()
					: navigator.browserLanguage.toLowerCase();
		if (!$dp.dd || $dp.eCont
				|| ($dp.lang && $dp.realLang && $dp.realLang.name != $dp.lang)) {
			if ($dp.dd)
				J[_].body.removeChild($dp.dd);
			if ($.$dpPath == "")
				G(A);
			var C = "<iframe src=\""
					+ $.$dpPath
					+ "My97DatePicker.htm\" frameborder=\"0\" border=\"0\" scrolling=\"no\"></iframe>";
			if ($dp.eCont)
				$dp.eCont.innerHTML = C;
			else {
				$dp.dd = Q[_].createElement("DIV");
				$dp.dd.style.cssText = "position:absolute;z-index:19700";
				$dp.dd.innerHTML = C;
				Q[_].body.appendChild($dp.dd);
				var R = $dp.dd.childNodes[0];
				M(R, function() {
					$dp.status = 2
				});
				if (!$dp.realLang) {
					$dp.dd.style.top = $dp.dd.style.left = "-1970px";
					return
				} else {
					$dp.dd.style.display = "block";
					M(R, D)
				}
			}
		} else if ($dp.cal) {
			$dp.dd.style.display = "block";
			$dp.cal.init();
			D()
		}
		function D() {
			var F = $dp.position.left, B = $dp.position.top, G = I($dp.el), $ = E(J), C = O(Q), A = N(Q), D = $dp.dd.offsetHeight, _ = $dp.dd.offsetWidth;
			if (isNaN(B)) {
				if (B == "above"
						|| (B != "under" && (($.topM + G.bottom + D > C.height) && ($.topM
								+ G.top - D > 0))))
					B = A.top + $.topM + G.top - D - 3;
				else
					B = A.top + $.topM + G.bottom;
				B += H ? 1 : -1
			} else
				B += A.top + $.topM;
			if (isNaN(F))
				F = A.left + Math.min($.leftM + G.left, C.width - _ - 5)
						- (H ? 0 : 2);
			else
				F += A.left + $.leftM;
			$dp.dd.style.top = B + "px";
			$dp.dd.style.left = F + "px"
		}
		function B() {
			if (H) {
				func = B.caller;
				while (func != null) {
					var $ = func.arguments[0];
					if ($ && ($ + "").indexOf("Event") >= 0)
						return $;
					func = func.caller
				}
				return null
			}
			return event
		}
	}
})()