/*
** 입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4~10), 영문자,숫자 로만 구성
// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Password2: 재입력후 Password 와 일치성 확인
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
// Jno : select 를 이용 (X)
// Info : (X) */

"use strict";

// 1) ID: 길이(4~10), 영문자,숫자 로만 구성
function idCheck() {
    let id = document.getElementById('id').value;

    if (id.length < 4 || id.length > 10) {
        document.getElementById('iMessage').innerHTML = 'id 는 4~10 글자 입니다.';
        return false;

    } else if (id.replace(/[a-z.0-9]/gi, '').length > 0) {
        // 영문과 숫자로만 입력했는지 : id 에서 영문과 숫자를 모두 ''(없음)으로 변경하면 length = 0 이 됨

        document.getElementById('iMessage').innerHTML = 'id 는 영문과 숫자만 입력하세요.';
        return false;

    } else {
        document.getElementById('iMessage').innerHTML = '';
        return true;

    }

}

// 2) Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
function pwCheck() {
    let pw = document.getElementById('password').value;

    if (pw.length >= 4 && pw.length <= 10) {

        if (pw.replace(/[0-9.a-z.가-힣]/gi, '').length > 0) {   // 특수문자 포함 여부 확인

            if (pw.replace(/[0-9.a-z.!-/]/gi, '').length > 0) { // 한글 포함 여부 확인
                document.getElementById('pMessage').innerHTML = '영문, 숫자, 특수문자로 구성해야합니다.';
                return false;

            } else {
                document.getElementById('pMessage').innerHTML = '';
                return true;

            }
        } else {
            document.getElementById('pMessage').innerHTML = '특수문자를 반드시 1개 이상 포함해야 합니다.';
            return false;

        }
    } else {
        document.getElementById('pMessage').innerHTML = '길이는 4 ~ 10 입니다.';
        return false;
    }
}

// 3) Password2: 재입력후 Password 와 일치성 확인
function pw2Check() {
    let pw2 = document.getElementById('password2').value;

    if (pw2 == document.getElementById('password').value) {
        document.getElementById('p2Message').innerHTML = '';
        return true;

    } else {
        document.getElementById('p2Message').innerHTML = '비밀번호가 일치하지 않습니다.';
        return false;
    }
}

// 4) Name : 길이(2이상), 영문 또는 한글로 만 입력
function nameCheck() {
    let name = document.getElementById('name').value;

    if (name.length < 2) {
        document.getElementById('nMessage').innerHTML = '이름은 2글자 이상 입력해야 합니다.';
        return false;

    } else if (name.replace(/[a-z.가-힣]/gi, '').length > 0) {
        document.getElementById('nMessage').innerHTML = '이름은 영문 또는 한글만 입력해야 합니다.';
        return false;

    } else {
        document.getElementById('nMessage').innerHTML = '';
        return true;
    }
}

// 5) Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )
function ageCheck() {
    let age = document.getElementById('age').value;

    if (age == '') {
        document.getElementById('aMessage').innerHTML = '나이를 입력해야 합니다.';
        return false;

    } else if (age.replace(/[0-9]/g, '').length > 0) {
        document.getElementById('aMessage').innerHTML = '숫자만 입력해야 합니다.';
        return false;

    } else {
        document.getElementById('aMessage').innerHTML = '';
        return true;
    }

    //     /*  Number.inInteger(n): 정수확인가능 (n 이 정수일때만 true)
    //         단, n 이 숫자타입이어야함
    //         아래처럼 value 는 문자로 인식하기때문에 숫자화_parseInt 가 필요함. 
    //         단, parseInt(age) 사용시 주의
    //         - 실수 입력시 정수로 바뀌어 처리됨
    //         - 문자가 포함된 숫자도 앞쪽의 숫자값만 가져와 정수 return */
    //     if (age == '') {
    //         document.getElementById('aMessage').innerHTML = '나이를 입력해야 합니다.';
    //         return false;

    //     } else if (age.replace(/[^0-9]/g, '').length < age.length) {
    //         // ^ = not
    //         document.getElementById('aMessage').innerHTML = '숫자만 입력해야 합니다.';
    //         return false;

    //     } else {
    //         document.getElementById('aMessage').innerHTML = '';
    //         return true;
    //     }
}

// 6) BirthDay : 입력 여부 확인  ( length == 10 )
function bdCheck() {
    let bd = document.getElementById('birthday').value;

    if (bd.length == 10) {
        document.getElementById('bMessage').innerHTML = '';
        return true;

    } else {
        document.getElementById('bMessage').innerHTML = '다시 확인하세요.';
        return false;
    }
}

// 7) Point : 정수 또는 실수 허용 ( 구간설정 100 ~ 10000 까지만 가능 )
function poCheck() {
    let po = document.getElementById('point').value;

    if (po == '') {
        document.getElementById('oMessage').innerHTML = '포인트를 입력하세요.';
        return false;

    } else if (po < 100 || po > 10000) {
        document.getElementById('oMessage').innerHTML = '100 부터 10000 까지만 가능합니다.';
        return false;

    } else {
        if (po.replace(/[0-9./.]/g, '').length > 0) {
            // 0 에서 9 + '.' = [0-9./.]
            document.getElementById('oMessage').innerHTML = '정수 또는 실수만 입력하세요.';
            return false;

        } else {
            document.getElementById('oMessage').innerHTML = '';
            return true;
        }
    }


    // /* parseFloat(point)
    //     -> 오류 또는 입력값이 없는 경우 NaN return
    //     -> 확인 : Number.isNaN(parseFloat(point)) 
    //     -> 단, 숫자로 시작하면 뒤쪽에 문자가 섞여있어도 숫자값만 사용함 ( NaN 을 return 하지않음 )  */
    // if (po.replace(/[^0-9./.]/g, '').length < po.length || Number.isNaN(parseFloat(po))) {
    //     // 소수점이 있으면 포함시켜야 하므로 정규식에 추가 / 소수점이 기호가 아니라 비교값이므로 "/." 식으로 표기함
    //     // 숫자가 아닌 값이 있는지 확인 & Number.isNaN 적용
    //     document.getElementById('oMessage').innerHTML = 'point는 정수 또는 실수로 입력하세요';
    //     return false;

    // } else if (parseInt(po) < 100 || parseInt(po) > 10000) {
    //     document.getElementById('oMessage').innerHTML = 'point 값이 범위(100 ~ 10000)를 벗어납니다.';
    //     return false;

    // } else {
    //     document.getElementById('oMessage').innerHTML = '';
    //     return true;
    // }
}