const logo = document.querySelector("#logo");
logo.addEventListener('click', ()=>{
    location.href="/";
});

// 이용약관 체크박스 이벤트
const agree1 = document.querySelector("#agree1");

// 이용약관 체크박스 이벤트
const agree2 = document.querySelector("#agree2");

//개인정보 수집 동의
const okagree = document.querySelector("#okagree");
okagree?.addEventListener('click', ()=>{
    if (!agree1.checked) {alert("이용약관에 동의를 체크하세요")}
    else if (!agree2.checked) {alert("개인정보 수집에 동의를 체크하세요")}
    else {location.href="/join/checkme";}
})

//개인정보 수집 미동의
const noagree = document.querySelector("#noagree");
noagree?.addEventListener('click', ()=>{
    location.href="/";
});

//---------------------------------------------------

// 실명확인
const checkfrm2 = document.forms.checkfrm2;
const chkbtn2 = document.querySelector("#check2btn")
chkbtn2?.addEventListener('click',()=>{
    if(checkfrm2.name.value === ''){alert("이름을 입력하세요")}
    else if(checkfrm2.jumin1.value === ''){alert("생년월일을 입력하세요")}
    else if(checkfrm2.jumin2.value === ''){alert("주민번호 뒷자리를 입력하세요")}
    else if(!checkfrm2.chkjumin.checked){alert("동의에 체크해주세요")}
    else {
        checkfrm2.method = 'post';
        checkfrm2.action = "/join/joinme";
        checkfrm2.submit();
    }

})

// -------------------------------------------------------

const jnfrm = document.forms.joinfrm;
const zipbtn = document.querySelector("#findzipbtn")
const dong = document.querySelector("#dong")
const addrlist = document.querySelector("#addrlist")
const joinbtn = document.querySelector("#joinbtn")
const sendzip = document.querySelector("#sendzip")
const zipmodal = document.querySelector("#zipmodal")
const email3 = document.querySelector("#email3")
const zipmdbtn = document.querySelector("#zipmdbtn");
const uidmsg = document.querySelector("#uidmsg");
const pwdmsg = document.querySelector("#pwdmsg1");
const userid = document.querySelector("#userid");
const repasswd = document.querySelector("#repasswd");




joinbtn?.addEventListener('click',()=>{
    if(jnfrm.userid.value === ''){alert("아이디를 입력하세요")}
    else if(jnfrm.passwd.value === ''){alert("비밀번호를 입력하세요")}
    else if(jnfrm.repasswd.value === ''){alert("입력했던 비밀번호를 입력하세요")}
    else if(jnfrm.passwd.value !== jnfrm.repasswd.value){alert("일치하지 않습니다. 비밀번호를 확인하세요")}
    else if(jnfrm.zip1.value === '' || jnfrm.zip2.value === '' ){alert("우편 번호를 입력하세요")}
    else if(jnfrm.addr1.value === '' || jnfrm.addr2.value === ''){alert("주소를 입력하세요")}
    else if(jnfrm.email1.value === '' || jnfrm.email2.value === ''){alert("이메일을 입력하세요")}
    else if(jnfrm.tel2.value === '' || jnfrm.tel3.value === ''){alert("전화번호를 입력하세요")}
    else if(grecaptcha.getResponse() === ''){alert("자동가입 방지를 입력하세요")}
    else if(jnfrm.checkuid.value === 'no'){alert("아이디 중복 체크를 확인하세요")}
    else {
        jnfrm.zipcode.value = jnfrm.zip1.value + '-' + jnfrm.zip2.value;
        jnfrm.email.value = jnfrm.email1.value + '@' + jnfrm.email2.value;
        jnfrm.phone.value = jnfrm.tel1.value + '-' +jnfrm.tel2.value + '-' + jnfrm.tel3.value;

        jnfrm.method = 'post';
        jnfrm.action = "/join/joinok";
        jnfrm.submit();
    }
})


const showzipaddr = (jsons) => {
    // for(idx in jsons) {
    //     console.log(jsons[idx]);
    // }

    jsons = JSON.parse(jsons);
    let addrs = '';
    jsons.forEach(function (data,idx) {
        let ri = (data['ri'] !== null) ? data['ri'] : '';
        let bunji = (data['bunji'] !== null) ? data['bunji'] : '';
        addrs += `<option>${data['zipcode']} ${data['sido']}
            ${data['gugun']} ${data['dong']} ${ri} ${bunji}</option>`;
    }) // 여기서 띄어쓰기가 안되어있어서 zip2에 몰아서 출력되는 것이었다.
    while (addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);
    }
    addrlist.innerHTML = addrs;
}

zipbtn?.addEventListener('click',()=>{
    if(dong.value === ''){ alert('검색할 동이름을 입력하세요'); return;}
    const url = '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text()).then(text=>showzipaddr(text));
})

sendzip?.addEventListener('click', () => {
    let addr = addrlist.value;
    if (addr !== '') {
        // 123-456 서울 구로구 구로1동
        let ziplist = addr.split(' ')[0];
        let ziplist1 = `${addr.split(' ')[1]} ${addr.split(' ')[2]} ${addr.split(' ')[3]} ${addr.split(' ')[4]} ${addr.split(' ')[5]}`;

        jnfrm.zip1.value = ziplist.split('-')[0];
        jnfrm.zip2.value = ziplist.split('-')[1];
        jnfrm.addr1.value = ziplist1;

        modal.hide();

    }
    else {
        alert("주소를 선택하세요");
    }
})
let modal = null;
try{modal = new bootstrap.Modal(zipmodal,{});}
catch (e) {}

zipmdbtn?.addEventListener('click',()=>{
    while (addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);
    }
    dong.value = '';
    modal.show();
})

email3?.addEventListener('change',()=>{
    if(email3.value === "직접입력하기"){
        jnfrm.email2.readOnly = false;
        jnfrm.email2.value = '';
    }else if(email3.value !== "직접입력하기"){
        jnfrm.email2.readOnly = true;
        jnfrm.email2.value = email3.value;
    }
})

dong?.addEventListener('keydown',(e)=>{
    if(e.keyCode === 13) {
        e.preventDefault();
    }
})

const styleCheckuid = (chkuid) => {
    let msg = '사용불가능한 아이디입니다'
    uidmsg.style.color = 'red';
    jnfrm.checkuid.value = 'no';

    if(chkuid === '0') {
        msg = '사용가능한 아이디입니다'
        uidmsg.style.color = 'blue';
        jnfrm.checkuid.value = 'yes';
    }
    uidmsg.innerText = msg;
}

userid?.addEventListener('blur',()=>{
    if(userid.value === ''){
        uidmsg.innerText = '6~16 자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다'
        uidmsg.style.color = 'gray';
        jnfrm.checkuid.value = 'no';
        return;
    }
    const url = '/join/checkuid?uid=' + userid.value;
    fetch(url).then(response=>response.text()).then(text=>styleCheckuid(text))
})


repasswd?.addEventListener('blur',()=>{
    let msg = '비밀번호가 불일치합니다'
    pwdmsg.style.color = 'red';

    if(repasswd.value === jnfrm.passwd.value) {
        msg = '비밀번호가 일치합니다.'
        pwdmsg.style.color = 'blue';
    }

    if(repasswd.value === ''){
        msg = '이전 항목에서 입력했던 비밀번호를 한번 더 입력하세요'
        pwdmsg.style.color = 'gray';
    }

    pwdmsg.innerText = msg;
})

//-----------------------joinok
const go2index = document.querySelector('#go2index');

go2index?.addEventListener('click',()=>{
    location.href = '/';
})

//---------------------------------login
const loginbtn = document.querySelector("#loginbtn");
const logoutbtn = document.querySelector("#logoutbtn");
const lgfrm = document.forms.lgnfrm;

loginbtn?.addEventListener('click',()=>{
    if(lgfrm.userid1.value === '') {alert("아이디를 입력하세요")}
    else if(lgfrm.passwd1.value === '') {alert("비밀번호를 입력하세요")}
    else {
    lgfrm.method = 'post';
    lgfrm.action = '/login';
    lgfrm.submit();
    }
})

logoutbtn?.addEventListener('click',()=>{
    location.href='/logout'
})