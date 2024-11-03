$OBJ = {
	'win' : $(window),
	'doc' : $(document),
	'html' : $('html')
}

function winW(){//창 너비
	return $OBJ.win.width();
}

function winH(){// 창 높이
	return $OBJ.win.height();
}

function winSh(){// 스크롤 값
	return $OBJ.win.scrollTop();
}

//calc(var(--vh, 1vh) * 100)
var vh = window.innerHeight * 0.01;
var vw = window.innerWidth * 0.01;
document.documentElement.style.setProperty('--vh', `${vh}px`);
document.documentElement.style.setProperty('--vw', `${vw}px`);
window.addEventListener('resize', () => {
	var vh = window.innerHeight * 0.01;
	var vw = window.innerWidth * 0.01;
	document.documentElement.style.setProperty('--vh', `${vh}px`);
	document.documentElement.style.setProperty('--vw', `${vw}px`);
});

function mChk(){// 모바일 체크
	return $('#mchk').is(':visible');
}

var head = {
	init : function(){
		this.action();
	},
	action : function(){
		var a = $('#header');

		a.on('click','.sch',function(){
			$OBJ.html.toggleClass('schOn');
			$OBJ.html.removeClass('gnbOn');
		});

		a.on('click','.mnu',function(){
			$OBJ.html.toggleClass('gnbOn');
			$OBJ.html.removeClass('schOn');
		});

	}
}


var gotop = {
	init : function(){
		this.action();
	},
	action : function(){
		var a = $('#gotop');

		function goTopShow(){
			if(winSh() > 60){
				a.addClass('show');
				$OBJ.html.addClass('snbFix');
			}else{
				a.removeClass('show');
				$OBJ.html.removeClass('snbFix');
			}
		}
		function goTopShow2(){
			if(winSh() > 70){
				$OBJ.html.addClass('snbFix2');
			}else{
				$OBJ.html.removeClass('snbFix2');
			}
		}

		a.on('click',function(){
			$.scrollTo($OBJ.html,300);
		});

		$OBJ.win.on('load scroll',function(){
			goTopShow();
			goTopShow2();
		});

	}
}


var navi = {
	init : function(){
		if($('#navi').length > 0){
			this.action();
		}
	},
	action : function(){
		var a = $('#navi');
		a.on('click','span',function(){
			$(this).closest('li').toggleClass('active').siblings().removeClass('active');
		});
	}
}

var popup = {
	init : function(){
		if($('.__popLayer').length > 0){
			this.action();
		}
	},
	action : function(){
		var a = $('.__popLayer');
		var close = a.find('.close');

		a.draggable();


		close.on('click',function(){
			par.hide();
		});

	}
}


var mtit = {
	init : function(){
		if($('.mobiletitle').length > 0){
			this.action();
		}
	},
	action : function(){
		$('#header h2').html($('.mobiletitle').text());
	}
}

var tab = {
	init : function(){
		if($('._tab').length > 0){
			this.action();
		}
	},
	action : function(){
		$('._tab > *').on('click',function(){
			$(this).addClass('active').siblings().removeClass('active');
			$('._box').eq($(this).index()).addClass('active').siblings().removeClass('active');
			return false;
		});
	}
};
$OBJ.doc.ready(function(){
	head.init();
	gotop.init();
	navi.init();
	popup.init();
	mtit.init();
	tab.init();
});

$OBJ.win.on('load',function(){
	AOS.init({
		duration:1000,
		offset: 20
	});
});