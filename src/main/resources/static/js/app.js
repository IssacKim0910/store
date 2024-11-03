// 모바일 에이전트 구분



var isMobile = {
  Android: function() {
    return navigator.userAgent.match(/Android|AOS|webview/i) == null ? false : true;
  },
  iOS: function() {
    return navigator.userAgent.match(/iPhone|iPad|iPod|iOS/i) == null ? false : true;
  },
  any: function() {
    return (isMobile.Android() || isMobile.iOS());
  }
};


// window.webview.setLogin('id');
// webkit.messageHandlers.setLogin.postMessage('id');




/*
function getToken() {

  if (isMobile.any()) {
    if (isMobile.Android()) {
      alert('AOS');

      var token = window.webview.getToken();
      alert(token);

    } else if (isMobile.iOS()) {
      alert('iOS');
      webkit.messageHandlers.getToken.postMessage(1); // 값이 빌 경우 앱 호출 안 됨
    }
  }

}


// iOS 정보 받는 부분
function getTokenIOS(str){
    alert(str);
}
*/

function actionCancel() {

      if (isMobile.any()) {
        if (isMobile.Android()) {
          window.webview.actionCancel();
        } else if (isMobile.iOS()) {
          webkit.messageHandlers.actionCancel.postMessage(1); // 값이 빌 경우 앱 호출 안 됨
        }
      }

}


function checkPermission() {

    if (isMobile.any()) {
      if (isMobile.Android()) {
        window.webview.checkPermission();
      } else if (isMobile.iOS()) {
        webkit.messageHandlers.checkPermission.postMessage(1); // 값이 빌 경우 앱 호출 안 됨
      }
    }

}


function moveToUrl(url) {
  if (isMobile.any()) {
    if (isMobile.Android()) {
      window.webview.moveToUrl('https://cafe.naver.com/pistore');
    } else if (isMobile.iOS()) {
      webkit.messageHandlers.moveToUrl.postMessage('https://cafe.naver.com/pistore'); // 값이 빌 경우 앱 호출 안 됨
    }
  }

}

function actionBack() {
    if (isMobile.any()) {
      if (isMobile.Android()) {
    window.webview.actionBack();
      } else if (isMobile.iOS()) {
        webkit.messageHandlers.actionBack.postMessage(1); // 값이 빌 경우 앱 호출 안 됨
      }
    }
}

function sharedUrl(URL) {

  if (isMobile.any()) {
    if (isMobile.Android()) {
    window.webview.sharedUrl(URL);
    } else if (isMobile.iOS()) {
      webkit.messageHandlers.sharedUrl.postMessage(URL); // 값이 빌 경우 앱 호출 안 됨
    }
  }

}

// 로그아웃, 비회원시 빈값 전달 => window.webview.setLogin('');
function setLogin() {
    if (isMobile.any()) {
      if (isMobile.Android()) {
        window.webview.setLogin('test@test.com');
      } else if (isMobile.iOS()) {
        webkit.messageHandlers.setLogin.postMessage('test@test.com'); // 값이 빌 경우 앱 호출 안 됨
      }
    }
}
